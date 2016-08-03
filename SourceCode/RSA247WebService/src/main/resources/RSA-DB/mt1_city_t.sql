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
-- Table structure for table `city_t`
--

DROP TABLE IF EXISTS `city_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city_t` (
  `city_id` int(11) NOT NULL AUTO_INCREMENT,
  `city_name` varchar(255) DEFAULT NULL,
  `city_code` varchar(255) DEFAULT NULL,
  `state_id` int(11) DEFAULT NULL,
  `is_enabled` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`city_id`),
  KEY `state_id` (`state_id`),
  CONSTRAINT `FK_gfkdhkbmopw60wcpspo5a3fmr` FOREIGN KEY (`state_id`) REFERENCES `state_t` (`state_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city_t`
--

LOCK TABLES `city_t` WRITE;
/*!40000 ALTER TABLE `city_t` DISABLE KEYS */;
INSERT INTO `city_t` VALUES (1,'Pune','PU',15,1),(2,'Bengaluru','BNG',12,1),(3,'Mumbai','MU',15,1);
/*!40000 ALTER TABLE `city_t` ENABLE KEYS */;
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
