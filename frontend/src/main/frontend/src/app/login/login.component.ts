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
    console.log("funkcja");
    this.authenticationService.loginWithFacebook();
  }

  // login() {
  //   this.loading = true;
  //   this.authenticationService.login(this.model.username, this.model.password)
  //     .subscribe(result => {
  //       if (result === true) {
  //         // login successful
  //         this.router.navigate(['project-list']);
  //         this.refresh();
  //       } else {
  //         // login failed
  //         this.error = 'Username or password is incorrect';
  //         this.loading = false;
  //       }
  //     }, error => {
  //       this.loading = false;
  //       this.error = error;
  //     });
  // }
}
