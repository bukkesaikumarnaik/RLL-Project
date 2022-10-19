import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user';
import { AuthService } from 'src/app/service/auth.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {

  name : string = '';
  username : string = '';
  password : string = '';
  cpassword : string = '';

  user : User = new User();

  constructor( private authService : AuthService, private route : Router) { }

  ngOnInit(): void {
    this.username = '';
    this.password = '';
    this.cpassword = '';
    this.name = '';
  }

  signup() {

    this.user.username = this.username;
    this.user.password = this.password;
    this.cpassword == this.password;
    this.user.name = this.name;
    this.user.role = 'user';

    this.authService.signUp(this.user).subscribe(res => {
      if(res == null ) {
        Swal.fire("Registration failed ! " + this.username , ' try again' , 'error');
        this.ngOnInit();
      }else {
        console.log("Registration successful");
        Swal.fire('Welcome '+ this.username,
         ' You can Login NOW!', 'info');
        this.route.navigate(['/']);
      }
    }, err => {
      Swal.fire("Registration failed.");
      this.ngOnInit();
    })

  }

}