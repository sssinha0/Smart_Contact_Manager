import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-user-dash-board',
  templateUrl: './user-dash-board.component.html',
  styleUrls: ['./user-dash-board.component.css']
})
export class UserDashBoardComponent implements OnInit {
  toggle = true;
  
 
  constructor(private router:Router,private userService:UserService) { }

  ngOnInit(): void {
  }
  enableDisableRule() {
    this.toggle = !this.toggle;
}
logout(){
  localStorage.removeItem("token");
  this.userService.loginStatusSubject.next(false);
  this.router.navigate(['/home']);
}
}