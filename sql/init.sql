create user db_admin superuser password 'myAdmin';

create schema if not exists simple_company;

CREATE SEQUENCE IF NOT EXISTS simple_company.employee_pkg
    MINVALUE 1  NO MAXVALUE
    START WITH 1;

create table if not exists simple_company.employee(
      id int primary key default nextval('simple_company.employee_pkg' :: regclass),
      first_name text not null ,
      last_name text not null ,
      email_id text not null
);

CREATE UNIQUE INDEX if not exists "employee_id_idx" ON simple_company.employee using btree(id ASC);

alter table simple_company.employee cluster on employee_id_idx;

insert into simple_company.employee(first_name, last_name, email_id) VALUES ('Tom', 'Cruse', 'cruse@icloud.com');
insert into simple_company.employee(first_name, last_name, email_id) VALUES ('Jon', 'Jones', 'jones@icloud.com');
