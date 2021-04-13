import { HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Token } from 'src/app/models/token';
import { User } from 'src/app/models/userprofile';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {



  public  token: Token | undefined;
  constructor(private loginService:LoginService) { }

  ngOnInit() {
  }



public login(loginForm:NgForm): void{
  this.loginService.login(loginForm.value).subscribe(
    (response:any)=>{
      this.token=response;
      this.loginService.loginUser(this.token.token);
      loginForm.reset();
      window.location.href="/shop"
     },
          (error: HttpErrorResponse) =>{
           alert(error.message);
           loginForm.reset();
         }     
  );
}




}


