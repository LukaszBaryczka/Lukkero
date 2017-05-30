import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-project-list',
  templateUrl: './project-list.component.html',
  styleUrls: ['./project-list.component.css']
})
export class ProjectListComponent {

  projekty: Array<Project> = [
    {
      nazwa:'pierwszy',
      czas:1,
      opis:'opis 1'
    },
    {
      nazwa:'drugi',
      czas:1,
      opis:'opis 2'
    },
    {
      nazwa:'trzeci',
      czas:1,
      opis:'opis 3'
    },
    {
      nazwa:'czwarty',
      czas:1,
      opis:'opis 4'
    },
    {
      nazwa:'piąty',
      czas:1,
      opis:'opis 5'
    }
  ]

}

export interface Project {
  nazwa:string;
  czas:number;
  opis:string;
}
