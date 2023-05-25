CREATE DATABASE  IF NOT EXISTS `flyaway_directory`;
USE `flyaway_directory`;



DROP TABLE IF EXISTS `booking`;
DROP TABLE IF EXISTS `flight`;
DROP TABLE IF EXISTS `airport`;
DROP TABLE IF EXISTS `airline`;
DROP TABLE IF EXISTS `customer`;
--
-- Table structure for table `airline`
--


CREATE TABLE `airline` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `short_name` char(2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `airline`
--

INSERT INTO `airline` VALUES
	(1,'American Airlines','AA'),
	(2,'Lufthansa','LH');



DROP TABLE IF EXISTS `airport`;

--
-- Table structure for table `airport`
--

CREATE TABLE `airport` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `short_name` char(3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;



--
-- Data for table `airport`
--

INSERT INTO `airport` VALUES
	(1,'Frankfurt Airport','FRA'),
	(2,'San Francisco International Airport','SFO');

DROP TABLE IF EXISTS `flight`;
--
-- Table structure for table `flight`
--
CREATE TABLE `flight` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `source` INT NOT NULL,
  `destination` INT NOT NULL,
  `airline` INT NOT NULL,
  `departure_datetime` DATETIME NOT NULL,
  `ticket_price` DECIMAL(10, 2) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`source`) REFERENCES `airport` (`id`) ON DELETE CASCADE,
  FOREIGN KEY (`destination`) REFERENCES `airport` (`id`) ON DELETE CASCADE,
  FOREIGN KEY (`airline`) REFERENCES `airline` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


INSERT INTO `flight` (`source`, `destination`, `airline`, `departure_datetime`, `ticket_price`)
VALUES
    (1, 2, 1, '2023-05-11 10:00:00', 250.0),
    (1, 2, 2, '2023-05-12 14:30:00', 125.0),
    (2, 1, 1, '2023-05-13 09:45:00', 99.90);




CREATE TABLE `customer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `phone_number` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

INSERT INTO `customer` (`first_name`, `last_name`, `email`, `phone_number`)
VALUES
    ('John', 'Doe', 'johndoe@example.com', '1234567890'),
    ('Jane', 'Smith', 'janesmith@example.com', '9876543210');


CREATE TABLE `booking` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `customer_id` INT NOT NULL,
  `flight_id` INT NOT NULL,
  `number_of_persons` INT NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`) ON DELETE CASCADE,
  FOREIGN KEY (`flight_id`) REFERENCES `flight` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

INSERT INTO `booking` (`customer_id`, `flight_id`, `number_of_persons`)
VALUES
    (1, 1, 2);


DROP TABLE IF EXISTS `authorities`;
DROP TABLE IF EXISTS `users`;

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` char(68) NOT NULL,
  `enabled` tinyint NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `users`
--
-- NOTE: The passwords are encrypted using BCrypt
--
-- Default passwords here are: fun123
--

INSERT INTO `users`
VALUES
('john','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q',1),
('mary','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q',1),
('susan','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q',1);


--
-- Table structure for table `authorities`
--

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities4_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities4_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Inserting data for table `authorities`
--

INSERT INTO `authorities`
VALUES
('john','ROLE_EMPLOYEE'),
('mary','ROLE_EMPLOYEE'),
('mary','ROLE_MANAGER'),
('susan','ROLE_EMPLOYEE'),
('susan','ROLE_MANAGER'),
('susan','ROLE_ADMIN');

