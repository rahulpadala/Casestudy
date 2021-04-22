import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { User } from '../models/userprofile';
import { LoginService } from './login.service';

@Injectable({
  providedIn: 'root'
})
export class UserprofileService {

  private apiUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient,private loginservice:LoginService) { }

  public getUsers(): Observable<User[]>{
    return this.http.get<User[]>(`${this.apiUrl}/profile/viewAllUsers`)
  }

  public getUser(): Observable<any>{
    return this.http.get<User>(`${this.apiUrl}/token/user`);
     }

  public addNewCustomer(userprofile: User, role: string): Observable<User>{
    console.log(role);
    return this.http.post<User>(this.apiUrl+"/profile/add"+role ,userprofile);
  }

}
