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
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `country` (
  `CT_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `CT_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `CT_PPrefix` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`CT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES ('CN','China','+86'),('DE','Germany','+49'),('FR','France','+33'),('JP','Japan','+81'),('KH','Cambodia','+855'),('LA','Laos','+865'),('SG','Singapore','+65'),('SK','South Korea','+82'),('TH','Thaland','+66'),('UK','United Kingdom','+44'),('US','United States','+1'),('VN','Viet Nam','+84');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
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
  `C_IDNUMBER` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `C_GENDER` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `C_PHONE` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `C_DAYOFBIRTH` date NOT NULL,
  `C_EMAIL` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `C_ADDRESS` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `C_COUNTRY` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `C_NATIONALITY` varchar(50) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`C_ID`),
  KEY `FK_CusToCT_idx` (`C_COUNTRY`,`C_NATIONALITY`),
  KEY `FK_CusToCT1_idx` (`C_NATIONALITY`),
  CONSTRAINT `FK_CusToCT` FOREIGN KEY (`C_COUNTRY`) REFERENCES `country` (`CT_ID`),
  CONSTRAINT `FK_CusToCT1` FOREIGN KEY (`C_NATIONALITY`) REFERENCES `country` (`CT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES ('cus00001','Nguyễn Thị Thanh','568856287','Nam','0735548311','1981-05-23','thanh@gmail.com','1 Nguyễn Kiệm TP.HCM','VN','VN'),('cus00002','Trần Quang An','643125784','Nữ','0504260246','1998-01-26','an@gmail.com','2 Nguyễn Kiệm TP.HCM','VN','VN');
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
-- Table structure for table `flight_info`
--

DROP TABLE IF EXISTS `flight_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flight_info` (
  `F_ID` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `F_TAKEOFFDATE` date NOT NULL,
  `F_TAKEOFFTIME` time DEFAULT NULL,
  `F_ARRIVALDATE` date DEFAULT NULL,
  `F_ARRIVALTIME` time DEFAULT NULL,
  `F_ROUTE` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `F_PRICE` double NOT NULL,
  PRIMARY KEY (`F_ID`,`F_TAKEOFFDATE`),
  KEY `FK_FInfoToRoute_idx` (`F_ROUTE`),
  CONSTRAINT `FK_FInfoToRoute` FOREIGN KEY (`F_ROUTE`) REFERENCES `route` (`R_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flight_info`
--

LOCK TABLES `flight_info` WRITE;
/*!40000 ALTER TABLE `flight_info` DISABLE KEYS */;
INSERT INTO `flight_info` VALUES ('fl0001','2019-12-30','09:00:00','2019-12-30','21:00:00','r001',20000000),('fl0002','2020-01-05','18:00:00','2020-02-06','17:00:00','r001',30000000),('fl0003','2020-01-05','18:00:00','2020-02-06','17:00:00','r001',20000),('fl0004','2019-12-30','09:00:00','2019-12-30','21:00:00','r001',1000),('fl0005','2019-11-26','03:00:00','2019-11-26','19:30:00','r021',50000000),('fl0006','2019-10-30','17:00:00','2019-10-31','10:30:00','r020',20000000),('fl0007','2019-11-26','07:45:00','2019-11-26','18:30:00','r019',40000000),('fl0008','2019-10-17','04:00:00','2019-10-17','15:45:00','r018',80000000),('fl0009','2019-10-15','16:30:00','2019-10-16','08:30:00','r017',40000000),('fl0010','2019-12-03','13:45:00','2019-12-04','02:30:00','r016',20000000),('fl0011','2019-12-17','19:30:00','2019-12-17','21:45:00','r015',10000000),('fl0012','2019-11-02','18:00:00','2019-11-03','11:30:00','r014',20000000),('fl0013','2019-12-04','12:30:00','2019-12-04','18:45:00','r013',20000000),('fl0014','2019-10-09','09:45:00','2019-10-10','11:00:00','r012',20000000),('fl0015','2019-10-08','08:00:00','2019-10-08','11:00:00','r011',20000000),('fl0016','2019-11-02','15:00:00','2019-11-03','16:00:00','r010',20000000),('fl0017','2019-12-04','23:30:00','2019-12-05','05:00:00','r009',40000000),('fl0018','2019-11-06','10:00:00','2019-11-07','11:45:00','r008',20000000),('fl0019','2019-10-17','17:45:00','2019-10-17','21:00:00','r007',80000000),('fl0020','2019-10-15','05:00:00','2019-10-15','19:00:00','r006',50000000),('fl0021','2019-05-12','02:00:00','2019-05-12','13:00:00','r002',20000000),('fl0022','2019-08-16','18:45:00','2019-08-17','16:00:00','r003',50000000),('fl0023','2019-09-21','16:45:00','2019-09-22','20:00:00','r004',30000000),('fl0024','2019-09-26','22:45:00','2019-09-27','03:45:00','r005',90000000),('fl0025','2020-01-05','09:00:00','2019-12-30','21:00:00','r001',1000),('fl0026','2020-01-05','18:00:00','2020-02-06','17:00:00','r001',20000),('fl0027','2020-01-04','07:00:00','2020-01-04','17:00:00','r002',5000000),('fl0028','2020-01-04','17:00:00','2020-01-05','17:00:00','r003',500000);
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
  `MainPilot` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `SidePilot` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `F_Attendant1` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `F_Attendant2` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `F_Attendant3` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `PL_ID` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`F_ID`),
  KEY `FK_FlyingToPlane_idx` (`PL_ID`),
  KEY `FK_FlyingToEmp_idx` (`MainPilot`,`SidePilot`),
  KEY `FK_FlyingToEmp1_idx` (`SidePilot`),
  KEY `FK_FlyingToEmp2_idx` (`F_Attendant1`),
  KEY `FK_FlyingToEmp3_idx` (`F_Attendant2`),
  KEY `FK_FlyingToEmp4_idx` (`F_Attendant3`),
  CONSTRAINT `FK_FlyingToEmp` FOREIGN KEY (`MainPilot`) REFERENCES `employee` (`E_ID`),
  CONSTRAINT `FK_FlyingToEmp1` FOREIGN KEY (`SidePilot`) REFERENCES `employee` (`E_ID`),
  CONSTRAINT `FK_FlyingToEmp2` FOREIGN KEY (`F_Attendant1`) REFERENCES `employee` (`E_ID`),
  CONSTRAINT `FK_FlyingToEmp3` FOREIGN KEY (`F_Attendant2`) REFERENCES `employee` (`E_ID`),
  CONSTRAINT `FK_FlyingToEmp4` FOREIGN KEY (`F_Attendant3`) REFERENCES `employee` (`E_ID`),
  CONSTRAINT `FK_FlyingToFL` FOREIGN KEY (`F_ID`) REFERENCES `flight_info` (`F_ID`),
  CONSTRAINT `FK_FlyingToPlane` FOREIGN KEY (`PL_ID`) REFERENCES `plane` (`PL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flying`
--

LOCK TABLES `flying` WRITE;
/*!40000 ALTER TABLE `flying` DISABLE KEYS */;
INSERT INTO `flying` VALUES ('fl0001','pl001','pl002','fa001','fa002','fa003','VN-A001'),('fl0002','pl002','pl001','fa003','fa002','fa001','VN-A002'),('fl0003','pl003','pl004','fa004','fa005','fa006','VN-A003'),('fl0004','pl004','pl005','fa005','fa007','fa003','VN-A004'),('fl0005','pl002','pl006','fa005','fa010','fa009','VN-A005'),('fl0006','pl010','pl003','fa011','fa007','fa013','VN-A006'),('fl0007','pl003','pl005','fa001','fa002','fa003','VN-A007'),('fl0008','pl010','pl002','fa010','fa020','fa019','VN-A008'),('fl0009','pl005','pl007','fa011','fa017','fa015','VN-A009'),('fl0010','pl004','pl008','fa003','fa008','fa005','VN-A010'),('fl0011','pl009','pl002','fa003','fa006','fa020','VN-A010'),('fl0012','pl004','pl007','fa018','fa015','fa014','VN-A009'),('fl0013','pl001','pl002','fa001','fa002','fa003','VN-A008'),('fl0014','pl001','pl002','fa001','fa002','fa003','VN-A007'),('fl0015','pl001','pl002','fa001','fa002','fa003','VN-A006'),('fl0016','pl001','pl002','fa001','fa002','fa003','VN-A005'),('fl0017','pl001','pl002','fa001','fa002','fa003','VN-A007'),('fl0018','pl001','pl002','fa001','fa002','fa003','VN-A008'),('fl0019','pl001','pl002','fa001','fa002','fa003','VN-A009'),('fl0020','pl001','pl002','fa001','fa002','fa003','VN-A002'),('fl0021','pl001','pl002','fa001','fa002','fa003','VN-A001'),('fl0022','pl001','pl002','fa001','fa002','fa003','VN-A002'),('fl0023','pl001','pl002','fa001','fa002','fa003','VN-A003'),('fl0024','pl001','pl002','fa001','fa002','fa003','VN-A004');
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
  `R_ID` varchar(45) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `TakeOffPlace` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `ArrivalPlace` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `R_DETAIL` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`R_ID`,`TakeOffPlace`,`ArrivalPlace`),
  KEY `FK_RouteToAirport_idx` (`TakeOffPlace`),
  KEY `FK_RouteToAirport1_idx` (`ArrivalPlace`),
  CONSTRAINT `FK_RouteToAirport` FOREIGN KEY (`TakeOffPlace`) REFERENCES `airport_info` (`A_ID`),
  CONSTRAINT `FK_RouteToAirport1` FOREIGN KEY (`ArrivalPlace`) REFERENCES `airport_info` (`A_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `route`
--

LOCK TABLES `route` WRITE;
/*!40000 ALTER TABLE `route` DISABLE KEYS */;
INSERT INTO `route` VALUES ('r001','BMV','DAD',''),('r002','BMV','HAN',''),('r003','BMV','HPH',''),('r004','BMV','VII',''),('r005','CXR','HPH',''),('r006','CXR','ICN',''),('r007','DAD','BMV',''),('r008','DAD','DLI',''),('r009','DAD','HPH',''),('r010','DAD','ICN',''),('r011','DAD','PXU',''),('r012','DAD','SGN',''),('r013','DAD','TPE',''),('r014','DLI','DAD',''),('r015','DLI','HAN',''),('r016','HAN','BMV',''),('r017','HAN','CXR',''),('r018','HAN','DAD',''),('r019','HAN','DLI',''),('r020','HAN','HUI',''),('r021','HAN','PQC',''),('r022','HAN','PXU',''),('r023','HAN','SGN',''),('r024','HAN','TPE',''),('r025','HAN','UIH',''),('r026','HAN','VCA',''),('r027','HAN','VCL',''),('r028','HAN','VDH',''),('r029','HAN','VII',''),('r030','HPH','BMV',''),('r031','HPH','CXR',''),('r032','HPH','SGN',''),('r033','HPH','UIH',''),('r034','ICN','CXR',''),('r035','SGN','HPH',''),('r036','SGN','HUI',''),('r037','SGN','THD',''),('r038','SGN','UIH',''),('r039','SGN','VDH',''),('r040','SGN','VDO',''),('r041','SGN','VII',''),('r042','TPE','DAD',''),('r043','VCA','HAN',''),('r044','VCL','HAN',''),('r045','VDH','SGN',''),('r046','VII','BMV',''),('r047','UIH','HAN',''),('r048','UIH','HPH',''),('r049','UIH','SGN','');
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
  `BACKTRIP` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `SEAT_ID` varchar(45) COLLATE utf8_unicode_ci NOT NULL,
  `PRICE` double DEFAULT NULL,
  `Booker` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`C_ID`,`F_ID`,`TA_ID`,`DEPARTURE_DATE`),
  KEY `FK_TicketToTA_idx` (`TA_ID`),
  KEY `FK_TicketToFL_idx` (`F_ID`),
  KEY `FK_TicketToCus_idx` (`Booker`),
  CONSTRAINT `FK_TicketToCus` FOREIGN KEY (`C_ID`) REFERENCES `customer` (`C_ID`),
  CONSTRAINT `FK_TicketToCus1` FOREIGN KEY (`Booker`) REFERENCES `customer` (`C_ID`),
  CONSTRAINT `FK_TicketToFL` FOREIGN KEY (`F_ID`) REFERENCES `flight_info` (`F_ID`),
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
INSERT INTO `ticketing_agent` VALUES ('ta001','Nguyễn Vân Trường An','025767462','1998-10-24','09255712712','Anguyen đẹp zai','2410'),('ta002','Trần Châu Nhật Bảo','012345678','1998-01-01','0912345676','Tôi bị khùng','12131456'),('ta003','Đỗ Quang Ân','087654321','1998-02-03','0923532432','Tôi bị điên','1234');
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

-- Dump completed on 2020-01-05 14:28:39
