/* Crear la DB, usuario y asignacion de privilegios con usuario root */
CREATE database myDB;
CREATE USER myuser@'%' IDENTIFIED BY 'mypassword';

GRANT ALL ON myDB.* TO myuser@'%';


/******** Luego conectar con el usuario 'dbuser' para crear las tablas *******/
/* jdbc:mysql://localhost:3306/sampleDB */