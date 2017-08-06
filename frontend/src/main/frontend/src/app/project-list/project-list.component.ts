import { Component, OnInit } from '@angular/core';
import { Project } from '../../dictionary/Project';
import {ProjectListService} from "./project-list.service";

@Component({
  selector: 'app-project-list',
  templateUrl: './project-list.component.html',
  styleUrls: ['./project-list.component.css'],
  providers: [ProjectListService]
})
export class ProjectListComponent implements OnInit {

  ngOnInit() {}

  projekty: Array<Project>;
  errorMessage: string;

  constructor(private service:ProjectListService) {
    this.service.getProjectList().subscribe(
      data => this.projekty = data,
      error => this.errorMessage = <any>error
    );
  }
}
