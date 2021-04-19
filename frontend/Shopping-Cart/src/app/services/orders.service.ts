import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Address } from '../models/address';
import { CartItem } from '../models/cart-item';

@Injectable({
  providedIn: 'root'
})
export class OrdersService {

  private apiUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }



  public placeOrder(id:number,address:Address): Observable<any>{
    return this.http.post<any>(`${this.apiUrl}/order/placeOrder/${id}`,address)
  }

  public getOrders():Observable<any>{
    return this.http.get(`${this.apiUrl}/order/viewAllOrders`)
  }


  public getAddress(id:number): Observable<any>{
    return this.http.get(`${this.apiUrl}/order/getAddByCustomerId/${id}`)
  }

  public storeAddress(address:Address):Observable<any>{
    return this.http.put(`${this.apiUrl}/order/storeAddress`,address)
  }

  public getOrdersByCustomerId(id: number){
    return this.http.get(`${this.apiUrl}/order/getOrderByCustomerId/${id}`)
  }

  

  





}
