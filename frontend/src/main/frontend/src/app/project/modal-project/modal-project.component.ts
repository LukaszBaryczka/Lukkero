import { Component, OnInit } from '@angular/core';
import {NgbModal, ModalDismissReasons} from '@ng-bootstrap/ng-bootstrap';
import { MembersService } from '../../members/members.service'

import { ModalProjectService } from './modal-project.service'
import {User} from "../../../dictionary/User";
import {Project} from "../../../dictionary/Project";

@Component({
  selector: 'modal-project',
  templateUrl: './modal-project.component.html',
  providers: [ModalProjectService, MembersService]
})
export class ModalProjectComponent implements OnInit{
  closeResult: string;
  myOptions: Array<User>;
  project : Project;
  selectedUser: Array<User>;
  deadline;

  constructor(private modalService: NgbModal,
              private membersService : MembersService) {}

  ngOnInit() {
    this.project = new Project();
    this.membersService.getMembers().subscribe(
      data => this.myOptions = data
    );
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
    console.log("dodaje nowy projekt")
    console.log("Project name " + this.project.name)
    console.log("Project description " + this.project.description)
    if(!(typeof this.deadline === "undefined")) {
      this.project.deadline = this.deadline.year + "-"
      if (this.deadline.month < 10) {
        this.project.deadline += "0" + this.deadline.month + "-"
      } else {
        this.project.deadline += this.deadline.month + "-"
      }
      if (this.deadline.day < 10) {
        this.project.deadline += "0" + this.deadline.day
      } else {
        this.project.deadline += this.deadline.day
      }
    }
    console.log("Project deadline " + this.project.deadline)

    //TODO
    console.log(this.selectedUser)
  }
}
