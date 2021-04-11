import { IRestaurant } from 'app/shared/model/restaurant.model';
import { IProduit } from 'app/shared/model/produit.model';

export interface IPanier {
  id?: number;
  nbElements?: number;
  price?: number;
  restaurants?: IRestaurant[];
  produits?: IProduit[];
  compteId?: number;
}

export class Panier implements IPanier {
  constructor(
    public id?: number,
    public nbElements?: number,
    public price?: number,
    public restaurants?: IRestaurant[],
    public produits?: IProduit[],
    public compteId?: number
  ) {}
}
