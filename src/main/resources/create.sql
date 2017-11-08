-- MySQL dump 10.13  Distrib 5.7.20, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: FBTRTest
-- ------------------------------------------------------
-- Server version	5.7.20-0ubuntu0.16.04.1

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
-- Table structure for table `difficulty`
--

DROP TABLE IF EXISTS `difficulty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `difficulty` (
  `difficultyId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`difficultyId`)
) ENGINE=InnoDB AUTO_INCREMENT=979 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `difficulty`
--

LOCK TABLES `difficulty` WRITE;
/*!40000 ALTER TABLE `difficulty` DISABLE KEYS */;
INSERT INTO `difficulty` VALUES (974,'Easiest - White'),(975,'Easy - Green'),(976,'More Difficult - Blue'),(977,'Very Difficult - Black'),(978,'Extremely Difficult- Double Black');
/*!40000 ALTER TABLE `difficulty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grooming_type`
--

DROP TABLE IF EXISTS `grooming_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grooming_type` (
  `groomingTypeId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`groomingTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=811 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grooming_type`
--

LOCK TABLES `grooming_type` WRITE;
/*!40000 ALTER TABLE `grooming_type` DISABLE KEYS */;
INSERT INTO `grooming_type` VALUES (807,'Ridden In'),(808,'Snowmobile packed'),(809,'Machine rolled'),(810,'Other');
/*!40000 ALTER TABLE `grooming_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `location` (
  `locationId` int(11) NOT NULL AUTO_INCREMENT,
  `address1` varchar(120) DEFAULT NULL,
  `address2` varchar(120) DEFAULT NULL,
  `city` varchar(120) DEFAULT NULL,
  `state` varchar(2) DEFAULT NULL,
  `postalcode` varchar(16) DEFAULT NULL,
  `lat` decimal(9,6) DEFAULT NULL,
  `lon` decimal(9,6) DEFAULT NULL,
  PRIMARY KEY (`locationId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` VALUES (1,'13088 W County Hwy OO',NULL,'Hayward','WI','54843',46.109810,91.297598);
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `roleId` int(11) NOT NULL AUTO_INCREMENT,
  `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `name` varchar(255) DEFAULT NULL,
  `updateDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userName` varchar(255) NOT NULL,
  PRIMARY KEY (`roleId`),
  UNIQUE KEY `userName_UNIQUE` (`userName`),
  CONSTRAINT `fkroleuser` FOREIGN KEY (`userName`) REFERENCES `user` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=2031 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (2025,'2017-11-08 01:50:50','user','2017-11-08 01:50:50','UnitTester0'),(2026,'2017-11-08 01:50:50','user','2017-11-08 01:50:50','UnitTester1'),(2027,'2017-11-08 01:50:50','user','2017-11-08 01:50:50','UnitTester2'),(2028,'2017-11-08 01:50:50','user','2017-11-08 01:50:50','UnitTester3'),(2029,'2017-11-08 01:50:50','user','2017-11-08 01:50:50','UnitTester4'),(2030,'2017-11-08 01:50:50','admin','2017-11-08 01:50:50','UnitTesterA');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trail`
--

DROP TABLE IF EXISTS `trail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trail` (
  `trailId` int(11) NOT NULL AUTO_INCREMENT,
  `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `description` varchar(255) DEFAULT NULL,
  `length` decimal(19,2) DEFAULT NULL,
  `lengthUnits` varchar(255) DEFAULT NULL,
  `location` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `trailMap` varchar(255) DEFAULT NULL,
  `updateDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `website` varchar(255) DEFAULT NULL,
  `difficulty` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  PRIMARY KEY (`trailId`),
  KEY `fktrailtrail_type_idx` (`type`),
  KEY `fktrailuser_idx` (`user`),
  KEY `FK_2cr12nofidid9db5lgy5t6uk9` (`difficulty`),
  KEY `fktraillocation_idx` (`location`),
  CONSTRAINT `FK_2cr12nofidid9db5lgy5t6uk9` FOREIGN KEY (`difficulty`) REFERENCES `difficulty` (`difficultyId`),
  CONSTRAINT `fktraillocation` FOREIGN KEY (`location`) REFERENCES `location` (`locationId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fktrailtrail_type` FOREIGN KEY (`type`) REFERENCES `trail_type` (`trailTypeId`),
  CONSTRAINT `fktrailuser` FOREIGN KEY (`user`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=465 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trail`
--

LOCK TABLES `trail` WRITE;
/*!40000 ALTER TABLE `trail` DISABLE KEYS */;
INSERT INTO `trail` VALUES (463,'2017-11-08 01:50:50','Big Fat Loop',NULL,NULL,NULL,'BFL',NULL,'2017-11-08 01:50:50',NULL,NULL,546,2025),(464,'2017-11-08 01:52:29','Description for makwa',16.00,'mi',1,'Makwa','map link. ','2017-11-08 01:52:29','website for camba',976,546,2025);
/*!40000 ALTER TABLE `trail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trail_report`
--

DROP TABLE IF EXISTS `trail_report`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trail_report` (
  `trailReportId` int(11) NOT NULL AUTO_INCREMENT,
  `comments` varchar(1000) DEFAULT NULL,
  `conditions` varchar(1000) DEFAULT NULL,
  `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `rideDate` datetime DEFAULT NULL,
  `updateDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `grooming` int(11) DEFAULT NULL,
  `trail` int(11) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  PRIMARY KEY (`trailReportId`),
  KEY `fktrail_reportGrooming` (`grooming`),
  KEY `fktrail_reporttrail` (`trail`),
  KEY `fktrail_reportuser_idx` (`user`),
  CONSTRAINT `fktrail_reportGrooming` FOREIGN KEY (`grooming`) REFERENCES `grooming_type` (`groomingTypeId`),
  CONSTRAINT `fktrail_reporttrail` FOREIGN KEY (`trail`) REFERENCES `trail` (`trailId`),
  CONSTRAINT `fktrail_reportuser` FOREIGN KEY (`user`) REFERENCES `user` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trail_report`
--

LOCK TABLES `trail_report` WRITE;
/*!40000 ALTER TABLE `trail_report` DISABLE KEYS */;
INSERT INTO `trail_report` VALUES (93,'test comments',NULL,'2017-11-08 01:50:50',NULL,'2017-11-08 01:50:50',NULL,463,2025),(94,NULL,'Fantastic','2017-11-08 01:54:06','2017-11-01 00:00:00','2017-11-08 01:54:06',807,464,2025);
/*!40000 ALTER TABLE `trail_report` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trail_type`
--

DROP TABLE IF EXISTS `trail_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trail_type` (
  `trailTypeId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`trailTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=550 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trail_type`
--

LOCK TABLES `trail_type` WRITE;
/*!40000 ALTER TABLE `trail_type` DISABLE KEYS */;
INSERT INTO `trail_type` VALUES (546,'Singletrack'),(547,'Doubletrack'),(548,'Forest Road'),(549,'Other');
/*!40000 ALTER TABLE `trail_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `email` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `updateDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userName` varchar(255) NOT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `userName_UNIQUE` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=2031 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (2025,'2017-11-08 01:50:50','UserDaoTester@gmail.com0','Unit0','Test0','supersecret0','2017-11-08 01:50:50','UnitTester0'),(2026,'2017-11-08 01:50:50','UserDaoTester@gmail.com1','Unit1','Test1','supersecret1','2017-11-08 01:50:50','UnitTester1'),(2027,'2017-11-08 01:50:50','UserDaoTester@gmail.com2','Unit2','Test2','supersecret2','2017-11-08 01:50:50','UnitTester2'),(2028,'2017-11-08 01:50:50','UserDaoTester@gmail.com3','Unit3','Test3','supersecret3','2017-11-08 01:50:50','UnitTester3'),(2029,'2017-11-08 01:50:50','UserDaoTester@gmail.com4','Unit4','Test4','supersecret4','2017-11-08 01:50:50','UnitTester4'),(2030,'2017-11-08 01:50:50','UserDaoTesterA@gmail.com','Unit','Test','supersecret','2017-11-08 01:50:50','UnitTesterA');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-07 19:58:30
