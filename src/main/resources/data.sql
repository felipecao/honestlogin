DROP TABLE IF EXISTS user;

CREATE TABLE user (
  username VARCHAR(250) PRIMARY KEY,
  password VARCHAR(250) NOT NULL
);

INSERT INTO user (username, password) VALUES ('user', 'password');