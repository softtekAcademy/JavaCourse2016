
CREATE  TABLE users (
  username VARCHAR(45) NOT NULL ,
  password VARCHAR(45) NOT NULL ,
  enabled BOOLEAN NOT NULL
);

CREATE TABLE user_roles (
  user_role_id integer NOT NULL,
  username varchar(45) NOT NULL,
  role varchar(45) NOT NULL
);

INSERT INTO users(username,password,enabled)
VALUES ('softtek','123456', true);
INSERT INTO users(username,password,enabled)
VALUES ('user','123456', true);

INSERT INTO user_roles (user_role_id,username, role)
VALUES (1,'softtek', 'ROLE_USER');
INSERT INTO user_roles (user_role_id,username, role)
VALUES (2,'softtek', 'ROLE_ADMIN');
INSERT INTO user_roles (user_role_id,username, role)
VALUES (3,'user', 'ROLE_USER');