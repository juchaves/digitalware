import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from 'src/app/models/customer';
import { CustomerService } from 'src/app/services/customer.service';

@Component({
  selector: 'app-customer-add',
  templateUrl: './customer-add.component.html',
  styleUrls: ['./customer-add.component.css']
})
export class CustomerAddComponent implements OnInit {

  constructor(private router:Router, private customerService:CustomerService, private activatedRoute:ActivatedRoute) { }

  customerModel = new Customer();

  ngOnInit(): void {
    this.activatedRoute.params
        .subscribe( params => {
          let id:number = params["id"];
          if(id) {
            this.customerService.getCustomer(id)
              .subscribe(response => this.customerModel=response);
          }
        })
  }

  save() {
    this.customerService.createCustomer(this.customerModel)
    .subscribe( data=> {
      alert("Se agregó con éxito!!");
      this.router.navigate(["customers"]);
    })
  }

  update() {
    this.customerService.updateCustomer(this.customerModel)
    .subscribe( data => {
      alert("Se actualizó con éxito!!");
      this.router.navigate(["customers"]);
    })
  }

}
