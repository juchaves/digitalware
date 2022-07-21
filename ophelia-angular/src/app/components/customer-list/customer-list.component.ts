import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from 'src/app/models/customer';
import { CustomerService } from 'src/app/services/customer.service';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  customers: Customer[] = [];
  constructor(private servicio:CustomerService, private router:Router) { }

  ngOnInit(): void {
    this.servicio.getCustomers()
    .subscribe( data => {
      console.log(data);
      this.customers = data;
    })
  }

  delete(id:number) {
    this.servicio.deleteCustomer(id).subscribe(
    res=> {this.ngOnInit();},
    err => console.log(err));
  }

  add() {
    this.router.navigate(["customer_update"]);
  }

}
