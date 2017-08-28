import { Component, OnInit } from '@angular/core';
import { CommentService } from './comment.service';
import { Router, ActivatedRoute } from "@angular/router";
import { Comment } from '../../dictionary/Comment'

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css'],
  providers: [CommentService]
})
export class CommentComponent implements OnInit {

  projectId: number;
  taskId: number;
  comments: Array<Comment>;
  errorMessage: string;
  comment: Comment;

  constructor(private router: Router,
              private commentService : CommentService,
              private route: ActivatedRoute) {
    this.comment = new Comment;
  }

  ngOnInit() {
    let params: any = this.route.snapshot.params;
    this.projectId = params.projectId;
    this.taskId = params.taskId;

    if(!(typeof this.projectId === "undefined")) {
      console.log("GET!! projectId: " + this.projectId);
      this.getCommentFromProject(this.projectId);
    } else if (!(typeof this.taskId === "undefined")) {
      console.log("GET!! taskId: " + this.taskId);
      this.getCommentFromTask(this.taskId);
    }

    console.log("projectId: " + this.projectId);
    console.log("taskId: " + this.taskId);
  }

  getCommentFromProject(projectId) {
    this.commentService.getCommentFromProject(projectId).subscribe(
      data => {
        this.comments = data,
        console.log("Sprawdzam " + JSON.stringify(data)),
        console.log("Sprawdzam2 " + this.comments)},
      error => {
        this.errorMessage = <any>error
      }
    );
  }

  getCommentFromTask(taskId) {
    this.commentService.getCommentFromTask(taskId).subscribe(
      data => {
        this.comments = data,
        console.log("getCommentFromTask"),
        console.log(this.comments)},
      error => {
        this.errorMessage = <any>error
      }
    );
  }

  doTextareaValueChange(ev) {
    try {
      this.comment.content = ev.target.value;
    } catch(e) {
      console.info('could not set textarea-value');
    }
  }

  onSubmit() {
    if(!(typeof this.projectId === "undefined")) {
      this.commentService.postCommentFromProject(this.comment, this.projectId)
        .subscribe(result => {
          if (result === true) {
            console.log('updateComment')
            window.location.reload();
          }});
    } else if(!(typeof this.taskId === "undefined")) {
      this.commentService.postCommentFromTask(this.comment, this.taskId)
        .subscribe(result => {
          if (result === true) {
            console.log('updateComment')
            window.location.reload();
          }});
    }
  }

}
