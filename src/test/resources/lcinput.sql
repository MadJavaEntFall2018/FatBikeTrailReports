create table difficulty
(
  difficultyId int auto_increment
    primary key,
  name varchar(255) null
)
;

create table grooming_type
(
  groomingTypeId int auto_increment
    primary key,
  name varchar(255) null
)
;

create table role
(
  roleId int auto_increment
    primary key,
  createDate timestamp default CURRENT_TIMESTAMP not null,
  name varchar(255) null,
  updateDate timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP not null,
  userName varchar(255) not null,
  constraint userName_UNIQUE
  unique (userName)
)
;

create table trail
(
  trailId int auto_increment
    primary key,
  createDate timestamp default CURRENT_TIMESTAMP not null,
  description varchar(255) null,
  length decimal(19,2) null,
  lengthUnits varchar(255) null,
  location int null,
  name varchar(255) null,
  trailMap varchar(255) null,
  updateDate timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP not null,
  website varchar(255) null,
  difficulty int null,
  type int null,
  user int null,
  constraint FK_2cr12nofidid9db5lgy5t6uk9
  foreign key (difficulty) references difficulty (difficultyId)
)
;

create index fktrailtrail_type_idx
  on trail (type)
;

create index fktrailuser_idx
  on trail (user)
;

create index FK_2cr12nofidid9db5lgy5t6uk9
  on trail (difficulty)
;

create table trail_report
(
  trailReportId int auto_increment
    primary key,
  comments varchar(1000) null,
  conditions varchar(1000) null,
  createDate timestamp default CURRENT_TIMESTAMP not null,
  rideDate datetime null,
  updateDate timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP not null,
  grooming int null,
  trail int null,
  user int null,
  constraint fktrail_reportGrooming
  foreign key (grooming) references grooming_type (groomingTypeId),
  constraint fktrail_reporttrail
  foreign key (trail) references trail (trailId)
)
;

create index fktrail_reportGrooming
  on trail_report (grooming)
;

create index fktrail_reporttrail
  on trail_report (trail)
;

create index fktrail_reportuser_idx
  on trail_report (user)
;

create table trail_type
(
  trailTypeId int auto_increment
    primary key,
  name varchar(45) null
)
;

alter table trail
  add constraint fktrailtrail_type
foreign key (type) references trail_type (trailTypeId)
;

create table user
(
  userId int auto_increment
    primary key,
  createDate timestamp default CURRENT_TIMESTAMP not null,
  email varchar(255) null,
  firstName varchar(255) null,
  lastName varchar(255) null,
  password varchar(255) null,
  updateDate timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP not null,
  userName varchar(255) not null,
  constraint userName_UNIQUE
  unique (userName)
)
;

alter table role
  add constraint fkroleuser
foreign key (userName) references user (userName)
;

alter table trail
  add constraint fktrailuser
foreign key (user) references user (userId)
;

alter table trail_report
  add constraint fktrail_reportuser
foreign key (user) references user (userId)
;

