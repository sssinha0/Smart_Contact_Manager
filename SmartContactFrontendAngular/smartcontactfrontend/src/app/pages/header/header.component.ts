import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  token:any;
  isLoggedIn=false;
  userdata:any;
  message: string='';
  subscription: Subscription | undefined;
  constructor(private userService:UserService,private router:Router) { }

  ngOnInit(): void {
    this.userService.loginStatusSubject.asObservable().subscribe(
      (data)=>{
        this.isLoggedIn=true;
        this.userService.currentUser().subscribe(
          (data:any)=>{
            this.userdata=data;
            console.log("Sucess in header");
          }
          ,
          (err:any)=>{
            console.log("Error in the header file");
          }
        )
      },
      (err)=>{
        this.isLoggedIn=false;
      }
    )
    
  }
  logout(){
    localStorage.removeItem("token");
    this.isLoggedIn=false;
    this.router.navigate(['']);
  }
}
