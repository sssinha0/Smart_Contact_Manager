import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { Observable, Subscriber } from 'rxjs';
import { login } from '../model/login';
import { loginresponse } from '../model/loginresponse';
import { signup } from '../model/signup';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private baseUrl:String="http://localhost:8090"

  public loginStatusSubject= new Subject<Boolean>();
  constructor(private http:HttpClient) { }

  login(data:login):Observable<any>{
    return  this.http.post<any>(`${this.baseUrl}/generate-token`,data);
  }
  signup(data:signup):Observable<any>{
    return this.http.post<any>(`${this.baseUrl}/user/signup`,data);
  }
  currentUser():Observable<any>{
    return this.http.get<any>(`${this.baseUrl}/current-user`);
  }

}
