import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CustomerAddComponent } from './components/customer-add/customer-add.component';
import { CustomerListComponent } from './components/customer-list/customer-list.component';
import { ItemAddComponent } from './components/item-add/item-add.component';
import { ItemListComponent } from './components/item-list/item-list.component';
import { ProductAddComponent } from './components/product-add/product-add.component';
import { ProductListComponent } from './components/product-list/product-list.component';
import { SaleAddComponent } from './components/sale-add/sale-add.component';
import { SaleListComponent } from './components/sale-list/sale-list.component';

const routes: Routes = [
  {path:"customers", component:CustomerListComponent},
  {path:"items", component:ItemListComponent},
  {path:"products", component:ProductListComponent},
  {path:"sales", component:SaleListComponent},
  {path:"customer_update", component:CustomerAddComponent},
  {path:"item_update", component:ItemAddComponent},
  {path:"product_update", component:ProductAddComponent},
  {path:"sale_update", component:SaleAddComponent},
  {path:"customer_update/:id", component:CustomerAddComponent},
  {path:"item_update/:id", component:ItemAddComponent},
  {path:"product_update/:id", component:ProductAddComponent},
  {path:"sale_update/:id", component:SaleAddComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
