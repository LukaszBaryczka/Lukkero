import { Component, OnInit } from '@angular/core';
import { Task } from '../../dictionary/Task'
import { ActivatedRoute } from '@angular/router'
import {TaskService} from "./task.service";
import { Router } from '@angular/router';
import { Location } from '@angular/common';

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css'],
  providers: [TaskService]
})
export class TaskComponent implements OnInit {

  taskId;
  task: Task;
  errorMessage: string;

  constructor(
    private router: Router,
    private service:TaskService,
    private route: ActivatedRoute,
    private location: Location) {
    this.task = new Task();
  }

  ngOnInit() {
    this.getData();
    this.getTask(this.taskId);
  }

  getTask(taskId) {
    this.service.getTaskById(taskId).subscribe(
      data => {this.task = data,
        console.log("Sprawdzam " + JSON.stringify(data)),
        console.log("Sprawdzam2 " + this.task.name)},
      error => {
        this.router.navigate(['login']);
        this.errorMessage = <any>error
      }
    );
  }

  getData() {
    let params: any = this.route.snapshot.params;
    this.taskId = params.taskId;
    console.log("TaskComponent Id taska: " + this.taskId);
  }

  goBack(){
    this.location.back();
  }

}
