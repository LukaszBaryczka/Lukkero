import { Component, OnInit } from '@angular/core';
import { User } from '../../dictionary/User';
import { UserService } from "./user.service";
import { AuthenticationService } from '../login/authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css'],
  providers: [UserService]
})
export class UserComponent implements OnInit {

  user: User;
  errorMessage: string;

  constructor(
    private service:UserService,
    private authenticationService:AuthenticationService,
    private router: Router) {
      this.user = new User();
  }

  ngOnInit() {
    this.service.getUser().subscribe(
      data => this.user = data,
      error => {
        this.router.navigate(['login']);
        this.errorMessage = <any>error
      }
    );
  }

  logout() {
    this.authenticationService.logout();
    this.refresh();
  }

  refresh(): void {
    window.location.reload();
  }

  visibility() : boolean {
    return this.authenticationService.isLoggedIn();
  }
}
