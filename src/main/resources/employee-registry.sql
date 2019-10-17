drop schema if exists registry cascade;
create schema registry;

drop table if exists registry.login_credentials cascade;
create table registry.login_credentials (
	emp_id varchar(10) primary key,
	password varchar(15),
    created_by varchar(10),
	created_time timestamp
);

drop table if exists registry.employee_details cascade;
create table registry.employee_details (
	               emp_id varchar(10) primary key,
					first_name varchar(25),
					last_name varchar(25),
					email varchar(30),
					gender varchar(1),
					age int,
					created_by varchar(10),
					created_time timestamp,
					modified_time timestamp,
					FOREIGN KEY(created_by) references registry.login_credentials(emp_id)
					);


--select * from registry.login_credentials;
select * from registry.employee_details;