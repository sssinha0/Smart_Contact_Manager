import { NgModule } from '@angular/core';
import {FormsModule,ReactiveFormsModule} from '@angular/forms'
import { BrowserModule } from '@angular/platform-browser';
import {MatToolbarModule} from '@angular/material/toolbar';
import { AppRoutingModule } from './app-routing.module';
import {MatButtonModule} from '@angular/material/button';
import { AppComponent } from './app.component';
import { HomeComponent } from './pages/home/home.component';
import { LoginComponent } from './UserDashboard/login/login.component';
import { SignupComponent } from './UserDashboard/signup/signup.component';
import { HeaderComponent } from './pages/header/header.component';
import { FooterComponent } from './pages/footer/footer.component';
import {MatCardModule} from '@angular/material/card';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatIcon, MatIconModule} from '@angular/material/icon';
import {MatSelectModule} from '@angular/material/select';
import {MatListModule} from '@angular/material/list';
import {MatInputModule} from '@angular/material/input';
import {MatTableModule} from '@angular/material/table';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatDividerModule} from '@angular/material/divider';
import {HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import { MiddleComponent } from './pages/middle/middle.component'
import { JwtInterceptorService } from './util/jwt-interceptor.service';
import { UserDashBoardComponent } from './UserDashboard/user-dash-board/user-dash-board.component';
import { ProfileComponent } from './UserDashboard/profile/profile.component';
import { ShowcontactComponent } from './UserDashboard/showcontact/showcontact.component';
import { AddcontactComponent } from './UserDashboard/addcontact/addcontact.component';
import { ContactdetailsComponent } from './UserDashboard/contactdetails/contactdetails.component';
import { CKEditorModule } from '@ckeditor/ckeditor5-angular';
@NgModule({
  declarations: [
    
    AppComponent,
    LoginComponent,
    HomeComponent,
    SignupComponent,
    HeaderComponent,
    FooterComponent,
    MiddleComponent,
    UserDashBoardComponent,
    ProfileComponent,
    ShowcontactComponent,
    AddcontactComponent,
    ContactdetailsComponent
  ],
  imports: [
    CKEditorModule,
    MatPaginatorModule,
    MatTableModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    MatDividerModule,
    MatFormFieldModule,
    MatSnackBarModule,
    MatInputModule,
    MatListModule,
    MatSelectModule,
    MatIconModule,
    MatGridListModule,
    BrowserModule,
    AppRoutingModule,
    MatToolbarModule,
    MatButtonModule,
    MatCardModule,
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: JwtInterceptorService,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
