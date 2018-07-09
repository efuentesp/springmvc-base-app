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
-- Table structure for table `afiliado`
--

DROP TABLE IF EXISTS `afiliado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `afiliado` (
  `generoId` varchar(100) DEFAULT NULL,
  `beneficiarioId` int(11) DEFAULT NULL,
  `nss` varchar(100) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `apellido_paterno` varchar(100) DEFAULT NULL,
  `apellido_materno` varchar(100) DEFAULT NULL,
  `observaciones` varchar(100) DEFAULT NULL,
  `fecha_afiliacion` varchar(100) DEFAULT NULL,
  `foto` varchar(100) DEFAULT NULL,
  `acta_nacimiento` varchar(100) DEFAULT NULL,
  `correo` varchar(100) DEFAULT NULL,
  `semanas_cotizadas` varchar(100) DEFAULT NULL,
  `monto_pension` varchar(100) DEFAULT NULL,
  `afiliadoId` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`afiliadoId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `afiliado`
--

LOCK TABLES `afiliado` WRITE;
/*!40000 ALTER TABLE `afiliado` DISABLE KEYS */;
INSERT INTO `afiliado` VALUES ('male',3,'1234567890','Juan','Medina','Jimenez','Sin observaciones','18-01-2010','N/A','1234568','juan@correo.com','100','15000',2),('male',3,'1254789632','Leon','Hernandez','Tapia','Informacion pendiente','20-06-2000','N/A','9876523','leon@correo.com','200','8000',3),('male',3,'1345687920','Martin','Lopez','Lopez','Sin observaciones','01-07-1998','N/A','1564892','martin@gmail.com','120','12000',4),('female',3,'2158764923','Raul','Romero','Flores','Sin observaciones','06-12-1980','N/A','1359786','raul@hotmail.com','190','25000',5),('female',3,'0123456892','Marcos','Rojas','Perez','Sin observaciones','26-02-1998','N/A','1589764','marcos@yahoo.com.mx','50','9000',6),('female',3,'2153489760','Mauricio','Mendez','Chavez','Sin observaciones','04-06-2010','N/A','2658952','mauricio@gmail.com','23','40000',7),('male',3,'2587694310','Jesus','Lima','Moreno','Informacion pendiente','03-08-2011','N/A','2358552','jesus@gmail.com','23','30000',8);
/*!40000 ALTER TABLE `afiliado` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-09 13:03:54
