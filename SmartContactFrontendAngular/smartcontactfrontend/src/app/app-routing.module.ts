import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { MiddleComponent } from './pages/middle/middle.component';
import { AddcontactComponent } from './UserDashboard/addcontact/addcontact.component';
import { ContactdetailsComponent } from './UserDashboard/contactdetails/contactdetails.component';
import { LoginComponent } from './UserDashboard/login/login.component';
import { ProfileComponent } from './UserDashboard/profile/profile.component';
import { ShowcontactComponent } from './UserDashboard/showcontact/showcontact.component';
import { SignupComponent } from './UserDashboard/signup/signup.component';
import { UserDashBoardComponent } from './UserDashboard/user-dash-board/user-dash-board.component';

const routes: Routes = [
  {
    path:'',component:HomeComponent,
    children:[
      {path:'home',component:MiddleComponent},
      {path:'login',component:LoginComponent},
      {path:'signup',component:SignupComponent},
      {path:'about',component:UserDashBoardComponent},
      {path:'user-dashboard',component:UserDashBoardComponent,
      children:[
          {path:'add-contact',component:AddcontactComponent},
          {path:'show-contact',component:ShowcontactComponent},
          {path:'profile',component:ProfileComponent},
          {path:'view-contact',component:ContactdetailsComponent}
      ]}
    ]
  },
 
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
