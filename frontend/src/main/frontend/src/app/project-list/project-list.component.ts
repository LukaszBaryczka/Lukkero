import { Component, OnInit } from '@angular/core';
import { Project } from '../../dictionary/Project';
import {ProjectListService} from "./project-list.service";
import { Router } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-project-list',
  templateUrl: './project-list.component.html',
  styleUrls: ['./project-list.component.css'],
  providers: [ProjectListService]
})
export class ProjectListComponent implements OnInit {

  ngOnInit() {
    this.service.getProjectList().subscribe(
      data => this.projekty = data,
      error => {
        this.router.navigate(['login']);
        this.errorMessage = <any>error
      }
    );
  }

  projekty: Array<Project>;
  errorMessage: string;

  constructor(
    private router: Router,
    private service:ProjectListService,
    private location: Location) {  }

  goBack(){
    this.location.back();
  }
}
