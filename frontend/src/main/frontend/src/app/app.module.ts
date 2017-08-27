import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpModule, JsonpModule } from '@angular/http';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { SelectModule } from 'ng2-select';

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
import { FacebookModule } from 'ngx-facebook';
import { ModalProjectComponent } from './project/modal-project/modal-project.component';
import { ModalTaskComponent } from './task-list/modal-task/modal-task.component';


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
    LoginComponent,
    ModalProjectComponent,
    ModalTaskComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routes,
    FacebookModule.forRoot(),
    NgbModule.forRoot(),
    ReactiveFormsModule,
    JsonpModule,
    SelectModule
  ],
  providers: [ AuthenticationService, CanActivateAuthGuard ],
  bootstrap: [AppComponent]
})
export class AppModule { }
