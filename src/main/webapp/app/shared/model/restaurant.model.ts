import { IProduit } from 'app/shared/model/produit.model';
import { IPanier } from 'app/shared/model/panier.model';

export interface IRestaurant {
  id?: number;
  name?: string;
  address?: string;
  compteId?: number;
  produits?: IProduit[];
  paniers?: IPanier[];
}

export class Restaurant implements IRestaurant {
  constructor(
    public id?: number,
    public name?: string,
    public address?: string,
    public compteId?: number,
    public produits?: IProduit[],
    public paniers?: IPanier[]
  ) {}
}
