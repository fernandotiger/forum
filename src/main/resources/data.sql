insert into USER_DATA (name, email, password) values ('fernando', 'fernando@test.com', '123456');

insert into course (name, category) values ('Java course', 'Programming');

insert into topic (title, message, status, creation_date, author_id, course_id) values ('Java course is best?', 'I wanna know if it is', 'NOT_ANSWERED', '2021-09-05 19:00:00', 1, 1);
insert into topic (title, message, status, creation_date, author_id, course_id) values ('Python course is best?', 'I wanna know if python is the best', 'NOT_ANSWERED', '2021-09-05 20:00:00', 1, 1);

insert into answer (message, creation_date, topic_id, author_id) values ('Java course is the best', '2021-09-05 19:00:00',1, 1);