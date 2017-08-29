import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Task } from '../../dictionary/Task';
import {TaskListService} from "./task-list.service";
import { Router } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css'],
  providers: [TaskListService]
})
export class TaskListComponent implements OnInit {
  projectId;

  tasks: Array<Task>;
  errorMessage: string;

  constructor(
    private router: Router,
    private service:TaskListService,
    private route: ActivatedRoute,
    private location: Location) {}

  ngOnInit() {
    this.getData();
    if(this.projectId == null) {
      this.getAllByUser();
    } else {
      this.getByProjectId(this.projectId)
    }
  }

  getData() {
    let params: any = this.route.snapshot.params;
    this.projectId = params.projectId;
    console.log("Id projektu: " + this.projectId);
  }

  getByProjectId(projectId) {
    this.service.getByProjectId(projectId).subscribe(
      data => this.tasks = data,
      error => {
        this.router.navigate(['login']);
        this.errorMessage = <any>error
      }
    );
  }

  getAllByUser() {
    this.service.getAllByUser().subscribe(
      data => this.tasks = data,
      error => {
        this.router.navigate(['login']);
        this.errorMessage = <any>error
      }
    );
  }

  goBack(){
    this.location.back();
  }
}

