drop table change;
drop table task;
drop table project;
drop table customer;
drop table notification;

create table customer(
customer_id bigint primary key not null,
first_name varchar(20),
last_name varchar(20),
email varchar(50),
work_time date
)

create table task(
task_id bigint primary key not null,
title varchar(20),
description varchar(500),
deadline date,
ess_time date,
all_time date,
day_time date,
customer bigint references customer(customer_id),
project bigint references project(project_id)
)

create table project (
project_id bigint primary key not null,
title varchar(20),
description varchar(20),
amount_tasks numeric,
complete_tasks numeric,
user_tasks numeric,
deadline date
)

create table change(
change_id bigint primary key not null,
customer bigint references customer(customer_id),
project bigint references project(project_id),
task bigint references task(task_id),
visible boolean
)

create table notification(
notification_id bigint primary key not null,
customer bigint references customer(customer_id),
project bigint references project(project_id),
task bigint references task(task_id),
visible boolean
)

create table user_project (
project_id bigint references project(project_id),
customer_id bigint references customer(customer_id)
);

alter table customer
add username varchar(50);

alter table customer
add password varchar(500);

alter table customer
add enabled varchar(50);

alter table customer
add last_password_reset_date date;

create table authority (
authority_id bigint primary key not null,
name varchar(20)
);


create table user_authority (
customer_id bigint references customer(customer_id),
authority_id bigint references authority(authority_id)
);