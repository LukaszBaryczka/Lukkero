import { Component, OnInit } from '@angular/core';
import {User} from "../../dictionary/User";
import {MembersService} from "./members.service";
import { Router } from '@angular/router';


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

  constructor(
    private router: Router,
    private service:MembersService) {
  }

  getChanges() {
    this.service.getMembers().subscribe(
      data => this.userList = data,
      error => {
        this.router.navigate(['login']);
        this.errorMessage = <any>error}
    );
  }

}
