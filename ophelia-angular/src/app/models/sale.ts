import { Customer } from "./customer";

export class Sale {
  public id!: number;
  public date!: Date;
  public grossValue!: number;
  public discount!: number;
  public tax!: number;
  public fullValue!: number;
  public customer!: Customer;
}
