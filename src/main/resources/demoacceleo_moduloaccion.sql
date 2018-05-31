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
-- Table structure for table `moduloaccion`
--

DROP TABLE IF EXISTS `moduloaccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `moduloaccion` (
  `idmoduloaccion` int(11) NOT NULL AUTO_INCREMENT,
  `idmodulo` int(11) NOT NULL,
  `idaccion` int(11) NOT NULL,
  `estatus` tinyint(4) NOT NULL,
  `fechacreacion` datetime NOT NULL,
  `fechamodificacion` datetime DEFAULT NULL,
  PRIMARY KEY (`idmoduloaccion`),
  UNIQUE KEY `uk_idmodulo_idaccion` (`idmodulo`,`idaccion`),
  KEY `fk_idmodulo_idx` (`idmodulo`),
  KEY `fk_idaccion_idx` (`idaccion`),
  CONSTRAINT `fk_idaccion` FOREIGN KEY (`idaccion`) REFERENCES `accion` (`idaccion`) ON UPDATE CASCADE,
  CONSTRAINT `fk_idmodulo` FOREIGN KEY (`idmodulo`) REFERENCES `modulo` (`idmodulo`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1 COMMENT='Se almacena todas las acciones que se pueden realizar sobre cada uno de los modulos.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `moduloaccion`
--

LOCK TABLES `moduloaccion` WRITE;
/*!40000 ALTER TABLE `moduloaccion` DISABLE KEYS */;
INSERT INTO `moduloaccion` VALUES (1,1,1,1,'2018-05-29 19:08:10',NULL),(2,1,2,1,'2018-05-29 19:08:26',NULL),(3,1,3,1,'2018-05-29 19:08:37',NULL),(4,1,4,1,'2018-05-29 19:08:46',NULL),(5,2,1,1,'2018-05-29 19:09:08',NULL),(6,2,2,1,'2018-05-29 19:09:29',NULL),(7,2,3,1,'2018-05-29 19:09:41',NULL),(8,2,4,1,'2018-05-29 19:09:50',NULL);
/*!40000 ALTER TABLE `moduloaccion` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-30 20:41:37
