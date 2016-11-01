CREATE DATABASE omsdb CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE USER 'omsdb' IDENTIFIED BY 'omsdb';
GRANT ALL ON omsdb.* TO 'omsdb'@'%' IDENTIFIED BY 'omsdb';
GRANT ALL ON omsdb.* TO 'omsdb'@'localhost' IDENTIFIED BY 'omsdb';
GRANT ALL ON omsdb.delete_orders TO 'omsdb'@'localhost' IDENTIFIED BY 'omsdb';
FLUSH PRIVILEGES;