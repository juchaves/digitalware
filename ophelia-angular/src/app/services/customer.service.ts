import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Customer } from '../models/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  url:string = 'http://localhost:8080/api/customers';

  constructor(private http:HttpClient) { }

  getCustomers(): Observable<Customer[]> {
    return this.http.get<Customer[]>(this.url + "/list");
  }

  getCustomer(id: number): Observable<Customer> {
    return this.http.get<Customer>(this.url + "/get/" + id);
  }

  createCustomer(c:Customer): Observable<Customer> {
    return this.http.post<Customer>(this.url + "/create", c);
  }

  updateCustomer(c:Customer): Observable<Customer> {
    return this.http.put<Customer>(this.url + "/update/" + c.id, c);
  }

  deleteCustomer(id: number): Observable<Customer> {
    return this.http.delete<Customer>(this.url + "/delete/" + id);
  }

}
