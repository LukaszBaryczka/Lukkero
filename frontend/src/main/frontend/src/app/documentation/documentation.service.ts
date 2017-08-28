import { Injectable } from '@angular/core';
import { Http, Headers, Response } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/map';
import { AppConfig } from '../../../src/config';
import {} from '@angular/http';
import { AuthenticationService } from '../login/authentication.service'
import {Documentation} from "../../dictionary/Documentation";


@Injectable()
export class DocumentationService {

  constructor(private http: Http, private authenticationService: AuthenticationService) { }

  private headers = new Headers({
    'Content-Type': 'application/json',
    'Authorization': this.authenticationService.getToken()
  });


  getDoc(projectId:number) {
    return this.http.get(
      AppConfig.API_BASE_URL
      + AppConfig.API_DOC_URL
      + "/" + projectId,
      {headers: this.headers})
      .map(response => response.json())
      .catch(this.handleError);
  }

  postDoc(doc : Documentation, projectId:number): Observable<boolean> {
    return this.http.post(
      AppConfig.API_BASE_URL
      + AppConfig.API_DOC_URL
      + "/" + projectId, JSON.stringify(doc),
      {
        headers: this.headers
      })
      .map((response: Response) => {
        return true;
      }).catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }

  share(projectId:number) {
    this.authenticationService.shareOnFacebook(
      AppConfig.API_BASE_FRONT_URL
      + AppConfig.API_DOC_URL
      + "/" + projectId)
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
