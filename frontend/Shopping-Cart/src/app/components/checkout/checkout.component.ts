import { HttpErrorResponse } from '@angular/common/http';
import { Component, Inject, OnInit } from '@angular/core';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material';
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
  constructor(@Inject(MAT_DIALOG_DATA) public data : any,private dialog : MatDialog, private orderService : OrdersService) { }
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



}
