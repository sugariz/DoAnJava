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
-- Table structure for table `giaovien`
--

DROP TABLE IF EXISTS `giaovien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `giaovien` (
  `MAGV` varchar(6) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `TENGIAOVIEN` varchar(30) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `DIACHI` varchar(50) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  `DIENTHOAI` varchar(10) COLLATE utf8mb4_vietnamese_ci NOT NULL,
  PRIMARY KEY (`MAGV`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_vietnamese_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `giaovien`
--

LOCK TABLES `giaovien` WRITE;
/*!40000 ALTER TABLE `giaovien` DISABLE KEYS */;
INSERT INTO `giaovien` VALUES ('GV0001','Nguyễn Hoàng Trung','100 Trần Hưng Đạo, Long Xuyên','0975058876'),('GV0002','Phan Hồng Nhung','Lac Quoi - Tri Ton','0976630315'),('GV0003','Huỳnh Thanh Trúc','10C Nguyễn Trung Trực, Châu Đốc','0699015456'),('GV0004','Lam Trung Toan','Long Dien B, An Phú','0845241566'),('GV0005','Huynh Túc Trí','Rạch Giá, Kiên Giang','0123456789'),('GV0006','Lê Thi Minh Nguyệt','000 Long Xuyên, An Giang','0123456789'),('GV0007','Nguyễn Nhựt Triều','3 Ngô Quyền.Quận 8','0799653581'),('GV0008','Nguyễn Nhựt Triều','3 Ngô Quyền','0799653581'),('GV0009','Lê Minh','3 Hàng Xuyên','0972112681'),('GV0010','Thiện','3 Nguyễn Tri Phương','078112684');
/*!40000 ALTER TABLE `giaovien` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-16 22:02:46
