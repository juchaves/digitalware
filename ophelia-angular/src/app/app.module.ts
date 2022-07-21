import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SaleListComponent } from './components/sale-list/sale-list.component';
import { ProductListComponent } from './components/product-list/product-list.component';
import { CustomerListComponent } from './components/customer-list/customer-list.component';
import { ItemListComponent } from './components/item-list/item-list.component';
import { HttpClientModule } from '@angular/common/http';
import { SaleAddComponent } from './components/sale-add/sale-add.component';
import { CustomerAddComponent } from './components/customer-add/customer-add.component';
import { ProductAddComponent } from './components/product-add/product-add.component';
import { ItemAddComponent } from './components/item-add/item-add.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    SaleListComponent,
    ProductListComponent,
    CustomerListComponent,
    ItemListComponent,
    SaleAddComponent,
    CustomerAddComponent,
    ProductAddComponent,
    ItemAddComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
