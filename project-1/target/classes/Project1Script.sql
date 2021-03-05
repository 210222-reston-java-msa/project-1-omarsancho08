create schema project1;

create table UserRoles(

	id serial primary key,
	role_name varchar(50) unique not null
);

create table users(
	id serial primary key,
	username varchar unique,
	pass varchar(50) not null,
	first_name varchar(50) not null,
	last_name varchar(50) not null,
	email varchar(50) unique,
	role_id int not null references UserRoles(id)
);


create table reimbursement_status(
	id serial primary key,
	status varchar(50) unique not null
);

create table reimbursement_type(
	id serial primary key,
	reimb_type varchar(50) unique not null
);

create table reimbursement(
	id serial primary key,
	amount numeric (20,2) default 0 not null ,
	submit_date timestamp not null,
	resolved_date timestamp not null,
	description varchar(50) not null,
	receipt bytea,
	author  integer references users(id),
	resolver integer references users(id),
	status_id integer references reimbursement_status(id),
	type_id integer references reimbursement_type(id)
		
);

insert into reimbursement_status (id, status) 
values ('1','Pending'),
		('2','Approved'),
		('3','Denied');

select * from userroles;
select * from reimbursement_status;

