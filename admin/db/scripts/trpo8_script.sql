DELETE FROM `TRPO8`.`ORDER_ITEM`;
DELETE FROM `TRPO8`.`ORDER`;
DELETE FROM `TRPO8`.`SESSION`;
DELETE FROM `TRPO8`.`PROFILE`;
DELETE FROM `TRPO8`.`ACCOUNT`;
DELETE FROM `TRPO8`.`MOBILE_APP`;
DELETE FROM `TRPO8`.`DEVELOPER`;



INSERT INTO `TRPO8`.`ACCOUNT` (`ID`, `USERNAME`, `PASSWORD`, `LOGGED_IN`)
VALUES
	(1, "email1@gmail.com", "password1", 0),
	(2, "email2@gmail.com", "password2", 0),
	(3, "email3@gmail.com", "password3", 0);

INSERT INTO `TRPO8`.`PROFILE` (`ID`, `EMAIL`, `FIRST_NAME`, `LAST_NAME`, `ADDRESS`)
VALUES
	(1, "email1@gmail.com", "Eric", "Cartman", "Minsk, Belarus"),
	(2, "email2@gmail.com", "Stan", "Marsh", "Minsk, Belarus"),
	(3, "email3@gmail.com", "Kyle", "Broflovsky", "Minsk, Belarus");

INSERT INTO `TRPO8`.`DEVELOPER` (`ID`, `NAME`, `RAITING`)
VALUES
	(1, "Igor Moiseyenko", "5");

INSERT INTO `TRPO8`.`MOBILE_APP` (`ID`, `NAME`, `PRICE`, `TYPE`, `RAITING`, `DESCRIPTION`, `developer_ID`)
VALUES
	(1, "Calendar", "1.50", "UTILITY", "5", "Calendar for mobile phones.", "1"),
	(2, "Clock", "1.00", "UTILITY", "4", "Clock for mobile phones.", "1"),
	(3, "Maps", "2.45", "UTILITY", "5", "Maps for mobile phones.", "1");

INSERT INTO `TRPO8`.`ORDER` (`ID`, `account_ID`)
VALUES
	(1, 1),
	(2, 1),
	(3, 1);

INSERT INTO `TRPO8`.`ORDER_ITEM` (`ID`, `QUANTITY`, `mobileApp_ID`, `order_ID`)
VALUES
	(1, 2, 1, 1),
	(2, 1, 2, 1),
	(3, 1, 3, 1),

	(4, 2, 3, 2),
	(5, 3, 2, 2),
	(6, 1, 1, 2),

	(7, 3, 1, 3),
	(8, 4, 2, 3),
	(9, 4, 3, 3);
