import { Component, OnInit } from '@angular/core';
import { User } from '../../dictionary/User';
import {UserService} from "./user.service";

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css'],
  providers: [UserService]
})
export class UserComponent implements OnInit {

  user: User;
  errorMessage: string;

  constructor(private service:UserService) {
      this.user = new User();
  }

  ngOnInit() {
    this.service.getUser().subscribe(
      data => this.user = data,
      error => this.errorMessage = <any>error
    );
  }
}
