import { Component, OnInit } from '@angular/core';
import { signup } from 'src/app/model/signup';
import { UserService } from 'src/app/service/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  hide=true;
  signupuser:signup=new signup();
  errormessage:string='';
  constructor(private userServices:UserService) { }

  ngOnInit(): void {
  }
  signup(data:signup){
    this.errormessage='';
    console.log(data);
    this.userServices.signup(data).subscribe(
      (data:any)=>{
        Swal.fire("Sucess","Signup sucessfully ",'success');
        this.signupuser=new signup()
      },
      (err:any)=>{
     console.log(err);
       if(err.error.name!=null&&err.error.name!=undefined){
        this.errormessage+=err.error.name;
        Swal.fire("Name Error",this.errormessage,'error');
       }else
       if(err.error.password!=undefined&&err.error.password!=null){
        this.errormessage+=err.error.password;
        Swal.fire("Password Error",this.errormessage,'error');
       }else
       if(err.error.username!=null&&err.error.username!=undefined){
        this.errormessage+=err.error.username;
        Swal.fire("Username Error",this.errormessage,'error');
       }
       else if(err.error.errorName!=null&&err.error.errorName!=undefined){
        Swal.fire("Error",err.error.errorName,'error');
       }else{
        Swal.fire("Error","Server Error not responding",'error');
       }
        
      }
    )
  }
}
