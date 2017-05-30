import {Component, OnInit} from '@angular/core';
import { DataService } from './data.service'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [DataService]
})
export class AppComponent implements OnInit {
  title = 'Hello World';
  mojaZmienna = 'Liczba';
  liczba;
  errorMessage: string;

  constructor(private dataService: DataService) {}

  ngOnInit() { this.getData(); }

  getData() {
    this.dataService.fetchData().subscribe(
      data => this.liczba = data,
      error => this.errorMessage = <any>error
    );
  }
}
