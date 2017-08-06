import { Component, OnInit } from '@angular/core';
import {User} from "../../dictionary/User";
import {MembersService} from "./members.service";

@Component({
  selector: 'app-members',
  templateUrl: './members.component.html',
  styleUrls: ['./members.component.css'],
  providers: [MembersService]
})
export class MembersComponent implements OnInit {

  userList: Array<User>;
  errorMessage: string;

  ngOnInit() {
    this.getChanges();
  }

  constructor(private service:MembersService) {
  }

  getChanges() {
    this.service.getMembers().subscribe(
      data => this.userList = data,
      error => this.errorMessage = <any>error
    );
  }

}
