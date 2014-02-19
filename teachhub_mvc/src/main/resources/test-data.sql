insert into role (TITLE, PRIVILEGE) values ('admin', '11111111');
insert into role (TITLE, PRIVILEGE) values ('teacher', '11110000');
insert into role (TITLE, PRIVILEGE) values ('student', '00000000');

insert into contact_group (TITLE) values ('AB-02-1');

insert into contact (FIRST_NAME, LAST_NAME, PASSWORD, EMAIL, ROLE_ID, GROUP_ID) values ('Eugene', 'Krylov', 'pass1', 'ekrylov@mail.com', 1, 1);
insert into contact (FIRST_NAME, LAST_NAME, PASSWORD, EMAIL, ROLE_ID, GROUP_ID) values ('Elena', 'Krylova', 'pass2', 'ekrylova@mail.com', 2, 1);

insert into unit (TITLE, DESCRIPTION) values ('Lesson Present Simple', 'Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui.');
insert into unit (TITLE, DESCRIPTION) values ('Lesson Present Continues', 'Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Nullam quis risus eget urna mollis ornare vel eu leo. Donec ullamcorper nulla non metus auctor fringilla. Curabitur blandit tempus porttitor. Duis mollis, est non commodo luctus, nisi erat porttitor ligula, eget lacinia odio sem nec elit.');

insert into task_content (TASK_TYPE, QUESTION, RESPONSE_OPTION, CORRECT_ANSWER, POINT) values (0, 'I was a chemist at the Amos Cosmetics factory in New Jersey, USA, trying to design a new perfume when it happened. I never thought I would discover something quite so amazing by  ______.', 'incident,accident,event,occasion', 2, 10);
insert into task_content (TASK_TYPE, QUESTION, RESPONSE_OPTION, CORRECT_ANSWER, POINT) values (0, 'Uncle Will arrived at Kent at 5 p.m.  "What’s wrong with your father, Bess?" Will asked after ______ her with an affectionate embrace.', 'meeting,greeting,keeping,holding', 2, 10);
insert into task_content (TASK_TYPE, QUESTION, RESPONSE_OPTION, CORRECT_ANSWER, POINT) values (0, 'Daniel sailed out of Southampton on the Queen Mary that evening with his mother waving from the dockside. It was nice to have someone to see him ______ , someone who cared about him.', 'about,to,off,on', 3, 10);
insert into task_content (TASK_TYPE, QUESTION, RESPONSE_OPTION, CORRECT_ANSWER, POINT) values (0, 'Birthdays are great ________ for children.', 'event,fun,occasion,pleasure', 2, 10);
insert into task_content (TASK_TYPE, QUESTION, RESPONSE_OPTION, CORRECT_ANSWER, POINT) values (0, 'When dear old Mrs Bram went back to London after _________________ with the Hunters, she sent the children a dolls house.', 'remaining,living,visiting,staying', 4, 10);
insert into task_content (TASK_TYPE, QUESTION, RESPONSE_OPTION, CORRECT_ANSWER, POINT) values (0, 'I shall never forget, as long as I live, the day when I first set _________ in London.', 'feet,steps,foot,legs', 3, 10);
insert into task_content (TASK_TYPE, QUESTION, RESPONSE_OPTION, CORRECT_ANSWER, POINT) values (0, 'We had a heavenly day yesterday. We went to Stratford-on-Avon, the place where Shakespeare was born and died. It was a ________ day, for yesterday was April 23rd; that is St. George‘s Day – the saint of England – and that is the day on which Shakespeare was born, and also the day on which he died.', 'fitting,becoming,appropriate,suitable', 4, 10);
insert into task_content (TASK_TYPE, QUESTION, RESPONSE_OPTION, CORRECT_ANSWER, POINT) values (0, 'Jack was full of energy and _____________. He built a house and a barn and a blacksmith shop.', 'invention,suggestion,idea,theory', 1, 10);
insert into task_content (TASK_TYPE, QUESTION, RESPONSE_OPTION, CORRECT_ANSWER, POINT) values (1, 'Write a letter introducing yourself to a penpal.', '', 0, 10);

insert into task (TASK_CONTENT_ID, TITLE, DESCRIPTION) values (1, 'Grammar and vocabulary - questions to choose a correct answer', 'Read the text with gaps. Enter the number of option you choose an answer.');
insert into task (TASK_CONTENT_ID, TITLE, DESCRIPTION) values (2, 'Grammar and vocabulary - questions to choose a correct answer', 'Read the text with gaps. Enter the number of option you choose an answer.'); 
insert into task (TASK_CONTENT_ID, TITLE, DESCRIPTION) values (3, 'Grammar and vocabulary - questions to choose a correct answer', 'Read the text with gaps. Enter the number of option you choose an answer.');
insert into task (TASK_CONTENT_ID, TITLE, DESCRIPTION) values (4, 'Grammar and vocabulary - questions to choose a correct answer', 'Read the text with gaps. Enter the number of option you choose an answer.'); 
insert into task (TASK_CONTENT_ID, TITLE, DESCRIPTION) values (5, 'Grammar and vocabulary - questions to choose a correct answer', 'Read the text with gaps. Enter the number of option you choose an answer.');
insert into task (TASK_CONTENT_ID, TITLE, DESCRIPTION) values (6, 'Grammar and vocabulary - questions to choose a correct answer', 'Read the text with gaps. Enter the number of option you choose an answer.');
insert into task (TASK_CONTENT_ID, TITLE, DESCRIPTION) values (7, 'Grammar and vocabulary - questions to choose a correct answer', 'Read the text with gaps. Enter the number of option you choose an answer.');
insert into task (TASK_CONTENT_ID, TITLE, DESCRIPTION) values (8, 'Grammar and vocabulary - questions to choose a correct answer', 'Read the text with gaps. Enter the number of option you choose an answer.');
insert into task (TASK_CONTENT_ID, TITLE, DESCRIPTION) values (9, 'Write', 'Write task');

insert into unit_task (UNIT_ID, TASK_ID) values (1, 1);
insert into unit_task (UNIT_ID, TASK_ID) values (1, 2);
insert into unit_task (UNIT_ID, TASK_ID) values (1, 3);
insert into unit_task (UNIT_ID, TASK_ID) values (1, 4);
insert into unit_task (UNIT_ID, TASK_ID) values (2, 5);
insert into unit_task (UNIT_ID, TASK_ID) values (2, 6);
insert into unit_task (UNIT_ID, TASK_ID) values (2, 7);
insert into unit_task (UNIT_ID, TASK_ID) values (2, 8);
insert into unit_task (UNIT_ID, TASK_ID) values (2, 9);

insert into assignment (CONTACT_ID, UNIT_TASK_ID, STATUS, MARK, ANSWER) values (1, 1, 0, 0, '');
insert into assignment (CONTACT_ID, UNIT_TASK_ID, STATUS, MARK, ANSWER) values (1, 2, 0, 0, '');
insert into assignment (CONTACT_ID, UNIT_TASK_ID, STATUS, MARK, ANSWER) values (1, 3, 0, 0, '');
insert into assignment (CONTACT_ID, UNIT_TASK_ID, STATUS, MARK, ANSWER) values (1, 4, 0, 0, '');
insert into assignment (CONTACT_ID, UNIT_TASK_ID, STATUS, MARK, ANSWER) values (1, 5, 0, 0, '');
insert into assignment (CONTACT_ID, UNIT_TASK_ID, STATUS, MARK, ANSWER) values (1, 6, 0, 0, '');
insert into assignment (CONTACT_ID, UNIT_TASK_ID, STATUS, MARK, ANSWER) values (1, 7, 0, 0, '');
insert into assignment (CONTACT_ID, UNIT_TASK_ID, STATUS, MARK, ANSWER) values (1, 8, 0, 0, '');
insert into assignment (CONTACT_ID, UNIT_TASK_ID, STATUS, MARK, ANSWER) values (1, 9, 0, 0, '');