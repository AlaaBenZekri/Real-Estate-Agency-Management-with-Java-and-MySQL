-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: agence
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bien`
--

DROP TABLE IF EXISTS `bien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bien` (
  `num` int NOT NULL AUTO_INCREMENT,
  `Status` varchar(45) NOT NULL,
  `Code` int NOT NULL,
  `Date` date NOT NULL,
  `NumRue` int DEFAULT NULL,
  `Rue` varchar(45) NOT NULL,
  `CodePostale` int NOT NULL,
  `Local` varchar(45) NOT NULL,
  `idProp` int NOT NULL,
  `MontantCautionLocative` double DEFAULT NULL,
  `LoyerMensuel` double DEFAULT NULL,
  `ChargeMensuel` double DEFAULT NULL,
  `Meuble` tinyint DEFAULT NULL,
  `PrixDemande` double DEFAULT NULL,
  `Etat` varchar(45) DEFAULT NULL,
  `NombreChambres` int DEFAULT NULL,
  `NombreGarages` int DEFAULT NULL,
  `CuisineEquipe` tinyint DEFAULT NULL,
  `SuperficieJardin` double DEFAULT NULL,
  `NombreEtages` int DEFAULT NULL,
  `EtageDeLocal` int DEFAULT NULL,
  `Ascenseur` tinyint DEFAULT NULL,
  `NbrComposants` int DEFAULT NULL,
  `Superficie` int NOT NULL,
  PRIMARY KEY (`num`),
  UNIQUE KEY `num_UNIQUE` (`num`),
  KEY `num` (`num`) /*!80000 INVISIBLE */,
  KEY `code` (`Code`),
  KEY `idProp` (`idProp`),
  CONSTRAINT `code` FOREIGN KEY (`Code`) REFERENCES `classe` (`Code`),
  CONSTRAINT `idProp` FOREIGN KEY (`idProp`) REFERENCES `proprietaire` (`idProp`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bien`
--

LOCK TABLES `bien` WRITE;
/*!40000 ALTER TABLE `bien` DISABLE KEYS */;
INSERT INTO `bien` VALUES (13,'A vendre',12,'2021-04-30',1,'Un',1111,'Uno',3,NULL,NULL,NULL,NULL,180000,'Correct',3,1,1,30,1,NULL,NULL,NULL,200),(16,'A vendre',29,'2021-04-30',2,'Deux',2222,'Dos',3,NULL,NULL,NULL,NULL,140000,'Impeccable',2,1,0,10,1,NULL,NULL,NULL,150),(18,'A vendre',21,'2021-04-30',6,'Lfel',1511,'Ariana',6,100,300,100,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,2,1,NULL,100);
/*!40000 ALTER TABLE `bien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classe`
--

DROP TABLE IF EXISTS `classe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classe` (
  `Code` int NOT NULL AUTO_INCREMENT,
  `Type` varchar(45) NOT NULL,
  `ModeOffre` varchar(45) NOT NULL,
  `PrixMax` double NOT NULL,
  `SuperficieMin` double NOT NULL,
  PRIMARY KEY (`Code`),
  UNIQUE KEY `Code_UNIQUE` (`Code`),
  KEY `Code` (`Code`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classe`
--

LOCK TABLES `classe` WRITE;
/*!40000 ALTER TABLE `classe` DISABLE KEYS */;
INSERT INTO `classe` VALUES (11,'Maison','A vendre',100000,100),(12,'Maison','A vendre',200000,200),(13,'Maison','A louer',4000,100),(14,'Maison','A louer',8000,200),(15,'Appartement','A vendre',100000,120),(16,'Appartement','A vendre',200000,240),(17,'Appartement','A louer',9000,120),(18,'Appartement','A louer',11000,250),(19,'Studio','A vendre',70000,60),(20,'Studio','A vendre',90000,180),(21,'Studio','A louer',1000,70),(23,'Studio','A louer',2000,190),(24,'Entrepot','A vendre',40000,400),(25,'Entrepot','A louer',30000,500),(26,'Emplacement','A vendre',35000,70),(27,'Emplacement','A louer',5000,70),(28,'Terrain','A vendre',50000,200),(29,'Maison','A vendre',170000,150);
/*!40000 ALTER TABLE `classe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `idClient` int NOT NULL AUTO_INCREMENT,
  `Nom` varchar(45) NOT NULL,
  `Prenom` varchar(45) NOT NULL,
  `NumRue` int NOT NULL,
  `Rue` varchar(45) NOT NULL,
  `CodePostale` int NOT NULL,
  `Localite` varchar(45) NOT NULL,
  `NumTel` int NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idClient`),
  UNIQUE KEY `idClient` (`idClient`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `contrat`
--

DROP TABLE IF EXISTS `contrat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contrat` (
  `idContrat` int NOT NULL AUTO_INCREMENT,
  `num` int NOT NULL,
  `idClient` int NOT NULL,
  `Date` date NOT NULL,
  `Prix` double NOT NULL,
  PRIMARY KEY (`idContrat`),
  UNIQUE KEY `idContrat_UNIQUE` (`idContrat`) /*!80000 INVISIBLE */,
  KEY `idContrat` (`idContrat`) /*!80000 INVISIBLE */,
  KEY `idc_idx` (`idClient`),
  KEY `num_idx` (`num`) /*!80000 INVISIBLE */,
  CONSTRAINT `idc` FOREIGN KEY (`idClient`) REFERENCES `client` (`idClient`),
  CONSTRAINT `num` FOREIGN KEY (`num`) REFERENCES `bien` (`num`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contrat`
--

LOCK TABLES `contrat` WRITE;
/*!40000 ALTER TABLE `contrat` DISABLE KEYS */;
/*!40000 ALTER TABLE `contrat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employebureau`
--

DROP TABLE IF EXISTS `employebureau`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employebureau` (
  `idEmp` int NOT NULL AUTO_INCREMENT,
  `Adresse` varchar(45) NOT NULL,
  `MotDePasse` varchar(45) NOT NULL,
  `Admin` tinyint NOT NULL DEFAULT '0',
  `Nom` varchar(45) NOT NULL,
  `Prenom` varchar(45) NOT NULL,
  `NumRue` int NOT NULL,
  `Rue` varchar(45) NOT NULL,
  `CodePostale` int NOT NULL,
  `Localite` varchar(45) NOT NULL,
  `NumTel` int NOT NULL,
  PRIMARY KEY (`idEmp`),
  UNIQUE KEY `idEmp_UNIQUE` (`idEmp`),
  UNIQUE KEY `AddresseEmail_UNIQUE` (`Adresse`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employebureau`
--

LOCK TABLES `employebureau` WRITE;
/*!40000 ALTER TABLE `employebureau` DISABLE KEYS */;
INSERT INTO `employebureau` VALUES (6,'alaaeddinebenzekri@gmail.com','aaa111',1,'Ben Zekri','Alaa Eddine',1,'Republique',2082,'fouchena',99215025),(7,'Saoudadam66@gmail.com','azerty',0,'Saoud','Adam',1,'rue',2000,'Djerba',99555777);
/*!40000 ALTER TABLE `employebureau` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employevisite`
--

DROP TABLE IF EXISTS `employevisite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employevisite` (
  `idEmp` int NOT NULL AUTO_INCREMENT,
  `Nom` varchar(45) NOT NULL,
  `Prenom` varchar(45) NOT NULL,
  `NumRue` int NOT NULL,
  `Rue` varchar(45) NOT NULL,
  `CodePostale` int NOT NULL,
  `Localite` varchar(45) NOT NULL,
  `NumTel` int NOT NULL,
  PRIMARY KEY (`idEmp`),
  UNIQUE KEY `idEmp_UNIQUE` (`idEmp`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employevisite`
--

LOCK TABLES `employevisite` WRITE;
/*!40000 ALTER TABLE `employevisite` DISABLE KEYS */;
INSERT INTO `employevisite` VALUES (5,'Ben Hassan','Hassan',1,'aaaaa',1441,'ouuouuu',1234111),(6,'Bouzouer','Ammar',2,'Athene',1080,'Grec',99999999),(7,'Hassan','Mohsen',3,'Arbi',1000,'Houma',99887766),(8,'Ben Abdeltif','Lotfi',1,'Saada',9866,'Kabbariyya',99885566),(9,'Ben Mhenni','Hani',8,'Kronfol',6585,'Wardia',95557755),(10,'Khadhraoui','Raouf',3,'Klil',1000,'Milaha',99557733),(11,'Gharbi','Karim',3,'Kammoun',2080,'Mhamdia',99575844);
/*!40000 ALTER TABLE `employevisite` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proprietaire`
--

DROP TABLE IF EXISTS `proprietaire`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proprietaire` (
  `idProp` int NOT NULL AUTO_INCREMENT,
  `Nom` varchar(45) NOT NULL,
  `Prenom` varchar(45) NOT NULL,
  `NumRue` int NOT NULL,
  `Rue` varchar(45) NOT NULL,
  `CodePostale` int NOT NULL,
  `Localite` varchar(45) NOT NULL,
  `NumTelPrv` int NOT NULL,
  `HeureDebPrsTelPrv` int NOT NULL,
  `HeureFinPrsTelPrv` int NOT NULL,
  `NumTelTrv` int NOT NULL,
  `HeureDebPrsTelTrv` int NOT NULL,
  `HeureFinPrsTelTrv` int NOT NULL,
  PRIMARY KEY (`idProp`),
  UNIQUE KEY `idProp_UNIQUE` (`idProp`),
  KEY `idProp` (`idProp`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proprietaire`
--

LOCK TABLES `proprietaire` WRITE;
/*!40000 ALTER TABLE `proprietaire` DISABLE KEYS */;
INSERT INTO `proprietaire` VALUES (3,'Ben Ahmed','Ahmed',5,'Hadhaka',1999,'Naassen',99999666,7,20,99668855,9,16),(4,'Habbouba','Hedi',6,'Mziwed',1616,'Lila',99778844,7,22,99444444,21,23),(5,'Marzouki','Moncef',1,'Riassa',1515,'Carthage',99487461,7,20,9978674,9,16),(6,'Saied','Kais',1,'Riassa',1111,'Mnihla',99154446,7,21,99776431,9,17);
/*!40000 ALTER TABLE `proprietaire` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visite`
--

DROP TABLE IF EXISTS `visite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `visite` (
  `idVisite` int NOT NULL AUTO_INCREMENT,
  `num` int NOT NULL,
  `idClient` int NOT NULL,
  `idEmp` int NOT NULL,
  `Date` date NOT NULL,
  `Heure` time NOT NULL,
  PRIMARY KEY (`idVisite`),
  UNIQUE KEY `idVisite_UNIQUE` (`idVisite`),
  KEY `idEmp_idx` (`idEmp`) /*!80000 INVISIBLE */,
  KEY `idc_idx` (`idClient`),
  KEY `num_idx` (`num`),
  CONSTRAINT `idcl` FOREIGN KEY (`idClient`) REFERENCES `client` (`idClient`),
  CONSTRAINT `idEmp` FOREIGN KEY (`idEmp`) REFERENCES `employevisite` (`idEmp`),
  CONSTRAINT `nume` FOREIGN KEY (`num`) REFERENCES `bien` (`num`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visite`
--

LOCK TABLES `visite` WRITE;
/*!40000 ALTER TABLE `visite` DISABLE KEYS */;
/*!40000 ALTER TABLE `visite` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-30 22:52:04
