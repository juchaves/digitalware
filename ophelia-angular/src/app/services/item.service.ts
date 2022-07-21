import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Item } from '../models/item';

@Injectable({
  providedIn: 'root'
})
export class ItemService {
  url:string = 'http://localhost:8080/api/items';

  constructor(private http:HttpClient) { }

  getItems(): Observable<Item[]> {
    return this.http.get<Item[]>(this.url + "/list");
  }

  getItem(id: number): Observable<Item> {
    return this.http.get<Item>(this.url + "/get/" + id);
  }

  createItem(i:Item): Observable<Item> {
    return this.http.post<Item>(this.url + "/create", i);
  }

  updateItem(i:Item): Observable<Item> {
    return this.http.put<Item>(this.url + "/update/" + i.id, i);
  }

  deleteItem(id: number): Observable<Item> {
    return this.http.delete<Item>(this.url + "/delete/" + id);
  }

}
