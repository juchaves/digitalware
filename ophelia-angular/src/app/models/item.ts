import { Product } from "./product";
import { Sale } from "./sale";

export class Item {
  public id!: number;
  public admissionDate!: Date;
  public cost!: number;
  public price!: number;
  public itemCode!: String;
  public product!: Product;
  public sale!: Sale;
}
