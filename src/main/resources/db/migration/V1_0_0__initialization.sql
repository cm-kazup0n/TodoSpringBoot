CREATE DATABASE IF NOT EXISTS todoapp;
CREATE USER 'todoapp'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON todoapp.* TO 'todoapp'@'localhost';
