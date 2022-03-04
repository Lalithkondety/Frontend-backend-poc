import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';
import { User } from '../user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  user = new User();
  msg = "";

  constructor(private _service : LoginService, private _router : Router) { }

  ngOnInit(): void {
  }
  loginUser(){
   this.user.password= btoa(String(this.user.password))
   this._service.loginUserFromRemote(this.user).subscribe(
     data =>{
       console.log("responce recived")
       this._router.navigate(['/loginsuccess'])
      },
     error => {
       console.log("exception occure")
       this.msg = "Bad Credentials please enter valid emailid/password";
      }
   );
  }

  gotoregistration(){
    this._router.navigate(['/registration'])
  }
}
