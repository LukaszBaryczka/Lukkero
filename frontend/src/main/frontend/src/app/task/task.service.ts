import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';
import { AppConfig } from '../../../src/config';
import { AuthenticationService } from '../login/authentication.service'

@Injectable()
export class TaskService {

  constructor(private http: Http, private authenticationService: AuthenticationService) { }

  private headers = new Headers({
    'Content-Type': 'application/json',
    'Authorization': this.authenticationService.getToken()
  });

  getTaskById(taskId:number) //: Promise<Task>
  {
    return this.http.get(AppConfig.API_BASE_URL
      + AppConfig.API_TASK_URL
      + "/" + taskId, {headers: this.headers})
      //.toPromise()
      .map(response => response.json())//.task as Task)
      .catch(this.handleError);
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
