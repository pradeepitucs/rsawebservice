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
-- Table structure for table `vehicle_manufacturer_t`
--

DROP TABLE IF EXISTS `vehicle_manufacturer_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vehicle_manufacturer_t` (
  `manufacturer_id` int(11) NOT NULL,
  `manufacturer_name` varchar(45) DEFAULT NULL,
  `is_enabled` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`manufacturer_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle_manufacturer_t`
--

LOCK TABLES `vehicle_manufacturer_t` WRITE;
/*!40000 ALTER TABLE `vehicle_manufacturer_t` DISABLE KEYS */;
INSERT INTO `vehicle_manufacturer_t` VALUES (1,'Abarth',1),(2,'Aston Martin',1),(3,'Audi',1),(4,'Bentley',1),(5,'BMW',1),(6,'Bugatti',1),(7,'Caterham',1),(8,'Chevrolet',1),(9,'Conquest',1),(10,'Datsun',1),(11,'DC',1),(12,'Ferrari',1),(13,'Fiat',1),(14,'Force',1),(15,'Ford',1),(16,'Honda',1),(17,'Hyundai',1),(18,'ICML',1),(19,'Isuzu',1),(20,'Jaguar',1),(21,'Jeep',1),(22,'Koenigsegg',1),(23,'Lamborghini',1),(24,'Landrover',1),(25,'Mahindra',1),(26,'Mahindra Ssangyong',1),(27,'Maruthi',1),(28,'Maserati',1),(29,'Mercedez Benz',1),(30,'Mini',1),(31,'Mitsubishi',1),(32,'Nissan',1),(33,'Porshe',1),(34,'Premier',1),(35,'Renault',1),(36,'Rolls Royce',1),(37,'Skoda',1),(38,'Tata',1),(39,'Tesla',1),(40,'Toyota',1),(41,'Volkswagen',1),(42,'Volvo',1);
/*!40000 ALTER TABLE `vehicle_manufacturer_t` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-30 20:27:41
