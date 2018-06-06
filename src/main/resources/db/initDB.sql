DROP TABLE IF EXISTS votes;
DROP TABLE  IF EXISTS menu;
DROP TABLE IF EXISTS restaurant ;
DROP TABLE IF EXISTS users ;
DROP TABLE IF EXISTS label ;


DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 100000;


CREATE TABLE restaurant
(
  id    INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name  VARCHAR(255) NOT NULL
);
CREATE TABLE menu
(
  id    INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  date  DATE NOT NULL ,
  price NUMERIC NOT NULL,
  description VARCHAR(255) NOT NULL,
  rest_id INTEGER NOT NULL,
  FOREIGN KEY (rest_id) REFERENCES RESTAURANT (id)
);
CREATE UNIQUE INDEX menu_unique_restaurant_date_idx ON menu (rest_id, date);

CREATE TABLE users
(
  id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name             VARCHAR(255)            NOT NULL,
  email            VARCHAR(255)            NOT NULL,
  password         VARCHAR(255)            NOT NULL,
  isAdmin          BOOLEAN    NOT NULL

);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE votes
(
  id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  user_id          INTEGER NOT NULL,
  rest_id          INTEGER NOT NULL,
  date             DATE     NOT NULL ,
  FOREIGN KEY (rest_id) REFERENCES RESTAURANT (id) ,
  FOREIGN KEY (user_id) REFERENCES users (id)
);
CREATE UNIQUE INDEX votes_unique_user_date_idx ON votes (user_id, date);

CREATE TABLE label
(
  id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  date             DATE     NOT NULL

);
CREATE UNIQUE INDEX label_unique_date_idx ON label (date);