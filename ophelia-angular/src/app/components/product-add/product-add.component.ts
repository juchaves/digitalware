import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from 'src/app/models/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-add',
  templateUrl: './product-add.component.html',
  styleUrls: ['./product-add.component.css']
})
export class ProductAddComponent implements OnInit {

  constructor(private router:Router, private productService:ProductService, private activatedRoute:ActivatedRoute) { }

  productModel = new Product();

  ngOnInit(): void  {
      this.activatedRoute.params
        .subscribe( params => {
          let id:number = params["id"];
          if(id) {
            this.productService.getProduct(id)
              .subscribe(response => this.productModel=response);
          }
        })

  }
  save() {
    this.productService.createProduct(this.productModel)
    .subscribe( data=> {
      alert("Se agregó con éxito!!");
      this.router.navigate(["products"]);
    })
  }

  update() {
    this.productService.updateProduct(this.productModel)
    .subscribe( data => {
      alert("Se actualizó con éxito!!");
      this.router.navigate(["products"]);
    })
  }


}
