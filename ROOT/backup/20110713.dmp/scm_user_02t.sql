CREATE DATABASE  IF NOT EXISTS `scm` /*!40100 DEFAULT CHARACTER SET euckr */;
USE `scm`;
-- MySQL dump 10.13  Distrib 5.5.9, for Win32 (x86)
--
-- Host: localhost    Database: scm
-- ------------------------------------------------------
-- Server version	5.0.27-community-nt

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
-- Not dumping tablespaces as no INFORMATION_SCHEMA.FILES table on this server
--

--
-- Table structure for table `user_02t`
--

DROP TABLE IF EXISTS `user_02t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_02t` (
  `SCMID` varchar(10) NOT NULL,
  `IPADDRESS` varchar(20) default NULL,
  `LOGINTIME` date default NULL,
  `PASSWORD` varchar(40) default NULL,
  `LOGINNAME` varchar(100) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_02t`
--

LOCK TABLES `user_02t` WRITE;
/*!40000 ALTER TABLE `user_02t` DISABLE KEYS */;
INSERT INTO `user_02t` VALUES ('B1001','10.2.1.161','2011-05-25','1234','USA RETAIL LIMITED.'),('b1001','10.2.1.161','2011-05-25','1234','USA RETAIL LIMITED.'),('B1001','10.2.1.161','2011-05-25','1234','USA RETAIL LIMITED.'),('B1001','10.2.1.161','2011-05-25','1234','USA RETAIL LIMITED.'),('B1001','10.2.1.161','2011-05-26','1233','USA RETAIL LIMITED.'),('b1001','58.106.238.45','2011-05-28','1233','USA RETAIL LIMITED.'),('B1002','58.106.238.45','2011-06-03','1234','LIT LIMITED GUANGZHOU'),('B1001','10.2.1.161','2011-06-03','1233','HOT & DELICIOUS '),('B1001','10.2.1.161','2011-06-03','1233','HOT & DELICIOUS '),('B1001','10.2.1.161','2011-06-03','1233','HOT & DELICIOUS '),('B1001','10.2.1.161','2011-06-03','1233','HOT & DELICIOUS '),('B1001','10.2.1.161','2011-06-03','1233','HOT & DELICIOUS '),('B1001','10.2.1.161','2011-06-07','1233','HOT & DELICIOUS '),('B9999','10.2.1.161','2011-06-08','1234','BUYER(TEST)'),('B9999','10.2.1.161','2011-06-08','1234','BUYER(TEST)'),('B9999','10.2.1.161','2011-06-08','1234','BUYER(TEST)'),('b9999','10.2.1.161','2011-06-08','1234','BUYER(TEST)'),('b9999','10.2.1.161','2011-06-08','1234','BUYER(TEST)'),('B1001','175.39.77.33','2011-06-13','1233','HOT & DELICIOUS '),('B1001','175.39.77.33','2011-06-13','1233','HOT & DELICIOUS '),('B1001','10.2.1.161','2011-06-14','1111','HOT & DELICIOUS '),('B1001','10.2.1.161','2011-06-14','1111','HOT & DELICIOUS '),('B1001','10.2.1.161','2011-06-14','1111','HOT & DELICIOUS '),('B1001','10.2.1.161','2011-06-16','1234','HOT & DELICIOUS '),('B1001','10.2.1.161','2011-06-16','1234','HOT & DELICIOUS '),('b1001','10.2.1.161','2011-06-16','1234','HOT & DELICIOUS '),('B1001','10.2.1.161','2011-06-21','1234','HOT & DELICIOUS '),('b1001','10.2.1.161','2011-06-21','1234','HOT & DELICIOUS '),('B1001','10.2.1.161','2011-06-24','1234','HOT & DELICIOUS '),('b1001','10.2.1.161','2011-06-24','1234','HOT & DELICIOUS '),('B1001','10.2.1.161','2011-06-27','1234','HOT & DELICIOUS '),('B1001','10.2.1.161','2011-06-27','1234','HOT & DELICIOUS '),('B1001','10.2.1.161','2011-06-27','1234','HOT & DELICIOUS '),('B1001','10.2.1.161','2011-06-27','1234','HOT & DELICIOUS '),('B1001','10.2.1.161','2011-06-29','1234','HOT & DELICIOUS '),('B1001','10.2.1.161','2011-06-29','1234','HOT & DELICIOUS '),('B1001','10.2.1.161','2011-06-30','1234','HOT & DELICIOUS '),('B1001','10.2.1.161','2011-06-30','1234','HOT & DELICIOUS '),('B1001','10.2.1.161','2011-06-30','1234','HOT & DELICIOUS '),('B1001','10.2.1.161','2011-06-30','1234','HOT & DELICIOUS '),('B1001','10.2.1.161','2011-06-30','1234','HOT & DELICIOUS '),('B1001','219.136.88.251','2011-07-11','1234','HOT & DELICIOUS '),('B1001','219.136.88.251','2011-07-11','1234','HOT & DELICIOUS '),('B1001','219.136.88.251','2011-07-11','1234','HOT & DELICIOUS '),('B1001','219.136.81.195','2011-07-11','1234','HOT & DELICIOUS '),('B1001','113.68.195.157','2011-07-12','1234','HOT & DELICIOUS ');
/*!40000 ALTER TABLE `user_02t` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2011-07-13 11:57:29
