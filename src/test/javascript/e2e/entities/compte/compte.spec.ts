import { browser, ExpectedConditions as ec, promise } from 'protractor';
import { NavBarPage, SignInPage } from '../../page-objects/jhi-page-objects';

import { CompteComponentsPage, CompteDeleteDialog, CompteUpdatePage } from './compte.page-object';

const expect = chai.expect;

describe('Compte e2e test', () => {
  let navBarPage: NavBarPage;
  let signInPage: SignInPage;
  let compteComponentsPage: CompteComponentsPage;
  let compteUpdatePage: CompteUpdatePage;
  let compteDeleteDialog: CompteDeleteDialog;

  before(async () => {
    await browser.get('/');
    navBarPage = new NavBarPage();
    signInPage = await navBarPage.getSignInPage();
    await signInPage.autoSignInUsing('admin', 'admin');
    await browser.wait(ec.visibilityOf(navBarPage.entityMenu), 5000);
  });

  it('should load Comptes', async () => {
    await navBarPage.goToEntity('compte');
    compteComponentsPage = new CompteComponentsPage();
    await browser.wait(ec.visibilityOf(compteComponentsPage.title), 5000);
    expect(await compteComponentsPage.getTitle()).to.eq('myappApp.compte.home.title');
    await browser.wait(ec.or(ec.visibilityOf(compteComponentsPage.entities), ec.visibilityOf(compteComponentsPage.noResult)), 1000);
  });

  it('should load create Compte page', async () => {
    await compteComponentsPage.clickOnCreateButton();
    compteUpdatePage = new CompteUpdatePage();
    expect(await compteUpdatePage.getPageTitle()).to.eq('myappApp.compte.home.createOrEditLabel');
    await compteUpdatePage.cancel();
  });

  it('should create and save Comptes', async () => {
    const nbButtonsBeforeCreate = await compteComponentsPage.countDeleteButtons();

    await compteComponentsPage.clickOnCreateButton();

    await promise.all([
      compteUpdatePage.setNameInput('name'),
      compteUpdatePage.setSurnameInput('surname'),
      compteUpdatePage.setAgeInput('5'),
      compteUpdatePage.setAddressInput('address'),
    ]);

    expect(await compteUpdatePage.getNameInput()).to.eq('name', 'Expected Name value to be equals to name');
    expect(await compteUpdatePage.getSurnameInput()).to.eq('surname', 'Expected Surname value to be equals to surname');
    expect(await compteUpdatePage.getAgeInput()).to.eq('5', 'Expected age value to be equals to 5');
    expect(await compteUpdatePage.getAddressInput()).to.eq('address', 'Expected Address value to be equals to address');

    await compteUpdatePage.save();
    expect(await compteUpdatePage.getSaveButton().isPresent(), 'Expected save button disappear').to.be.false;

    expect(await compteComponentsPage.countDeleteButtons()).to.eq(nbButtonsBeforeCreate + 1, 'Expected one more entry in the table');
  });

  it('should delete last Compte', async () => {
    const nbButtonsBeforeDelete = await compteComponentsPage.countDeleteButtons();
    await compteComponentsPage.clickOnLastDeleteButton();

    compteDeleteDialog = new CompteDeleteDialog();
    expect(await compteDeleteDialog.getDialogTitle()).to.eq('myappApp.compte.delete.question');
    await compteDeleteDialog.clickOnConfirmButton();

    expect(await compteComponentsPage.countDeleteButtons()).to.eq(nbButtonsBeforeDelete - 1);
  });

  after(async () => {
    await navBarPage.autoSignOut();
  });
});
