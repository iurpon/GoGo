/*
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS meals;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 100000;

CREATE TABLE users
(
  id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name             VARCHAR                 NOT NULL,
  email            VARCHAR                 NOT NULL,
  password         VARCHAR                 NOT NULL,
  registered       TIMESTAMP DEFAULT now() NOT NULL,
  enabled          BOOL DEFAULT TRUE       NOT NULL,
  calories_per_day INTEGER DEFAULT 2000    NOT NULL
);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE meals (
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  user_id     INTEGER   NOT NULL,
  date_time   TIMESTAMP NOT NULL,
  description TEXT      NOT NULL,
  calories    INT       NOT NULL,
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX meals_unique_user_datetime_idx ON meals (user_id, date_time);

*/

DROP TABLE  IF EXISTS menu;
DROP TABLE IF EXISTS restaurant ;
DROP TABLE IF EXISTS users ;
DROP TABLE IF EXISTS votes;

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