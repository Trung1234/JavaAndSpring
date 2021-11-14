
CREATE SCHEMA `spring-boot-shop` ;
 
CREATE TABLE `spring-boot-shop`.`product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `content` VARCHAR(45) NULL,
  `name` VARCHAR(45) NULL,
  `author_name` VARCHAR(45) NULL,
  `price` FLOAT(45) NULL,
  `image_path` VARCHAR(255) NULL,
  PRIMARY KEY (`id`));