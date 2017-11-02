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
  `difficulty` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`difficultyId`)
) ENGINE=InnoDB AUTO_INCREMENT=317 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `difficulty`
--

LOCK TABLES `difficulty` WRITE;
/*!40000 ALTER TABLE `difficulty` DISABLE KEYS */;
INSERT INTO `difficulty` VALUES (315,'Hard'),(316,'Easy');
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
  `grooming` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`groomingTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grooming_type`
--

LOCK TABLES `grooming_type` WRITE;
/*!40000 ALTER TABLE `grooming_type` DISABLE KEYS */;
INSERT INTO `grooming_type` VALUES (107,'Ridden In'),(108,'Snowmobile');
/*!40000 ALTER TABLE `grooming_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `roleId` int(11) NOT NULL AUTO_INCREMENT,
  `createDate` datetime DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `userName` varchar(255) NOT NULL,
  PRIMARY KEY (`roleId`),
  UNIQUE KEY `userName_UNIQUE` (`userName`),
  CONSTRAINT `fkroleuser` FOREIGN KEY (`userName`) REFERENCES `user` (`userName`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1474 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1468,NULL,'user',NULL,'UnitTester0'),(1469,NULL,'user',NULL,'UnitTester1'),(1470,NULL,'user',NULL,'UnitTester2'),(1471,NULL,'user',NULL,'UnitTester3'),(1472,NULL,'user',NULL,'UnitTester4'),(1473,NULL,'admin',NULL,'UnitTesterA');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `trail_type`
--

DROP TABLE IF EXISTS `trail_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trail_type` (
  `trailTypeId` int(11) NOT NULL AUTO_INCREMENT,
  `trailType` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`trailTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trail_type`
--

LOCK TABLES `trail_type` WRITE;
/*!40000 ALTER TABLE `trail_type` DISABLE KEYS */;
INSERT INTO `trail_type` VALUES (53,'SingleTrack');
/*!40000 ALTER TABLE `trail_type` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `trail`
--

DROP TABLE IF EXISTS `trail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `trail` (
  `trailId` int(11) NOT NULL AUTO_INCREMENT,
  `createDate` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `length` decimal(19,2) DEFAULT NULL,
  `lengthUnits` varchar(255) DEFAULT NULL,
  `location` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `trailMap` varchar(255) DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `website` varchar(255) DEFAULT NULL,
  `difficulty` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  PRIMARY KEY (`trailId`),
  KEY `FK_2cr12nofidid9db5lgy5t6uk9` (`difficulty`),
  KEY `fktrailuser_idx` (`user`),
  KEY `fktrailtrail_type_idx` (`type`),
  CONSTRAINT `FK_2cr12nofidid9db5lgy5t6uk9` FOREIGN KEY (`difficulty`) REFERENCES `difficulty` (`difficultyId`),
  CONSTRAINT `fktrailtrail_type` FOREIGN KEY (`type`) REFERENCES `trail_type` (`trailTypeId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fktrailuser` FOREIGN KEY (`user`) REFERENCES `user` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=214 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trail`
--

LOCK TABLES `trail` WRITE;
/*!40000 ALTER TABLE `trail` DISABLE KEYS */;
INSERT INTO `trail` VALUES (213,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,315,53,1476);
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
  `createDate` varchar(45) DEFAULT NULL,
  `rideDate` varchar(45) DEFAULT NULL,
  `updateDate` varchar(45) DEFAULT NULL,
  `grooming` int(11) DEFAULT NULL,
  `trail` int(11) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  PRIMARY KEY (`trailReportId`),
  KEY `fktrail_reportGrooming` (`grooming`),
  KEY `fktrail_reporttrail` (`trail`),
  KEY `fktrail_reportuser_idx` (`user`),
  CONSTRAINT `fktrail_reportGrooming` FOREIGN KEY (`grooming`) REFERENCES `grooming_type` (`groomingTypeId`),
  CONSTRAINT `fktrail_reporttrail` FOREIGN KEY (`trail`) REFERENCES `trail` (`trailId`),
  CONSTRAINT `fktrail_reportuser` FOREIGN KEY (`user`) REFERENCES `user` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trail_report`
--

LOCK TABLES `trail_report` WRITE;
/*!40000 ALTER TABLE `trail_report` DISABLE KEYS */;
INSERT INTO `trail_report` VALUES (79,'test comments','Fast and Firm',NULL,NULL,NULL,NULL,213,1476);
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
  `trailType` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`trailTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trail_type`
--

LOCK TABLES `trail_type` WRITE;
/*!40000 ALTER TABLE `trail_type` DISABLE KEYS */;
INSERT INTO `trail_type` VALUES (53,'SingleTrack');
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
  `createDate` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `userName` varchar(255) NOT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `userName_UNIQUE` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=1482 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1476,NULL,'userDaoTester@gmail.com0','Unit0','Test0','supersecret0',NULL,'UnitTester0'),(1477,NULL,'userDaoTester@gmail.com1','Unit1','Test1','supersecret1',NULL,'UnitTester1'),(1478,NULL,'userDaoTester@gmail.com2','Unit2','Test2','supersecret2',NULL,'UnitTester2'),(1479,NULL,'userDaoTester@gmail.com3','Unit3','Test3','supersecret3',NULL,'UnitTester3'),(1480,NULL,'userDaoTester@gmail.com4','Unit4','Test4','supersecret4',NULL,'UnitTester4'),(1481,NULL,'userDaoTesterA@gmail.com','Unit','Test','supersecret',NULL,'UnitTesterA');
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

-- Dump completed on 2017-11-01 12:48:49
