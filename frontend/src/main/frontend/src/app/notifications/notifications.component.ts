import { Component, OnInit } from '@angular/core';
import { Notification } from  '../../dictionary/Notification';
import {NotificationsService} from "./notifications.service";
import { Router } from '@angular/router';


@Component({
  selector: 'app-notifications',
  templateUrl: './notifications.component.html',
  styleUrls: ['./notifications.component.css'],
  providers: [NotificationsService]
})
export class NotificationsComponent implements OnInit{

  notificationList: Array<Notification>;
  errorMessage: string;

  constructor(
    private router: Router,
    private service:NotificationsService) {  }

  ngOnInit() {
    this.getNotification();
}

  getNotification() {
    this.service.getNotifications().subscribe(
      data => this.notificationList = data,
      error => {
        this.router.navigate(['login']);
        this.errorMessage = <any>error
      }
    );
  }
}
