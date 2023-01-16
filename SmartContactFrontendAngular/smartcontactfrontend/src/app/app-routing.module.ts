import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './UserDashboard/login/login.component';
import { SignupComponent } from './UserDashboard/signup/signup.component';

const routes: Routes = [
  {
    path:'',component:HomeComponent
  },
{
  path:'login',component:LoginComponent
},
{path:'signup',component:SignupComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
