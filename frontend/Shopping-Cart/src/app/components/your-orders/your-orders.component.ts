import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Orders } from 'src/app/models/orders';
import { User } from 'src/app/models/userprofile';
import { OrdersService } from 'src/app/services/orders.service';
import { UserprofileService } from 'src/app/services/userprofile.service';

@Component({
  selector: 'app-your-orders',
  templateUrl: './your-orders.component.html',
  styleUrls: ['./your-orders.component.css']
})
export class YourOrdersComponent implements OnInit {

  public id:number;
  public orders: Orders;
  public cost: string;
  public ordered = "Ordered";
  public delivered = "Delivered";
  public message = "Order Deleted Successfully";
  public success = ":(";

  constructor(private orderService : OrdersService,private user : UserprofileService,private _snackBar: MatSnackBar) { }


  ngOnInit() {
    this.getUser();
  }

  getUser(){
    this.user.getUser().subscribe(
      (response:User)=>{
        this.id = response.profileId;
        this.getOrders(this.id);
      }
    );
  }

  

  getOrders(id:number){
    this.orderService.getOrdersByCustomerId(id).subscribe(
      (response:Orders)=>{
        this.orders = response;
      },(HttpErrorResponse)=>{
        console.log(HttpErrorResponse);
      }

    );
  }

  delete(id:string){
    this.orderService.deleteOrder(id).subscribe(
      (response)=>{
        window.location.href="/shop";
      }
    );
  }

  openSnackBar(message: string , action : string) {
    this._snackBar.open(message,action, {
      duration: 2000,
    });
  }

  costs(price:number){
    var x:string=price.toString();
    var lastThree = x.substring(x.length-3);
    var otherNumbers = x.substring(0,x.length-3);
    if(otherNumbers != '')
        lastThree = ',' + lastThree;
    this.cost = otherNumbers.replace(/\B(?=(\d{2})+(?!\d))/g, ",") + lastThree;
  }

}
