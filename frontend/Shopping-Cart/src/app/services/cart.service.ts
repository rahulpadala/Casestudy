import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

//import { CartItem } from '../models/cart-item';
// import { cartUrl } from '../config/api';
import { Product } from '../models/product';
import { environment } from 'src/environments/environment';
import { CartItem } from '../models/cart-item'

@Injectable({
  providedIn: 'root'
})
export class CartService {


  private apiServerUrl= environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  // getCartItems(): Observable<CartItem[]> {
  //   //TODO: Mapping the obtained result to our CartItem props. (pipe() and map())
  //   return this.http.get<CartItem[]>(cartUrl).pipe(
  //     map((result: any[]) => {
  //       let cartItems: CartItem[] = [];

  //       for (let item of result) {
  //         let productExists = false

  //         for (let i in cartItems) {
  //           if (cartItems[i].productId === item.product.id) {
  //             cartItems[i].qty++
  //             productExists = true
  //             break;
  //           }
  //         }

  //         if (!productExists) {
  //           cartItems.push(new CartItem(item.id, item.product));
  //         }
  //       }

  //       return cartItems;
  //     })
  //   );
  // }

  // addCart(id:number):Observable<any>{
  //   console.log("came to service");
  //   return this.http.post<any>(`${this.apiServerUrl}/cart/addCart/${id}`,id);
  // }

  generateCart(){
    return this.http.post<any>(`${this.apiServerUrl}/token/cart`,null);
  }

  getCart(){
    return this.http.get<CartItem>(`${this.apiServerUrl}/token/cart`)
  }

  updateCart(Cid:number, id:number){
    return this.http.post(`${this.apiServerUrl}/cart/updateCart/${Cid}/${id}`,{Cid , id});
  }
  
  addProductToCart(Cid:number , Pid:number ): Observable<any> {
    return this.http.post(`${this.apiServerUrl}/cart/addToCart/${Cid}/${Pid}`, { Cid , Pid });
  }
}
