import { Component, OnInit } from '@angular/core';
import { Notification } from  '../../dictionary/Notification'
import {NotificationsService} from "./notifications.service";

@Component({
  selector: 'app-notifications',
  templateUrl: './notifications.component.html',
  styleUrls: ['./notifications.component.css'],
  providers: [NotificationsService]
})
export class NotificationsComponent implements OnInit{

  notificationList: Array<Notification>;
  errorMessage: string;

  constructor(private service:NotificationsService) {  }

  ngOnInit() {
    this.getNotification();
}

  getNotification() {
    this.service.getNotifications().subscribe(
      data => this.notificationList = data,
      error => this.errorMessage = <any>error
    );
  }
}
