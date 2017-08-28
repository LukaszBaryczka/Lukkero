import { Component, OnInit } from '@angular/core';
import { DocumentationService } from './documentation.service';
import { Router, ActivatedRoute } from "@angular/router";
import {Documentation} from "../../dictionary/Documentation";

@Component({
  selector: 'app-documentation',
  templateUrl: './documentation.component.html',
  styleUrls: ['./documentation.component.css'],
  providers: [DocumentationService]
})
export class DocumentationComponent implements OnInit {

  documentation : Documentation;
  doc:string;
  visibleEdit : boolean;
  projectId:number;
  errorMessage: string;

  constructor(private router: Router,
              private documentationService : DocumentationService,
              private route: ActivatedRoute) {
    this.visibleEdit = false;
    this.documentation = new Documentation;
  }

  ngOnInit() {
    let params: any = this.route.snapshot.params;
    this.projectId = params.projectId;
    this.getProject(this.projectId);
  }

  getProject(taskId) {
    this.documentationService.getDoc(taskId).subscribe(
      data => {this.documentation = data,
        this.doc = this.documentation.doc,
        console.log("Sprawdzam " + JSON.stringify(data)),
        console.log("Sprawdzam2 " + this.documentation)},
      error => {
        this.errorMessage = <any>error
      }
    );
  }

  edit() {
    this.visibleEdit = !this.visibleEdit;
  }

  doTextareaValueChange(ev) {
    try {
      this.doc = ev.target.value;
    } catch(e) {
      console.info('could not set textarea-value');
    }
  }

  onSubmit() {
    this.visibleEdit = !this.visibleEdit;

    this.documentation.doc = this.doc;

    this.documentationService.postDoc(this.documentation, this.projectId)
      .subscribe(result => {
        if (result === true) {
          console.log('updateDoc')
          window.location.reload();
        }});;
  }

  share() {
    console.log(this.projectId);
    this.documentationService.share(this.projectId);
  }

}
