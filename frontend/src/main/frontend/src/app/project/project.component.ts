import { Component, OnInit } from '@angular/core';
import {ProjectService} from "./project.service";
import {Project} from "../../dictionary/Project";
import {ActivatedRoute} from "@angular/router";
import { Router } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.css'],
  providers: [ProjectService]
})
export class ProjectComponent implements OnInit {

  projectId;
  project: Project;
  errorMessage: string;

  constructor(
    private router: Router,
    private service:ProjectService,
    private route: ActivatedRoute,
    private location: Location) {
    this.project = new Project();
  }

  ngOnInit() {
    this.getData();
    this.getProject(this.projectId);
  }

  getProject(taskId) {
    this.service.getProject(taskId).subscribe(
      data => {this.project = data,
        console.log("Sprawdzam " + JSON.stringify(data)),
        console.log("Sprawdzam2 " + this.project.name)},
      error => {
        this.router.navigate(['login']);
        this.errorMessage = <any>error
      }
    );
  }

  getData() {
    let params: any = this.route.snapshot.params;
    this.projectId = params.projectId;
    console.log("ProjectComponent Id project: " + this.projectId);
  }

  goBack(){
    this.location.back();
  }
}
