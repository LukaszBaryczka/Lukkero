import { Component, OnInit } from '@angular/core';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { Router, ActivatedRoute } from '@angular/router';

import { MembersService } from '../../members/members.service';
import { ModalTaskService } from './modal-task.service';
import { ProjectService } from '../../project/project.service'
import { ProjectListService } from '../../project-list/project-list.service'
import {User} from "../../../dictionary/User";
import {Task} from "../../../dictionary/Task";
import {Project} from "../../../dictionary/Project";

@Component({
  selector: 'modal-task',
  templateUrl: './modal-task.component.html',
  providers: [ModalTaskService, MembersService, ProjectService,
    ProjectListService]
})
export class ModalTaskComponent implements OnInit{
  closeResult: string;
  users: Array<User>;
  projects: Array<Project>;
  task : Task;
  customer: User;
  project: Project;
  deadline;
  esstime;
  visible: boolean = false;
  projectId;
  userId;

  constructor(private modalService: NgbModal,
              private membersService : MembersService,
              private router: Router,
              private modalTaskService: ModalTaskService,
              private route: ActivatedRoute,
              private projectService: ProjectService,
              private projectListService: ProjectListService
  ) {}

  ngOnInit() {
    this.task = new Task();
    this.membersService.getMembers().subscribe(
      data => this.users = data
    );
    this.projectListService.getProjectList().subscribe(
      data => this.projects = data
    );

    let params: any = this.route.snapshot.params;
    this.projectId = params.projectId;
    if(typeof this.projectId === "undefined") {
      this.visible = true
    }
    if(!(typeof this.projectId === "undefined")) {
      this.projectService.getProject(this.projectId).subscribe(
        data => this.project = data
      );
    }
  }

  open(content) {
    this.modalService.open(content).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
      this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
    });
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return  `with: ${reason}`;
    }
  }

  onSubmit() {

    this.task.deadline = this.date(this.deadline, this.task.deadline)
    this.task.essTime = this.date(this.esstime, this.task.essTime)

    console.log("++++++++++++++++");
    console.log(this.task);
    console.log(this.customer);
    console.log(this.project);
    console.log("++++++++++++++++");

    this.modalTaskService.postTask(this.task, this.project, this.customer)
      .subscribe(result => {
        if (result === true) {
          console.log('add new project')
          window.location.reload();
        }});
  }

  private date(dateA: any, dateB:any) : string {
    if(!(typeof dateA === "undefined")) {
      dateB = dateA.year + "-"
      if (dateA.month < 10) {
        dateB += "0" + dateA.month + "-"
      } else {
        dateB += dateA.month + "-"
      }
      if (dateA.day < 10) {
        dateB += "0" + dateA.day
      } else {
        dateB += dateA.day
      }

      return dateB;
    }
  }
}
