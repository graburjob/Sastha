CREATE TABLE `users` (
  `USER_ID` varchar(50) NOT NULL DEFAULT '',
  `Name` varchar(100) DEFAULT NULL,
  `Password` varchar(20) DEFAULT NULL,
  `Role` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

