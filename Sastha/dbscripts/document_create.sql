CREATE TABLE `document` (
  `Document_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Document_Name` varchar(20) DEFAULT NULL,
  `Document_Type` varchar(20) DEFAULT NULL,
  `Document` blob NOT NULL,
  `User_ID` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Document_ID`),
  KEY `DocumentFK` (`User_ID`),
  CONSTRAINT `DocumentFK` FOREIGN KEY (`User_ID`) REFERENCES `users` (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

