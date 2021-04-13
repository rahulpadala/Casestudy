import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';


import { Product } from 'src/app/models/product';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private apiUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getProducts(): Observable<Product[]>{
    return this.http.get<Product[]>(`${this.apiUrl}/product/viewAllProducts`)
  }

  public getProductByID(id: number): Observable<Product>{
    return this.http.get<Product>(`${this.apiUrl}/product/viewProductById/${id}`)
  }
}
