import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from 'src/app/models/customer';
import { Sale } from 'src/app/models/sale';
import { CustomerService } from 'src/app/services/customer.service';
import { SaleService } from 'src/app/services/sale.service';

@Component({
  selector: 'app-sale-add',
  templateUrl: './sale-add.component.html',
  styleUrls: ['./sale-add.component.css']
})
export class SaleAddComponent implements OnInit {

  constructor(private router:Router, private saleService:SaleService, private customersService:CustomerService, private activatedRoute:ActivatedRoute) { }

  saleModel = new Sale();

  customers: Customer[] = [];


  ngOnInit(): void {
    this.customersService.getCustomers()
      .subscribe( response => this.customers = response)

      this.activatedRoute.params
        .subscribe( params => {
          let id:number = params["id"];
          if(id) {
            this.saleService.getSale(id)
              .subscribe(response => this.saleModel=response);
          }
        })

  }

  save() {
    this.saleService.createSale(this.saleModel)
      .subscribe(data=> {
        alert("Se agregó con exito");
        this.router.navigate(["sales"]);
      })

  }

  update() {
    this.saleService.updateSale(this.saleModel)
    .subscribe( data => {
      alert("Se actualizó con éxito!!");
      this.router.navigate(["sales"]);
    })
  }

  customerCompare(o1:Customer, o2:Customer) {
    if(o1 === undefined && o2 === undefined) return true;
    return o1 === null || o2 === null || o1 === undefined || o2 === undefined ? false : o1.id == o2.id;
  }

}
