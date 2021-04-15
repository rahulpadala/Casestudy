import { Injectable, Injector } from '@angular/core';
import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http'
import { LoginService } from './login.service'
import { Observable } from 'rxjs';
@Injectable()
export class TokenInterceptorService implements HttpInterceptor {

  constructor(private injector: Injector,private loginservice: LoginService){}
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let newReq = req;
    let token = this.loginservice.getToken();
    console.log("interceptor", token);

    if (token != null) {
        newReq = newReq.clone({ setHeaders: { Authorization: `Bearer ${token}` } })
    }

    return next.handle(newReq);

}

}