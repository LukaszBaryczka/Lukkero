import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FacebookService, LoginResponse } from 'ngx-facebook';

import { AuthenticationService } from './authentication.service';

@Component({
  selector: 'app-login',
  moduleId: module.id,
  templateUrl: 'login.component.html',
  styleUrls: ['login.component.css']
})

export class LoginComponent implements OnInit {
  model: any = {};
  loading = false;
  error = '';



  constructor(
    private router: Router,
    private authenticationService: AuthenticationService,
    private fb: FacebookService) { }

  ngOnInit() {
    // reset login status
    this.authenticationService.logout();
  }

  loginFacebook() {
    console.log("login");
    this.authenticationService.loginWithFacebook();
  }

  signUp() {
    console.log("signUp");
    this.authenticationService.signUpWithFacebook();
  }
}
