import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Orders } from 'src/app/models/orders';
import { OrdersService } from 'src/app/services/orders.service';

@Component({
  selector: 'app-delivery',
  templateUrl: './delivery.component.html',
  styleUrls: ['./delivery.component.css']
})
export class DeliveryComponent implements OnInit {

  public id:number;
  public orders: Orders[];
  public cost: string;
  public ordered = "Ordered";
  public delivered = "Delivered";
  public message = "Out for Delivery";
  public success = ":)";

  constructor(private orderService : OrdersService,private _snackBar: MatSnackBar) { }

  ngOnInit() {
    this.getOrders();
  }

   

  getOrders(){
    this.orderService.getOrders().subscribe(
      (response:Orders[])=>{
        this.orders = response;
      },(HttpErrorResponse)=>{
        console.log(HttpErrorResponse);
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

  deliver(oid:string){
    console.log(oid);
    this.orderService.changeOrderStatus(this.delivered,oid).subscribe(
      (response:any)=>{
        this.ngOnInit();
      },(error)=>{
        console.log(error);
      }

    );
  }

}
