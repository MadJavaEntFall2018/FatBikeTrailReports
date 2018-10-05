-- MySQL dump 10.13  Distrib 5.7.23, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: FBTR
-- ------------------------------------------------------
-- Server version	5.7.23-0ubuntu0.16.04.1

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
-- Table structure for table `Difficulty`
--

DROP TABLE IF EXISTS `Difficulty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Difficulty` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=228 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Difficulty`
--

LOCK TABLES `Difficulty` WRITE;
/*!40000 ALTER TABLE `Difficulty` DISABLE KEYS */;
INSERT INTO `Difficulty` VALUES (223,'Easiest - White'),(224,'Easy - Green'),(225,'More Difficult - Blue'),(226,'Very Difficult - Black'),(227,'Extremely Difficult- Double Black');
/*!40000 ALTER TABLE `Difficulty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `GroomingType`
--

DROP TABLE IF EXISTS `GroomingType`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `GroomingType` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=173 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GroomingType`
--

LOCK TABLES `GroomingType` WRITE;
/*!40000 ALTER TABLE `GroomingType` DISABLE KEYS */;
INSERT INTO `GroomingType` VALUES (169,'Ridden In'),(170,'Snowmobile packed'),(171,'Machine rolled'),(172,'Other');
/*!40000 ALTER TABLE `GroomingType` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Location`
--

DROP TABLE IF EXISTS `Location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Location` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address1` varchar(120) DEFAULT NULL,
  `address2` varchar(120) DEFAULT NULL,
  `city` varchar(120) DEFAULT NULL,
  `state` varchar(2) DEFAULT NULL,
  `postalcode` varchar(16) DEFAULT NULL,
  `lat` decimal(9,6) DEFAULT NULL,
  `lon` decimal(9,6) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Location`
--

LOCK TABLES `Location` WRITE;
/*!40000 ALTER TABLE `Location` DISABLE KEYS */;
/*!40000 ALTER TABLE `Location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Role`
--

DROP TABLE IF EXISTS `Role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createDate` datetime DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `userName` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `userName_UNIQUE` (`userName`),
  CONSTRAINT `Role_User_userName_fk` FOREIGN KEY (`userName`) REFERENCES `User` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=258 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Role`
--

LOCK TABLES `Role` WRITE;
/*!40000 ALTER TABLE `Role` DISABLE KEYS */;
INSERT INTO `Role` VALUES (252,NULL,'user',NULL,'UnitTester0'),(253,NULL,'user',NULL,'UnitTester1'),(254,NULL,'user',NULL,'UnitTester2'),(255,NULL,'user',NULL,'UnitTester3'),(256,NULL,'user',NULL,'UnitTester4'),(257,NULL,'admin',NULL,'UnitTesterA');
/*!40000 ALTER TABLE `Role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Trail`
--

DROP TABLE IF EXISTS `Trail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Trail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createDate` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `length` decimal(19,2) DEFAULT NULL,
  `lengthUnits` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `trailMap` varchar(255) DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `website` varchar(255) DEFAULT NULL,
  `difficulty` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `location` int(11) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Trail_Difficulty_id_fk` (`difficulty`),
  KEY `Trail_TrailType_id_fk` (`type`),
  KEY `Trail_Location_id_fk` (`location`),
  KEY `Trail_User_id_fk` (`user`),
  CONSTRAINT `Trail_Difficulty_id_fk` FOREIGN KEY (`difficulty`) REFERENCES `Difficulty` (`id`),
  CONSTRAINT `Trail_Location_id_fk` FOREIGN KEY (`location`) REFERENCES `Location` (`id`),
  CONSTRAINT `Trail_TrailType_id_fk` FOREIGN KEY (`type`) REFERENCES `TrailType` (`id`),
  CONSTRAINT `Trail_User_id_fk` FOREIGN KEY (`user`) REFERENCES `User` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Trail`
--

LOCK TABLES `Trail` WRITE;
/*!40000 ALTER TABLE `Trail` DISABLE KEYS */;
INSERT INTO `Trail` VALUES (13,NULL,NULL,NULL,NULL,'TestTrailName',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(14,NULL,NULL,NULL,NULL,'TestTrailName',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(16,NULL,NULL,NULL,NULL,'TestTrailName',NULL,NULL,'TestWebSite',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `Trail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TrailHead`
--

DROP TABLE IF EXISTS `TrailHead`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TrailHead` (
  `name` varchar(100) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `location` int(11) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `trail` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `TrailHead_id_uindex` (`id`),
  KEY `TrailHead_Trail_id_fk` (`trail`),
  KEY `TrailHead_Location_id_fk` (`location`),
  CONSTRAINT `TrailHead_Location_id_fk` FOREIGN KEY (`location`) REFERENCES `Location` (`id`),
  CONSTRAINT `TrailHead_Trail_id_fk` FOREIGN KEY (`trail`) REFERENCES `Trail` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TrailHead`
--

LOCK TABLES `TrailHead` WRITE;
/*!40000 ALTER TABLE `TrailHead` DISABLE KEYS */;
/*!40000 ALTER TABLE `TrailHead` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TrailReport`
--

DROP TABLE IF EXISTS `TrailReport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TrailReport` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comments` varchar(1000) DEFAULT NULL,
  `conditions` varchar(1000) DEFAULT NULL,
  `createDate` varchar(45) NOT NULL,
  `rideDate` varchar(45) DEFAULT NULL,
  `updateDate` varchar(45) NOT NULL,
  `grooming` int(11) DEFAULT NULL,
  `trail` int(11) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `TrailReport_GroomingType_id_fk` (`grooming`),
  KEY `TrailReport_Trail_id_fk` (`trail`),
  KEY `TrailReport_User_id_fk` (`user`),
  CONSTRAINT `TrailReport_GroomingType_id_fk` FOREIGN KEY (`grooming`) REFERENCES `GroomingType` (`id`),
  CONSTRAINT `TrailReport_Trail_id_fk` FOREIGN KEY (`trail`) REFERENCES `Trail` (`id`),
  CONSTRAINT `TrailReport_User_id_fk` FOREIGN KEY (`user`) REFERENCES `User` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TrailReport`
--

LOCK TABLES `TrailReport` WRITE;
/*!40000 ALTER TABLE `TrailReport` DISABLE KEYS */;
/*!40000 ALTER TABLE `TrailReport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TrailType`
--

DROP TABLE IF EXISTS `TrailType`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TrailType` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=216 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TrailType`
--

LOCK TABLES `TrailType` WRITE;
/*!40000 ALTER TABLE `TrailType` DISABLE KEYS */;
INSERT INTO `TrailType` VALUES (211,'Singletrack'),(212,'Doubletrack'),(213,'Forest Road'),(214,'Mixed'),(215,'Other');
/*!40000 ALTER TABLE `TrailType` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `createDate` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `userName` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `userName_UNIQUE` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=289 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (283,NULL,'UserDaoTester@gmail.com0','Unit0','Test0','supersecret0',NULL,'UnitTester0'),(284,NULL,'UserDaoTester@gmail.com1','Unit1','Test1','supersecret1',NULL,'UnitTester1'),(285,NULL,'UserDaoTester@gmail.com2','Unit2','Test2','supersecret2',NULL,'UnitTester2'),(286,NULL,'UserDaoTester@gmail.com3','Unit3','Test3','supersecret3',NULL,'UnitTester3'),(287,NULL,'UserDaoTester@gmail.com4','Unit4','Test4','supersecret4',NULL,'UnitTester4'),(288,NULL,'UserDaoTesterA@gmail.com','Unit','Test','supersecret',NULL,'UnitTesterA');
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-05 14:59:11
