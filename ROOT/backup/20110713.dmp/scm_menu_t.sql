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
-- Table structure for table `menu_t`
--

DROP TABLE IF EXISTS `menu_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu_t` (
  `SEQNO` int(19) NOT NULL auto_increment,
  `MENU_TYPE` varchar(2) NOT NULL,
  `USER_GROUP` varchar(5) NOT NULL,
  `MENUNAME` varchar(100) NOT NULL,
  `MENUURL` varchar(200) default NULL,
  `SORT_NO` varchar(4) default NULL,
  `PARENT_NO` int(19) NOT NULL,
  `STAFFID` varchar(10) default NULL,
  `INPUT_DATE` date default NULL,
  `MODIFYID` varchar(10) default NULL,
  `MODIFY_DATE` date default NULL,
  PRIMARY KEY  (`SEQNO`,`MENU_TYPE`,`USER_GROUP`,`MENUNAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu_t`
--

LOCK TABLES `menu_t` WRITE;
/*!40000 ALTER TABLE `menu_t` DISABLE KEYS */;
INSERT INTO `menu_t` VALUES (1,'Z','Z','Home',NULL,'000',1,'3',NULL,'3',NULL),(43,'H','N','My Account',NULL,'100',1,'3',NULL,'3',NULL),(44,'H','N','Buyer공지관리','/admin/memo/','110',43,'3',NULL,'9144',NULL),(48,'H','N','오더관리','','300',1,'3',NULL,'9144','2011-05-31'),(49,'H','N','PO수정','/ordermanagement/admin_order_list.jsp','310',48,'3',NULL,'9144',NULL),(50,'H','N','Order Amendment','/ordermanagement/order_amend_list.jsp','320',48,'3',NULL,'9144',NULL),(52,'H','N','Shipment생성','/ordermanagement/shipment_issue_list.jsp','510',528,'3',NULL,'9144',NULL),(54,'H','N','Invoices Search','/order/admin_invoice_search.jsp','360',48,'3',NULL,'3',NULL),(55,'H','N','업무게시판/자료실',NULL,'900',1,'3',NULL,'9144',NULL),(56,'H','N','제품정보 조회','/ordermanagementr/product_info.jsp','910',55,'3',NULL,'9144',NULL),(61,'H','N','Password Change','/admin/resetAdminPasswdForm.jsp?fromURL=menu','160',43,'9240',NULL,'9240',NULL),(101,'H','B','My Account',NULL,'100',1,NULL,NULL,NULL,NULL),(102,'H','B','SAMPLE관리',NULL,'200',1,NULL,NULL,'9144',NULL),(103,'H','B','Password Change','/admin/resetAdminPasswdForm.jsp?fromURL=menu','150',101,NULL,NULL,NULL,NULL),(110,'H','B','업무게시판/자료실',NULL,'900',1,NULL,NULL,'9144',NULL),(111,'H','B','제품정보 조회','/ordermanagement/product_info.jsp','910',110,NULL,NULL,'9144',NULL),(114,'H','N','SAMPLE관리',NULL,'200',1,NULL,NULL,'9144',NULL),(115,'H','N','Sample이미지 관리','/admin/buyer/style_image_upload_form.jsp','210',114,NULL,NULL,'9144',NULL),(116,'H','B','Sample이미지 관리','/admin/buyer/style_image_upload_form.jsp','240',102,NULL,NULL,'9144','2011-06-02'),(117,'H','N','Original Sample관리','/admin/buyer/original_sample_in_out_list.jsp','220',114,NULL,NULL,'9144',NULL),(118,'H','B','Original Sample관리','/admin/buyer/original_sample_in_out_list.jsp','220',102,NULL,NULL,'9144',NULL),(201,'C','M','My Account',NULL,'100',1,NULL,NULL,NULL,NULL),(202,'C','M','Memorandum','/memo/memo.jsp','110',201,NULL,NULL,NULL,NULL),(203,'C','M','Profile','/account/','120',201,NULL,NULL,NULL,NULL),(205,'C','M','Order Management',NULL,'300',1,NULL,NULL,NULL,NULL),(206,'C','M','PO Confirmation','/order/dsk_po_confirm_search.jsp','310',205,NULL,NULL,'9240',NULL),(207,'C','M','PO History','/order/dsk_po_status.jsp','320',205,NULL,NULL,NULL,NULL),(208,'C','M','Order Amendment','/order/po_amend.jsp','330',205,NULL,NULL,NULL,NULL),(209,'C','M','Barcode Files','/order/barcode.jsp','340',205,NULL,NULL,NULL,NULL),(211,'C','M','Packing List','/order/packing.jsp','361',205,NULL,NULL,NULL,NULL),(213,'C','M','Q.C Roster','/order/qc_report.jsp','380',205,NULL,NULL,NULL,NULL),(214,'C','M','Q.C Analysis','/order/qc_analysis.jsp','390',205,NULL,NULL,NULL,NULL),(216,'C','M','GI Packing List','/order/invoice_confirm_search_dsk.jsp','362',205,NULL,NULL,NULL,NULL),(220,'C','M','Services & Support',NULL,'500',1,NULL,NULL,NULL,NULL),(221,'C','M','Product Info.','/order/product_info.jsp','510',220,NULL,NULL,NULL,NULL),(222,'C','M','Manuals','/notice/list.jsp?table_name=notice','530',220,NULL,NULL,'9240',NULL),(224,'C','M','Password Change','/apess/resetPasswdForm.jsp?fromURL=menu','140',201,NULL,NULL,NULL,NULL),(226,'C','C','My Account',NULL,'100',1,NULL,NULL,NULL,NULL),(227,'C','C','Memorandum','/memo/memo.jsp','110',226,NULL,NULL,NULL,NULL),(228,'C','C','Password Change','/apess/resetPasswdForm.jsp?fromURL=menu','140',226,NULL,NULL,NULL,NULL),(229,'C','C','Payment Management',NULL,'300',1,NULL,NULL,NULL,NULL),(230,'C','C','PO History','/order/dsk_po_status.jsp','320',229,NULL,NULL,NULL,NULL),(233,'C','C','GI Packing List','/order/invoice_confirm_search_dsk.jsp','362',229,NULL,NULL,NULL,NULL),(237,'C','C','Invoice Search','/apess/invoice_list.jsp','351',229,NULL,NULL,NULL,NULL),(238,'C','C','Services & Support',NULL,'600',1,NULL,NULL,NULL,NULL),(239,'C','C','Product Info.','/order/product_info.jsp','610',238,NULL,NULL,NULL,NULL),(240,'C','C','Manuals','/notice/list.jsp?table_name=notice','630',238,NULL,NULL,'9240',NULL),(242,'C','S','My Account',NULL,'100',1,NULL,NULL,NULL,NULL),(243,'C','S','Memorandum','/memo/memo.jsp','110',242,NULL,NULL,NULL,NULL),(244,'C','S','Password Change','/apess/resetPasswdForm.jsp?fromURL=menu','140',242,NULL,NULL,NULL,NULL),(245,'C','S','Shipment Management',NULL,'300',1,NULL,NULL,NULL,NULL),(247,'C','S','Packing Form Creation','/order/packing_create.jsp','350',245,NULL,NULL,NULL,NULL),(248,'C','S','Packing List','/order/packing.jsp','351',245,NULL,NULL,NULL,NULL),(252,'C','S','Invoice Creation','/apess/invoice_issue_list.jsp','360',245,NULL,NULL,NULL,NULL),(253,'C','S','Invoice Search','/apess/invoice_list.jsp','361',245,NULL,NULL,NULL,NULL),(257,'C','A','My Account',NULL,'100',1,NULL,NULL,NULL,NULL),(258,'C','A','Memorandum','/memo/memo.jsp','110',257,NULL,NULL,'9240',NULL),(259,'C','A','Password Change','/apess/resetPasswdForm.jsp?fromURL=menu','140',257,NULL,NULL,NULL,NULL),(260,'C','A','Shipment Management',NULL,'300',1,NULL,NULL,NULL,NULL),(261,'C','A','PO History','/order/dsk_po_status.jsp','320',260,NULL,NULL,NULL,NULL),(262,'C','A','Packing List','/order/packing.jsp','351',260,NULL,NULL,NULL,NULL),(263,'C','A','Received Qty List','/order/invoice_confirm_search_dsk.jsp','352',260,NULL,NULL,'9240',NULL),(265,'C','A','Invoice Search','/apess/invoice_list.jsp','361',260,NULL,NULL,NULL,NULL),(268,'C','A','Services & Support',NULL,'600',1,NULL,NULL,NULL,NULL),(269,'C','A','Product Info.','/order/product_info.jsp','610',268,NULL,NULL,NULL,NULL),(270,'C','A','Manuals','/notice/list.jsp?table_name=notice','630',268,NULL,NULL,'9240',NULL),(272,'C','A','Packing Form Creation','/order/packing_create.jsp','350',260,NULL,NULL,NULL,NULL),(273,'C','A','Invoice Creation','/apess/invoice_issue_list.jsp','360',260,NULL,NULL,NULL,NULL),(274,'C','A','PO History+','/order/dsk_po_status.jsp?M=Y','321',260,NULL,NULL,'9240',NULL),(275,'C','A','Invoice Search+','/apess/invoice_list.jsp?M=Y','362',260,NULL,NULL,'9240',NULL),(276,'C','A','Apess User List','/admin/apessuser/list.jsp','120',257,NULL,NULL,'9240',NULL),(277,'C','A','Inspector Management','/apess/inspector_list.jsp','130',257,NULL,NULL,NULL,NULL),(286,'H','A','나의계정','','050',1,NULL,NULL,'9144','2011-05-23'),(287,'H','A','SAMPLE관리',NULL,'200',1,NULL,NULL,'9144',NULL),(288,'H','A','오더관리',NULL,'300',1,NULL,NULL,'9144',NULL),(289,'H','A','업무게시판/자료실',NULL,'900',1,NULL,NULL,'9144',NULL),(290,'H','A','Buyer 공지사항 관리','/admin/memo/','110',494,NULL,NULL,'9144',NULL),(291,'H','A','Buyer관리','/account/supplier.jsp','120',494,NULL,NULL,'9144',NULL),(293,'H','A','사용자 관리','/admin/adminuser/list.jsp','140',494,NULL,NULL,'9144',NULL),(296,'H','A','사용자 메뉴관리','/admin/menu/menu_list.jsp?menuType=H','150',494,NULL,NULL,'9144','2011-06-03'),(297,'H','A','Buyer 메뉴 관리','/admin/menu/menu_list.jsp?menuType=S','151',494,NULL,NULL,'9144','2011-06-03'),(299,'H','A','비밀번호 변경','/admin/resetAdminPasswdForm.jsp?fromURL=menu','060',286,NULL,NULL,'9144',NULL),(300,'H','A','Sample이미지 관리','/admin/buyer/style_image_upload_form.jsp','250',287,NULL,NULL,'9144','2011-06-02'),(301,'H','A','Original Sample관리','/admin/buyer/original_sample_in_out_list.jsp','220',287,NULL,NULL,'9144',NULL),(302,'H','A','PO수정','/ordermanagement/admin_order_list.jsp','310',288,NULL,NULL,'9144',NULL),(303,'H','A','Order Amendment','/ordermanagement/order_amend_list.jsp','320',288,NULL,NULL,'9144',NULL),(305,'H','A','Shipment생성','/ordermanagement/shipment_issue_list.jsp','510',525,NULL,NULL,'9144',NULL),(308,'H','A','Invoices검색','/payment/invoice_search.jsp','740',527,NULL,NULL,'9144',NULL),(311,'H','A','제품정보 조회','/ordermanagement/admin_item_history_list.jsp','910',289,NULL,NULL,'9144',NULL),(351,'C','S','PO History','/order/dsk_po_status.jsp','320',245,'9240',NULL,'9240',NULL),(353,'C','A','Q.C Roster','/order/qc_report.jsp','380',260,'9240',NULL,'9240',NULL),(354,'C','A','Q.C Analysis','/order/qc_analysis.jsp','381',260,'9240',NULL,'9240',NULL),(355,'C','A','Barcode Files','/order/barcode.jsp','340',260,'9240',NULL,'9240',NULL),(356,'C','S','Barcode Files','/order/barcode.jsp','340',245,'9240',NULL,'9240',NULL),(359,'C','A','Barcode Check','/pda.jsp','390',260,'9240',NULL,'9240',NULL),(360,'C','C','Barcode Check','/pda.jsp','390',229,'9240',NULL,'9240',NULL),(361,'C','M','Barcode Check','/pda.jsp','395',205,'9240',NULL,'9240',NULL),(362,'C','S','Barcode Check','/pda.jsp','390',245,'9240',NULL,'9240',NULL),(364,'H','N','Buyer관리','/account/supplier.jsp','120',43,'9240',NULL,'9144',NULL),(391,'H','A','자료실','/notice_new/list.jsp?noticeType=2','940',289,'9240',NULL,'9144','2011-06-29'),(392,'H','N','자료실','/notice_new/list.jsp?noticeType=2','940',55,'9240',NULL,'9144','2011-06-29'),(393,'H','B','자료실','/notice_new/list.jsp?noticeType=2','940',110,'9240',NULL,'9144','2011-06-29'),(400,'S','F','My Account','','100',1,'9240',NULL,'9144','2011-05-23'),(401,'S','F','Order Management',NULL,'300',1,'9240',NULL,'9144',NULL),(402,'S','F','Invoices',NULL,'400',1,'9240',NULL,'9144',NULL),(403,'S','F','업무게시판/자료실',NULL,'500',1,'9240',NULL,'9144',NULL),(404,'S','F','공지사항','/memo/index.jsp','110',400,'9240',NULL,'9144',NULL),(405,'S','F','Profile','/account/view_profile.jsp','120',400,'9240',NULL,'9144',NULL),(406,'S','F','PO Confirmation','/ordermanagement/buyer_order_confirm_list.jsp','310',401,'9240',NULL,'9144',NULL),(407,'S','F','PO History','/ordermanagement/buyer_order_list.jsp','320',401,'9240',NULL,'9144',NULL),(408,'S','F','Order Amendment','/ordermanagement/buyer_order_amend_list.jsp','330',401,'9240',NULL,'9144',NULL),(412,'S','F','Invoice조회','/payment/buyer_invoice_search.jsp','405',402,'9240',NULL,'9144',NULL),(415,'S','F','Payment조회','/payment/buyer_payment_search.jsp','425',402,'9240',NULL,'9144',NULL),(417,'S','F','제품정보 조회','/ordermanagement/buyer_item_history_list.jsp','510',403,'9240',NULL,'9144',NULL),(418,'S','F','게시판','/notice_new/buyer_list.jsp?noticeType=1','530',403,'9240',NULL,'9144','2011-06-29'),(419,'S','F','자료실','/notice_new/buyer_list.jsp?noticeType=2','540',403,'9240',NULL,'9144','2011-06-29'),(447,'C','A','Tag Specs','/notice/list.jsp?table_name=notice2','640',268,'9240',NULL,'9240',NULL),(448,'C','C','Tag Specs','/notice/list.jsp?table_name=notice2','640',238,'9240',NULL,'9240',NULL),(449,'C','M','Tag Specs','/notice/list.jsp?table_name=notice2','540',220,'9240',NULL,'9240',NULL),(453,'H','A','Order Status관리','/ordermanagement/admin_order_status_list.jsp','315',288,'9240',NULL,'9144',NULL),(454,'H','B','오더관리',NULL,'300',1,'9240',NULL,'9144',NULL),(455,'H','B','Order Status관리','/ordermanagement/admin_order_status_list.jsp','315',454,'9240',NULL,'9144',NULL),(457,'S','F','Shipment List','/ordermanagement/buyer_shipment_list.jsp','375',401,'9240',NULL,'9144',NULL),(458,'H','A','Shipment List','/ordermanagement/admin_shipment_list.jsp','520',525,'9240',NULL,'9144',NULL),(459,'H','N','Shipment List','/ordermanagement/admin_shipment_list.jsp','520',528,'9240',NULL,'9144',NULL),(460,'C','A','Profile','/account/','135',257,'9240',NULL,'9240',NULL),(461,'H','N','Order Status관리','/ordermanagement/admin_order_status_list.jsp','315',48,'9240',NULL,'9144',NULL),(485,'C','A','Shipment Creation','/order/shipment_issue_list.jsp','355',260,'9240',NULL,'9240',NULL),(486,'C','A','Shipment List','/order/shipment_list.jsp','356',260,'9240',NULL,'9240',NULL),(487,'C','A','Credit/Debit Note','/order/dsk_note.jsp','363',260,'9240',NULL,'9240',NULL),(488,'C','S','Shipment Creation','/order/shipment_issue_list.jsp','355',245,'9240',NULL,'9240',NULL),(489,'C','S','Shipment List','/order/shipment_list.jsp','356',245,'9240',NULL,'9240',NULL),(490,'C','S','Credit/Debit Note','/order/dsk_note.jsp','363',245,'9240',NULL,'9240',NULL),(491,'C','C','Credit/Debit Note','/order/dsk_note.jsp','363',229,'9240',NULL,'9240',NULL),(492,'H','A','기초코드 관리','/admin/codes/code_list.jsp','125',494,'9144',NULL,'9144',NULL),(494,'H','A','시스템관리','','100',1,'9144',NULL,'9144','2011-05-23'),(496,'H','A','시스템공지 관리','/admin/notice/list.jsp','155',494,'9144',NULL,'9144',NULL),(497,'H','A','생산업체 등록','/account/sub_list.jsp','130',494,'9144',NULL,'9144',NULL),(498,'H','A','PO생성','/ordermanagement/PurchaseOrder.jsp','305',288,'9144',NULL,'9144',NULL),(500,'H','A','상품이미지 Upload','/ordermanagement/image_upload.jsp','313',288,'9144',NULL,'9144',NULL),(502,'H','A','Company Logo등록','/admin/codes/companyci_upload.jsp','160',494,'9144',NULL,'9144',NULL),(504,'H','A','상품이미지 Batch Upload','/ordermanagement/style_image_upload_form.jsp','314',288,'9144',NULL,'9144',NULL),(505,'H','B','상품이미지 Batch Upload','/ordermanagement/style_image_upload_form.jsp','321',454,'9144',NULL,'9144','2011-06-08'),(506,'H','N','상품이미지 Batch Upload','/ordermanagement/style_image_upload_form.jsp','305',48,'9144',NULL,'9144',NULL),(508,'S','F','SAMPLE관리',NULL,'200',1,'9144',NULL,'9144',NULL),(509,'S','F','Original Sample관리','/sample/original_sample_list.jsp','210',508,'9144',NULL,'9144','2011-05-23'),(510,'H','A','회사정보 관리','/account/company_list.jsp','135',494,'9144',NULL,'9144',NULL),(511,'H','A','생산관리',NULL,'400',1,'9144',NULL,'9144',NULL),(512,'H','A','생산현황 관리','/admin/product/product_management.jsp','410',511,'9144',NULL,'9144',NULL),(515,'H','B','Order Amendment','/ordermanagement/order_amend_list.jsp','317',454,'9144',NULL,'9144',NULL),(516,'H','B','PO생성','/ordermanagement/PurchaseOrder.jsp','312',454,'9144',NULL,'9144','2011-06-08'),(517,'H','B','PO수정','/ordermanagement/admin_order_list.jsp','313',454,'9144',NULL,'9144','2011-06-08'),(518,'H','B','상품이미지 Upload','/ordermanagement/image_upload.jsp','320',454,'9144',NULL,'9144','2011-06-08'),(520,'H','B','Shipment생성','/ordermanagement/shipment_issue_list.jsp','510',529,'9144',NULL,'9144',NULL),(522,'H','B','생산관리',NULL,'400',1,'9144',NULL,'9144',NULL),(523,'H','B','생산현황 관리','/admin/product/product_management.jsp','410',522,'9144',NULL,'9144',NULL),(524,'H','B','Buyer 공지사항 관리','/admin/memo/','151',101,'9144',NULL,'9144',NULL),(525,'H','A','출하관리',NULL,'500',1,'9144',NULL,'9144',NULL),(526,'H','A','Invoice생성','/payment/invoice_confirm_search.jsp','730',527,'9144',NULL,'9144',NULL),(527,'H','A','대금결제 관리','','700',1,'9144',NULL,'9144','2011-05-31'),(528,'H','N','출하관리',NULL,'500',1,'9144',NULL,'9144',NULL),(529,'H','B','출하관리',NULL,'500',1,'9144',NULL,'9144',NULL),(530,'H','B','Shipment list','/ordermanagement/admin_shipment_list.jsp','520',529,'9144',NULL,'9144',NULL),(531,'H','B','대금결제 관리','','700',1,'9144',NULL,'9144','2011-05-31'),(532,'H','B','Invoice생성','/payment/invoice_confirm_search.jsp','710',531,'9144',NULL,'9144',NULL),(533,'H','B','Invoices검색','/payment/invoice_search.jsp','720',531,'9144',NULL,'9144',NULL),(534,'H','A','하청공장 결제관리','/payment/sub_payment_list.jsp','710',527,'9144',NULL,'9144','2011-05-31'),(535,'H','A','PO History','/ordermanagement/admin_order_history_list.jsp','311',288,'9144',NULL,'9144',NULL),(536,'H','N','PO History','/ordermanagement/admin_order_history_list.jsp','316',48,'9144',NULL,'9144',NULL),(537,'H','B','PO History','/ordermanagement/admin_order_history_list.jsp','314',454,'9144',NULL,'9144','2011-06-08'),(538,'H','A','Buyer Payment관리','/payment/admin_payment_list.jsp','750',527,'9144',NULL,'9144',NULL),(539,'H','A','Payment조회','/payment/admin_payment_search.jsp','760',527,'9144',NULL,'9144',NULL),(540,'H','A','생산원가관리','/admin/product/cost_management.jsp','420',511,'9144','2011-05-26','9144','2011-05-26'),(541,'H','A','Sample Sheet관리','/admin/buyer/original_sample_list.jsp','230',287,'9144','2011-06-02','9144','2011-06-02'),(542,'H','B','Sample Sheet관리','/admin/buyer/original_sample_list.jsp','230',102,'9144','2011-06-02','9144','2011-06-02'),(543,'S','F','Sample Sheet조회','/sample/sample_sheet_list.jsp','220',508,'9144','2011-06-03','9144','2011-06-03'),(544,'H','B','Buyer조회','/account/supplier.jsp','311',454,'9144','2011-06-08','9144','2011-06-08'),(545,'H','B','외주생산업체 관리','/account/sub_list.jsp','310',454,'9144','2011-06-08','9144','2011-06-08'),(546,'H','B','생산원가 관리','/admin/product/cost_management.jsp','420',522,'1001','2011-06-08','1001','2011-06-08'),(547,'H','B','하청공장 결제관리','/admin/product/cost_management.jsp','705',531,'1001','2011-06-08','1001','2011-06-08'),(548,'H','B','Buyer Payment관리','/payment/admin_payment_list.jsp','730',531,'1001','2011-06-08','1001','2011-06-08'),(549,'H','B','Payment조회','/payment/admin_payment_search.jsp','740',531,'1001','2011-06-08','1001','2011-06-08'),(550,'H','A','외주하청 오더관리','/admin/product/admin_suborder_list.jsp','415',511,'9144','2011-06-17','9144','2011-06-17'),(551,'H','B','외주하청 오더관리','/admin/product/admin_suborder_list.jsp','415',522,'9144','2011-06-20','9144','2011-06-20'),(552,'H','A','업무 게시판','/notice_new/list.jsp?noticeType=1','920',289,'9144','2011-06-29','9144','2011-06-29'),(553,'H','B','업무 게시판','/notice_new/list.jsp?noticeType=1','920',110,'9144','2011-06-29','9144','2011-06-29'),(554,'H','N','업무 게시판','/notice_new/list.jsp?noticeType=1','920',55,'9144','2011-06-29','9144','2011-06-29'),(555,'H','A','DB Layout','/admin/SystemAdmin/Table_Layout.html','190',494,'9144','2011-07-05','9144','2011-07-05');
/*!40000 ALTER TABLE `menu_t` ENABLE KEYS */;
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
