import { Component, OnInit } from '@angular/core';
import { ChangesService } from "./changes.service";
import { Change } from "../../dictionary/Change";
import { Router } from '@angular/router';


@Component({
  selector: 'app-changes',
  templateUrl: './changes.component.html',
  styleUrls: ['./changes.component.css'],
  providers: [ChangesService]
})
export class ChangesComponent implements OnInit{

  changeList: Array<Change>;
  errorMessage: string;

  ngOnInit() {
    this.getChanges();
  }

  constructor(
    private service:ChangesService,
    private router: Router) {
  }

  getChanges() {
    this.service.getChanges().subscribe(
      data => {
        this.changeList = data;
        console.log("Changes");
        console.log(this.changeList);
        },

      error => {
        this.router.navigate(['login']);
        this.errorMessage = <any>error}
    );
  }

  visibleProject(change : Change) : boolean {
    if (change.project == null) {
      return true;
    } else {
      return false;
    }
  }

  visibleTask(change : Change) : boolean {
    if (change.task == null) {
      return true;
    } else {
      return false;
    }
  }
}
