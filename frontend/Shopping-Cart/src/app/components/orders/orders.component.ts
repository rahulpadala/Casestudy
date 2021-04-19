import { HttpErrorResponse } from '@angular/common/http';
import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material';
import { Address } from 'src/app/models/address';
import { CartItem } from 'src/app/models/cart-item';
import { User } from 'src/app/models/userprofile';
// import { CartService } from 'src/app/services/cart.service';
// import { LoginService } from 'src/app/services/login.service';
import { OrdersService } from 'src/app/services/orders.service';
// import { UserprofileService } from 'src/app/services/userprofile.service';
import { DatePipe } from '@angular/common';
@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css'],
  providers: [DatePipe]
})
export class OrdersComponent implements OnInit {

  public id : number;
  public address : Address;
  currentDate = new Date();
  public cost:string;
  constructor(private orderService : OrdersService,@Inject(MAT_DIALOG_DATA) public data: any) { }

  ngOnInit() {
    this.id = this.data.cart.cartId;
    this.getAddress(this.id);
    this.costs(this.data.cart.totalPrice)
  } 

  public getAddress(id:number){
    this.orderService.getAddress(id).subscribe(
      (response:Address)=>{
        console.log(response);
          this.address = response;
          this.placeOrder(id,this.address); 
      }
    );
  }

  costs(price:number){
    var x:string=price.toString();
    var lastThree = x.substring(x.length-3);
    var otherNumbers = x.substring(0,x.length-3);
    if(otherNumbers != '')
        lastThree = ',' + lastThree;
    this.cost = otherNumbers.replace(/\B(?=(\d{2})+(?!\d))/g, ",") + lastThree;
  }

  public placeOrder(id:number,address : Address)
  {
    this.orderService.placeOrder(id,address).subscribe(
      (response)=>{

      },(HttpErrorResponse)=>
      {
        console.log(HttpErrorResponse);  
      }
    );
  }





}
