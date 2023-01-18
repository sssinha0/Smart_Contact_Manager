import { Token } from '@angular/compiler';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { login } from 'src/app/model/login';
import { UserService } from 'src/app/service/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginuser:login=new login();
  userDetails:any;
  constructor(private userServices:UserService,private router:Router) { }

  ngOnInit(): void {
  }
  hide=true;
  
  login(data:login){
   this.userServices.login(data).subscribe(
    (data:any)=>{
      localStorage.setItem("token",data.token);
      Swal.fire("Sucess","Login ScuessFully",'success');
      this.userServices.loginStatusSubject.next(true);
      this.router.navigate(['/user-dashboard'])
    },
    (err:any)=>{
      Swal.fire("Error","Something went wrong",'error')
    }
   )
  }

}
