/* Crear la DB, usuario y asignacion de privilegios con usuario roor*/
CREATE database sampleDB;
CREATE USER 'dbuser'@'%' IDENTIFIED BY 'dbuser';

GRANT ALL ON sampleDB.* TO 'dbuser'@'%';


/******** Luego conectar con el usuario 'dbuser' para crear las tablas *******/
/* jdbc:mysql://localhost:3306/sampleDB */