-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: lovebee
-- ------------------------------------------------------
-- Server version	5.7.19-log

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
-- Table structure for table `tbl_aniversarry`
--

DROP TABLE IF EXISTS `tbl_aniversarry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_aniversarry` (
  `aniversarryid` bigint(255) NOT NULL AUTO_INCREMENT,
  `coupleid` varchar(100) NOT NULL,
  `name` varchar(200) DEFAULT NULL,
  `date` datetime NOT NULL,
  `urlimage` varchar(500) NOT NULL,
  `detail` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`aniversarryid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_chatbox`
--

DROP TABLE IF EXISTS `tbl_chatbox`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_chatbox` (
  `chatid` bigint(255) NOT NULL AUTO_INCREMENT,
  `coupleid` varchar(100) NOT NULL,
  `senderid` int(255) NOT NULL,
  `receiveid` int(255) NOT NULL,
  `messenger` varchar(500) NOT NULL,
  `date` datetime NOT NULL,
  `chat_id` int(255) NOT NULL,
  `couple_id` varchar(255) DEFAULT NULL,
  `receive_id` int(255) DEFAULT NULL,
  `sender_id` int(255) DEFAULT NULL,
  PRIMARY KEY (`chatid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_coverimage`
--

DROP TABLE IF EXISTS `tbl_coverimage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_coverimage` (
  `coverimage_id` int(255) NOT NULL,
  `coverimage_name` varchar(100) NOT NULL,
  `coverimage_url` varchar(255) NOT NULL,
  `coverimage_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`coverimage_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_emoji`
--

DROP TABLE IF EXISTS `tbl_emoji`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_emoji` (
  `emoji_id` int(11) NOT NULL AUTO_INCREMENT,
  `emoji_name` varchar(255) DEFAULT NULL,
  `emoji_url` varchar(255) DEFAULT NULL,
  `group_emoji_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`emoji_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_event`
--

DROP TABLE IF EXISTS `tbl_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_event` (
  `eventid` bigint(255) NOT NULL AUTO_INCREMENT,
  `coupleid` varchar(100) NOT NULL,
  `name` varchar(200) DEFAULT NULL,
  `date` datetime NOT NULL,
  `urlimage` varchar(500) DEFAULT NULL,
  `alterday` varchar(255) DEFAULT NULL,
  `emoticon` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`eventid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_garelly`
--

DROP TABLE IF EXISTS `tbl_garelly`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_garelly` (
  `garellyid` bigint(255) NOT NULL AUTO_INCREMENT,
  `coupleid` varchar(100) NOT NULL,
  `aniversarryid` bigint(255) NOT NULL,
  `urlimage` varchar(500) NOT NULL,
  PRIMARY KEY (`garellyid`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_group_emoji`
--

DROP TABLE IF EXISTS `tbl_group_emoji`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_group_emoji` (
  `group_emoji_id` int(11) NOT NULL AUTO_INCREMENT,
  `group_emoji_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`group_emoji_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_notification`
--

DROP TABLE IF EXISTS `tbl_notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_notification` (
  `notifi_id` int(11) NOT NULL AUTO_INCREMENT,
  `datetime` varchar(255) DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `userid_send` int(11) DEFAULT NULL,
  PRIMARY KEY (`notifi_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_request_love`
--

DROP TABLE IF EXISTS `tbl_request_love`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_request_love` (
  `requestloveid` bigint(255) NOT NULL AUTO_INCREMENT,
  `senderid` int(255) NOT NULL,
  `receiveid` int(255) NOT NULL,
  `state` varchar(10) NOT NULL DEFAULT 'none',
  PRIMARY KEY (`requestloveid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tbl_user`
--

DROP TABLE IF EXISTS `tbl_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_user` (
  `userid` int(255) NOT NULL AUTO_INCREMENT,
  `coupleid` varchar(100) DEFAULT NULL,
  `username` varchar(100) NOT NULL,
  `pass` varchar(30) NOT NULL,
  `nickname` varchar(100) NOT NULL,
  `birth` date NOT NULL,
  `gender` tinyint(2) NOT NULL,
  `phone` varchar(13) DEFAULT NULL,
  `ip` varchar(100) DEFAULT NULL,
  `emoticon` varchar(200) NOT NULL,
  `avatar` varchar(200) NOT NULL,
  `user_id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping routines for database 'lovebee'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-11-26 13:08:08
