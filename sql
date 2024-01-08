create table football_stadium(
f_code varchar(100),
city varchar(30) not null,
districe varchar(30) not null,
available_open time not null,
available_close time not null,
total_stadium_num int not null,
available int,
primary key(f_code));

create table reservation(
reservation_code varchar(100),
email varchar(100) not null,
f_code varchar(100) not null,
booking_date date not null,
reservation_date date default now(),
start_time int not null,
primary key(reservation_code));

create table tmt_file (
uuid varchar(200),
save_dir varchar(100),
file_name varchar(100),
primary key(uuid));