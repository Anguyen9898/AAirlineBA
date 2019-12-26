-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: aabairline
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `airport_info`
--

DROP TABLE IF EXISTS `airport_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `airport_info` (
  `A_ID` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `A_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `A_ADDRESS` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`A_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airport_info`
--

LOCK TABLES `airport_info` WRITE;
/*!40000 ALTER TABLE `airport_info` DISABLE KEYS */;
INSERT INTO `airport_info` VALUES ('BMV','Buôn Ma Thuột','Đắk Lắk'),('CXR','Cam Ranh','Khánh Hòa'),('DAD','Đà Nẵng','Đà Nẵng'),('DLI','Liên Khương','Lâm Đồng'),('HAN','Nội Bài','Hà Nội'),('HPH','Cát Bi','Hải Phòng'),('HUI','Phú Bài','Thừa Thiên'),('ICN','Seoul','Hàn Quốc'),('PQC','Phú Quốc','Kiên Giang'),('PXU','Pleiku','Gia Lai'),('SGN','Tân Sơn Nhất','Tp HCM'),('THD','Thọ Xuân','Thanh Hóa'),('TPE','Đài Bắc','Đài Loan'),('UIH','Phù Cát','Bình Định'),('VCA','Cần Thơ','Cần Thơ'),('VCL','Chu Lai','Quảng Nam'),('VDH','Đồng Hới','Quảng Bình'),('VDO','Vân Đồn','Quảng Ninh'),('VII','Vinh','Nghệ An');
/*!40000 ALTER TABLE `airport_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `C_ID` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `C_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `C_IDNNUMBER` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `C_PHONE` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `C_DAYOFBIRTH` date DEFAULT NULL,
  `C_ADDRESS` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `C_COUNTRY` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `C_NATIONALITY` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`C_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('cus001','Nguyễn Thị Thanh','568856287','0735548311','1981-05-23',NULL,'',''),('cus002','Trần Quang An','643125784','0504260246','1998-01-26',NULL,'',''),('cus003','Nguyễn Văn Bình','355246251','0513820256','1995-09-06',NULL,'',''),('cus004','Lê Phan Anh','731433461','0701511400','1992-09-24',NULL,'',''),('cus005','Trần Nhật An','511635405','0774745361','1990-01-17',NULL,'',''),('cus006','Đỗ Văn Mỹ','811617362','0347170574','1986-01-14',NULL,'',''),('cus007','Trần Nhật Dương','184312144','0760537260','1966-04-19',NULL,'',''),('cus008','Lê Nhật Anh','542173106','0357266856','1969-08-16',NULL,'',''),('cus009','Trần Văn Bảo','638811861','0356744721','1971-02-15',NULL,'',''),('cus010','Đỗ Phan Dương','402206137','4022061374','1992-10-24',NULL,'','');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `E_ID` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `E_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `E_DAYOFBIRTH` date DEFAULT NULL,
  `E_IDNUMBER` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `E_GENDER` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `E_POSITION` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`E_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('fa001','Đỗ Thị Thanh','1988-07-27','618757174','Nữ','Tiếp Viên Hàng Không'),('fa002','Đỗ Văn Dương','1977-08-12','272650062','Nam','Tiếp Viên Hàng Không'),('fa003','Nguyễn Văn Bảo','1971-01-18','217243153','Nam','Tiếp Viên Hàng Không'),('fa004','Lê Phan Mỹ','1970-11-20','123583548','Nữ','Tiếp Viên Hàng Không'),('fa005','Trần Nhật Anh','1966-01-12','320548646','Nam','Tiếp Viên Hàng Không'),('fa006','Nguyễn Quang Bình','1966-05-27','774223482','Nam','Tiếp Viên Hàng Không'),('fa007','Nguyễn Nhật Bảo','1997-04-27','35568404','Nam','Tiếp Viên Hàng Không'),('fa008','Đỗ Quang Thanh','1979-09-19','167711127','Nam','Tiếp Viên Hàng Không'),('fa009','Lê Thị Bình','1961-01-03','413458427','Nữ','Tiếp Viên Hàng Không'),('fa010','Trần Văn Ân','1998-06-04','870010140','Nam','Tiếp Viên Hàng Không'),('fa011','Phạm Quang An','1982-02-25','210756647','Nam','Tiếp Viên Hàng Không'),('fa012','Lê Văn Bình','1988-01-27','85208407','Nam','Tiếp Viên Hàng Không'),('fa013','Lê Nhật Thanh','1978-01-03','746613041','Nữ','Tiếp Viên Hàng Không'),('fa014','Nguyễn Thị Dương','1991-04-09','305765181','Nữ','Tiếp Viên Hàng Không'),('fa015','Lê Nhật Mỹ','1992-02-19','754561032','Nam','Tiếp Viên Hàng Không'),('fa016','Lê Thị Dương','1980-11-17','156141138','Nữ','Tiếp Viên Hàng Không'),('fa017','Phạm Văn Thanh','1984-08-27','240561424','Nam','Tiếp Viên Hàng Không'),('fa018','Đỗ Quang Ân','1982-04-01','222011663','Nam','Tiếp Viên Hàng Không'),('fa019','Lê Văn Thanh','1986-10-02','327557187','Nam','Tiếp Viên Hàng Không'),('fa020','Nguyễn Phan Thanh','1962-09-08','314453673','Nữ','Tiếp Viên Hàng Không'),('pl001','Trần Phan An','1998-11-25','117204671','Nam','Phi Công'),('pl002','Lê Nhật Ân','1988-03-03','168247210','Nam','Phi Công'),('pl003','Lê Nhật Bình','1979-04-13','875823755','Nam','Phi Công'),('pl004','Phạm Phan Ân','1983-06-26','501387506','Nam','Phi Công'),('pl005','Lê Quang Dương','1978-05-20','476667241','Nam','Phi Công'),('pl006','Phạm Văn An','1962-04-08','375808368','Nam','Phi Công'),('pl007','Phạm Quang Dương','1971-05-11','508067207','Nam','Phi Công'),('pl008','Phạm Nhật Bình','1974-10-04','877053172','Nam','Phi Công'),('pl009','Phạm Phan Dương','1986-06-20','310666236','Nam','Phi Công'),('pl010','Phạm Nhật Anh','1962-04-19','868181700','Nam','Phi Công');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `filght_schedule`
--

DROP TABLE IF EXISTS `filght_schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `filght_schedule` (
  `F_ID` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `DEPATURE_DATE` date NOT NULL,
  `PL_ID` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`F_ID`,`DEPATURE_DATE`),
  KEY `FK_FSToPlane_idx` (`PL_ID`),
  CONSTRAINT `FK_FSToFInfo` FOREIGN KEY (`F_ID`, `DEPATURE_DATE`) REFERENCES `flight_info` (`F_ID`, `F_TAKEOFFDATE`),
  CONSTRAINT `FK_FSToPlane` FOREIGN KEY (`PL_ID`) REFERENCES `plane` (`PL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `filght_schedule`
--

LOCK TABLES `filght_schedule` WRITE;
/*!40000 ALTER TABLE `filght_schedule` DISABLE KEYS */;
/*!40000 ALTER TABLE `filght_schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flight_info`
--

DROP TABLE IF EXISTS `flight_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flight_info` (
  `F_ID` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `F_TAKEOFFDATE` date NOT NULL,
  `F_TAKEOFFTIME` time DEFAULT NULL,
  `F_TAKEOFFPLACE` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `F_ARRIVALTIME` time DEFAULT NULL,
  `F_ARRIVALPLACE` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`F_ID`,`F_TAKEOFFDATE`),
  KEY `FK_FInfoToRoute_idx` (`F_TAKEOFFPLACE`),
  KEY `FK_FInfoToRoute1_idx` (`F_ARRIVALPLACE`),
  CONSTRAINT `FK_FInfoToRoute` FOREIGN KEY (`F_TAKEOFFPLACE`) REFERENCES `route` (`TakeOff_ID`),
  CONSTRAINT `FK_FInfoToRoute1` FOREIGN KEY (`F_ARRIVALPLACE`) REFERENCES `route` (`Arrival_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight_info`
--

LOCK TABLES `flight_info` WRITE;
/*!40000 ALTER TABLE `flight_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `flight_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flying`
--

DROP TABLE IF EXISTS `flying`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flying` (
  `F_ID` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `E_ID` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  ` BE_ASSIGNED` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`F_ID`,`E_ID`),
  KEY `FK_FlyingToEmployee_idx` (`E_ID`),
  CONSTRAINT `FK_FlyingToEmployee` FOREIGN KEY (`E_ID`) REFERENCES `employee` (`E_ID`),
  CONSTRAINT `FK_FlyingToFS` FOREIGN KEY (`F_ID`) REFERENCES `filght_schedule` (`F_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flying`
--

LOCK TABLES `flying` WRITE;
/*!40000 ALTER TABLE `flying` DISABLE KEYS */;
/*!40000 ALTER TABLE `flying` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plane`
--

DROP TABLE IF EXISTS `plane`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plane` (
  `PL_ID` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `PL_SEATAMOUNT` decimal(8,0) DEFAULT NULL,
  `PL_EMPTYSEATAMOUNT` decimal(8,0) DEFAULT NULL,
  PRIMARY KEY (`PL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plane`
--

LOCK TABLES `plane` WRITE;
/*!40000 ALTER TABLE `plane` DISABLE KEYS */;
INSERT INTO `plane` VALUES ('VN-A001',100,100),('VN-A002',100,100),('VN-A003',100,100),('VN-A004',100,100),('VN-A005',150,150),('VN-A006',150,150),('VN-A007',150,150),('VN-A008',180,180),('VN-A009',180,180),('VN-A010',180,180);
/*!40000 ALTER TABLE `plane` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `route`
--

DROP TABLE IF EXISTS `route`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `route` (
  `Arrival_ID` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `TakeOff_ID` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`Arrival_ID`,`TakeOff_ID`),
  KEY `FK_RouteToAirport1_idx` (`TakeOff_ID`),
  CONSTRAINT `FK_RouteToAirport` FOREIGN KEY (`Arrival_ID`) REFERENCES `airport_info` (`A_ID`),
  CONSTRAINT `FK_RouteToAirport1` FOREIGN KEY (`TakeOff_ID`) REFERENCES `airport_info` (`A_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `route`
--

LOCK TABLES `route` WRITE;
/*!40000 ALTER TABLE `route` DISABLE KEYS */;
INSERT INTO `route` VALUES ('DAD','BMV'),('HAN','BMV'),('HPH','BMV'),('VII','BMV'),('HPH','CXR'),('ICN','CXR'),('BMV','DAD'),('DLI','DAD'),('HPH','DAD'),('ICN','DAD'),('PXU','DAD'),('SGN','DAD'),('TPE','DAD'),('DAD','DLI'),('HAN','DLI'),('BMV','HAN'),('CXR','HAN'),('DAD','HAN'),('DLI','HAN'),('HUI','HAN'),('PQC','HAN'),('PXU','HAN'),('SGN','HAN'),('TPE','HAN'),('UIH','HAN'),('VCA','HAN'),('VCL','HAN'),('VDH','HAN'),('VII','HAN'),('BMV','HPH'),('CXR','HPH'),('SGN','HPH'),('UIH','HPH'),('CXR','ICN'),('HPH','SGN'),('HUI','SGN'),('THD','SGN'),('UIH','SGN'),('VDH','SGN'),('VDO','SGN'),('VII','SGN'),('DAD','TPE'),('HAN','VCA'),('HAN','VCL'),('SGN','VDH'),('BMV','VII');
/*!40000 ALTER TABLE `route` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket` (
  `C_ID` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `F_ID` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `TA_ID` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `DEPARTURE_DATE` date NOT NULL,
  `BOOKING_TIME` time NOT NULL,
  `BOOKING_DATE` date NOT NULL,
  `IS_ROUNDTRIP` tinyint(4) NOT NULL,
  `BACKDATE` date DEFAULT NULL,
  PRIMARY KEY (`C_ID`,`F_ID`,`TA_ID`,`DEPARTURE_DATE`),
  KEY `FK_TicketToTA_idx` (`TA_ID`),
  KEY `FK_TicketToFS_idx` (`F_ID`,`DEPARTURE_DATE`),
  CONSTRAINT `FK_TicketToCus` FOREIGN KEY (`C_ID`) REFERENCES `customer` (`C_ID`),
  CONSTRAINT `FK_TicketToFS` FOREIGN KEY (`F_ID`, `DEPARTURE_DATE`) REFERENCES `filght_schedule` (`F_ID`, `DEPATURE_DATE`),
  CONSTRAINT `FK_TicketToTA` FOREIGN KEY (`TA_ID`) REFERENCES `ticketing_agent` (`TA_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticketing_agent`
--

DROP TABLE IF EXISTS `ticketing_agent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticketing_agent` (
  `TA_ID` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `TA_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `TA_IDNUMBER` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `TA_DAYOFBIRTRH` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `TA_PHONE` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `TA_ACCOUNTID` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `TA_PASSWORD` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`TA_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticketing_agent`
--

LOCK TABLES `ticketing_agent` WRITE;
/*!40000 ALTER TABLE `ticketing_agent` DISABLE KEYS */;
/*!40000 ALTER TABLE `ticketing_agent` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-26 19:58:30
