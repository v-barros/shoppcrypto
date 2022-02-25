CREATE TABLE `users` (
	`name` VARCHAR(255) NOT NULL,
	`nickname` VARCHAR(255) NOT NULL,
	`email` VARCHAR(255) NOT NULL,
	`phone` VARCHAR(20) NOT NULL,
	`gender` CHAR(1) NOT NULL,
	`password` VARCHAR(255) NOT NULL,
	`id` INT NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB;