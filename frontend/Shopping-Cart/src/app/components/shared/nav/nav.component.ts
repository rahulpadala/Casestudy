import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/userprofile';
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
  public customer = false;
  public merchant = false;
  public deliveryAgent=false;

  constructor(private loginservice:LoginService,private router: Router,private user: UserprofileService) { }

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
      console.log(this.customer);
    }   
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
