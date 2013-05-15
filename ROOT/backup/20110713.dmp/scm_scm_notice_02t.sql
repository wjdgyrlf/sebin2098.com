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
-- Table structure for table `scm_notice_02t`
--

DROP TABLE IF EXISTS `scm_notice_02t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scm_notice_02t` (
  `NOTICE_SEQNO` int(10) NOT NULL,
  `SEQNO` int(10) NOT NULL,
  `ATTACH_FILE` varchar(300) default NULL,
  `ATTACH_REAL_FILE` varchar(300) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scm_notice_02t`
--

LOCK TABLES `scm_notice_02t` WRITE;
/*!40000 ALTER TABLE `scm_notice_02t` DISABLE KEYS */;
/*!40000 ALTER TABLE `scm_notice_02t` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2011-07-13 11:57:31
