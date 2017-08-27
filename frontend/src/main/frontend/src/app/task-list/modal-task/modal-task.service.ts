import { Injectable } from '@angular/core';
import {User} from "../../../dictionary/User";
import {Task} from "../../../dictionary/Task";
import {Observable} from "rxjs/Observable";
import {AuthenticationService} from "../../login/authentication.service";
import {Http, Response, Headers} from "@angular/http";
import {AppConfig} from "../../../config";
import {Project} from "../../../dictionary/Project";

@Injectable()
export class ModalTaskService {

  private postUrl = AppConfig.API_BASE_URL+AppConfig.API_TASK_URL

  constructor(private http: Http, private authenticationService: AuthenticationService) { }

  private headers = new Headers({
  'Content-Type': 'application/json',
  'Authorization': this.authenticationService.getToken()
  });

  postTask(task : Task, project: Project, customer: User): Observable<boolean> {
  return this.http.post(this.postUrl, JSON.stringify(
    {
      task : task,
      customer : customer,
      project : project
    }),
    {
      headers: this.headers
    })
    .map((response: Response) => {
      return true;
    }).catch((error:any) => Observable.throw(error.json().error || 'Server error'));
}
}
