-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: medify
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `uid` int NOT NULL AUTO_INCREMENT,
  `roleid` int DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `surname` varchar(50) NOT NULL,
  `Gender` enum('Male','Female','Other') NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `date_of_birth` date NOT NULL,
  `contact_number` varchar(15) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`uid`),
  KEY `roleid` (`roleid`),
  CONSTRAINT `users_ibfk_1` FOREIGN KEY (`roleid`) REFERENCES `role` (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,1,'Admin','User','Other','admin123','admin@medify.com','1970-01-01','5555555555','1 Admin St'),(2,2,'John','Doe','Male','doctor123','johndoe@hospital.com','1980-01-01','1234567890','123 Main St'),(3,2,'Jane','Smith','Female','securepassword','janesmith@hospital.com','1985-07-14','9876543210','456 Elm St'),(4,2,'David','Williams','Male','doctor1234','davidwilliams@hospital.com','1982-09-18','2134567890','23 Maple St'),(5,2,'Robert','Garcia','Male','doctorsecure','robertgarcia@hospital.com','1978-02-10','4321567890','45 Willow Dr'),(6,2,'Jennifer','Clark','Female','doctor12345','jenniferclark@hospital.com','1983-08-29','7654321678','78 Poplar Way'),(7,3,'Michael','Lee','Male','mysecret','michaellee@patient.com','1990-03-22','0987654321','789 Oak Ave'),(8,3,'Alice','Johnson','Female','strongpass','alicejohnson@patient.com','1975-12-05','1098765432','10 Pine Blvd'),(9,3,'Emily','Brown','Female','patientsecure','emilybrown@patient.com','1995-06-21','3214567890','34 Cedar Lane'),(10,3,'Sarah','Davis','Female','myhealthdata','sarahdavis@patient.com','1992-11-03','5432167890','56 Birch Rd'),(11,3,'William','Miller','Male','secretpassword','williammiller@patient.com','1987-04-17','6543216789','67 Elm St'),(12,3,'Charles','Taylor','Male','patient123','charlestaylor@patient.com','1965-09-25','8765432109','89 Spruce St'),(13,3,'Barbara','White','Female','securepatient','barbarawhite@patient.com','1970-05-12','9876543211','90 Elm St'),(14,3,'Daniel','Rodriguez','Male','myhealthinfo','danielrodriguez@patient.com','1982-02-04','0123456789','101 new St'),(15,3,'Emirhan','Yıldız','Male','123456','emirhanyildiz@ogr.eskisehir.edu.tr','2002-01-16','5469383008','Kavakpınar mahallesi saki sokak 18/2 Pendik/İSTANBUL');
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

-- Dump completed on 2024-05-02 20:01:56
