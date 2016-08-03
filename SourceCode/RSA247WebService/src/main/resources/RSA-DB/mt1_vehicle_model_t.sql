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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-30 20:27:42
