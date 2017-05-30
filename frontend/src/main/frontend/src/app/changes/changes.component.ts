import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-changes',
  templateUrl: './changes.component.html',
  styleUrls: ['./changes.component.css']
})
export class ChangesComponent {

  changeList: Array<Changes> = [
    {
      who: 'Lukas',
      where: 'pierwsze powiadomienie',
      what: 'cos'
    },
    {
      who: 'Lukas',
      where: 'pierwsze powiadomienie',
      what: 'cos'
    },
    {
      who: 'Lukas',
      where: 'pierwsze powiadomienie',
      what: 'cos'
    },
    {
      who: 'Lukas',
      where: 'pierwsze powiadomienie',
      what: 'cos'
    },
    {
      who: 'Lukas',
      where: 'pierwsze powiadomienie',
      what: 'cos'
    },
    {
      who: 'Lukas',
      where: 'pierwsze powiadomienie',
      what: 'cos'
    },
    {
      who: 'Lukas',
      where: 'pierwsze powiadomienie',
      what: 'cos'
    },
    {
      who: 'Lukas',
      where: 'pierwsze powiadomienie',
      what: 'cos'
    }
  ]

}

export interface Changes {
  who:string;
  where:string;
  what:string
}
