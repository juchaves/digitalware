import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Sale } from 'src/app/models/sale';
import { SaleService } from 'src/app/services/sale.service';

@Component({
  selector: 'app-sale-list',
  templateUrl: './sale-list.component.html',
  styleUrls: ['./sale-list.component.css']
})
export class SaleListComponent implements OnInit {

  sales: Sale[] = [];
  constructor(private servicio:SaleService, private router:Router) { }

  ngOnInit(): void {
    this.servicio.getSales()
    .subscribe( data => {
      console.log(data);
      this.sales = data;
    })
  }

  delete(id:number) {
    this.servicio.deleteSale(id).subscribe(
    res=> {this.ngOnInit();},
    err => console.log(err));
  }

  add() {
    this.router.navigate(["sale_update"]);
  }

}
