insert into customer (customer_id, first_name, last_name, email, work_time)
values ( 1, "lbar", "bar", "email", null )

insert into project (project_id, title, description, amountTasks,
    completeTasks, userTasks, deadline)
values ( 1, "name1", "desc1", 3, 2, 1, null );
insert into project (project_id, title, description, amountTasks,
    completeTasks, userTasks, deadline)
values ( 2, "name2", "desc2", 3, 2, 1, null );

insert into task (task_id, title, description, deadline, essTime, allTime,
 dayTime, customer, project_id)
values ( 1, "name1", "desc1", null, null, null, null, 1, 1 );
insert into task (task_id, title, description, deadline, essTime, allTime,
 dayTime, customer, project_id)
values ( 2, "name2", "desc2", null, null, null, null, 1, 1 );
insert into task (task_id, title, description, deadline, essTime, allTime,
 dayTime, customer, project_id)
values ( 3, "name3", "desc3", null, null, null, null, 1, 1 );
insert into task (task_id, title, description, deadline, essTime, allTime,
 dayTime, customer, project_id)
values ( 4, "name4", "desc4", null, null, null, null, 1, 2 );
insert into task (task_id, title, description, deadline, essTime, allTime,
 dayTime, customer, project_id)
values ( 5, "name5", "desc5", null, null, null, null, 1, 2 );
insert into task (task_id, title, description, deadline, essTime, allTime,
 dayTime, customer, project_id)
values ( 6, "name6", "desc6", null, null, null, null, 1, 2 );

insert into change (change_id, customer, project, task, visible)
values (1, 1, 1, 1, true)
insert into change (change_id, customer, project, task, visible)
values (2, 1, 1, 2, true)
insert into change (change_id, customer, project, task, visible)
values (3, 1, 2, 3, true)
insert into change (change_id, customer, project, task, visible)
values (4, 1, 2, 4, true)

insert into notification (notification_id, customer, project, task, visible)
values (1, 1, 1, 1, true)
insert into change (change_id, customer, project, task, visible)
values (2, 1, 1, 2, true)
insert into change (change_id, customer, project, task, visible)
values (3, 1, 2, 3, true)
insert into change (change_id, customer, project, task, visible)
values (4, 1, 2, 4, true)

insert into user_project (project_id, customer_id)
values (1,1)
insert into user_project (project_id, customer_id)
values (2,1);
