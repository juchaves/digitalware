import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Item } from 'src/app/models/item';
import { Product } from 'src/app/models/product';
import { Sale } from 'src/app/models/sale';
import { ItemService } from 'src/app/services/item.service';
import { ProductService } from 'src/app/services/product.service';
import { SaleService } from 'src/app/services/sale.service';

@Component({
  selector: 'app-item-add',
  templateUrl: './item-add.component.html',
  styleUrls: ['./item-add.component.css']
})
export class ItemAddComponent implements OnInit {

  constructor(private router:Router, private itemService:ItemService, private productService:ProductService, private saleService:SaleService, private activatedRoute:ActivatedRoute) { }

  itemModel = new Item();

  products: Product[] = [];

  sales: Sale[] = [];

  ngOnInit(): void {
    this.productService.getProducts()
    .subscribe( response => this.products = response)
    this.saleService.getSales()
    .subscribe( response => this.sales = response)

    this.activatedRoute.params
        .subscribe( params => {
          let id:number = params["id"];
          if(id) {
            this.itemService.getItem(id)
              .subscribe(response => this.itemModel=response);
          }
        })

  }

  save() {
    this.itemService.createItem( this.itemModel)
      .subscribe( data => {
        alert( "Se agregó con éxito!!" );
        this.router.navigate(["items"]);
      })
  }

  update() {
    this.itemService.updateItem(this.itemModel)
    .subscribe( data => {
      alert("Se actualizó con éxito!!");
      this.router.navigate(["items"]);
    })
  }

  productCompare(o1:Product, o2:Product) {
    if(o1 === undefined && o2 === undefined) return true;
    return o1 === null || o2 === null || o1 === undefined || o2 === undefined ? false : o1.id == o2.id;
  }

  saleCompare(o1:Sale, o2:Sale) {
    if(o1 === undefined && o2 === undefined) return true;
    return o1 === null || o2 === null || o1 === undefined || o2 === undefined ? false : o1.id == o2.id;
  }


}
