---풋볼 구장---
create table football_stadium(
f_code varchar(100),
user_name varchar(100) not null,
stadium_name varchar(100) not null,
city varchar(30) not null,
districe varchar(30) not null,
available_open time not null,
available_close time not null,
total_stadium_num int not null,
available int,
description varchar(300),
primary key(f_code));


---예약---
create table reservation(
reservation_code varchar(100),
email varchar(100) not null,
f_code varchar(100) not null,
booking_date date not null,
reservation_date datetime default now(),
start_time int not null,
primary key(reservation_code));

---임시파일---
create table tmt_file (
uuid varchar(200),
save_dir varchar(100),
file_name varchar(100),
reg_at datetime default now(),
primary key(uuid));

---풋볼구장 이미지---
create table stadium_file(
f_code varchar(100),
uuid varchar(200),
save_dir varchar(100),
file_name varchar(100),
reg_at datetime default now(),
mod_at datetime,
primary key(uuid));

---풋볼구장 상세정보---
create table stadium_detail(
f_code varchar(100) not null,
stadium_detail_name varchar(100) not null,
size varchar(100) not null,
reg_at datetime default now());