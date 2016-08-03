CREATE DATABASE  IF NOT EXISTS `mt2` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mt2`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: mt1
-- ------------------------------------------------------
-- Server version	5.7.12-log

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
-- Table structure for table `state_t`
--

DROP TABLE IF EXISTS `state_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `state_t` (
  `state_id` int(11) NOT NULL AUTO_INCREMENT,
  `state_name` varchar(255) DEFAULT NULL,
  `state_code` varchar(255) DEFAULT NULL,
  `is_enabled` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`state_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `state_t`
--

LOCK TABLES `state_t` WRITE;
/*!40000 ALTER TABLE `state_t` DISABLE KEYS */;
INSERT INTO `state_t` VALUES (1,'Andhra Pradesh\r\n','AP\r\n',0),(2,'Arunachal Pradesh\r\n','AR\r\n',0),(3,'Assam\r\n','AS',0),(4,'Bihar\r\n','BR\r\n',0),(5,'Chhattisgarh\r\n','CG\r\n',0),(6,'Goa\r\n','GA\r\n',0),(7,'Gujarat\r\n','GJ',0),(8,'Haryana\r\n','HR',0),(9,'Himachal Pradesh\r\n','HP',0),(10,'Jammu and Kashmir\r\n','JK',0),(11,'Jharkhand\r\n','JH',0),(12,'Karnataka\r\n','KA',1),(13,'Kerala\r\n','KL',0),(14,'Madhya Pradesh\r\n','MP',0),(15,'Maharashtra\r\n','MH',1),(16,'Manipur\r\n','MN',0),(17,'Meghalaya\r\n','ML',0),(18,'Mizoram\r\n','MZ',0),(19,'Nagaland\r\n','NL',0),(20,'Orissa\r\n','OR',0),(21,'Punjab\r\n','PB',0),(22,'Rajasthan\r\n','RJ',0),(23,'Sikkim\r\n','SK',0),(24,'Tamil Nadu\r\n','TN',0),(25,'Tripura\r\n','TR',0),(26,'Uttarakhand\r\n','UK',0),(27,'Uttar Pradesh\r\n','UP',0),(28,'West Bengal\r\n','WB',0),(29,'Andaman and Nicobar Islands\r\n','AN',0),(30,'Chandigarh\r\n','CH',0),(31,'Dadra and Nagar Haveli\r\n','DH',0),(32,'Daman and Diu\r\n','DD',0),(33,'Delhi\r\n','DL',0),(34,'Lakshadweep\r\n','LD',0),(35,'Pondicherry\r\n','PY',0);
/*!40000 ALTER TABLE `state_t` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-30 20:27:42
