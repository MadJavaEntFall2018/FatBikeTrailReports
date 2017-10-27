-- MySQL dump 10.13  Distrib 5.7.13, for linux-glibc2.5 (x86_64)
--
-- Host: localhost    Database: FBTRTest
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
  `difficulty` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`difficultyId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `GroomingType`
--

DROP TABLE IF EXISTS `GroomingType`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `GroomingType` (
  `groomingTypeId` int(11) NOT NULL AUTO_INCREMENT,
  `grooming` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`groomingTypeId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Role`
--

DROP TABLE IF EXISTS `Role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Role` (
  `roleId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(45) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  `updateDate` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `createDate` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`roleId`),
  KEY `fk_role_1_idx` (`userName`),
  CONSTRAINT `fkRoleUser` FOREIGN KEY (`userName`) REFERENCES `User` (`userName`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Trail`
--

DROP TABLE IF EXISTS `Trail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Trail` (
  `trailId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `location` int(11) DEFAULT NULL,
  `difficulty` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `length` decimal(4,1) DEFAULT NULL,
  `lengthUnits` varchar(45) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `website` varchar(45) DEFAULT NULL,
  `trailMap` varchar(45) DEFAULT NULL,
  `createDate` datetime DEFAULT CURRENT_TIMESTAMP,
  `updateDate` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `user` int(11) DEFAULT NULL,
  PRIMARY KEY (`trailId`),
  KEY `fkTrailUser_idx` (`user`),
  KEY `fkTrailTrailType_idx` (`type`),
  KEY `fkTrailDifficulty_idx` (`difficulty`),
  CONSTRAINT `fkTrailDifficulty` FOREIGN KEY (`difficulty`) REFERENCES `Difficulty` (`difficultyId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkTrailTrailType` FOREIGN KEY (`type`) REFERENCES `TrailType` (`trailTypeId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkTrailUser` FOREIGN KEY (`user`) REFERENCES `User` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `TrailReport`
--

DROP TABLE IF EXISTS `TrailReport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TrailReport` (
  `trailReportId` int(11) NOT NULL AUTO_INCREMENT,
  `rideDate` varchar(45) DEFAULT NULL,
  `createDate` varchar(45) DEFAULT 'CURRENT_TIMESTAMP',
  `updateDate` varchar(45) DEFAULT 'CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP',
  `conditions` varchar(1000) DEFAULT NULL,
  `comments` varchar(1000) DEFAULT NULL,
  `user` int(11) DEFAULT NULL,
  `trail` int(11) DEFAULT NULL,
  `grooming` int(11) DEFAULT NULL,
  PRIMARY KEY (`trailReportId`),
  KEY `fk_TrailReport_Grooming_idx` (`grooming`),
  KEY `fkTrailReportUser_idx` (`user`),
  KEY `fkTrailReportTrail_idx` (`trail`),
  CONSTRAINT `fkTrailReportGrooming` FOREIGN KEY (`grooming`) REFERENCES `GroomingType` (`groomingTypeId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkTrailReportTrail` FOREIGN KEY (`trail`) REFERENCES `Trail` (`trailId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fkTrailReportUser` FOREIGN KEY (`user`) REFERENCES `User` (`userId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

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
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `createDate` datetime DEFAULT CURRENT_TIMESTAMP,
  `updateDate` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `userName` varchar(45) NOT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `UserName_UNIQUE` (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-27 14:26:40