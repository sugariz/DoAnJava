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
-- Table structure for table `hocsinh`
--

DROP TABLE IF EXISTS `hocsinh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hocsinh` (
  `MAHS` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `HO` varchar(20) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `TEN` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `NGAYSINH` date NOT NULL,
  `DIACHI` varchar(100) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `GIOITINH` tinyint(1) NOT NULL,
  `EMAIL` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `SODIENTHOAI` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  PRIMARY KEY (`MAHS`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hocsinh`
--

LOCK TABLES `hocsinh` WRITE;
/*!40000 ALTER TABLE `hocsinh` DISABLE KEYS */;
INSERT INTO `hocsinh` VALUES ('3118310412','Nguyễn Quỳnh','Như','1999-05-13','23 Lê Hồng Phong,Phường 15,Quận 10,TP.Hồ Chí Minh',2,'nhuquynh11@gmail.com','0985667132'),('3118345678','Nguyễn Thị','Lan Hương','1998-06-03','342 Hòa Hưng,Quận 10,TP.Hồ Chí Minh',2,'huongRageDog@gmail.com','0799966633'),('3118450612','Nguyễn Thị Trâm','Anh','1999-08-13','3 Hùng Vương',2,'anhtram@gmail.com','0789112381'),('3118510412','Phan Mạnh','Quỳnh','2000-08-18','2 Nguyễn Tri Phương',1,'quynhphan@gmail.com','0896665358'),('3119410304','Diep Bao Thanh','Phong','2001-02-02','462 Duong Ba Trac, quan 8',1,'phongdiepp@gmail.com','0342997254'),('3119410456','Nguyen Minh','Tri','2001-03-04','793/12 Tran Xuan Soan',0,'minhtridhmdg@gmail.com','0395648320'),('3119510412','Nguyễn Văn','Đức','1999-06-15','273 An Dương Vương,Quận 5,TP.Hồ Chí Minh',1,'ducvo@gmail.com','0791123581'),('319610324','Nguyễn Huỳnh','Toàn','2000-07-16','5 Lê Hông Phong',1,'toan12@gmail.com','0983204102'),('319610326','Huỳnh Ngọc','Đức','2001-08-19','3 Quận 3',1,'ducvip@gmail.com','0123589677');
/*!40000 ALTER TABLE `hocsinh` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-16 22:00:06
