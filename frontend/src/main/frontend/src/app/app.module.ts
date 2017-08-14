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
import { routes } from './app.router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component'
import { AuthenticationService } from "./login/authentication.service";
import { CanActivateAuthGuard } from './can-activate.authguard';


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
    LogoComponent,
    HomeComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routes
  ],
  providers: [ AuthenticationService, CanActivateAuthGuard ],
  bootstrap: [AppComponent]
})
export class AppModule { }
