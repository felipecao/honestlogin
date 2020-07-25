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
  price DOUBLE NOT NULL,
  image_url VARCHAR(1024) NOT NULL
);

INSERT INTO user (username, password) VALUES ('user', 'password');
INSERT INTO menu_item (id, name, description, price, image_url) VALUES (1, 'Veggie salad', 'Salad created with the best fresh products of the season. Bread not included.', 7.9, 'https://honestgreens.com/wp-content/uploads/2020/06/web3.png');
INSERT INTO menu_item (id, name, description, price, image_url) VALUES (2, 'Summer Burrata', 'Burrata cheese, cherry balsamic gazpacho, seaweed pesto, marinated watermelon, peach, mixed lettuce, kale.', 7.9, 'https://honestgreens.com/wp-content/uploads/2020/06/Summer-Burrata.png');
INSERT INTO menu_item (id, name, description, price, image_url) VALUES (3, 'Heavenly Hummus', 'Three kinds of hummus: beet, classic and black sesame on a base of kale, lentils, mint, pumpkin, grilled cherry tomatoes, mushrooms, cucumber, lombard, red pepper, white beans, kalamata olives, pomegranate and za’atar', 7.9, 'https://honestgreens.com/wp-content/uploads/2020/06/Heavenly-Hummus.png');
INSERT INTO menu_item (id, name, description, price, image_url) VALUES (4, 'Steak, Charcoal Grilled with Chimichurri', 'Local pasture-raised beef, marinated with fresh herbs, Josper grilled, served medium-rare', 7.9, 'https://honestgreens.com/wp-content/uploads/2020/06/web1.png');