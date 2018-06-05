/*DELETE FROM user_roles;
DELETE FROM meals;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password) VALUES
  ('User', 'user@yandex.ru', 'password'),
  ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001),
  ('ROLE_USER', 100001);

INSERT INTO meals (date_time, description, calories, user_id) VALUES
  ('2015-05-30 10:00:00', 'Завтрак', 500, 100000),
  ('2015-05-30 13:00:00', 'Обед', 1000, 100000),
  ('2015-05-30 20:00:00', 'Ужин', 500, 100000),
  ('2015-05-31 10:00:00', 'Завтрак', 500, 100000),
  ('2015-05-31 13:00:00', 'Обед', 1000, 100000),
  ('2015-05-31 20:00:00', 'Ужин', 510, 100000),
  ('2015-06-01 14:00:00', 'Админ ланч', 510, 100001),
  ('2015-06-01 21:00:00', 'Админ ужин', 1500, 100001);*/

-- DELETE FROM users;
DELETE FROM menu;
DELETE FROM restaurant;
DELETE FROM users;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO restaurant (name) VALUES
  ('Always fresh'),
  ('Good lunch'),
  ('Taco Bell'),
  ('Italian restaurant'),
  ('Burger King');

INSERT INTO menu (date, price, description, rest_id) VALUES
  ('2018-05-27', 23.35, 'chicken, barbeque sauce, vegetable, slice bread, milk', 100000),
  ('2018-05-27', 18.22, 'hot dog, french fries, beans, fruit, milk',     100001),
  ('2018-05-27', 20.01, 'taco, cheese , salsa, fruit, milk', 100002),
  ('2018-05-27', 23.34, 'cheese, pizza, vegetable,fruit, milk', 100003),
  ('2018-05-27', 17.56, 'hamburger, ketchup, backed chips, fruit, milk', 100004);



INSERT INTO users (NAME, EMAIL, PASSWORD,ISADMIN) VALUES
  ('user1','user1@mail.ru','pass1',FALSE ),
  ('user2','user2@mail.ru','pass2',FALSE),
  ('user3','user3@mail.ru','pass3',FALSE),
  ('user4','user4@mail.ru','pass4',FALSE),
  ('user5','user5@mail.ru','pass5',FALSE),
  ('admin','admin@mail.ru','passAdmin',TRUE );/**/
