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
-- Table structure for table `vg_common_code`
--

DROP TABLE IF EXISTS `vg_common_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vg_common_code` (
  `CODE` varchar(20) NOT NULL,
  `CODE_NAME` varchar(50) NOT NULL,
  `TYPE` varchar(20) NOT NULL,
  `DESCRIPTION` varchar(200) default NULL,
  `USE_YN` varchar(1) default 'Y',
  `MODIFIER` varchar(10) default NULL,
  `MODIFIED_DATE` date default NULL,
  `SORT_ORDER` int(5) default NULL,
  `RELATED_CODE` varchar(20) default NULL,
  PRIMARY KEY  (`TYPE`,`CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vg_common_code`
--

LOCK TABLES `vg_common_code` WRITE;
/*!40000 ALTER TABLE `vg_common_code` DISABLE KEYS */;
INSERT INTO `vg_common_code` VALUES ('COUNTRY_CODE','Country Code','0',NULL,'Y',NULL,NULL,NULL,NULL),('CURRENCY','CURRENCY TYPE','0',NULL,'Y',NULL,NULL,NULL,NULL),('DELIVERY_TYPE','Deliver Type','0',NULL,'Y',NULL,NULL,NULL,NULL),('FORWARDER','Nominated Forwarder','0',NULL,'Y',NULL,NULL,NULL,NULL),('MATERIAL','제품소재','0',NULL,NULL,NULL,NULL,NULL,NULL),('ORDER_STATUS','Order Status','0',NULL,'Y',NULL,NULL,NULL,NULL),('PGR','Product Group','0',NULL,'Y',NULL,NULL,NULL,NULL),('SAMPLE','SAMPLE관리자','0',NULL,NULL,NULL,NULL,NULL,NULL),('SEASON','SEASON','0',NULL,'Y',NULL,NULL,NULL,NULL),('SGR','Product Sub group','0',NULL,'Y',NULL,NULL,NULL,NULL),('SHIPPING_PORT','Shipping Port','0',NULL,'Y',NULL,NULL,NULL,NULL),('SUB_MAT','부자재코드','0','원가관리용','Y',NULL,NULL,NULL,NULL),('TRANS_TYPE','배송형태','0',NULL,NULL,NULL,NULL,NULL,NULL),('USER_CLASS','User Class','0',NULL,'Y',NULL,NULL,NULL,NULL),('USER_GROUP','User Group','0',NULL,'Y',NULL,NULL,NULL,NULL),('USER_TYPE','User Type','0',NULL,'Y',NULL,NULL,NULL,NULL),('AU','Australia','COUNTRY_CODE',NULL,'Y','9144',NULL,6,NULL),('BD','Bangladesh','COUNTRY_CODE',NULL,'Y','9144',NULL,8,NULL),('CN','CHINA','COUNTRY_CODE','','Y','9144','2011-05-23',2,''),('HK','Hongkong','COUNTRY_CODE',NULL,'Y','9144',NULL,3,NULL),('IN','India','COUNTRY_CODE',NULL,'Y','9144',NULL,7,NULL),('KR','KOREA','COUNTRY_CODE',NULL,'Y','9144',NULL,4,NULL),('MN','Mongolia','COUNTRY_CODE',NULL,'Y','9144',NULL,9,NULL),('PH','Philippines','COUNTRY_CODE',NULL,'Y','9144',NULL,10,NULL),('PK','Pakistan','COUNTRY_CODE',NULL,'Y','9144',NULL,11,NULL),('TW','Taiwan','COUNTRY_CODE',NULL,'Y','9144',NULL,12,NULL),('US','USA','COUNTRY_CODE',NULL,'Y','9144',NULL,1,NULL),('VN','Vietnam','COUNTRY_CODE',NULL,'Y','9144',NULL,5,NULL),('CNY','CNY','CURRENCY',NULL,'Y','9144',NULL,6,NULL),('EUR','EUR','CURRENCY',NULL,'Y','9144',NULL,3,NULL),('GBP','GBP','CURRENCY',NULL,'Y','9144',NULL,5,NULL),('HKD','HKD','CURRENCY',NULL,'Y','9144',NULL,NULL,NULL),('JPY','JPY','CURRENCY',NULL,'Y','9144',NULL,2,NULL),('KRW','KRW','CURRENCY',NULL,'Y','9144',NULL,4,NULL),('USD','USD','CURRENCY',NULL,'Y','9144',NULL,1,NULL),('CMT','CMT','DELIVERY_TYPE',NULL,'Y','9144',NULL,20,NULL),('ES','ES','DELIVERY_TYPE',NULL,'Y','9144',NULL,50,NULL),('FOB','FOB','DELIVERY_TYPE',NULL,'Y','9144',NULL,10,NULL),('J','J','DELIVERY_TYPE',NULL,'Y','9144',NULL,NULL,NULL),('PN','PN','DELIVERY_TYPE',NULL,'Y','9144',NULL,70,NULL),('PNJ','PNJ','DELIVERY_TYPE',NULL,'Y','9144',NULL,60,NULL),('SMP','SMP','DELIVERY_TYPE',NULL,'Y','9144',NULL,30,NULL),('SO','SO','DELIVERY_TYPE',NULL,'Y','9144',NULL,40,NULL),('01','Capricon Logistics','FORWARDER',NULL,'Y',NULL,NULL,NULL,'IN'),('02','Coreana Co','FORWARDER',NULL,'Y',NULL,NULL,NULL,'CN'),('03','SGL Universal Co','FORWARDER',NULL,'Y',NULL,NULL,NULL,'CN'),('04','Alliance','FORWARDER',NULL,'Y',NULL,NULL,NULL,'IN'),('05','Wings Air Cargo Co','FORWARDER',NULL,'Y',NULL,NULL,NULL,'BD'),('06','TNT China','FORWARDER',NULL,'Y',NULL,NULL,NULL,'CN'),('07','TNT India','FORWARDER',NULL,'Y',NULL,NULL,NULL,'IN'),('08','Explorer Freight Co','FORWARDER',NULL,'Y',NULL,NULL,NULL,'PH'),('10','WOVEN-나일론','MATERIAL','','Y','9144','2011-06-30',10,''),('00','CREATED','ORDER_STATUS',NULL,'Y','9144',NULL,10,NULL),('10','ORIGINAL SAMPLE','ORDER_STATUS',NULL,'Y','9144',NULL,11,NULL),('20','SAMPLE발송','ORDER_STATUS','Buyer에게 e-mail발송됨','Y','9144','2011-06-03',12,''),('22','SAMPLE수신','ORDER_STATUS',NULL,'Y','9144',NULL,13,NULL),('24','DESIGN수정요청','ORDER_STATUS','바이어로 부터 세빈담당자에게 e-mail발송됨','Y','9144','2011-06-03',14,''),('26','SAMPLE수정','ORDER_STATUS','Buyer에게 e-mail발송됨','Y','9144','2011-06-03',15,''),('30','DESIGN확정','ORDER_STATUS','Buyer에게 e-mail발송됨','Y','9144','2011-06-03',16,''),('35','ORDER요청','ORDER_STATUS','Buyer에게 e-mail발송됨','Y','9144','2011-06-03',17,''),('40','PO-CONFIRM요청','ORDER_STATUS','Buyer에게 e-mail발송됨','Y','9144','2011-06-21',18,''),('45','ORDER확정및생산','ORDER_STATUS','바이어로 부터 세빈담당자에게 e-mail발송됨','Y','9144','2011-06-21',19,''),('50','PP SAMPLE','ORDER_STATUS',NULL,'Y','9144',NULL,20,NULL),('55','PP CONFIRM','ORDER_STATUS',NULL,'Y','9144',NULL,21,NULL),('60','생산지시','ORDER_STATUS',NULL,'Y','9144',NULL,22,NULL),('65','하청','ORDER_STATUS',NULL,'Y','9144',NULL,23,NULL),('70','TOP제작','ORDER_STATUS',NULL,'Y','9144',NULL,24,NULL),('73','제품완성','ORDER_STATUS',NULL,'Y','9144',NULL,24,NULL),('75','SHIPMENT작성','ORDER_STATUS',NULL,'Y','9144',NULL,24,NULL),('80','제품출고','ORDER_STATUS',NULL,'Y','9144',NULL,25,NULL),('85','상품입고','ORDER_STATUS',NULL,'Y','9144',NULL,26,NULL),('90','INVOICE작성','ORDER_STATUS',NULL,'Y','9144',NULL,27,NULL),('92','대금청구','ORDER_STATUS',NULL,'Y','9144',NULL,28,NULL),('94','INVOICE수신','ORDER_STATUS',NULL,'Y','9144',NULL,29,NULL),('96','대금지불','ORDER_STATUS',NULL,'Y','9144',NULL,30,NULL),('98','입금확인','ORDER_STATUS',NULL,'Y','9144',NULL,31,NULL),('99','PAYMENT완료','ORDER_STATUS',NULL,'Y','9144',NULL,32,NULL),('999','ORDER취소','ORDER_STATUS','Buyer에게 e-mail발송됨','Y','9144','2011-06-03',33,''),('1','WOVEN','PGR',NULL,'Y','9144',NULL,5,NULL),('2','KNIT','PGR',NULL,'Y',NULL,NULL,10,NULL),('3','ACCESSORY','PGR',NULL,'Y',NULL,NULL,20,NULL),('9144','JEFFREY SONG','SAMPLE','Jeffrey.song@ffb.net.au','Y','9144',NULL,10,NULL),('AUTUMN','AUTUMN','SEASON',NULL,'Y','9144',NULL,30,NULL),('SPRING','SPRING','SEASON',NULL,'Y','9144',NULL,10,NULL),('SUMMER','SUMMER','SEASON',NULL,'Y','9144',NULL,20,NULL),('WINTER','WINTER','SEASON',NULL,'Y','9144',NULL,40,NULL),('KCRD','Knit-Cardigan','SGR',NULL,'Y',NULL,NULL,540,'2'),('KDRS','Knit-Dress','SGR',NULL,'Y',NULL,NULL,560,'2'),('KJKT','Knit-Jacket','SGR',NULL,'Y',NULL,NULL,570,'2'),('KTOP','Knit-Top','SGR',NULL,'Y',NULL,NULL,520,'2'),('WBLS','Woven-Blouse','SGR',NULL,'Y',NULL,NULL,360,'1'),('WDRS','Woven-Dress','SGR',NULL,'Y',NULL,NULL,310,'1'),('WJKT','Woven-Jacket','SGR',NULL,'Y',NULL,NULL,370,'1'),('WPNT','Woven-Pants','SGR',NULL,'Y',NULL,NULL,490,'1'),('WSHT','Woven-Shirt','SGR',NULL,'Y',NULL,NULL,340,'1'),('WSKT','Woven-Skirt','SGR',NULL,'Y',NULL,NULL,450,'1'),('WTOP','Woven-Top','SGR',NULL,'Y',NULL,NULL,280,'1'),('01','Bangladesh','SHIPPING_PORT',NULL,'Y',NULL,NULL,NULL,'BD'),('02','Chennai','SHIPPING_PORT',NULL,'Y',NULL,NULL,NULL,'IN'),('03','Dalian','SHIPPING_PORT',NULL,'Y',NULL,NULL,NULL,'CN'),('04','Hangzhou','SHIPPING_PORT',NULL,'Y',NULL,NULL,NULL,'CN'),('05','Guangzhou','SHIPPING_PORT',NULL,'Y',NULL,NULL,NULL,'CN'),('06','Hanoi','SHIPPING_PORT',NULL,'Y',NULL,NULL,NULL,'VN'),('07','Hochimin','SHIPPING_PORT',NULL,'Y',NULL,NULL,NULL,'VN'),('08','Honkong','SHIPPING_PORT',NULL,'Y',NULL,NULL,NULL,'HK'),('09','Incheon','SHIPPING_PORT',NULL,'Y',NULL,NULL,NULL,'KR'),('10','Jaipur','SHIPPING_PORT',NULL,'Y',NULL,NULL,NULL,'IN'),('11','KICT','SHIPPING_PORT',NULL,'Y',NULL,NULL,NULL,'PK'),('12','Mongolia','SHIPPING_PORT',NULL,'Y',NULL,NULL,NULL,'MN'),('13','Mumbai','SHIPPING_PORT',NULL,'Y',NULL,NULL,NULL,'IN'),('14','New Delhi','SHIPPING_PORT',NULL,'Y',NULL,NULL,NULL,'IN'),('15','PICT','SHIPPING_PORT',NULL,'Y',NULL,NULL,NULL,'PK'),('16','Pusan','SHIPPING_PORT',NULL,'Y',NULL,NULL,NULL,'KR'),('17','Qingdao','SHIPPING_PORT',NULL,'Y',NULL,NULL,NULL,'CN'),('18','Shanghai','SHIPPING_PORT',NULL,'Y',NULL,NULL,NULL,'CN'),('19','Shenzhen','SHIPPING_PORT',NULL,'Y',NULL,NULL,NULL,'CN'),('20','Taipei','SHIPPING_PORT',NULL,'Y',NULL,NULL,NULL,'TW'),('21','Manila','SHIPPING_PORT',NULL,'Y',NULL,NULL,NULL,'PH'),('S10','단추','SUB_MAT','','Y','9144','2011-05-27',10,''),('S20','고무줄','SUB_MAT','','Y','9144','2011-05-27',20,''),('S30','지퍼','SUB_MAT','','Y','9144','2011-05-27',30,''),('S40','행거루프','SUB_MAT','','Y','9144','2011-05-27',40,''),('AIR','AIR','TRANS_TYPE',NULL,'Y','9144',NULL,20,NULL),('SEA','SEA','TRANS_TYPE',NULL,'Y','9144',NULL,10,NULL),('1','Apparel','USER_CLASS',NULL,'Y',NULL,NULL,10,NULL),('2','Non-Apparel','USER_CLASS',NULL,'Y',NULL,NULL,20,NULL),('A','시스템관리자 Group','USER_GROUP',NULL,'Y','9144',NULL,10,'0'),('AP','LOCAL','USER_GROUP',NULL,'Y','9144',NULL,100,'S'),('B','PO관리 Group','USER_GROUP',NULL,'Y','9144',NULL,30,'H'),('C','Account','USER_GROUP',NULL,'Y',NULL,NULL,60,'C'),('D','DDP','USER_GROUP',NULL,'Y',NULL,NULL,80,'S'),('F','FOB','USER_GROUP',NULL,'Y',NULL,NULL,90,'S'),('M','QC','USER_GROUP',NULL,'Y','9144',NULL,50,'C'),('N','일반관리자 Group','USER_GROUP',NULL,'Y','9144',NULL,20,'H'),('S','Shipping','USER_GROUP',NULL,'Y',NULL,NULL,70,'C'),('H','세빈 사용자','USER_TYPE',NULL,'Y','9144',NULL,10,'H'),('S','Buyer','USER_TYPE',NULL,'Y','9144',NULL,20,'S');
/*!40000 ALTER TABLE `vg_common_code` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2011-07-13 11:57:28
