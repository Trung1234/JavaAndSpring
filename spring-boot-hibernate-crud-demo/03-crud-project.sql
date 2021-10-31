CREATE SCHEMA `spring-boot-hibernate` ;
CREATE TABLE `spring-boot-hibernate`.`customer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `address` VARCHAR(255) NULL,
  PRIMARY KEY (`id`));
  
  CREATE TABLE `spring-boot-hibernate`.`Users` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(45) NULL,
    `display_name` VARCHAR(255) NULL,
    `password` VARCHAR(45) NULL,
	`id_role` INT NOT NULL,
    PRIMARY KEY (`id`));
    
    INSERT INTO 
	`spring-boot-hibernate`.Users (name, display_name, password,id_role) 
VALUES
  	('Lokesh', 'Gupta', '123456',1);

  
  INSERT INTO `spring-boot-hibernate`.`customer`(name, address)
VALUES ("Cardinal",  "Skagen 21");

DROP TABLE IF EXISTS TBL_EMPLOYEES;
 
CREATE TABLE `spring-boot-hibernate`.`TBL_EMPLOYEES` (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  email VARCHAR(250) DEFAULT NULL
);

INSERT INTO 
	`spring-boot-hibernate`.TBL_EMPLOYEES (first_name, last_name, email) 
VALUES
  	('Lokesh', 'Gupta', 'howtodoinjava@gmail.com'),
  	('John', 'Doe', 'xyz@email.com');
 SELECT * FROM `spring-boot-hibernate`.TBL_EMPLOYEES;
 
  SELECT * FROM `spring-boot-hibernate`.Users;