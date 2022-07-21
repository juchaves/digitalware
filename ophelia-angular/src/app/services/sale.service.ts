import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Sale } from '../models/sale';

@Injectable({
  providedIn: 'root'
})
export class SaleService {
  url:string = 'http://localhost:8080/api/sales';

  constructor(private http:HttpClient) { }

  getSales(): Observable<Sale[]> {
    return this.http.get<Sale[]>(this.url + "/list");
  }

  getSale(id: number): Observable<Sale> {
    return this.http.get<Sale>(this.url + "/get/" + id);
  }

  createSale(s:Sale): Observable<Sale> {
    return this.http.post<Sale>(this.url + "/create", s);
  }

  updateSale(s:Sale): Observable<Sale> {
    return this.http.put<Sale>(this.url + "/update/" + s.id, s);
  }

  deleteSale(id: number): Observable<Sale> {
    return this.http.delete<Sale>(this.url + "/delete/" + id);
  }

}
