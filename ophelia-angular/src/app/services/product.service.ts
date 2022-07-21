import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Product } from '../models/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  url:string = 'http://localhost:8080/api/products';

  constructor(private http:HttpClient) { }

  getProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(this.url + "/list");
  }

  getProduct(id: number): Observable<Product> {
    return this.http.get<Product>(this.url + "/get/" + id);
  }

  createProduct(p:Product): Observable<Product> {
    return this.http.post<Product>(this.url + "/create", p);
  }

  updateProduct(p:Product): Observable<Product> {
    return this.http.put<Product>(this.url + "/update/" + p.id, p);
  }

  deleteProduct(id: number): Observable<Product> {
    return this.http.delete<Product>(this.url + "/delete/" + id);
  }

}
