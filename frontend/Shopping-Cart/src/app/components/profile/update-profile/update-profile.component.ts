import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material';
import { Router } from '@angular/router';
import { render } from 'creditcardpayments/creditCardPayments'
import { User } from 'src/app/models/userprofile';
import { LoginService } from 'src/app/services/login.service';
import { OrdersService } from 'src/app/services/orders.service';
import { UserprofileService } from 'src/app/services/userprofile.service';
@Component({
  selector: 'app-update-profile',
  templateUrl: './update-profile.component.html',
  styleUrls: ['./update-profile.component.css']
})
export class UpdateProfileComponent implements OnInit {


  public user : User
  constructor(@Inject(MAT_DIALOG_DATA) public data: any,private userProfile : UserprofileService,private router: Router){}

  ngOnInit() {
    this.user = this.data.user;
  }


  updateUser(userP : User){
    this.userProfile.updateProfile(userP).subscribe(
      (response)=>{
        console.log(userP);
        window.location.href="/shop";    
      }
    );
  }





 

}
