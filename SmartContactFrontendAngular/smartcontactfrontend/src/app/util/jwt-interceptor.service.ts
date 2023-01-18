import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable()
export class JwtInterceptorService  implements HttpInterceptor{

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

    const token=localStorage.getItem("token");
    if(token){
    const authReq= req.clone({setHeaders:{Authorization:`Bearer ${token}`}});
    return next.handle(authReq);
    }else{
    return next.handle(req);
    }
}
}
