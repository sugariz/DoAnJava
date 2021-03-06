-- MySQL dump 10.13  Distrib 5.7.33, for Linux (x86_64)
--
-- Host: den1.mysql4.gear.host    Database: quanlyhocsinh
-- ------------------------------------------------------
-- Server version	5.7.26-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `thutiet`
--

DROP TABLE IF EXISTS `thutiet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `thutiet` (
  `MATHUTIET` varchar(20) NOT NULL,
  `MATHU` int(11) NOT NULL,
  `MATIET` int(11) NOT NULL,
  PRIMARY KEY (`MATHUTIET`),
  KEY `MATHU` (`MATHU`),
  KEY `MATIET` (`MATIET`),
  CONSTRAINT `FK_THU` FOREIGN KEY (`MATHU`) REFERENCES `thu` (`MATHU`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_TIET` FOREIGN KEY (`MATIET`) REFERENCES `tiet` (`MATIET`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thutiet`
--

LOCK TABLES `thutiet` WRITE;
/*!40000 ALTER TABLE `thutiet` DISABLE KEYS */;
INSERT INTO `thutiet` VALUES ('THU2TIET1',2,1),('THU2TIET10',2,10),('THU2TIET2',2,2),('THU2TIET3',2,3),('THU2TIET4',2,4),('THU2TIET5',2,5),('THU2TIET6',2,6),('THU2TIET7',2,7),('THU2TIET8',2,8),('THU2TIET9',2,9),('THU3TIET1',3,1),('THU3TIET10',3,10),('THU3TIET2',3,2),('THU3TIET3',3,3),('THU3TIET4',3,4),('THU3TIET5',3,5),('THU3TIET6',3,6),('THU3TIET7',3,7),('THU3TIET8',3,8),('THU3TIET9',3,9),('THU4TIET1',4,1),('THU4TIET10',4,10),('THU4TIET2',4,2),('THU4TIET3',4,3),('THU4TIET4',4,4),('THU4TIET5',4,5),('THU4TIET6',4,6),('THU4TIET7',4,7),('THU4TIET8',4,8),('THU4TIET9',4,9),('THU5TIET1',5,1),('THU5TIET10',5,10),('THU5TIET2',5,2),('THU5TIET3',5,3),('THU5TIET4',5,4),('THU5TIET5',5,5),('THU5TIET6',5,6),('THU5TIET7',5,7),('THU5TIET8',5,8),('THU5TIET9',5,9),('THU6TIET1',6,1),('THU6TIET10',6,10),('THU6TIET2',6,2),('THU6TIET3',6,3),('THU6TIET4',6,4),('THU6TIET5',6,5),('THU6TIET6',6,6),('THU6TIET7',6,7),('THU6TIET8',6,8),('THU6TIET9',6,9),('THU7TIET1',7,1),('THU7TIET10',7,10),('THU7TIET2',7,2),('THU7TIET3',7,3),('THU7TIET4',7,4),('THU7TIET5',7,5),('THU7TIET6',7,6),('THU7TIET7',7,7),('THU7TIET8',7,8),('THU7TIET9',7,9),('THU8TIET1',8,1),('THU8TIET10',8,10),('THU8TIET2',8,2),('THU8TIET3',8,3),('THU8TIET4',8,4),('THU8TIET5',8,5),('THU8TIET6',8,6),('THU8TIET7',8,7),('THU8TIET8',8,8),('THU8TIET9',8,9);
/*!40000 ALTER TABLE `thutiet` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-16 21:58:19
