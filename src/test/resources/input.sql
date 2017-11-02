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
-- Table structure for table `Difficulty`
--

DROP TABLE IF EXISTS `Difficulty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Difficulty` (
  `difficultyId` int(11) NOT NULL AUTO_INCREMENT,
  `difficulty` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`difficultyId`)
) ENGINE=InnoDB AUTO_INCREMENT=317 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Difficulty`
--

LOCK TABLES `Difficulty` WRITE;
/*!40000 ALTER TABLE `Difficulty` DISABLE KEYS */;
INSERT INTO `Difficulty` VALUES (315,'Hard'),(316,'Easy');
/*!40000 ALTER TABLE `Difficulty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `GroomingType`
--

DROP TABLE IF EXISTS `GroomingType`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `GroomingType` (
  `groomingTypeId` int(11) NOT NULL AUTO_INCREMENT,
  `grooming` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`groomingTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GroomingType`
--

LOCK TABLES `GroomingType` WRITE;
/*!40000 ALTER TABLE `GroomingType` DISABLE KEYS */;
INSERT INTO `GroomingType` VALUES (107,'Ridden In'),(108,'Snowmobile');
/*!40000 ALTER TABLE `GroomingType` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Role`
--

DROP TABLE IF EXISTS `Role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Role` (
  `roleId` int(11) NOT NULL AUTO_INCREMENT,
  `createDate` datetime DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `userName` varchar(255) NOT NULL,
  PRIMARY KEY (`roleId`),
  UNIQUE KEY `userName_UNIQUE` (`userName`),
  CONSTRAINT `fkRoleUser` FOREIGN KEY (`userName`) REFERENCES `User` (`userName`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=1474 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Role`
--

LOCK TABLES `Role` WRITE;
/*!40000 ALTER TABLE `Role` DISABLE KEYS */;
INSERT INTO `Role` VALUES (1468,NULL,'user',NULL,'UnitTester0'),(1469,NULL,'user',NULL,'UnitTester1'),(1470,NULL,'user',NULL,'UnitTester2'),(1471,NULL,'user',NULL,'UnitTester3'),(1472,NULL,'user',NULL,'UnitTester4'),(1473,NULL,'admin',NULL,'UnitTesterA');
/*!40000 ALTER TABLE `Role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Trail`
--

DROP TABLE IF EXISTS `Trail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Trail` (
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
  KEY `fkTrailUser_idx` (`user`),
  KEY `fkTrailTrailType_idx` (`type`),
  CONSTRAINT `FK_2cr12nofidid9db5lgy5t6uk9` FOREIGN KEY (`difficulty`) REFERENCES `Difficulty` (`difficultyId`),
  CONSTRAINT `fkTrailTrailType` FOREIGN KEY (`type`) REFERENCES `TrailType` (`trailTypeId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkTrailUser` FOREIGN KEY (`user`) REFERENCES `User` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=214 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Trail`
--

LOCK TABLES `Trail` WRITE;
/*!40000 ALTER TABLE `Trail` DISABLE KEYS */;
INSERT INTO `Trail` VALUES (213,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,315,53,1476);
/*!40000 ALTER TABLE `Trail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TrailReport`
--

DROP TABLE IF EXISTS `TrailReport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TrailReport` (
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
  KEY `fkTrailReportGrooming` (`grooming`),
  KEY `fkTrailReportTrail` (`trail`),
  KEY `fkTrailReportUser_idx` (`user`),
  CONSTRAINT `fkTrailReportGrooming` FOREIGN KEY (`grooming`) REFERENCES `GroomingType` (`groomingTypeId`),
  CONSTRAINT `fkTrailReportTrail` FOREIGN KEY (`trail`) REFERENCES `Trail` (`trailId`),
  CONSTRAINT `fkTrailReportUser` FOREIGN KEY (`user`) REFERENCES `User` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TrailReport`
--

LOCK TABLES `TrailReport` WRITE;
/*!40000 ALTER TABLE `TrailReport` DISABLE KEYS */;
INSERT INTO `TrailReport` VALUES (79,'test comments','Fast and Firm',NULL,NULL,NULL,NULL,213,1476);
/*!40000 ALTER TABLE `TrailReport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TrailType`
--

DROP TABLE IF EXISTS `TrailType`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TrailType` (
  `trailTypeId` int(11) NOT NULL AUTO_INCREMENT,
  `trailType` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`trailTypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TrailType`
--

LOCK TABLES `TrailType` WRITE;
/*!40000 ALTER TABLE `TrailType` DISABLE KEYS */;
INSERT INTO `TrailType` VALUES (53,'SingleTrack');
/*!40000 ALTER TABLE `TrailType` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
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
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES (1476,NULL,'UserDaoTester@gmail.com0','Unit0','Test0','supersecret0',NULL,'UnitTester0'),(1477,NULL,'UserDaoTester@gmail.com1','Unit1','Test1','supersecret1',NULL,'UnitTester1'),(1478,NULL,'UserDaoTester@gmail.com2','Unit2','Test2','supersecret2',NULL,'UnitTester2'),(1479,NULL,'UserDaoTester@gmail.com3','Unit3','Test3','supersecret3',NULL,'UnitTester3'),(1480,NULL,'UserDaoTester@gmail.com4','Unit4','Test4','supersecret4',NULL,'UnitTester4'),(1481,NULL,'UserDaoTesterA@gmail.com','Unit','Test','supersecret',NULL,'UnitTesterA');
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

-- Dump completed on 2017-11-01 12:48:49
