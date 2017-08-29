import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/map';
import { AppConfig } from '../../../src/config';
import { AuthenticationService } from '../login/authentication.service'
import { Notification } from '../../dictionary/Notification'

@Injectable()
export class NotificationsService {

  constructor(private http: Http, private authenticationService: AuthenticationService) { }

  private headers = new Headers({
    'Content-Type': 'application/json',
    'Authorization': this.authenticationService.getToken()
  });

  getNotifications() {
    return this.http.get(AppConfig.API_BASE_URL
      + AppConfig.API_NOTIFICATIONS_URL, {headers: this.headers})
      .map(response => response.json())
      .catch(this.handleError);
  }

  postNotifications(notification: Notification): Observable<boolean> {
    return this.http.post(AppConfig.API_BASE_URL
      + AppConfig.API_NOTIFICATIONS_URL, JSON.stringify(notification),
      {
        headers: this.headers
      })
      .map((response: Response) => {
        return true;
      }).catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }

  private handleError (error: Response | any) {
    // In a real world app, you might use a remote logging infrastructure
    let errMsg: string;
    if (error instanceof Response) {
      errMsg = `${error.status} - ${error.statusText || ''}`;
    } else {
      errMsg = error.message ? error.message : error.toString();
    }
    console.error(errMsg);
    return Observable.throw(errMsg);
  }

}
