DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS menu_item;

CREATE TABLE user (
  username VARCHAR(250) PRIMARY KEY,
  password VARCHAR(250) NOT NULL
);

CREATE TABLE menu_item (
  id IDENTITY PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  description VARCHAR(500) NOT NULL,
  price DOUBLE NOT NULL
);

INSERT INTO user (username, password) VALUES ('user', 'password');
INSERT INTO menu_item (id, name, description, price) VALUES (1, 'Pollo al Chipotle', 'Pechuga de pollo de corral, marinada y hecha al horno Josper de carbón.', 7.9);
INSERT INTO menu_item (id, name, description, price) VALUES (2, 'Ternera Chimichurri al Josper', 'De pasto, marinada con hierbas “chimichurri”, hecha al horno Josper de carbón.', 7.9);