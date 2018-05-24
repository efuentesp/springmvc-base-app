-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: demoacceleo
-- ------------------------------------------------------
-- Server version	5.7.22-log

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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `iduser` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(500) NOT NULL COMMENT 'El password se almacena con base a la informacion que regresa el token.',
  `rol` varchar(50) NOT NULL,
  PRIMARY KEY (`iduser`),
  UNIQUE KEY `iduser_UNIQUE` (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('1','user01','eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyMDEiLCJ1c2VySWQiOiIxIiwicm9sZSI6IkFkbWluaXN0cmFkb3IifQ.NFc5EVE_N0BeuEDgkq7EBe5uDkkJg3UZSZ3naV-jUfYG-3veyz3n_zye6g4vb058AwlCTVD_r5vdDFarpNF5-w','admin'),('2','user02','eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyMDIiLCJ1c2VySWQiOiIxIiwicm9sZSI6IkFkbWluaXN0cmFkb3IifQ.lCVVfVgFlMq7FIRUHZs9adC2YrmgOJ5MdcDbvdjQh9FD53AC8mLqgFr_PND5uvGWBUU7nPGhYsu46GB1sxJwMw','admin'),('3','user03','eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyMDMiLCJ1c2VySWQiOiIxIiwicm9sZSI6IkFkbWluaXN0cmFkb3IifQ.Yx78P6YRQcJkiA04ldaWqUjtxTyiZOPztBpbVkoUKabiC_A2U7jKT0IAE1FigKYy1jrUCjsnooEqwkWp6SO4BQ','admin');
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

-- Dump completed on 2018-05-24 16:19:17
