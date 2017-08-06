import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { TaskListComponent } from './task-list/task-list.component';
import { TaskComponent } from './task/task.component';
import { ProjectListComponent } from './project-list/project-list.component';
import { ProjectComponent } from './project/project.component';
import { NotificationsComponent } from './notifications/notifications.component';
import { MembersComponent } from './members/members.component';
import { LogoComponent } from './logo/logo.component';
import { ChangesComponent } from './changes/changes.component';
import { UserComponent } from './user/user.component';
import { HomeComponent } from './home/home.component';
import {LoginComponent} from "./login/login.component";

export const router: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full'},
  { path: 'home', component: HomeComponent},
  { path: 'user', component: UserComponent},
  { path: 'logo', component: LogoComponent},
  { path: 'members', component: MembersComponent},
  { path: 'notifications', component: NotificationsComponent},
  { path: 'project-list', component: ProjectListComponent},
  { path: 'project-list/:projectId', component: TaskListComponent},
  { path: 'task-list', component: TaskListComponent},
  { path: 'task/:taskId', component: TaskComponent},
  { path: 'project/:projectId', component: ProjectComponent},
  { path: 'login', component: LoginComponent},
  { path: 'changes', component: ChangesComponent}
];

export const routes: ModuleWithProviders = RouterModule.forRoot(router);
