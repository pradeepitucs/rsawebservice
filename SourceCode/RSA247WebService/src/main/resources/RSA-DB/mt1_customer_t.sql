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
-- Table structure for table `customer_t`
--

DROP TABLE IF EXISTS `customer_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_t` (
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `city_id` int(11) DEFAULT NULL,
  `email_id` varchar(255) DEFAULT NULL,
  `folder_name` varchar(255) DEFAULT NULL,
  `gcm_id` varchar(255) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  KEY `FK_8q42yc6ak99cpm9i86kyajn07` (`city_id`),
  KEY `FK_2yaf663jg298pg2w17t9dwja7` (`user_id`),
  CONSTRAINT `FK_2yaf663jg298pg2w17t9dwja7` FOREIGN KEY (`user_id`) REFERENCES `user_t` (`user_id`),
  CONSTRAINT `FK_8q42yc6ak99cpm9i86kyajn07` FOREIGN KEY (`city_id`) REFERENCES `city_t` (`city_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_t`
--

LOCK TABLES `customer_t` WRITE;
/*!40000 ALTER TABLE `customer_t` DISABLE KEYS */;
INSERT INTO `customer_t` VALUES ('\'Guru\'','\'raj\'',1,'\'guru@gmail.com\'','\'test\'','\'test\'',13),('\'Guru\'','\'raj\'',1,'\'guru@gmail.com\'','\'test\'','\'test\'',14),('\'test\'','\'last\'',1,'\'email\'','\'test\'','\'gcmid\'',16),('\'test\'','\'last\'',1,'\'email\'','\'test\'','\'gcmid\'',17);
/*!40000 ALTER TABLE `customer_t` ENABLE KEYS */;
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
