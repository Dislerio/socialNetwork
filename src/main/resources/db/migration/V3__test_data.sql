insert into `person` (`id`,`first_name`, `last_name`, `reg_date`, `birth_date`, `e_mail`, `phone`,
`password`, `photo`, `about`, `town` , `confirmation_code`, `is_approved`,
`messages_permission`, `last_online_time` ,`is_blocked`, `is_online`) values
( '1','Иванов', 'Иван', '2015-01-21', '1963-03-25', 'ivaniavanov@mail.ru', '79234567895', 'asdf1234', null, 'good man', 'Tomsk','', b'0', 'ALL', '2013-10-08 16:07:28', b'0', b'1'),
( '2','Сидоров', 'Максим', '2010-07-22', '1985-05-14', 'sidorovmaxim@mail.ru', '79856321456', 'maxim1234', null, 'good man', 'Omsk','', b'0', 'ALL', '2019-06-08 10:09:29', b'0', b'1'),
( '3','Михайлов', 'Сергей', '2012-07-01', '1990-05-19', 'mihailovsergei@mail.ru', '79135546932', 'sergei1990', null, 'funny man', 'Moscow','', b'0', 'FRIENDS', '2019-06-15 15:07:28', b'0', b'1'),
( '4','Твердохлебов', 'Роман', '2005-05-05', '1991-06-12', 'roman1991@mail.ru', '79423652145', 'roman1991', null, 'strong man', 'Moscow','', b'0', 'FRIENDS', '2019-06-16 16:08:20', b'0', b'1'),
( '5','Быкова', 'Анастасия', '2013-12-02', '1998-01-17', 'nasty1998@mail.ru', '79456328975', 'nasty456', null, 'nice girl', 'Krum','', b'0', 'FRIENDS', '2019-05-15 05:07:12', b'0', b'1'),
( '6','Ефремова', 'Алена', '2015-08-08', '1987-06-06', 'efremovaalena@mail.ru', '79238856712', 'alenka1278', null, 'happy woman', 'Tula','', b'0', 'FRIENDS', '2019-06-16 12:09:28', b'0', b'0'),
( '7','Губкин', 'Иван', '2012-01-09', '1993-03-15', 'ivangubkin@mail.ru', '79452548235', 'ivan8235', null, 'busy man', 'Moscow','', b'0', 'ALL', '2019-06-15 21:01:28', b'0', b'1'),
( '8','Никифоров', 'Никита', '2019-01-08', '2005-09-09', 'nikita2005@mail.ru', '79234435614', 'nikita5614', null, 'little man', 'Kazan','', b'0', 'ALL', '2019-06-15 22:57:28', b'0', b'1'),
( '9','Васов', 'Вадим', '2018-07-07', '2003-01-05', 'vadikvasov@mail.ru', '79839541265', 'vadik1265', null, 'cool', 'Ufa','', b'0', 'FRIENDS', '2019-06-15 23:01:56', b'0', b'0'),
( '10','Дымова', 'Дарья', '2015-09-07', '1995-11-15', 'dumova1995@mail.ru', '79234331552', 'dumova1552', null, 'happy', 'Moscow','', b'0', 'FRIENDS', '2019-06-15 13:52:14', b'0', b'1');



insert into `user` (`id`,`name`,`e_mail`, `password`, `type`) values
('1','Алексей', 'alex_inbox@gmail.com', 'alex1224', 'ADMIN'),
('2','Вася', 'vasya_inbox@gmail.com', 'vasya456321', 'ADMIN'),
('3','Света', 'sveta2000@gmail.com', 'sveta789', 'MODERATOR'),
('4','Игорь', 'igor1995@gmail.com', 'igor1995', 'MODERATOR'),
('5','Артем', 'tema_box@gmail.com', 'artem1996', 'MODERATOR'),
('6','Кирилл', 'kirill_box@gmail.com', 'kirill2005', 'MODERATOR'),
('7','Даня', 'danil2001@gmail.com', 'passdanil1525', 'ADMIN'),
('8','Виталий', 'vitali_inbox@gmail.com', 'vitali1224', 'MODERATOR'),
('9','Максим', 'max_box@gmail.com', 'maxpass1995', 'ADMIN'),
('10','Айгуль', 'igul8888@gmail.com', 'aigulpass8888', 'ADMIN');

insert into `friendship` (`id`,`status_id`,`src_person_id`, `dst_person_id`) values
('1','1', '2', '3'),
('2','2', '5', '2'),
('3','3', '4', '7'),
('4','3', '5', '1'),
('5','2', '2', '1'),
('6','2', '5', '2'),
('7','4', '8', '4'),
('8','4', '7', '4'),
('9','5', '9', '8'),
('10','5', '10', '3');

insert into `friendship_status` (`id`,`time`, `name`, `code`) values
('1','2019-06-12 13:50:30', 'Максим', 'REQUEST'),
('2','2018-01-10 12:01:10', 'Анастасия', 'FRIEND'),
('3','2018-10-02 09:50:15', 'Роман', 'BLOCKED'),
('4','2019-02-02 17:42:10', 'Анастасия', 'BLOCKED'),
('5','2019-02-27 08:57:33', 'Максим', 'FRIEND'),
('6','2019-03-21 22:55:30', 'Анастасия', 'FRIEND'),
('7','2019-04-01 19:50:30', 'Никита', 'DECLINED'),
('8','2019-05-12 17:50:30', 'Иван', 'DECLINED'),
('9','2019-06-06 16:12:39', 'Вадим', 'SUBSCRIBED'),
('10','2019-06-12 07:55:30', 'Дарья', 'SUBSCRIBED');

insert into `message` (`id`,`time`,`author_id`, `recipient_id`, `message_text`, `read_status`) values
('1','2019-04-14 17:50:30', '1', '3', 'привет, пойдем гулять', 'READ'),
('2','2018-02-19 13:01:10', '2', '9', 'привет, СДЕЛАЛ ДОМАШКУ', 'READ'),
('3','2018-12-06 08:35:15', '3', '5', 'пока', 'READ'),
('4','2019-05-17 17:12:10', '7', '5', 'привет, познакомимся', 'READ'),
('5','2019-05-17 18:47:33',  '5', '7', 'привет, НЕТ', 'SENT'),
('6','2019-07-28 23:55:30',  '10', '1', 'удачи', 'READ'),
('7','2019-09-24 11:57:30',  '8', '5', 'привет, до завтра', 'SENT'),
('8','2019-10-17 04:14:30',  '5', '4', 'зимой поеду домой', 'READ'),
('9','2019-04-14 18:22:39',  '3', '1', 'через час дождь', 'SENT'),
('10','2019-06-09 16:15:30',  '8', '9', 'конференция через 3 месяца', 'SENT');

insert into `post` (`id`,`time`,`author_id`, `title`, `post_text`, `is_blocked`) values
('1','2018-12-06 08:35:15', '2', 'Конференция', 'В МГУ 1 марта будет проходить международная конференция среди молодых ученых, заявки принимаются до 1 февраля', b'1'),
('2','2018-12-28 18:14:15', '4', 'Новый год', 'Мандарины - символ Нового года. В магазинах "Пятерочка" всего за 69 р/кг', b'1'),
('3','2019-02-05 09:26:15', '6', 'Новый год по всоточному календарю', 'Многие жители нашей многонациональной страны празднуют Новый год по восточному календарю', b'1'),
('4','2019-03-01 18:18:15', '10', 'Отдых за границей', 'Названы самые бюджетные варианты стран, куда можно отправиться всей семьей на море', b'1'),
('5','2019-03-24 12:52:15', '1', 'Масленица', 'В площади Ленина в предстоящие выходные пройдет ярмарка в честь масленницы', b'1'),
('6','2019-04-01 15:00:15', '5', 'Горящие туры', 'Успейте приобрести тур в солнечную Анапу по выгодным ценам', b'1'),
('7','2019-04-07 18:35:15', '7', 'Робототехника в России', 'Российские ученые изобрели робота-водителя', b'1'),
('8','2019-04-12 11:53:15', '9', 'День космонавтики', 'В день космонавтики мэр вручил дипломы ректору нашего университета', b'1'),
('9','2019-05-01 08:00:15', '8', 'Сборная России в чемпионате Европы пробился в полуфинал', 'Вратарь сборной проявил себя ловким и не пропустил ни одного гола. Благодаря ему команда одержала победу', b'1'),
('10','2019-05-05 18:35:15', '5', 'Худеть легко', 'Добавьте в свой ежедневный рацион грейфрут', b'1');

insert into `tag`(`id`,`tag`) values
('1','Погода'),
('2','Праздники'),
('3','Здоровье'),
('4','Наука'),
('5','Политика'),
('6','Путешествия'),
('7','Спорт'),
('8','Религия'),
('9','Еда'),
('10','Технологии');

insert into `post2tag`(`id`,`post_id`, `tag_id`) values
('1','1', '4'),
('2','2', '9'),
('3','3', '8'),
('4','4', '6'),
('5','5', '2'),
('6','6', '6'),
('7','7', '4'),
('8','8', '2'),
('9','9', '7'),
('10','10', '9');

insert into `post_like`(`id`,`time`,`person_id`, `post_id`) values
('1','2018-12-06 08:35:15', '2','2'),
('2','2015-11-14 07:01:56', '1','8'),
('3','2013-08-02 11:55:01', '5','4'),
('4','2011-07-04 12:12:10', '3','5'),
('5','2018-05-01 17:59:22', '1','2'),
('6','2016-03-16 18:17:39', '10','3'),
('7','2017-04-17 23:31:47', '4','7'),
('8','2016-11-12 12:02:54', '8','1'),
('9','2013-11-14 04:12:12', '9','3'),
('10','2019-01-18 05:14:51', '4','8'),
('11','2014-07-15 03:07:02', '3','7'),
('12','2015-06-19 17:12:15', '5','6'),
('13','2019-08-15 22:22:15', '3','7');

insert into `post_file`(`id`,`post_id`, `name`, `path`) values
('1','1', 'forma.doc','d:/Conference/'),
('2','1', 'zaiavlenie.doc','d:/Conference/'),
('3','1', 'list.doc','d:/Conference/'),
('4','2', 'orange.png','d:/Images/'),
('5','5', 'vesna.mp3','d:/Music/'),
('6','6', 'sun.png','d:/Images/'),
('7','6', 'komorovo.mp3','d:/Music/'),
('8','10', 'fruit.png','d:/Images/'),
('9','7', 'robot.png','d:/Images/');


insert into `post_comment`(`id`,`time`, `post_id`, `parent_id`, `author_id`, `comment_text`, `is_blocked`) values
('1','2018-12-06 11:00:15', '1',NULL, '4','Дистанционно можно участвовать?', b'0'),
('2','2018-12-06 15:40:15', '1','1', '2','Да, взнос 1000 руб', b'0'),
('3','2018-12-28 21:10:15', '2', NULL, '10', 'Еще бы', b'0'),
('4','2019-03-02 17:11:00', '4', NULL, '2', 'Какое море, на рыбалку с пацанами съездить бы хоть', b'0'),
('5','2019-03-02 18:51:00', '4', '5', '3', 'Точняк, хоть нормально отдохням без бабских "А сфотай так, а сфотай сидя еще..." ', b'0'),
('6','2019-03-02 18:54:00', '4', '6', '2', 'Все, на майские поедем', b'0'),
('7','2019-05-01 18:01:15', '9', NULL, '3', 'Красавик Акинфеев!!! Тащит всю команду', b'0'),
('8','2019-05-01 18:40:15', '9', '7', '4', 'Как в ЧМ. Гордость нашего народа. Ты до конца смотрел матч', b'0'),
('9','2019-05-01 18:45:15', '9', '8', '3', 'Нет, до 3 раунда', b'0'),
('10','2019-05-01 18:45:15', '9', '9', '4', 'Тогда зрелищное пропустил в конце 4 раунда', b'0');



insert into `notification_type`(`id`,`code` , `name`) values
('1','101','POST' ),
('2','102','POST_COMMENT' ),
('3','103', 'COMMENT_COMMENT'),
('4','104', 'FRIEND_REQUEST'),
('5','105', 'MESSAGE');

insert into `notification` (`id`,`type_id`, `sent_time`, `person_id`, `entity_id`, `contact`) values
('1','2', '2018-12-06 11:00:15', '2', '1', 'sidorovmaxim@mail.ru'),
('2','2', '2018-12-06 15:40:15', '4', '1', 'roman1991@mail.ru'),
('3','5', '2019-04-14 17:50:30', '3', '1', 'mihailovsergei@mail.ru'),
('4','5', '2019-04-14 18:22:39', '1', '9', 'ivaniavanov@mail.ru'),
('5','4', '2019-06-12 13:50:30', '3', '4', 'nasty1998@mail.ru'),
('6','1', '2018-12-06 08:35:15', '8','9', 'roman1991@mail.ru'),
('7','2', '2019-03-02 17:11:00', '2','4', 'dumova1995@mail.ru'),
('8','3', '2019-03-02 18:51:00', '5','5', 'sidorovmaxim@mail.ru'),
('9','3', '2019-03-02 18:54:00', '6','3', 'mihailovsergei@mail.ru'),
('10','2', '2018-12-28 21:10:15', '10','3', 'roman1991@mail.ru');

insert into `block_history` (`id`,`time`, `person_id`, `post_id`, `comment_id`, `action`) values
('1','2019-05-15 13:12:14', '4', '1', '1', 'UNBLOCK'),
('2','2016-01-10 18:16:33', '2', '1', '2', 'UNBLOCK'),
('3','2017-05-12 14:12:51', '10', '2', '3', 'UNBLOCK'),
('4','2017-10-10 05:00:42', '2', '4', '4', 'UNBLOCK'),
('5','2017-11-10 05:05:52', '3', '4', '5', 'UNBLOCK'),
('6','2018-08-08 17:17:10', '2', '4', '6', 'UNBLOCK'),
('7','2019-01-21 02:42:48', '3', '9', '7', 'UNBLOCK'),
('8','2019-02-25 08:32:16', '4', '9', '8', 'UNBLOCK'),
('9','2019-04-14 10:57:14', '3', '9', '9', 'UNBLOCK'),
('10','2019-06-12 13:50:30', '4', '9', '10', 'UNBLOCK');
