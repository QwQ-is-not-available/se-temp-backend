create database if not exists se1;
use se1;
drop table if exists user;
create table user
(
    id           int primary key auto_increment comment 'id in user table',
    user_id      varchar(20) not null unique comment 'user id',
    nickname     varchar(20) not null comment 'user nickname',
    password     varchar(64) comment 'user pw',
    token        varchar(250) comment 'user token',
    push_setting tinyint default 1 comment '0=off, 1=on'
) comment 'user table';
drop table if exists device;
create table device
(
    id            bigint primary key auto_increment comment 'id in device table',
    name          varchar(30) not null comment 'device name',
    type          tinyint     not null comment 'type:1:.. 2:..',
    user_id       varchar(20) not null comment 'user id in user table',
    switch_status smallint default 0 comment 'status:0~100',
    text          varchar(100) comment 'ip or command'
) comment 'device table';
drop table if exists routine;
create table routine
(
    id           int primary key auto_increment comment 'id in routine table',
    user_id      varchar(20) not null comment 'user id in user table',
    name         varchar(30) not null comment 'routine name',
    on_off       tinyint default 0 comment '0=off, 1=on',
    trigger_type tinyint comment 'type:1:.. 2:..',
    trigger_id   int comment 'id in trigger table'
) comment 'routine table';
drop table if exists tri_location;
create table tri_location
(
    id        int primary key auto_increment comment 'id in tri_location table',
    mode      tinyint default 0 comment '0=entering, 1=leaving',
    longitude decimal(11, 7) comment 'longitude',
    latitude  decimal(11, 7) comment 'latitude'
) comment 'trigger location table';
drop table if exists tri_posture;
create table tri_posture(
	id int primary key auto_increment comment 'id in tri_posture table',
	mode tinyint default 0 comment '0=sit, 1=stand, 2=lie',
	left_top_x double not null comment 'left_top_x',
    left_top_y double not null comment 'left_bottom_y',
    right_bottom_x double not null comment 'right_top_x',
    right_bottom_y double not null comment 'right_bottom_y',
	ip varchar(15) comment 'camera ip'  #not in use now
) comment 'trigger posture table';
drop table if exists tri_assistant;
create table tri_assistant
(
    id      int primary key auto_increment comment 'id in tri_assistant table',
    command varchar(100) not null comment 'ip or comment'
) comment 'trigger assistant table';
drop table if exists tri_time;
create table tri_time
(
    id   int primary key auto_increment comment 'id in tri_time table',
    time datetime not null comment 'time'
) comment 'trigger time table';
drop table if exists action;
create table action
(
    id          int primary key auto_increment comment 'id in action',
    routine_id  int comment 'id in routine',
    action_type tinyint comment 'type:1:device, 2:time',
    action_id   int comment 'id in action table'
) comment 'action table';
drop table if exists act_device;
create table act_device
(
    id            int primary key auto_increment comment 'id in device action',
    device_id     bigint comment 'id in routine',
    switch_status smallint default 0 comment '(will be modified) status:0~100',
    text          varchar(100) comment '(will be modified) ip or command',
    order1 int not null
) comment 'action device table';
drop table if exists act_time;
create table act_time
(
    id   int primary key auto_increment comment 'id in device action',
    time int not null comment 'time',
    order1 int not null
) comment 'action time delay table';
drop table if exists log1;
create table log1
(
    id         int primary key auto_increment comment 'id in device action',
    user_id    varchar(20) not null comment 'user id in user table',
    time       datetime    not null comment 'time',
    routine_id int         not null comment 'id in routine table'
) comment 'log table';

