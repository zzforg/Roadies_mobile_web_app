-- MySQL dump 10.13  Distrib 5.5.22, for osx10.6 (i386)
--
-- Host: localhost    Database: roadies
-- ------------------------------------------------------
-- Server version	5.5.22

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
-- Table structure for table `cases`
--

DROP TABLE IF EXISTS `cases`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cases` (
  `CASE_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `USER_ID` int(10) unsigned NOT NULL,
  `PROBLEM` varchar(255) DEFAULT NULL,
  `LOCATION` varchar(45) DEFAULT NULL,
  `TIMESTAMP` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`CASE_ID`),
  KEY `FK_user_cases` (`USER_ID`),
  CONSTRAINT `FK_user_cases` FOREIGN KEY (`USER_ID`) REFERENCES `users` (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cases`
--

LOCK TABLES `cases` WRITE;
/*!40000 ALTER TABLE `cases` DISABLE KEYS */;
INSERT INTO `cases` VALUES (1,2,'Flat tire','N61° 11\' 05.5\" W130° 30\' 10.0','2012-04-12 22:45:50'),(46,2,'w1','ww','2012-04-15 03:18:19'),(47,2,'w1','ww','2012-04-15 03:18:19'),(48,42,'w1','n','2012-04-15 02:01:20'),(49,42,'w1','n','2012-04-15 02:55:46'),(50,42,'w1','n','2012-04-15 03:15:05'),(51,43,'w1','n','2012-04-15 03:50:12'),(52,43,'w1','n','2012-04-15 03:53:14'),(53,44,'w1','n','2012-04-15 07:21:40'),(54,45,'w1','n','2012-04-15 07:40:44'),(55,45,'w1','n','2012-04-15 07:44:16'),(56,46,'w1','n','2012-04-15 07:45:25'),(57,47,'w1','n','2012-04-15 08:08:34'),(58,48,'w1','','2012-04-15 09:45:22'),(59,49,'w1','XX,YY','2012-04-15 09:47:49'),(60,50,'Brake: Lagging','XX,YY','2012-04-15 11:39:35'),(61,51,'Brake: Failure','XX,YY','2012-04-15 11:40:53'),(62,52,'Brake: Brake Oil Leaking','XX,YY','2012-04-15 11:44:24'),(63,53,'Brake: Failure','XX,YY','2012-04-15 12:31:56'),(64,54,'Brake: Brake Oil Leaking','XX,YY','2012-04-15 12:48:59'),(65,55,'Brake: Lagging','XX,YY','2012-04-15 12:49:58'),(66,56,'Brake: Lagging','XX,YY','2012-04-15 12:57:05'),(67,56,'Brake: Lagging','XX,YY','2012-04-15 12:57:16'),(68,57,'Brake: Lagging','XX,YY','2012-04-15 13:04:38'),(69,57,'Brake: Lagging','XX,YY','2012-04-15 13:04:49'),(70,58,'Brake: Failure','XX,YY','2012-04-15 13:28:03'),(71,59,'Brake: Failure','XX,YY','2012-04-15 13:32:30'),(72,60,'Brake: Failure','XX,YY','2012-04-15 14:41:17'),(73,61,'Brake: Lagging','152.99721476666664,-27.469394899999998','2012-04-15 17:45:21');
/*!40000 ALTER TABLE `cases` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_roles` (
  `USER_ROLE_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `USER_ID` int(10) unsigned NOT NULL,
  `AUTHORITY` varchar(45) NOT NULL,
  PRIMARY KEY (`USER_ROLE_ID`),
  KEY `FK_user_roles` (`USER_ID`),
  CONSTRAINT `FK_user_roles` FOREIGN KEY (`USER_ID`) REFERENCES `users` (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (1,2,'ROLE_USER'),(2,43,'ROLE_USER'),(3,44,'ROLE_USER'),(4,45,'ROLE_USER'),(5,46,'ROLE_USER'),(6,47,'ROLE_USER'),(7,48,'ROLE_USER'),(8,49,'ROLE_USER'),(9,50,'ROLE_USER'),(10,51,'ROLE_USER'),(11,52,'ROLE_USER'),(12,53,'ROLE_USER'),(13,54,'ROLE_USER'),(14,55,'ROLE_USER'),(15,56,'ROLE_USER'),(16,57,'ROLE_USER'),(17,58,'ROLE_USER'),(18,59,'ROLE_USER'),(19,60,'ROLE_USER'),(20,61,'ROLE_USER');
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `USER_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(45) NOT NULL,
  `PASSWORD` varchar(45) DEFAULT NULL,
  `ENABLED` tinyint(1) NOT NULL,
  `TIMESTAMP` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`USER_ID`),
  UNIQUE KEY `USER_ID_UNIQUE` (`USER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (2,'aabhushan','mainali',1,'2012-04-13 04:00:18'),(41,'jack','ww',1,'2012-04-14 06:52:47'),(42,'asd','asasd',1,'2012-04-15 02:01:19'),(43,'hey','hey',1,'2012-04-15 04:00:09'),(44,'','asasd',1,'2012-04-15 07:21:40'),(45,'uq','asasd',1,'2012-04-15 07:40:44'),(46,'cuq','',1,'2012-04-15 07:45:25'),(47,'ho','234',1,'2012-04-15 08:08:34'),(48,'aaaaa','qqqqq',1,'2012-04-15 09:45:22'),(49,'fig','dkkk',1,'2012-04-15 09:47:49'),(50,'c','qq',1,'2012-04-15 11:39:35'),(51,'ka','dff',1,'2012-04-15 11:40:53'),(52,'uii','qww',1,'2012-04-15 11:44:24'),(53,'Mcdonald','1234zxcv',1,'2012-04-15 12:31:55'),(54,'hungryjack','123456',1,'2012-04-15 12:48:59'),(55,'KFC','654321',1,'2012-04-15 12:49:58'),(56,'Thu','thu',1,'2012-04-15 12:57:05'),(57,'fun','hi',1,'2012-04-15 13:04:38'),(58,'merlo','uq1234',1,'2012-04-15 13:28:03'),(59,'Danno','1234j',1,'2012-04-15 13:32:30'),(60,'bower','12345',1,'2012-04-15 14:41:17'),(61,'hi','hi',1,'2012-04-15 17:45:21');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-04-16  4:06:59
