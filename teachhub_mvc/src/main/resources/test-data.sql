insert into role (TITLE, PRIVILEGE) values ('admin', '11111111');
insert into role (TITLE, PRIVILEGE) values ('teacher', '11110000');
insert into role (TITLE, PRIVILEGE) values ('student', '00000000');

insert into contact (FIRST_NAME, LAST_NAME, PASSWORD, EMAIL, ROLE_ID) values ('Eugene', 'Krylov', 'pass1', 'ekrylov@mail.com', 1);
insert into contact (FIRST_NAME, LAST_NAME, PASSWORD, EMAIL, ROLE_ID) values ('Elena', 'Krylova', 'pass2', 'ekrylova@mail.com', 2);