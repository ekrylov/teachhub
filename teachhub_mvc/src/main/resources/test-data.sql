insert into role (TITLE, PRIVILEGE) values ('admin', '11111111');
insert into role (TITLE, PRIVILEGE) values ('teacher', '11110000');
insert into role (TITLE, PRIVILEGE) values ('student', '00000000');

insert into contact_group (TITLE) values ('AB-02-1');

insert into contact (FIRST_NAME, LAST_NAME, PASSWORD, EMAIL, ROLE_ID, GROUP_ID) values ('Eugene', 'Krylov', 'pass1', 'ekrylov@mail.com', 1, 1);
insert into contact (FIRST_NAME, LAST_NAME, PASSWORD, EMAIL, ROLE_ID, GROUP_ID) values ('Elena', 'Krylova', 'pass2', 'ekrylova@mail.com', 2, 1);

insert into unit (TITLE, DESCRIPTION) values ('Donec id elit non mi porta gravida at eget metus.', 'Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.');
insert into unit (TITLE, DESCRIPTION) values ('Fusce dapibus, tellus ac cursus commodo, tortor mauris', 'Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Nullam quis risus eget urna mollis ornare vel eu leo. Donec ullamcorper nulla non metus auctor fringilla. Curabitur blandit tempus porttitor. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit.');

insert into task (TITLE, DESCRIPTION) values ('Fusce dapibus', 'Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.');
insert into task (TITLE, DESCRIPTION) values ('Fusce dapibus', 'Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.'); 
insert into task (TITLE, DESCRIPTION) values ('Fusce dapibus', 'Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.');
insert into task (TITLE, DESCRIPTION) values ('Fusce dapibus', 'Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.'); 
insert into task (TITLE, DESCRIPTION) values ('Fusce dapibus', 'Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.');
insert into task (TITLE, DESCRIPTION) values ('Fusce dapibus', 'Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.');

insert into unit_task (UNIT_ID, TASK_ID) values (1, 1);
insert into unit_task (UNIT_ID, TASK_ID) values (1, 2);
insert into unit_task (UNIT_ID, TASK_ID) values (1, 3);
insert into unit_task (UNIT_ID, TASK_ID) values (1, 4);
insert into unit_task (UNIT_ID, TASK_ID) values (2, 3);
insert into unit_task (UNIT_ID, TASK_ID) values (2, 4);
insert into unit_task (UNIT_ID, TASK_ID) values (2, 5);
insert into unit_task (UNIT_ID, TASK_ID) values (2, 6);

insert into assignment (CONTACT_ID, UNIT_TASK_ID, STATUS, MARK) values (1, 1, 0, 0);
insert into assignment (CONTACT_ID, UNIT_TASK_ID, STATUS, MARK) values (1, 2, 0, 0);
insert into assignment (CONTACT_ID, UNIT_TASK_ID, STATUS, MARK) values (1, 3, 0, 0);
insert into assignment (CONTACT_ID, UNIT_TASK_ID, STATUS, MARK) values (1, 4, 0, 0);
insert into assignment (CONTACT_ID, UNIT_TASK_ID, STATUS, MARK) values (1, 5, 0, 0);
insert into assignment (CONTACT_ID, UNIT_TASK_ID, STATUS, MARK) values (1, 6, 0, 0);
insert into assignment (CONTACT_ID, UNIT_TASK_ID, STATUS, MARK) values (1, 7, 0, 0);
insert into assignment (CONTACT_ID, UNIT_TASK_ID, STATUS, MARK) values (1, 8, 0, 0);