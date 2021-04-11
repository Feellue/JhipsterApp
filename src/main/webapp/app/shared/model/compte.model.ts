import { IPanier } from 'app/shared/model/panier.model';
import { ISystemePaiement } from 'app/shared/model/systeme-paiement.model';

export interface ICompte {
  id?: number;
  name?: string;
  surname?: string;
  age?: number;
  address?: string;
  paniers?: IPanier[];
  restaurantId?: number;
  systemePaiements?: ISystemePaiement[];
}

export class Compte implements ICompte {
  constructor(
    public id?: number,
    public name?: string,
    public surname?: string,
    public age?: number,
    public address?: string,
    public paniers?: IPanier[],
    public restaurantId?: number,
    public systemePaiements?: ISystemePaiement[]
  ) {}
}
