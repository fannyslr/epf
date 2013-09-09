CREATE DATABASE `test-epf`;

USE `test-epf`;

CREATE  TABLE user (

  `id` INT NOT NULL AUTO_INCREMENT ,

  `login` VARCHAR(255) NOT NULL ,

  `password` VARCHAR(45) NULL ,

  PRIMARY KEY (`id`) );

INSERT INTO user (login, password) VALUES ('root', 'toor');

INSERT INTO user (login, password) VALUES ('user', 'qwerty');


