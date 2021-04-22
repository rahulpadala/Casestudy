import { HttpErrorResponse } from '@angular/common/http';
import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material';
import { Router } from '@angular/router';
import { Address } from 'src/app/models/address';
import { CartItem } from 'src/app/models/cart-item';
import { OrdersService } from 'src/app/services/orders.service';
import { OrdersComponent } from '../orders/orders.component';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {

  public address:Address;
  public cart : CartItem;
  public customerId : number;
  public size = false;
  rzp1: any;
  constructor(@Inject(MAT_DIALOG_DATA) public data : any,private dialog : MatDialog, private orderService : OrdersService,private router: Router) { }
  ngOnInit() {
    this.cart=this.data.Cart;
    this.customerId = this.cart.cartId;
    this.getAddress(this.customerId);
  }

  // public order(){
  //   this.dialog.open(OrdersComponent,{ disableClose: true });
  // }

  public getAddress(id:number){
    this.orderService.getAddress(id).subscribe(
      (response:Address)=>{
        console.log(response);
          this.address = response;
      }
    );
  }
  public payment(address : Address){
    // document.getElementById('add-employee-form').click();
    address.customerId = this.customerId;
    this.address = address;
    this.orderService.storeAddress(address).subscribe(
      (response: any) => {
        this.pay();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
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

    public storeAddress(address : Address){
      // document.getElementById('add-employee-form').click();
      address.customerId = this.customerId;
      this.orderService.storeAddress(address).subscribe(
        (response: any) => {
          this.dialog.open(OrdersComponent,{data:{cart:this.cart},disableClose : true});
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
      );
    // console.log(address);
    
  }

  options = {
    "key": "rzp_test_nPdNVt3ndRRU3s", // Enter the Key ID generated from the Dashboard
    "amount": this.data.Cart.totalPrice * 100, // Amount is in currency subunits. Default currency is INR. Hence, 50000 refers to 50000 paise
    "currency": "INR",
    "name": "Shopping Cart",
    "description": "Test Transaction",
    "image": "https://www.graphicsprings.com/filestorage/stencils/b8639dd9acb3c6ab0b6771e529ad3930.png?width=500&height=500",
    "callback_url": "https://eneqd3r9zrjok.x.pipedream.net/",
    "handler":  (response)=>{
      this.placeOrder(this.customerId,this.address)
      window.location.href="/shop"; 
      alert("Your payment is successful");
      
    },
    "prefill": {
        "name": "Rahul",
        "email": "rahulpadala99@gmail.com",
        "contact": "8247776444"
    },
    "notes": {
        "address": "Razorpay Corporate Office"
    },
    "theme": {
        "color": "#3399cc"
    }
};

public  pay():void {
  this.rzp1 = new  this.orderService.nativeWindow.Razorpay(this.options);
  this.rzp1.open();
  this.rzp1.on('payment.failed',  (response)=>{
    alert("Your Payment failed"); 
  });
 }



}
