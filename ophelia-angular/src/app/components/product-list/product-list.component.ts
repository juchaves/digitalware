import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from 'src/app/models/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products: Product[] = [];
  constructor(private servicio:ProductService, private router:Router) { }

  ngOnInit(): void {
    this.servicio.getProducts()
    .subscribe( data => {
      console.log(data);
      this.products = data;
    })
  }

  delete(id:number) {
    this.servicio.deleteProduct(id).subscribe(
    res=> {this.ngOnInit();},
    err => console.log(err));
  }

  add() {
    this.router.navigate(["product_update"]);
  }

}
