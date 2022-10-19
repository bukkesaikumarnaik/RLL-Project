import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { AuthService } from 'src/app/service/auth.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  username : string = '';
  password : string = '';
  role : string = '';
  user : User = new User();
  roles : string[];

        form = new FormGroup({
             emp_name:new FormControl('touched',Validators.required)
         })

  constructor(private authService : AuthService, private route : Router ) { 
      this.roles = [
      'admin',
      'user'
     ]  }

  ngOnInit(): void {
    this.username = '';
    this.password = '';
  }

  login() {
    this.user.username = this.username;
    this.user.password = this.password;
    this.user.role = this.role;

    this.authService.login(this.user).subscribe((res: { token: string;} | null) => {

      if(res == null) {
        Swal.fire('Uername or password is wrong',
        'Try Again',
          'error');
        this.ngOnInit();
      }
      else
       {
        localStorage.setItem("token",res.token);
        if(this.role == 'user') {
          this.route.navigate(['/user']);
          Swal.fire(this.username + ' LogedIn successfully',
          'Welcome Back',
          'success')
        } 
        if( this.role == 'admin') {
          this.route.navigate(['/admin']);
          Swal.fire('Admin LogedIn successfully',
          'Welcome Back',
          'success')
        }
      }

    }, err => {
      Swal.fire("Login failed ",
       'try again admin',
      'warning');
      this.ngOnInit();
    })

  }

}