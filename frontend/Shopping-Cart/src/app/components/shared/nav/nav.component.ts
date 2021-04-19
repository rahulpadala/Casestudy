import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartItem } from 'src/app/models/cart-item';
import { User } from 'src/app/models/userprofile';
import { CartService } from 'src/app/services/cart.service';
import { LoginService } from 'src/app/services/login.service';
import { UserprofileService } from 'src/app/services/userprofile.service';


@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent implements OnInit {

  public loggedIn=false;
  public role : string= null;
  public name : string;
  public id : number;
  public customer = false;
  public merchant = false;
  public deliveryAgent=false;
  public usercart : CartItem;

  constructor(private loginservice:LoginService,private router: Router,private user: UserprofileService,private cart: CartService) { }

  ngOnInit(){
    
    this.loggedIn = this.loginservice.isLoggedIn();
    if(this.loggedIn){
      this.assignRole();
    }
  }
  logout()
  {
    this.loginservice.logout();
  }

  addNewCustomer()
  {
    this.router.navigate(['customer'])
  }

  addNewMerchant()
  {
    this.router.navigate(['merchant'])
  }

  addNewDeliveryAgent()
  {
    this.router.navigate(['deliveryAgent'])
  }

  assignRole()
  {
    this.user.getUser().subscribe(
      (response: User) => {
        this.role=response.role;
        //console.log(this.role);
        this.id=response.profileId;
        this.name = response.fullName;
        this.isCustomer();
        this.isMerchant();
        this.isDeliveryAgent();
      },(error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  isCustomer(){
    if(this.role==="Customer")
    {
      this.customer = true;
      //this.addCart(this.id);
      this.addCart();
      console.log(this.customer);
    }   
  }

  // public addCart(id:number):void{
  //   console.log("came to nav");
  //  this.cart.addCart(this.id).subscribe(
  //    (response:CartService)=>{
  //    },
  //    (error:HttpErrorResponse)=>{
  //      alert(error.message);
  //    }
  //  );
  // }

  public addCart():void{
    this.cart.generateCart().subscribe(
    (response:CartService)=>{
    },
   (error:HttpErrorResponse)=>{
           alert(error.message);
       }
   );
  }

  gotoCart()
  {
    this.router.navigate(['cart'])
  }

  orders()
  {
    this.router.navigate(['orders'])
  }



  isMerchant(){
    if(this.role=="Merchant")
    {
       this.merchant = true;
       console.log("merchant "+this.merchant);
    }
  }

  isDeliveryAgent(){
    if(this.role=="DeliveryAgent")
    {
      this.deliveryAgent = true;
      console.log("Delivery-Agent "+this.deliveryAgent);
    }

  }

  




}
