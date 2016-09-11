create database fin_bank_data;
  
create table fin_bank_data.otp_message(id bigint(20) not null auto_increment,
cust_application_id bigint(20) not null,
message varchar(200),
otp varchar(10) not null,
phone_no varchar(15),
created_at datetime not null,
used tinyint(1) default 0,
status varchar(50),
expired_at datetime not null,
primary key(id));

create table fin_bank_data.customer_application(id bigint(20) not null auto_increment,
bank_id bigint(20) not null,
status varchar(10),
response varchar(200),
primary key(id));

create table fin_bank_data.bank_detail(id bigint(20) not null auto_increment,
name varchar(100),
primary key(id));

create table fin_bank_data.bank_field(id bigint(20) not null auto_increment,
field_name varchar(100),
ui_name varchar(100),
field_type varchar(20),
default_value varchar(100),
internal_field tinyint(1) default 0,
mandatory tinyint(1) default 1,
primary key(id));

create table fin_bank_data.field_option(id bigint(20) not null auto_increment,
bank_field_id bigint(20) not null,
field_option varchar(20),
primary key(id));

create table fin_bank_data.bank_field_map(id bigint(20) not null auto_increment,
bank_id bigint(20) not null,
bank_field_id bigint(20) not null,
primary key(id));


create table fin_bank_data.bank_url(id bigint(20) not null auto_increment,
bank_id bigint(20) not null,
url varchar(100) not null,
url_type varchar(10) not null,
method varchar(10) not null,
primary key(id));



create table fin_bank_data.cust_application_field(id bigint(20) not null auto_increment,
application_id bigint(20) not null,
bank_field_id bigint(20) not null,
field_value varchar(200),
primary key(id));
select * from bank_url;