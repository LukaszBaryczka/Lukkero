import {User} from "./User";
import {Project} from "./Project";
import {Task} from "./Task";

export class Notification {
  id:string
  customer:User;
  project:Project;
  task:Task;
  visible:boolean;
}
