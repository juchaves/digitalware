import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Item } from 'src/app/models/item';
import { ItemService } from 'src/app/services/item.service';

@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css']
})
export class ItemListComponent implements OnInit {

  items: Item[] = [];
  constructor(private servicio:ItemService, private router:Router) { }

  ngOnInit(): void {
    this.servicio.getItems()
    .subscribe( data => {
      console.log(data);
      this.items = data;
    })
  }

  delete(id:number) {
    this.servicio.deleteItem(id).subscribe(
    res=> {this.ngOnInit();},
    err => console.log(err));
  }

  add() {
    this.router.navigate(["item_update"]);
  }



}
