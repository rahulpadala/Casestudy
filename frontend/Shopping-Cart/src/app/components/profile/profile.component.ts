import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material';
import { User } from 'src/app/models/userprofile';
import { LoginService } from 'src/app/services/login.service';
import { UserprofileService } from 'src/app/services/userprofile.service';
import { UpdateProfileComponent } from './update-profile/update-profile.component';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  public userprofile : User
  
  constructor(private loginservice: LoginService,private user: UserprofileService,private dialog : MatDialog) { }

  ngOnInit() {
    if(this.loginservice.isLoggedIn()){
      this.getUser();
    }
  }

  getUser(){
    this.user.getUser().subscribe(
      (response:User)=>{
        this.userprofile = response;
      },(HttpErrorResponse)=>
      {
        alert(HttpErrorResponse);
      }
    );
   }

   edit(){
     this.dialog.open(UpdateProfileComponent,{data:{user:this.userprofile}});
   }



}
