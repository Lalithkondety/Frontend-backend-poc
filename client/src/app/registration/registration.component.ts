import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';
import { User } from '../user';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  user = new User();
  msg='';
  constructor( private _service: LoginService, private _router : Router) { }

  ngOnInit(): void {
  }
  registerUser(){
    this.user.password= btoa(String(this.user.password))
    this._service.registerUserFromRemote(this.user).subscribe(
      data =>{
        console.log("responce recived")
        //this._router.navigate(['/login'])
        this.msg="Registration successfull";
       },
      error => {
        console.log("exception occure")
        this.msg = error.error;
       }
    );

  }
}
