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
-- Table structure for table `userauthoritymoduloaccion`
--

DROP TABLE IF EXISTS `userauthoritymoduloaccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `userauthoritymoduloaccion` (
  `iduserauthoritymoduloaccion` int(11) NOT NULL,
  `iduserauthority` int(11) NOT NULL,
  `idmoduloaccion` int(11) NOT NULL,
  `estatus` tinyint(4) NOT NULL,
  `fechacreacion` datetime NOT NULL,
  `fechamodificacion` datetime DEFAULT NULL,
  PRIMARY KEY (`iduserauthoritymoduloaccion`),
  UNIQUE KEY `uk_userauthority_moduloaccion` (`iduserauthority`,`idmoduloaccion`),
  KEY `fk_userauthority_idx` (`iduserauthority`),
  KEY `fk_moduloaccion_idx` (`idmoduloaccion`),
  CONSTRAINT `fk_moduloaccion` FOREIGN KEY (`idmoduloaccion`) REFERENCES `moduloaccion` (`idmoduloaccion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_userauthority` FOREIGN KEY (`iduserauthority`) REFERENCES `userauthority` (`iduserauthority`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COMMENT='Se almacenan todas las acciones que se pueden ejecutar en los modulos para cada uno de los usuarios.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userauthoritymoduloaccion`
--

LOCK TABLES `userauthoritymoduloaccion` WRITE;
/*!40000 ALTER TABLE `userauthoritymoduloaccion` DISABLE KEYS */;
INSERT INTO `userauthoritymoduloaccion` VALUES (1,1,1,1,'2018-05-29 19:17:44',NULL),(2,1,2,1,'2018-05-29 19:19:07',NULL),(3,1,3,1,'2018-05-29 19:19:17',NULL),(4,1,4,1,'2018-05-29 19:19:27',NULL);
/*!40000 ALTER TABLE `userauthoritymoduloaccion` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-29 19:20:57
