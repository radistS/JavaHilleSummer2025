CREATE SCHEMA if not exists app;


CREATE TABLE Users (
                       id int auto_increment primary key,
                       last_name varchar(255),
                       first_name varchar(255),
                       email varchar(100) not null,
                       phone varchar(15),
                       password varchar(50) not Null default 'xxxxxx'
);

alter table users add last_update timestamp;

alter table users add age int;

insert into users (last_name, first_name, email, phone)
values ('Ivan', 'Ivanov', 'ivan.ivanov@mail.com', '+38005566554433');
insert into users (last_name, first_name, email, phone) values ('Petr', 'Petrov', 'email2@mail.com', '+38005566554434');
insert into users (last_name, first_name, email, phone) values ('Sidr', 'Sidorov', 'email3@mail.com', '+38005566554435');

Update users set age = 25 where id = 1;
Update users set age = 33 where id = 2;
Update users set age = 12 where id = 3;
Update users set age = 45 where id = 4;


drop table users;

truncate table users;

ALTER TABLE users
    DROP COLUMN last_update;

Update users set password = 'password1' where id = 1;
Update users set password = 'password2' where id = 2;
Update users set password = 'password3' where id = 3;

select * from users where Users.age < 20;

select * from users where last_name = 'Ivan';
