import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/map';
import { AppConfig } from '../../../src/config';
import { AuthenticationService } from '../login/authentication.service'
import { Comment } from '../../dictionary/Comment'

@Injectable()
export class CommentService {

  constructor(private http: Http, private authenticationService: AuthenticationService) { }

  private headers = new Headers({
    'Content-Type': 'application/json',
    'Authorization': this.authenticationService.getToken()
  });


  getCommentFromProject(projectId:number) {
    return this.http.get(
      AppConfig.API_BASE_URL
      + AppConfig.API_PROJECT_URL
      + AppConfig.API_COMMENT_URL
      + "/" + projectId,
      {headers: this.headers})
      .map(response => response.json())
      .catch(this.handleError);
  }

  getCommentFromTask(taskId:number) {
    return this.http.get(
      AppConfig.API_BASE_URL
      + AppConfig.API_TASK_URL
      + AppConfig.API_COMMENT_URL
      + "/" + taskId,
      {headers: this.headers})
      .map(response => response.json())
      .catch(this.handleError);
  }

  postCommentFromProject(comment : Comment, projectId:number): Observable<boolean> {
    return this.http.post(
      AppConfig.API_BASE_URL
      + AppConfig.API_PROJECT_URL
      + AppConfig.API_COMMENT_URL
      + "/" + projectId,
      JSON.stringify(comment),
      {
        headers: this.headers
      })
      .map((response: Response) => {
        return true;
      }).catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }

  postCommentFromTask(comment : Comment, taskId:number): Observable<boolean> {
    return this.http.post(
      AppConfig.API_BASE_URL
      + AppConfig.API_TASK_URL
      + AppConfig.API_COMMENT_URL
      + "/" + taskId,
      JSON.stringify(comment),
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
