DROP TABLE order_line;
DROP TABLE orders;
DROP TABLE cart_line;
DROP TABLE cart;
DROP TABLE payment_method;
DROP TABLE status;
DROP TABLE category_item;
DROP TABLE category;
DROP TABLE item;
DROP TABLE uom;
DROP TABLE ship_to;
DROP TABLE user;
DROP TABLE user_role;
DROP TABLE city;
DROP TABLE state;
DROP TABLE shipping_zone;

CREATE TABLE SHIPPING_ZONE (
  shipping_zone_id VARCHAR(5) NOT NULL,
  description VARCHAR(20) NOT NULL,
  delivery_time INTEGER,
  shipping_cost DECIMAL(10,2),

  PRIMARY KEY(shipping_zone_id)
) ENGINE=InnoDB;


CREATE TABLE STATE (
  state_id INTEGER NOT NULL AUTO_INCREMENT,
  description VARCHAR(100),
  shipping_zone_id VARCHAR(5) NOT NULL,

  PRIMARY KEY(state_id),
  INDEX idx_state_shipping_zone_id(shipping_zone_id),
  CONSTRAINT fk_shipping_zone_state
    FOREIGN KEY(shipping_zone_id)
    REFERENCES shipping_zone(shipping_zone_id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
) ENGINE=InnoDB;


CREATE TABLE CITY (
  city_id INTEGER NOT NULL AUTO_INCREMENT,
  description VARCHAR(100),
  state_id INTEGER NOT NULL,

  PRIMARY KEY(city_id),
  INDEX idx_city_state_id(state_id),
  CONSTRAINT fk_state_city
    FOREIGN KEY(state_id)
    REFERENCES state(state_id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
) ENGINE=InnoDB;


CREATE TABLE USER_ROLE (
  user_role_id VARCHAR(5) NOT NULL,
  description VARCHAR(20),

  PRIMARY KEY(user_role_id)
) ENGINE=InnoDB;


CREATE TABLE USER (
  username VARCHAR(20) NOT NULL,
  password VARCHAR(20),
  name VARCHAR(100),
  user_role_id VARCHAR(5) NOT NULL,  
  active VARCHAR(1),

  PRIMARY KEY(username),
  INDEX idx_user_user_role_id(user_role_id),
  CONSTRAINT fk_user_role_user
    FOREIGN KEY(user_role_id)
    REFERENCES user_role(user_role_id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
) ENGINE=InnoDB;


CREATE TABLE SHIP_TO (
  ship_to_id INTEGER NOT NULL AUTO_INCREMENT,
  user VARCHAR(20) NOT NULL,
  name VARCHAR(100),
  address VARCHAR(250),
  city_id INTEGER NOT NULL,
  zip_code INTEGER,
  phone VARCHAR(20),
  email VARCHAR(100),

  PRIMARY KEY(ship_to_id),
  INDEX idx_ship_to_city_id(city_id),
  INDEX idx_ship_to_user(user),
  CONSTRAINT fk_user_ship_to
    FOREIGN KEY(user)
    REFERENCES user(username)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT fk_city_ship_to
    FOREIGN KEY(city_id)
    REFERENCES city(city_id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
) ENGINE=InnoDB;


CREATE TABLE UOM (
  uom_id VARCHAR(5) NOT NULL,
  description VARCHAR(20),

  PRIMARY KEY(uom_id)
) ENGINE=InnoDB;


CREATE TABLE ITEM (
  item_id INTEGER NOT NULL AUTO_INCREMENT,
  description VARCHAR(100),
  features VARCHAR(250),
  uom_id VARCHAR(5) NOT NULL,
  unit_price DECIMAL(10,2),
  image_path VARCHAR(250),
  stock INTEGER,
  active VARCHAR(1),

  PRIMARY KEY(item_id),
  INDEX idx_item_uom_id(uom_id),
  CONSTRAINT fk_uom_item
    FOREIGN KEY(uom_id)
    REFERENCES uom(uom_id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
) ENGINE=InnoDB;


CREATE TABLE CATEGORY (
  category_id INTEGER NOT NULL AUTO_INCREMENT,
  description VARCHAR(100),

  PRIMARY KEY(category_id)
) ENGINE=InnoDB;


CREATE TABLE CATEGORY_ITEM (
  category_id INTEGER NOT NULL,
  item_id INTEGER NOT NULL,

  PRIMARY KEY(category_id, item_id),
  INDEX idx_item_category_id(category_id),
  INDEX idx_category_item_id(item_id),
  CONSTRAINT fk_category_category_item
    FOREIGN KEY(category_id)
    REFERENCES category(category_id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT fk_item_category_item
    FOREIGN KEY(item_id)
    REFERENCES item(item_id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
) ENGINE=InnoDB;


CREATE TABLE STATUS (
  status_id INTEGER NOT NULL,
  description VARCHAR(100),
  status_type VARCHAR(20),

  PRIMARY KEY(status_id)
) ENGINE=InnoDB;


CREATE TABLE PAYMENT_METHOD (
  payment_method_id VARCHAR(5) NOT NULL,
  description VARCHAR(100),

  PRIMARY KEY(payment_method_id)
) ENGINE=InnoDB;


CREATE TABLE CART (
  cart_id INTEGER NOT NULL AUTO_INCREMENT,
  lines_amount DECIMAL(10,2),
  shipping_amount DECIMAL(10,2),
  cart_amount DECIMAL(10,2),
  ship_to_id INTEGER,
  status_id INTEGER NOT NULL,
  create_user VARCHAR(20),
  create_date DATETIME,
  update_user VARCHAR(20),
  update_date DATETIME,

  PRIMARY KEY(cart_id),
  INDEX idx_cart_ship_to_id(ship_to_id),
  INDEX idx_cart_status_id(status_id),
  CONSTRAINT fk_ship_to_cart
    FOREIGN KEY(ship_to_id)
    REFERENCES ship_to(ship_to_id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT fk_status_cart
    FOREIGN KEY(status_id)
    REFERENCES status(status_id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
) ENGINE=InnoDB;


CREATE TABLE CART_LINE (
  cart_line_id INTEGER NOT NULL AUTO_INCREMENT,
  cart_id INTEGER NOT NULL,
  item_id INTEGER NOT NULL,
  quantity INTEGER,

  PRIMARY KEY(cart_line_id),
  INDEX idx_cart_line_cart_id(cart_id),
  INDEX idx_cart_line_item_id(item_id),
  CONSTRAINT fk_cart_cart_line
    FOREIGN KEY(cart_id)
    REFERENCES cart(cart_id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT fk_item_cart
    FOREIGN KEY(item_id)
    REFERENCES item(item_id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
) ENGINE=InnoDB;


CREATE TABLE ORDERS (
  order_id INTEGER NOT NULL AUTO_INCREMENT,
  cart_id INTEGER NOT NULL,
  order_date DATETIME,
  schedule_date DATETIME,
  delivery_date DATETIME,
  cancellation_date DATETIME,
  lines_amount DECIMAL(10,2),
  shipping_amount DECIMAL(10,2),
  order_amount DECIMAL(10,2),
  payment_method_id VARCHAR(5),
  payment_reference VARCHAR(100),
  notes VARCHAR(250),
  status_id INTEGER NOT NULL,
  create_user VARCHAR(20),
  create_date DATETIME,
  update_user VARCHAR(20),
  update_date DATETIME,

  PRIMARY KEY(order_id),
  UNIQUE INDEX idx_order_cart_id(cart_id),
  INDEX idx_order_payment_method_id(payment_method_id),
  INDEX idx_order_status_id(status_id),
  CONSTRAINT fk_cart_order
    FOREIGN KEY(cart_id)
    REFERENCES cart(cart_id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT fk_payment_methotd_order
    FOREIGN KEY(payment_method_id)
    REFERENCES payment_method(payment_method_id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT fk_status_order
    FOREIGN KEY(status_id)
    REFERENCES status(status_id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
) ENGINE=InnoDB;


CREATE TABLE ORDER_LINE (
  order_line_id INTEGER NOT NULL AUTO_INCREMENT,
  order_id INTEGER NOT NULL,
  item_id INTEGER NOT NULL,
  quantity INTEGER,
  line_amount DECIMAL(10,2),
  status_id INTEGER NOT NULL,
  cart_line_id INTEGER,
  create_user VARCHAR(20),
  create_date DATETIME,
  update_user VARCHAR(20),
  update_date DATETIME,

  PRIMARY KEY(order_line_id),
  INDEX idx_order_line_order_id(order_id),
  INDEX idx_order_line_item_id(item_id),
  INDEX idx_order_line_status_id(status_id),
  CONSTRAINT fk_order_order_line
    FOREIGN KEY(order_id)
    REFERENCES orders(order_id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT fk_item_order_line
    FOREIGN KEY(item_id)
    REFERENCES item(item_id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT fk_status_order_line
    FOREIGN KEY(status_id)
    REFERENCES status(status_id)
    ON DELETE RESTRICT
    ON UPDATE CASCADE
) ENGINE=InnoDB;