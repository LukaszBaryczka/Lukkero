CREATE DATABASE  IF NOT EXISTS `LukkeroProd` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_polish_ci */;
USE `LukkeroProd`;

DROP TABLE IF EXISTS `authority`;
DROP TABLE IF EXISTS `changes`;
DROP TABLE IF EXISTS `comment`;
DROP TABLE IF EXISTS `customer`;
DROP TABLE IF EXISTS `documentation`;
DROP TABLE IF EXISTS `notification`;
DROP TABLE IF EXISTS `project`;
DROP TABLE IF EXISTS `task`;
DROP TABLE IF EXISTS `user_authority`;
DROP TABLE IF EXISTS `user_project`;

CREATE TABLE authority (
  authority_id bigint(20) NOT NULL,
  name varchar(20) DEFAULT NULL,
  PRIMARY KEY (authority_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE documentation (
  documentation_id bigint(20) NOT NULL AUTO_INCREMENT,
  doc varchar(5000) DEFAULT NULL,
  PRIMARY KEY (documentation_id)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE customer (
  customer_id bigint(20) NOT NULL AUTO_INCREMENT,
  first_name varchar(20) DEFAULT NULL,
  last_name varchar(20) DEFAULT NULL,
  email varchar(50) DEFAULT NULL,
  work_time date DEFAULT NULL,
  username varchar(50) DEFAULT NULL,
  password varchar(500) DEFAULT NULL,
  enabled tinyint(1) DEFAULT NULL,
  last_password_reset_date date DEFAULT NULL,
  PRIMARY KEY (customer_id)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

CREATE TABLE project (
  project_id bigint(20) NOT NULL AUTO_INCREMENT,
  title varchar(20) DEFAULT NULL,
  description varchar(500) DEFAULT NULL,
  amount_tasks decimal(10,0) DEFAULT NULL,
  complete_tasks decimal(10,0) DEFAULT NULL,
  user_tasks decimal(10,0) DEFAULT NULL,
  deadline date DEFAULT NULL,
  documentation bigint(20) DEFAULT NULL,
  PRIMARY KEY (project_id),
  KEY documentation (documentation),
  CONSTRAINT project_ibfk_1 FOREIGN KEY (documentation) REFERENCES documentation (documentation_id)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;

CREATE TABLE task (
  task_id bigint(20) NOT NULL AUTO_INCREMENT,
  title varchar(100) DEFAULT NULL,
  description varchar(500) DEFAULT NULL,
  deadline date DEFAULT NULL,
  ess_time date DEFAULT NULL,
  all_time date DEFAULT NULL,
  day_time date DEFAULT NULL,
  customer bigint(20) DEFAULT NULL,
  project bigint(20) DEFAULT NULL,
  PRIMARY KEY (task_id),
  KEY customer (customer),
  KEY project (project),
  CONSTRAINT task_ibfk_1 FOREIGN KEY (customer) REFERENCES customer (customer_id),
  CONSTRAINT task_ibfk_2 FOREIGN KEY (project) REFERENCES project (project_id)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

CREATE TABLE changes (
  change_id bigint(20) NOT NULL AUTO_INCREMENT,
  customer bigint(20) DEFAULT NULL,
  project bigint(20) DEFAULT NULL,
  task bigint(20) DEFAULT NULL,
  visible tinyint(1) DEFAULT NULL,
  PRIMARY KEY (change_id),
  KEY customer (customer),
  KEY project (project),
  KEY task (task),
  CONSTRAINT changes_ibfk_1 FOREIGN KEY (customer) REFERENCES customer (customer_id),
  CONSTRAINT changes_ibfk_2 FOREIGN KEY (project) REFERENCES project (project_id),
  CONSTRAINT changes_ibfk_3 FOREIGN KEY (task) REFERENCES task (task_id)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

CREATE TABLE comment (
  comment_id bigint(20) NOT NULL AUTO_INCREMENT,
  content varchar(500) DEFAULT NULL,
  task bigint(20) DEFAULT NULL,
  project bigint(20) DEFAULT NULL,
  PRIMARY KEY (comment_id),
  KEY project (project),
  KEY task (task),
  CONSTRAINT comment_ibfk_1 FOREIGN KEY (project) REFERENCES project (project_id),
  CONSTRAINT comment_ibfk_2 FOREIGN KEY (task) REFERENCES task (task_id)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

CREATE TABLE notification (
  notification_id bigint(20) NOT NULL AUTO_INCREMENT,
  customer bigint(20) DEFAULT NULL,
  project bigint(20) DEFAULT NULL,
  task bigint(20) DEFAULT NULL,
  visible tinyint(1) DEFAULT NULL,
  PRIMARY KEY (notification_id),
  KEY customer (customer),
  KEY project (project),
  KEY task (task),
  CONSTRAINT notification_ibfk_1 FOREIGN KEY (customer) REFERENCES customer (customer_id),
  CONSTRAINT notification_ibfk_2 FOREIGN KEY (project) REFERENCES project (project_id),
  CONSTRAINT notification_ibfk_3 FOREIGN KEY (task) REFERENCES task (task_id)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8;

CREATE TABLE user_authority (
  customer_id bigint(20) DEFAULT NULL,
  authority_id bigint(20) DEFAULT NULL,
  KEY customer_id (customer_id),
  KEY authority_id (authority_id),
  CONSTRAINT user_authority_ibfk_1 FOREIGN KEY (customer_id) REFERENCES customer (customer_id),
  CONSTRAINT user_authority_ibfk_2 FOREIGN KEY (authority_id) REFERENCES authority (authority_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE user_project (
  project_id bigint(20) DEFAULT NULL,
  customer_id bigint(20) DEFAULT NULL,
  KEY customer_id (customer_id),
  KEY project_id (project_id),
  CONSTRAINT user_project_ibfk_1 FOREIGN KEY (customer_id) REFERENCES customer (customer_id),
  CONSTRAINT user_project_ibfk_2 FOREIGN KEY (project_id) REFERENCES project (project_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
