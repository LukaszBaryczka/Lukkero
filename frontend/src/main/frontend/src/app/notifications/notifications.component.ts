import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-notifications',
  templateUrl: './notifications.component.html',
  styleUrls: ['./notifications.component.css']
})
export class NotificationsComponent {

  notificationList: Array<Notification> = [
    {
      from: 'Lukas',
      content: 'pierwsze powiadomienie'
    },
    {
      from: 'Lukas',
      content: 'pierwsze powiadomienie'
    },
    {
      from: 'Lukas',
      content: 'pierwsze powiadomienie'
    },
    {
      from: 'Lukas',
      content: 'pierwsze powiadomienie'
    },
    {
      from: 'Lukas',
      content: 'pierwsze powiadomienie'
    },
    {
      from: 'Lukas',
      content: 'pierwsze powiadomienie'
    },
    {
      from: 'Lukas',
      content: 'pierwsze powiadomienie'
    },
    {
      from: 'Lukas',
      content: 'pierwsze powiadomienie'
    }
  ]

}

export interface Notification {
  from:string;
  content:string
}
