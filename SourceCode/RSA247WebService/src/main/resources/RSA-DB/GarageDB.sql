CREATE DATABASE  IF NOT EXISTS `garage` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `garage`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: garage
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
-- Table structure for table `api_access_t`
--

DROP TABLE IF EXISTS `api_access_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `api_access_t` (
  `app_id` int(11) NOT NULL AUTO_INCREMENT,
  `is_enabled` tinyint(4) DEFAULT '1',
  `public_key` varbinary(200) DEFAULT NULL,
  `private_key` varbinary(200) DEFAULT NULL,
  PRIMARY KEY (`app_id`),
  UNIQUE KEY `public_key_UNIQUE` (`public_key`),
  UNIQUE KEY `private_key_UNIQUE` (`private_key`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `api_access_t`
--

LOCK TABLES `api_access_t` WRITE;
/*!40000 ALTER TABLE `api_access_t` DISABLE KEYS */;
INSERT INTO `api_access_t` VALUES (1,1,'apprsa','appucsrsa');
/*!40000 ALTER TABLE `api_access_t` ENABLE KEYS */;
UNLOCK TABLES;

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
INSERT INTO `city_t` (city_id, city_name, city_code, state_id,  is_enabled  ) VALUES (1,'Pune','PU',15,1),(2,'Bengaluru','BNG',12,1),(3,'Mumbai','MU',15,1);
/*!40000 ALTER TABLE `city_t` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_request_t`
--

DROP TABLE IF EXISTS `customer_request_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_request_t` (
  `issue_id` int(11) NOT NULL AUTO_INCREMENT,
  `customer_latitude` double DEFAULT NULL,
  `customer_longitude` double DEFAULT NULL,
  `issue_status` varchar(255) DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  `service_type_id` int(11) DEFAULT NULL,
  `issue_start_time` time DEFAULT NULL,
  PRIMARY KEY (`issue_id`),
  KEY `fk_customer_request_t_1_idx` (`customer_id`),
  KEY `fk_customer_request_t_2_idx` (`service_type_id`),
  KEY `fk_customer_request_t_3_idx` (`employee_id`),
  CONSTRAINT `fk_customer_request_t_1` FOREIGN KEY (`customer_id`) REFERENCES `customer_t` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_customer_request_t_2` FOREIGN KEY (`service_type_id`) REFERENCES `service_type_t` (`service_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_customer_request_t_3` FOREIGN KEY (`employee_id`) REFERENCES `service_provider_employee_t` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_request_t`
--

LOCK TABLES `customer_request_t` WRITE;
/*!40000 ALTER TABLE `customer_request_t` DISABLE KEYS */;
INSERT INTO `customer_request_t` VALUES (81,18.52,73.5,'Accepted',34,35,1,'10:20:30'),(82,18.52,73.5,'Accepted',34,35,1,'10:20:30'),(83,18.52,73.5,'Accepted',34,35,1,'10:20:30'),(84,18.52,73.5,'Accepted',34,35,1,'10:20:30'),(85,18.52,73.5,'Accepted',34,35,1,'10:20:30'),(86,18.52,73.5,'Accepted',34,35,1,'10:20:30');
/*!40000 ALTER TABLE `customer_request_t` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_review_t`
--

DROP TABLE IF EXISTS `customer_review_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_review_t` (
  `customer_review_id` int(11) NOT NULL AUTO_INCREMENT,
  `approval_status` int(11) DEFAULT NULL,
  `blocked` tinyint(1) DEFAULT NULL,
  `comment` longblob,
  `creation_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `headline` varchar(255) DEFAULT NULL,
  `rating` float DEFAULT NULL,
  `customer_id` int(11) DEFAULT NULL,
  `employee_id` int(11) DEFAULT NULL,
  `modification` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `issueId` int(11) DEFAULT NULL,
  `service_provider_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`customer_review_id`),
  KEY `fk_customer_review_t_1_idx` (`issueId`),
  KEY `fk_customer_review_t_2_idx` (`customer_id`),
  KEY `fk_customer_review_t_3_idx` (`employee_id`),
  KEY `FK_q4p74b9gt6inmmley5op9424c` (`service_provider_id`),
  CONSTRAINT `FK_q4p74b9gt6inmmley5op9424c` FOREIGN KEY (`service_provider_id`) REFERENCES `service_provider_t` (`service_provider_id`),
  CONSTRAINT `fk_customer_review_t_1` FOREIGN KEY (`issueId`) REFERENCES `customer_request_t` (`issue_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_customer_review_t_2` FOREIGN KEY (`customer_id`) REFERENCES `customer_t` (`user_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_customer_review_t_3` FOREIGN KEY (`employee_id`) REFERENCES `service_provider_employee_t` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_review_t`
--

LOCK TABLES `customer_review_t` WRITE;
/*!40000 ALTER TABLE `customer_review_t` DISABLE KEYS */;
INSERT INTO `customer_review_t` VALUES (6,1,1,'test','2016-08-19 04:24:50','test',5,34,35,'2016-08-19 04:24:50',81,7),(7,1,1,'test','2016-08-19 04:07:31','test',5,34,35,'2016-08-19 04:07:31',81,7),(8,1,1,'test','2016-08-19 04:27:00','test',5,34,35,'2016-08-19 04:27:00',81,7),(9,1,1,'test','2016-08-19 04:31:30','test',2,34,35,'2016-08-19 04:31:30',81,7);
/*!40000 ALTER TABLE `customer_review_t` ENABLE KEYS */;
UNLOCK TABLES;

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
  CONSTRAINT `FK_8q42yc6ak99cpm9i86kyajn07` FOREIGN KEY (`city_id`) REFERENCES `city_t` (`city_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_t`
--

LOCK TABLES `customer_t` WRITE;
/*!40000 ALTER TABLE `customer_t` DISABLE KEYS */;
INSERT INTO `customer_t` VALUES ('adi','sri',1,'adi@g.com','abc','abc',34);
/*!40000 ALTER TABLE `customer_t` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_t`
--

DROP TABLE IF EXISTS `role_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_t` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_t`
--

LOCK TABLES `role_t` WRITE;
/*!40000 ALTER TABLE `role_t` DISABLE KEYS */;
INSERT INTO `role_t` VALUES (1,'Admin'),(2,'Customer'),(3,'Employee');
/*!40000 ALTER TABLE `role_t` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service_provider_employee_t`
--

DROP TABLE IF EXISTS `service_provider_employee_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `service_provider_employee_t` (
  `employee_name` varchar(45) DEFAULT NULL,
  `employee_email` varchar(45) DEFAULT NULL,
  `is_owner` tinyint(1) DEFAULT NULL,
  `service_provider_id` int(11) DEFAULT NULL,
  `gcm_id` longtext NOT NULL,
  `older_employee_id` int(11) DEFAULT NULL,
  `is_send_approval_notification` tinyint(1) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  KEY `fk_service_provider_employee_t_1_idx` (`userId`),
  KEY `fk_service_provider_employee_t_2_idx` (`service_provider_id`),
  CONSTRAINT `FK_d8gnb8l8haw4dh3c75ymltbxc` FOREIGN KEY (`userId`) REFERENCES `user_t` (`user_id`),
  CONSTRAINT `fk_service_provider_employee_t_2` FOREIGN KEY (`service_provider_id`) REFERENCES `service_provider_t` (`service_provider_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_provider_employee_t`
--

LOCK TABLES `service_provider_employee_t` WRITE;
/*!40000 ALTER TABLE `service_provider_employee_t` DISABLE KEYS */;
INSERT INTO `service_provider_employee_t` VALUES ('adi','adi@g.com',1,6,'abc',6,1,35);
/*!40000 ALTER TABLE `service_provider_employee_t` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service_provider_t`
--

DROP TABLE IF EXISTS `service_provider_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `service_provider_t` (
  `body_repair` tinyint(1) DEFAULT NULL,
  `electrical_type` tinyint(1) DEFAULT NULL,
  `service_provider_image_folder_name` varchar(255) DEFAULT NULL,
  `mechanical_type` tinyint(1) DEFAULT NULL,
  `service_provider_rating` double DEFAULT NULL,
  `service_provider_city` varchar(255) DEFAULT NULL,
  `service_provider_comments` varchar(255) DEFAULT NULL,
  `service_provider_location_latitude` double DEFAULT NULL,
  `service_provider_location_longitude` double DEFAULT NULL,
  `max_distance_to_operate` int(11) DEFAULT NULL,
  `service_provider_name` varchar(255) DEFAULT NULL,
  `night_operation` tinyint(1) DEFAULT NULL,
  `premium_service_provider` varchar(255) DEFAULT NULL,
  `service_provider_website` varchar(255) DEFAULT NULL,
  `service_provider_otherservices` varchar(255) DEFAULT NULL,
  `service_provider_timing` varchar(255) DEFAULT NULL,
  `service_provider_experties` varchar(255) DEFAULT NULL,
  `four_wheeler` tinyint(1) DEFAULT NULL,
  `two_wheeler` tinyint(1) DEFAULT NULL,
  `older_service_provider_id` int(11) DEFAULT '0',
  `service_provider_timestamp` timestamp NULL DEFAULT NULL,
  `service_provider_id` int(11) NOT NULL AUTO_INCREMENT,
  `service_provider_phone_number` bigint(11) DEFAULT NULL,
  `is_enabled` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`service_provider_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_provider_t`
--

LOCK TABLES `service_provider_t` WRITE;
/*!40000 ALTER TABLE `service_provider_t` DISABLE KEYS */;
INSERT INTO `service_provider_t` VALUES (1,1,'aditya',1,4,'pune','aditya',18.52,73.5,2,'aditya',1,'aditya','aditya','aditya','aditya','abc',1,1,90,'2002-03-02 19:00:21',6,4563787650,1),(1,1,'aditya',1,4.25,'pune','aditya',18.52,73.5,2,'aditya',1,'aditya','aditya','aditya','aditya','abc',1,1,90,'2002-03-02 19:00:21',7,4563767650,1);
/*!40000 ALTER TABLE `service_provider_t` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service_type_t`
--

DROP TABLE IF EXISTS `service_type_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `service_type_t` (
  `service_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `service_price` int(11) DEFAULT NULL,
  `service_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`service_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_type_t`
--

LOCK TABLES `service_type_t` WRITE;
/*!40000 ALTER TABLE `service_type_t` DISABLE KEYS */;
INSERT INTO `service_type_t` VALUES (1,400,'Ambulance'),(2,200,'Police'),(3,100,'Flat Tyre'),(4,100,'Minor Repairs'),(5,200,'Battery'),(6,300,'Locked out'),(7,500,'Towing'),(8,400,'Fuel Refill');
/*!40000 ALTER TABLE `service_type_t` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `user_t`
--

DROP TABLE IF EXISTS `user_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_t` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `is_enabled` bit(1) DEFAULT NULL,
  `mobile_no` bigint(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `mobile_no` (`mobile_no`,`role_id`),
  UNIQUE KEY `UK_3xx9h2i3dwhfa2c2cpm0m3ie2` (`mobile_no`,`role_id`),
  KEY `FK_ixevo6kh1kxytsrog5hwehtec` (`role_id`),
  CONSTRAINT `FK_ixevo6kh1kxytsrog5hwehtec` FOREIGN KEY (`role_id`) REFERENCES `role_t` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_t`
--

LOCK TABLES `user_t` WRITE;
/*!40000 ALTER TABLE `user_t` DISABLE KEYS */;
INSERT INTO `user_t` VALUES (34,'',8892755277,2),(35,'',8796282038,3);
/*!40000 ALTER TABLE `user_t` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_vehicle_t`
--

DROP TABLE IF EXISTS `user_vehicle_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_vehicle_t` (
  `user_vehicle_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `vehicle_information_id` int(11) DEFAULT NULL,
  `registration_number` varchar(45) DEFAULT NULL,
  `year` year(4) DEFAULT NULL,
  `is_enabled` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`user_vehicle_id`),
  KEY `fk_user_vehicle_t_1_idx` (`vehicle_information_id`),
  CONSTRAINT `fk_user_vehicle_t_1` FOREIGN KEY (`vehicle_information_id`) REFERENCES `vehicle_information_t` (`vehicle_information_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_vehicle_t`
--

LOCK TABLES `user_vehicle_t` WRITE;
/*!40000 ALTER TABLE `user_vehicle_t` DISABLE KEYS */;
INSERT INTO `user_vehicle_t` VALUES (11,13,1,'\'KA-32 3333\'',1990,1),(12,28,1,'drty567',2015,1),(13,30,1,'sdfg567',2015,1);
/*!40000 ALTER TABLE `user_vehicle_t` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicle_body_type_t`
--

DROP TABLE IF EXISTS `vehicle_body_type_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vehicle_body_type_t` (
  `vehicle_body_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `vehicle_body_type_name` varchar(45) DEFAULT NULL,
  `is_enabled` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`vehicle_body_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle_body_type_t`
--

LOCK TABLES `vehicle_body_type_t` WRITE;
/*!40000 ALTER TABLE `vehicle_body_type_t` DISABLE KEYS */;
INSERT INTO `vehicle_body_type_t` VALUES (1,'SUV',1);
/*!40000 ALTER TABLE `vehicle_body_type_t` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicle_fuel_type_t`
--

DROP TABLE IF EXISTS `vehicle_fuel_type_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vehicle_fuel_type_t` (
  `vehicle_fuel_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `vehicle_fuel_type_name` varchar(45) DEFAULT NULL,
  `is_enabled` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`vehicle_fuel_type_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle_fuel_type_t`
--

LOCK TABLES `vehicle_fuel_type_t` WRITE;
/*!40000 ALTER TABLE `vehicle_fuel_type_t` DISABLE KEYS */;
INSERT INTO `vehicle_fuel_type_t` VALUES (1,'Diesel',1),(2,'Petrol',1);
/*!40000 ALTER TABLE `vehicle_fuel_type_t` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicle_information_t`
--

DROP TABLE IF EXISTS `vehicle_information_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vehicle_information_t` (
  `vehicle_information_id` int(11) NOT NULL,
  `vehicle_model_id` int(11) DEFAULT NULL,
  `vehicle_body_type_id` int(11) DEFAULT NULL,
  `vehicle_type_id` int(11) DEFAULT NULL,
  `vehicle_fuel_type_id` int(11) DEFAULT NULL,
  `is_enabled` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`vehicle_information_id`),
  KEY `fk_vehicle_information_t_1_idx` (`vehicle_body_type_id`),
  KEY `fk_vehicle_information_t_2_idx` (`vehicle_fuel_type_id`),
  KEY `fk_vehicle_information_t_3_idx` (`vehicle_model_id`),
  KEY `fk_vehicle_information_t_4_idx` (`vehicle_type_id`),
  CONSTRAINT `fk_vehicle_information_t_1` FOREIGN KEY (`vehicle_body_type_id`) REFERENCES `vehicle_body_type_t` (`vehicle_body_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_vehicle_information_t_2` FOREIGN KEY (`vehicle_fuel_type_id`) REFERENCES `vehicle_fuel_type_t` (`vehicle_fuel_type_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_vehicle_information_t_3` FOREIGN KEY (`vehicle_model_id`) REFERENCES `vehicle_model_t` (`model_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_vehicle_information_t_4` FOREIGN KEY (`vehicle_type_id`) REFERENCES `vehicle_type_t` (`vehicle_type`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle_information_t`
--

LOCK TABLES `vehicle_information_t` WRITE;
/*!40000 ALTER TABLE `vehicle_information_t` DISABLE KEYS */;
INSERT INTO `vehicle_information_t` VALUES (1,1,1,1,1,1),(2,1,1,1,2,1),(3,2,1,1,1,1),(4,2,1,1,2,1),(5,3,1,1,1,1),(6,3,1,1,2,1),(7,4,1,1,1,1),(8,4,1,1,2,1),(9,5,1,1,1,1),(10,5,1,1,2,1),(11,6,1,1,1,1),(12,6,1,1,2,1),(13,7,1,1,1,1),(14,7,1,1,2,1),(15,8,1,1,1,1),(16,8,1,1,2,1),(17,9,1,1,1,1),(18,9,1,1,2,1),(19,10,1,1,1,1),(20,10,1,1,2,1),(21,11,1,1,1,1),(22,11,1,1,2,1),(23,12,1,1,1,1),(24,12,1,1,2,1),(25,13,1,1,1,1),(26,13,1,1,2,1),(27,14,1,1,1,1),(28,14,1,1,2,1),(29,15,1,1,1,1),(30,15,1,1,2,1),(31,16,1,1,1,1),(32,16,1,1,2,1),(33,17,1,1,1,1),(34,17,1,1,2,1),(35,18,1,1,1,1),(36,18,1,1,2,1),(37,19,1,1,1,1),(38,19,1,1,2,1),(39,20,1,1,1,1),(40,20,1,1,2,1),(41,21,1,1,1,1),(42,21,1,1,2,1),(43,22,1,1,1,1),(44,22,1,1,2,1),(45,23,1,1,1,1),(46,23,1,1,2,1),(47,24,1,1,1,1),(48,24,1,1,2,1),(49,25,1,1,1,1),(50,25,1,1,2,1),(51,26,1,1,1,1),(52,26,1,1,2,1),(53,27,1,1,1,1),(54,27,1,1,2,1),(55,28,1,1,1,1),(56,28,1,1,2,1),(57,29,1,1,1,1),(58,29,1,1,2,1),(59,30,1,1,1,1),(60,30,1,1,2,1),(61,31,1,1,1,1),(62,31,1,1,2,1),(63,32,1,1,1,1),(64,32,1,1,2,1),(65,33,1,1,1,1),(66,33,1,1,2,1),(67,34,1,1,1,1),(68,34,1,1,2,1),(69,35,1,1,1,1),(70,35,1,1,2,1),(71,36,1,1,1,1),(72,36,1,1,2,1),(73,37,1,1,1,1),(74,37,1,1,2,1),(75,38,1,1,1,1),(76,38,1,1,2,1),(77,39,1,1,1,1),(78,39,1,1,2,1),(79,40,1,1,1,1),(80,40,1,1,2,1),(81,41,1,1,1,1),(82,41,1,1,2,1),(83,42,1,1,1,1),(84,42,1,1,2,1),(85,43,1,1,1,1),(86,43,1,1,2,1),(87,44,1,1,1,1),(88,44,1,1,2,1),(89,45,1,1,1,1),(90,45,1,1,2,1),(91,46,1,1,1,1),(92,46,1,1,2,1),(93,47,1,1,1,1),(94,47,1,1,2,1),(95,48,1,1,1,1),(96,48,1,1,2,1),(97,49,1,1,1,1),(98,49,1,1,2,1),(99,50,1,1,1,1),(100,50,1,1,2,1),(101,51,1,1,1,1),(102,51,1,1,2,1),(103,52,1,1,1,1),(104,52,1,1,2,1),(105,53,1,1,1,1),(106,53,1,1,2,1),(107,54,1,1,1,1),(108,54,1,1,2,1),(109,55,1,1,1,1),(110,55,1,1,2,1),(111,56,1,1,1,1),(112,56,1,1,2,1),(113,57,1,1,1,1),(114,57,1,1,2,1),(115,58,1,1,1,1),(116,58,1,1,2,1),(117,59,1,1,1,1),(118,59,1,1,2,1),(119,60,1,1,1,1),(120,60,1,1,2,1),(121,61,1,1,1,1),(122,61,1,1,2,1),(123,62,1,1,1,1),(124,62,1,1,2,1),(125,63,1,1,1,1),(126,63,1,1,2,1),(127,64,1,1,1,1),(128,64,1,1,2,1),(129,65,1,1,1,1),(130,65,1,1,2,1),(131,66,1,1,1,1),(132,66,1,1,2,1),(133,67,1,1,1,1),(134,67,1,1,2,1),(135,68,1,1,1,1),(136,68,1,1,2,1),(137,69,1,1,1,1),(138,69,1,1,2,1),(139,70,1,1,1,1),(140,70,1,1,2,1),(141,71,1,1,1,1),(142,71,1,1,2,1),(143,72,1,1,1,1),(144,72,1,1,2,1),(145,73,1,1,1,1),(146,73,1,1,2,1),(147,74,1,1,1,1),(148,74,1,1,2,1),(149,75,1,1,1,1),(150,75,1,1,2,1),(151,76,1,1,1,1),(152,76,1,1,2,1),(153,77,1,1,1,1),(154,77,1,1,2,1),(155,78,1,1,1,1),(156,78,1,1,2,1),(157,79,1,1,1,1),(158,79,1,1,2,1),(159,80,1,1,1,1),(160,80,1,1,2,1),(161,81,1,1,1,1),(162,81,1,1,2,1),(163,82,1,1,1,1),(164,82,1,1,2,1),(165,83,1,1,1,1),(166,83,1,1,2,1),(167,84,1,1,1,1),(168,84,1,1,2,1),(169,85,1,1,1,1),(170,85,1,1,2,1),(171,86,1,1,1,1),(172,86,1,1,2,1),(173,87,1,1,1,1),(174,87,1,1,2,1),(175,88,1,1,1,1),(176,88,1,1,2,1),(177,89,1,1,1,1),(178,89,1,1,2,1),(179,90,1,1,1,1),(180,90,1,1,2,1),(181,91,1,1,1,1),(182,91,1,1,2,1),(183,92,1,1,1,1),(184,92,1,1,2,1),(185,93,1,1,1,1),(186,93,1,1,2,1),(187,94,1,1,1,1),(188,94,1,1,2,1),(189,95,1,1,1,1),(190,95,1,1,2,1),(191,96,1,1,1,1),(192,96,1,1,2,1),(193,97,1,1,1,1),(194,97,1,1,2,1),(195,98,1,1,1,1),(196,98,1,1,2,1),(197,99,1,1,1,1),(198,99,1,1,2,1),(199,100,1,1,1,1),(200,100,1,1,2,1),(201,101,1,1,1,1),(202,101,1,1,2,1),(203,102,1,1,1,1),(204,102,1,1,2,1),(205,103,1,1,1,1),(206,103,1,1,2,1),(207,104,1,1,1,1),(208,104,1,1,2,1),(209,105,1,1,1,1),(210,105,1,1,2,1),(211,106,1,1,1,1),(212,106,1,1,2,1),(213,107,1,1,1,1),(214,107,1,1,2,1),(215,108,1,1,1,1),(216,108,1,1,2,1),(217,109,1,1,1,1),(218,109,1,1,2,1),(219,110,1,1,1,1),(220,110,1,1,2,1),(221,111,1,1,1,1),(222,111,1,1,2,1),(223,112,1,1,1,1),(224,112,1,1,2,1),(225,113,1,1,1,1),(226,113,1,1,2,1),(227,114,1,1,1,1),(228,114,1,1,2,1),(229,115,1,1,1,1),(230,115,1,1,2,1),(231,116,1,1,1,1),(232,116,1,1,2,1),(233,117,1,1,1,1),(234,117,1,1,2,1),(235,118,1,1,1,1),(236,118,1,1,2,1),(237,119,1,1,1,1),(238,119,1,1,2,1),(239,120,1,1,1,1),(240,120,1,1,2,1),(241,121,1,1,1,1),(242,121,1,1,2,1),(243,122,1,1,1,1),(244,122,1,1,2,1),(245,123,1,1,1,1),(246,123,1,1,2,1),(247,124,1,1,1,1),(248,124,1,1,2,1),(249,125,1,1,1,1),(250,125,1,1,2,1),(251,126,1,1,1,1),(252,126,1,1,2,1),(253,127,1,1,1,1),(254,127,1,1,2,1),(255,128,1,1,1,1),(256,128,1,1,2,1),(257,129,1,1,1,1),(258,129,1,1,2,1),(259,130,1,1,1,1),(260,130,1,1,2,1),(261,131,1,1,1,1),(262,131,1,1,2,1),(263,132,1,1,1,1),(264,132,1,1,2,1),(265,133,1,1,1,1),(266,133,1,1,2,1),(267,134,1,1,1,1),(268,134,1,1,2,1),(269,135,1,1,1,1),(270,135,1,1,2,1),(271,136,1,1,1,1),(272,136,1,1,2,1),(273,137,1,1,1,1),(274,137,1,1,2,1),(275,138,1,1,1,1),(276,138,1,1,2,1),(277,139,1,1,1,1),(278,139,1,1,2,1),(279,140,1,1,1,1),(280,140,1,1,2,1),(281,141,1,1,1,1),(282,141,1,1,2,1),(283,142,1,1,1,1),(284,142,1,1,2,1),(285,143,1,1,1,1),(286,143,1,1,2,1),(287,144,1,1,1,1),(288,144,1,1,2,1),(289,145,1,1,1,1),(290,145,1,1,2,1),(291,146,1,1,1,1),(292,146,1,1,2,1),(293,147,1,1,1,1),(294,147,1,1,2,1),(295,148,1,1,1,1),(296,148,1,1,2,1),(297,149,1,1,1,1),(298,149,1,1,2,1),(299,150,1,1,1,1),(300,150,1,1,2,1),(301,151,1,1,1,1),(302,151,1,1,2,1),(303,152,1,1,1,1),(304,152,1,1,2,1),(305,153,1,1,1,1),(306,153,1,1,2,1),(307,154,1,1,1,1),(308,154,1,1,2,1),(309,155,1,1,1,1),(310,155,1,1,2,1),(311,156,1,1,1,1),(312,156,1,1,2,1),(313,157,1,1,1,1),(314,157,1,1,2,1),(315,158,1,1,1,1),(316,158,1,1,2,1),(317,159,1,1,1,1),(318,159,1,1,2,1),(319,160,1,1,1,1),(320,160,1,1,2,1),(321,161,1,1,1,1),(322,161,1,1,2,1),(323,162,1,1,1,1),(324,162,1,1,2,1),(325,163,1,1,1,1),(326,163,1,1,2,1),(327,164,1,1,1,1),(328,164,1,1,2,1),(329,165,1,1,1,1),(330,165,1,1,2,1),(331,166,1,1,1,1),(332,166,1,1,2,1),(333,167,1,1,1,1),(334,167,1,1,2,1),(335,168,1,1,1,1),(336,168,1,1,2,1),(337,169,1,1,1,1),(338,169,1,1,2,1),(339,170,1,1,1,1),(340,170,1,1,2,1),(341,171,1,1,1,1),(342,171,1,1,2,1),(343,172,1,1,1,1),(344,172,1,1,2,1),(345,173,1,1,1,1),(346,173,1,1,2,1),(347,174,1,1,1,1),(348,174,1,1,2,1),(349,175,1,1,1,1),(350,175,1,1,2,1),(351,176,1,1,1,1),(352,176,1,1,2,1),(353,177,1,1,1,1),(354,177,1,1,2,1),(355,178,1,1,1,1),(356,178,1,1,2,1),(357,179,1,1,1,1),(358,179,1,1,2,1),(359,180,1,1,1,1),(360,180,1,1,2,1),(361,181,1,1,1,1),(362,181,1,1,2,1),(363,182,1,1,1,1),(364,182,1,1,2,1),(365,183,1,1,1,1),(366,183,1,1,2,1),(367,184,1,1,1,1),(368,184,1,1,2,1),(369,185,1,1,1,1),(370,185,1,1,2,1),(371,186,1,1,1,1),(372,186,1,1,2,1),(373,187,1,1,1,1),(374,187,1,1,2,1),(375,188,1,1,1,1),(376,188,1,1,2,1),(377,189,1,1,1,1),(378,189,1,1,2,1),(379,190,1,1,1,1),(380,190,1,1,2,1),(381,191,1,1,1,1),(382,191,1,1,2,1),(383,192,1,1,1,1),(384,192,1,1,2,1),(385,193,1,1,1,1),(386,193,1,1,2,1),(387,194,1,1,1,1),(388,194,1,1,2,1),(389,195,1,1,1,1),(390,195,1,1,2,1),(391,196,1,1,1,1),(392,196,1,1,2,1),(393,197,1,1,1,1),(394,197,1,1,2,1),(395,198,1,1,1,1),(396,198,1,1,2,1),(397,199,1,1,1,1),(398,199,1,1,2,1),(399,200,1,1,1,1),(400,200,1,1,2,1),(401,201,1,1,1,1),(402,201,1,1,2,1),(403,202,1,1,1,1),(404,202,1,1,2,1),(405,203,1,1,1,1),(406,203,1,1,2,1),(407,204,1,1,1,1),(408,204,1,1,2,1),(409,205,1,1,1,1),(410,205,1,1,2,1),(411,206,1,1,1,1),(412,206,1,1,2,1),(413,207,1,1,1,1),(414,207,1,1,2,1),(415,208,1,1,1,1),(416,208,1,1,2,1),(417,209,1,1,1,1),(418,209,1,1,2,1),(419,210,1,1,1,1),(420,210,1,1,2,1),(421,211,1,1,1,1),(422,211,1,1,2,1),(423,212,1,1,1,1),(424,212,1,1,2,1),(425,213,1,1,1,1),(426,213,1,1,2,1),(427,214,1,1,1,1),(428,214,1,1,2,1),(429,215,1,1,1,1),(430,215,1,1,2,1),(431,216,1,1,1,1),(432,216,1,1,2,1),(433,217,1,1,1,1),(434,217,1,1,2,1),(435,218,1,1,1,1),(436,218,1,1,2,1),(437,219,1,1,1,1),(438,219,1,1,2,1),(439,220,1,1,1,1),(440,220,1,1,2,1),(441,221,1,1,1,1),(442,221,1,1,2,1),(443,222,1,1,1,1),(444,222,1,1,2,1),(445,223,1,1,1,1),(446,223,1,1,2,1),(447,224,1,1,1,1),(448,224,1,1,2,1),(449,225,1,1,1,1),(450,225,1,1,2,1),(451,226,1,1,1,1),(452,226,1,1,2,1),(453,227,1,1,1,1),(454,227,1,1,2,1);
/*!40000 ALTER TABLE `vehicle_information_t` ENABLE KEYS */;
UNLOCK TABLES;

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

--
-- Table structure for table `vehicle_model_t`
--

DROP TABLE IF EXISTS `vehicle_model_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vehicle_model_t` (
  `model_id` int(11) NOT NULL AUTO_INCREMENT,
  `manufacturer_id` int(11) DEFAULT NULL,
  `module_name` varchar(255) DEFAULT NULL,
  `is_enabled` tinyint(1) DEFAULT NULL,
  `vehicle_model_id` int(11) NOT NULL,
  PRIMARY KEY (`model_id`),
  KEY `fk_vehicle_module_t_1_idx` (`manufacturer_id`),
  CONSTRAINT `fk_vehicle_model_t_1` FOREIGN KEY (`manufacturer_id`) REFERENCES `vehicle_manufacturer_t` (`manufacturer_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=228 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle_model_t`
--

LOCK TABLES `vehicle_model_t` WRITE;
/*!40000 ALTER TABLE `vehicle_model_t` DISABLE KEYS */;
INSERT INTO `vehicle_model_t` VALUES (1,1,'500',1,0),(2,2,'DB9',1,0),(3,2,'Rapide',1,0),(4,2,'Vanquish',1,0),(5,2,'Vantage',1,0),(6,3,'A3',1,0),(7,3,'A3 Cabriolet',1,0),(8,3,'A4',1,0),(9,3,'A6 ',1,0),(10,3,'A8',1,0),(11,3,'Q3',1,0),(12,3,'Q5',1,0),(13,3,'Q7',1,0),(14,3,'R8',1,0),(15,3,'RS5',1,0),(16,3,'RS6',1,0),(17,3,'RS7',1,0),(18,3,'S5',1,0),(19,3,'TT',1,0),(20,4,'Bentayga',1,0),(21,4,'Continental',1,0),(22,4,'Flying Spur',1,0),(23,4,'Mulsanne',1,0),(24,5,'1 Series',1,0),(25,5,'3 Series',1,0),(26,5,'5 Series',1,0),(27,5,'6 Series',1,0),(28,5,'7 Series',1,0),(29,5,'i8',1,0),(30,5,'M Series',1,0),(31,5,'X1',1,0),(32,5,'X3',1,0),(33,5,'X5',1,0),(34,5,'X6',1,0),(35,5,'Z4',1,0),(36,6,'Veyron',1,0),(37,7,'7',1,0),(38,8,'Beat',1,0),(39,8,'Cruze',1,0),(40,8,'Enjoy',1,0),(41,8,'Sail',1,0),(42,8,'Sail Hatchback',1,0),(43,8,'Spark',1,0),(44,8,'Tavera',1,0),(45,8,'Trailblazer',1,0),(46,9,'Evade',1,0),(47,10,'Go',1,0),(48,10,'Go Plus',1,0),(49,10,'Redi Go',1,0),(50,11,'Avanti',1,0),(51,12,'458 Speciale',1,0),(52,12,'488',1,0),(53,12,'California T',1,0),(54,12,'F12berlinetta',1,0),(55,12,'FF',1,0),(56,13,'500',1,0),(57,13,'Avventura',1,0),(58,13,'Punto Evo',1,0),(59,13,'Linea',1,0),(60,13,'Linea Classic',1,0),(61,14,'Gurkha',1,0),(62,14,'One SUV',1,0),(63,15,'Ecosport',1,0),(64,15,'Eneavour',1,0),(65,15,'Fiesta',1,0),(66,15,'Figo',1,0),(67,15,'Figo Aspire',1,0),(68,15,'Mustang',1,0),(69,16,'Amaze',1,0),(70,16,'BRV',1,0),(71,16,'Brio',1,0),(72,16,'City',1,0),(73,16,'CR-V',1,0),(74,16,'Jazz',1,0),(75,16,'Mobilio',1,0),(76,16,'Accord',1,0),(77,16,'Civic',1,0),(78,17,'Creta',1,0),(79,17,'Elantra',1,0),(80,17,'EON',1,0),(81,17,'Grand i10',1,0),(82,17,'i10',1,0),(83,17,'Elite i20',1,0),(84,17,'i20 Active',1,0),(85,17,'Santa Fe',1,0),(86,17,'Verna',1,0),(87,17,'Xcent',1,0),(88,17,'Sonata',1,0),(89,17,'Tucson',1,0),(90,18,'Extreme',1,0),(91,19,'D Max V Cross',1,0),(92,19,'MU 7',1,0),(93,20,'F-Type',1,0),(94,20,'XE',1,0),(95,20,'XF',1,0),(96,20,'XJ',1,0),(97,21,'Grand Cherokee',1,0),(98,21,'Grand Cherokee SRT',1,0),(99,21,'Wrangler',1,0),(100,22,'Agera',1,0),(101,23,'Aventador',1,0),(102,23,'Huracan',1,0),(103,24,'Discovery 4',1,0),(104,24,'Discovery Sport',1,0),(105,24,'Freelander 2',1,0),(106,24,'Range Rover',1,0),(107,24,'Evoque',1,0),(108,24,'Sport',1,0),(109,25,'Bolero',1,0),(110,25,'Verito',1,0),(111,25,'e20',1,0),(112,25,'KUV 100',1,0),(113,25,'Nuvo Sport',1,0),(114,25,'Quanto',1,0),(115,25,'Scorpio',1,0),(116,25,'Supro',1,0),(117,25,'Thar',1,0),(118,25,'TUV 300',1,0),(119,25,'XUV 500',1,0),(120,25,'Xylo',1,0),(121,26,'Rexton',1,0),(122,27,'Alto 800',1,0),(123,27,'Alto K10',1,0),(124,27,'Baleno',1,0),(125,27,'Celerio',1,0),(126,27,'Ciaz',1,0),(127,27,'Eeco',1,0),(128,27,'Ertiga',1,0),(129,27,'Gypsy',1,0),(130,27,'Omni',1,0),(131,27,'Ritz',1,0),(132,27,'Swift',1,0),(133,27,'Swift Dezire',1,0),(134,27,'S-Cross',1,0),(135,27,'Vitara Brezza',1,0),(136,27,'Wagaon R',1,0),(137,27,'Wagon R Stingray',1,0),(138,28,'Ghibli',1,0),(139,28,'Gran Cabrio',1,0),(140,28,'Gran Turismo',1,0),(141,28,'Quattroporte',1,0),(142,29,'A Class',1,0),(143,29,'AMG GT',1,0),(144,29,'B Class',1,0),(145,29,'CLA',1,0),(146,29,'CLS',1,0),(147,29,'E Class',1,0),(148,29,'G Class',1,0),(149,29,'GL Class',1,0),(150,29,'GLA 45 AMG',1,0),(151,29,'GLA Class',1,0),(152,29,'GLC',1,0),(153,29,'GLE',1,0),(154,29,'GLS',1,0),(155,29,'M Class',1,0),(156,29,'C Class',1,0),(157,29,'S Class',1,0),(158,29,'SLK',1,0),(159,30,'3 Door',1,0),(160,30,'5 Door',1,0),(161,30,'Cooper Convertible',1,0),(162,30,'Countryman',1,0),(163,31,'Pajero Sport',1,0),(164,32,'Evalia',1,0),(165,32,'Micra Active',1,0),(166,32,'Micra',1,0),(167,32,'Sunny',1,0),(168,32,'Terrano',1,0),(169,33,'911',1,0),(170,33,'Boxster',1,0),(171,33,'Cayenne',1,0),(172,33,'Cayman',1,0),(173,33,'Macan',1,0),(174,33,'Panamera',1,0),(175,34,'Rio',1,0),(176,35,'Duster',1,0),(177,35,'Fluence',1,0),(178,35,'Koleos',1,0),(179,35,'Kwid',1,0),(180,35,'Lodgy',1,0),(181,35,'Pulse',1,0),(182,35,'Scala',1,0),(183,36,'Dawn',1,0),(184,36,'Ghost',1,0),(185,36,'Phantom',1,0),(186,36,'Wraith',1,0),(187,37,'Octavia',1,0),(188,37,'Rapid',1,0),(189,37,'Superb',1,0),(190,37,'Yeti',1,0),(191,38,'Aria',1,0),(192,38,'Bolt',1,0),(193,38,'Indica eV2',1,0),(194,38,'Indigo eCS',1,0),(195,38,'Nano',1,0),(196,38,'Safari',1,0),(197,38,'Safari Storme',1,0),(198,38,'Sumo',1,0),(199,38,'Tiago',1,0),(200,38,'Xenon XT',1,0),(201,38,'Zest',1,0),(202,39,'Model 3',1,0),(203,39,'Model X',1,0),(204,40,'Camry',1,0),(205,40,'Corolla Altis',1,0),(206,40,'Etios',1,0),(207,40,'Etios Cross',1,0),(208,40,'Etios Liva',1,0),(209,40,'Fortuner',1,0),(210,40,'Innova',1,0),(211,40,'Innova Crysta',1,0),(212,40,'Land Crusier',1,0),(213,40,'Prius',1,0),(214,41,'Ameo',1,0),(215,41,'Beetle',1,0),(216,41,'Cross Polo',1,0),(217,41,'Jetta',1,0),(218,41,'Polo',1,0),(219,41,'Vento',1,0),(220,41,'Passat',1,0),(221,42,'S 80',1,0),(222,42,'S 60 Cross Country',1,0),(223,42,'S 60',1,0),(224,42,'V 40 Cross Country',1,0),(225,42,'V 40',1,0),(226,42,'XC 90',1,0),(227,42,'XC 60',1,0);
/*!40000 ALTER TABLE `vehicle_model_t` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicle_type_t`
--

DROP TABLE IF EXISTS `vehicle_type_t`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vehicle_type_t` (
  `vehicle_type` int(11) NOT NULL AUTO_INCREMENT,
  `vehicle_type_name` varchar(255) DEFAULT NULL,
  `is_enabled` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`vehicle_type`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle_type_t`
--

LOCK TABLES `vehicle_type_t` WRITE;
/*!40000 ALTER TABLE `vehicle_type_t` DISABLE KEYS */;
INSERT INTO `vehicle_type_t` VALUES (1,'Four Wheeler',1);
/*!40000 ALTER TABLE `vehicle_type_t` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-08-25 16:50:37
