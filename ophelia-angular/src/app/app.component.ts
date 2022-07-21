import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ophelia-angular';

  constructor(private router:Router) {}

  customers() {
    this.router.navigate(["customers"]);
  }
  products() {
    this.router.navigate(["products"]);
  }
  sales() {
    this.router.navigate(["sales"]);
  }
  items() {
    this.router.navigate(["items"]);
  }
}
