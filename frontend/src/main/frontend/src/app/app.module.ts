import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { ProjectComponent } from './project/project.component';
import { TaskListComponent } from './task-list/task-list.component';
import { MembersComponent } from './members/members.component';
import { TaskComponent } from './task/task.component';
import { ChangesComponent } from './changes/changes.component';
import { NotificationsComponent } from './notifications/notifications.component';
import { UserComponent } from './user/user.component';
import { ProjectListComponent } from './project-list/project-list.component';
import { LogoComponent } from './logo/logo.component';

@NgModule({
  declarations: [
    AppComponent,
    ProjectComponent,
    TaskListComponent,
    MembersComponent,
    TaskComponent,
    ChangesComponent,
    NotificationsComponent,
    UserComponent,
    ProjectListComponent,
    LogoComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
