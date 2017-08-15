import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';
import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import { AppConfig } from '../../../src/config';
import { FacebookService, LoginResponse, InitParams } from 'ngx-facebook';
import { Router } from '@angular/router';


@Injectable()
export class AuthenticationService {
  private authUrl = AppConfig.API_BASE_URL+AppConfig.API_AUTH_URL
  private headers = new Headers({'Content-Type': 'application/json'});

  constructor(
    private http: Http,
    private fb: FacebookService,
    private router: Router) {
    let initParams: InitParams = {
      appId: '124156321556281',
      xfbml: true,
      version: 'v2.8'
    };

    fb.init(initParams);
  }

  loginWithFacebook() {
    this.fb.login({scope:'email'})
      .then((response: LoginResponse) =>
      { console.log('fb login')
        this.getUserDataFromFB().then(res => {
          console.log('get data from fb')
          this.login("admin", "admin")
              .subscribe(result => {
                if (result === true) {
                  console.log('jwt login')
                  this.router.navigate(['project-list']);
                  window.location.reload();
                }});
        })
        console.log(response);
      })
      .catch((error: any) => console.error(error));
  }

  getUserDataFromFB() {
    return this.fb.api('/me?fields=id,first_name,last_name,email,gender');
  }

  login(username: string, password: string): Observable<boolean> {
    return this.http.post(this.authUrl, JSON.stringify({username: username, password: password}), {headers: this.headers})
      .map((response: Response) => {
        // login successful if there's a jwt token in the response
        let token = response.json() && response.json().token;
        if (token) {
          // store username and jwt token in local storage to keep user logged in between page refreshes
          localStorage.setItem('currentUser', JSON.stringify({ username: username, token: token }));

          // return true to indicate successful login
          return true;
        } else {
          // return false to indicate failed login
          return false;
        }
      }).catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }

  getToken(): String {
    var currentUser = JSON.parse(localStorage.getItem('currentUser'));
    var token = currentUser && currentUser.token;
    return token ? token : "";
  }

  logout(): void {
    if(!(typeof this.fb.getAuthResponse() === "undefined")) {
      this.fb.logout().then(() =>console.log('logged out'));
    }
    localStorage.removeItem('currentUser');
  }

  isLoggedIn(): boolean {
    var token: String = this.getToken();
    return token && token.length > 0;
  }
}
