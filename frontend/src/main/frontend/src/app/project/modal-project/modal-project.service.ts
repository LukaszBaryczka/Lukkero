import { Injectable } from '@angular/core';
import {Observable} from "rxjs/Observable";
import {AuthenticationService} from "../../login/authentication.service";
import {Http, Headers, Response} from "@angular/http";
import {AppConfig} from "../../../config";
import {Project} from "../../../dictionary/Project";
import {User} from "../../../dictionary/User";

@Injectable()
export class ModalProjectService {

  private postUrl = AppConfig.API_BASE_URL+AppConfig.API_PROJECT_URL

  constructor(private http: Http, private authenticationService: AuthenticationService) { }

  private headers = new Headers({
    'Content-Type': 'application/json',
    'Authorization': this.authenticationService.getToken()
  });

  postProject(project : Project, selectedUser: Array<User>): Observable<boolean> {
    return this.http.post(this.postUrl, JSON.stringify(
      {
        project : project,
        selectedUser : selectedUser
      }),
      {
        headers: this.headers
      })
      .map((response: Response) => {
      return true;
      }).catch((error:any) => Observable.throw(error.json().error || 'Server error'));
  }

}
