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

  public addProduct(product : Product): Observable<any>{
    return this.http.post<Product>(`${this.apiUrl}/product/addProduct`,product)
  }

  public updateProduct(product: Product):Observable<Product>{
    return this.http.put<Product>(`${this.apiUrl}/product/updateProduct`,product)
  }

  public deleteProduct(id:number){
    return this.http.delete(`${this.apiUrl}/product/deleteProduct/${id}`)
  }

  public getProductByName(name: string):Observable<Product>
  {
    return this.http.get<Product>(`${this.apiUrl}/product/viewProductById/${name}`)
  }

  public getProductByID(id: number): Observable<Product>{
    return this.http.get<Product>(`${this.apiUrl}/product/viewProductById/${id}`)
  }
}
