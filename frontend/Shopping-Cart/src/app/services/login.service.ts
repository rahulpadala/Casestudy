import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Login } from '../models/login';
import { User } from '../models/userprofile'
import { Token } from '../models/token';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private apiServerUrl= environment.apiBaseUrl;
  constructor(private httpClient: HttpClient) { }

    
  public login(login: Login): Observable<Login>{
    return this.httpClient.post<Login>(`${this.apiServerUrl}/login/authenticate`,login);
  }

  public loginUser(token: Token){
    localStorage.setItem("token",token.token)
    localStorage.setItem("role",token.user.role)
    return true;
  }

  public logout(){
    localStorage.removeItem("token");
    localStorage.removeItem("role");
    location.reload();
  }

  isLoggedIn() {
    let token = localStorage.getItem("token");
    if (token == undefined || token === '' || token == null) {
      return false;
    } else {
      return true;
    }
  }

  isCustomer() {
    let role = localStorage.getItem("role");
    if (role === "Customer"){
      return true;
    }else{
      return false;
    }
  }

  isMerchant(){
    let role = localStorage.getItem("role");
    if(role === "Merchant")
    {
      return true;
    }
    return false;
  }

  isDeliveryAgent(){
    let role = localStorage.getItem("role");
    if(role === "DeliveryAgent")
    {
      return true;
    }
    return false;
  }

  getToken()
  {
    return localStorage.getItem("token");
  }

  // getRole()
  // {
  //   return 
  // }


}