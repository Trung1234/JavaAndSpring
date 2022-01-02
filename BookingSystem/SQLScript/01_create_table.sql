DROP DATABASE IF EXISTS `booking-system`;
CREATE DATABASE `booking-system` ;

CREATE TABLE  `booking-system`.`room` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`room_number` INT(45) NOT NULL,
	`adults_capacity` INT(45) NOT NULL,
    `children_capacity` INT(45) NOT NULL,
    `price` DOUBLE NOT NULL,
    `status` BOOL DEFAULT 0,
	PRIMARY KEY (`id`)
) ;
CREATE TABLE  `booking-system`.`booking`(
	`id` INT NOT NULL AUTO_INCREMENT,
	`guest_last_name` varchar(45) NOT NULL,
	`guest_first_name` varchar(45) NOT NULL,
    `checkin_date` timestamp NOT NULL,
    `checkout_date` timestamp NOT NULL,
    `number_of_adults` INT(45) NOT NULL,
    `number_of_children` INT(45) NOT NULL,
    `room_id` INT NOT NULL,
    `booking_status` BIT(8) DEFAULT 1,
    PRIMARY KEY (`id`),
	FOREIGN KEY(room_id) REFERENCES room(id)
) ;