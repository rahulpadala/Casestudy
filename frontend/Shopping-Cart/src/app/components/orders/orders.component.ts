import { Component, OnInit } from '@angular/core';
import { Address } from 'src/app/models/address';
import { CartItem } from 'src/app/models/cart-item';
import { User } from 'src/app/models/userprofile';
import { CartService } from 'src/app/services/cart.service';
import { LoginService } from 'src/app/services/login.service';
import { OrdersService } from 'src/app/services/orders.service';
import { UserprofileService } from 'src/app/services/userprofile.service';

@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  public id : number;
  public address : Address;
  public cart : CartItem;
  constructor(private orderService : OrdersService,private user : UserprofileService,private cartService :CartService) { }

  ngOnInit() {
    this.getCart();
  } 
  public getAddress(id:number){
    this.orderService.getAddress(id).subscribe(
      (response:Address)=>{
        console.log(response);
          this.address = response; 
      }
    );
  }
  public getCart(){
      this.cartService.getCart().subscribe(
        (response:CartItem)=>{
          this.cart = response;
          this.getAddress(this.cart.cartId);
        }
      );  
  }


  // public placeOrder(address)





}
