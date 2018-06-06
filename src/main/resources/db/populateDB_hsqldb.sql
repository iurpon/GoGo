

DELETE FROM MENU;
DELETE FROM USERS;
DELETE FROM RESTAURANT;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO restaurant (name) VALUES
  ('Always fresh'),
  ('Good lunch'),
  ('Taco Bell'),
  ('Italian restaurant'),
  ('Burger King');

INSERT INTO menu (date, price, description, rest_id) VALUES
  ('2018-05-27', 23.34, 'chicken, barbeque sauce, vegetable, slice bread, milk', 100000),
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
  ('admin','admin@mail.ru','passAdmin',TRUE );