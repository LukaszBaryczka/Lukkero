import {User} from "./User";
import {Project} from "./Project";

export class Task {
  taskId:string;
  name:string;
  description:string;
  deadline:string;
  essTime:string;
  allTime:string;
  dayTime:string;
  customer:User;
  project:Project;
}
