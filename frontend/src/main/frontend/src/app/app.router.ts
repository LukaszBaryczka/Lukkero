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
import { LoginComponent } from "./login/login.component";
import { CanActivateAuthGuard } from './can-activate.authguard';
import { DocumentationComponent } from './documentation/documentation.component'

export const router: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full'},
  { path: 'home', component: HomeComponent, canActivate: [CanActivateAuthGuard]},
  { path: 'user', component: UserComponent, canActivate: [CanActivateAuthGuard]},
  { path: 'logo', component: LogoComponent, canActivate: [CanActivateAuthGuard]},
  { path: 'members', component: MembersComponent, canActivate: [CanActivateAuthGuard]},
  { path: 'notifications', component: NotificationsComponent, canActivate: [CanActivateAuthGuard]},
  { path: 'project-list', component: ProjectListComponent, canActivate: [CanActivateAuthGuard]},
  { path: 'project-list/:projectId', component: TaskListComponent, canActivate: [CanActivateAuthGuard]},
  { path: 'task-list', component: TaskListComponent, canActivate: [CanActivateAuthGuard]},
  { path: 'task/:taskId', component: TaskComponent, canActivate: [CanActivateAuthGuard]},
  { path: 'project/:projectId', component: ProjectComponent, canActivate: [CanActivateAuthGuard]},
  { path: 'doc/:projectId', component: DocumentationComponent, canActivate: [CanActivateAuthGuard]},
  { path: 'login', component: LoginComponent},
  { path: 'changes', component: ChangesComponent, canActivate: [CanActivateAuthGuard]}
];

export const routes: ModuleWithProviders = RouterModule.forRoot(router);
