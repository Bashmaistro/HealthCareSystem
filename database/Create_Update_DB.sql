DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `rid` int NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'Administrator'),(2,'Doctor'),(3,'Patient');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;


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


DROP TABLE IF EXISTS `doctors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doctors` (
  `did` int NOT NULL AUTO_INCREMENT,
  `uid` int DEFAULT NULL,
  `Degree` enum('Prof_Dr','Op_Dr','Exp_Dr','Fzt','Dr','Ast_Dr') NOT NULL,
  `Specialty` varchar(100) NOT NULL,
  PRIMARY KEY (`did`),
  KEY `doctors_ibfk_1` (`uid`),
  CONSTRAINT `doctors_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `users` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doctors`
--

LOCK TABLES `doctors` WRITE;
/*!40000 ALTER TABLE `doctors` DISABLE KEYS */;
INSERT INTO `doctors` VALUES (1,2,'Op_Dr','Cardiology'),(2,3,'Prof_Dr','Neurology'),(3,4,'Op_Dr','Dermatology'),(4,5,'Dr','Pediatrics'),(5,6,'Dr','General Practice');
/*!40000 ALTER TABLE `doctors` ENABLE KEYS */;
UNLOCK TABLES;

DROP TABLE IF EXISTS `patients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patients` (
  `pid` int NOT NULL AUTO_INCREMENT,
  `uid` int DEFAULT NULL,
  `specialCase` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pid`),
  KEY `patients_ibfk_1` (`uid`),
  CONSTRAINT `patients_ibfk_1` FOREIGN KEY (`uid`) REFERENCES `users` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patients`
--

LOCK TABLES `patients` WRITE;
/*!40000 ALTER TABLE `patients` DISABLE KEYS */;
INSERT INTO `patients` VALUES (1,7,'None'),(2,8,'Has allergies to penicillin'),(3,9,'Chronic back pain'),(4,10,'No special cases'),(5,11,'Family history of heart disease'),(6,12,'Recently recovered from pneumonia'),(7,13,'Monitored for high blood pressure'),(8,14,'Undergoing physical therapy'),(9,15,NULL);
/*!40000 ALTER TABLE `patients` ENABLE KEYS */;
UNLOCK TABLES;

DROP TABLE IF EXISTS `health_records`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `health_records` (
  `RecordID` int NOT NULL AUTO_INCREMENT,
  `pid` int DEFAULT NULL,
  `did` int DEFAULT NULL,
  `record_date` date NOT NULL,
  `Prescription` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`RecordID`),
  KEY `health_records_ibfk_2` (`did`),
  KEY `health_records_ibfk_1` (`pid`),
  CONSTRAINT `health_records_ibfk_1` FOREIGN KEY (`pid`) REFERENCES `patients` (`pid`),
  CONSTRAINT `health_records_ibfk_2` FOREIGN KEY (`did`) REFERENCES `doctors` (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `health_records`
--

LOCK TABLES `health_records` WRITE;
/*!40000 ALTER TABLE `health_records` DISABLE KEYS */;
INSERT INTO `health_records` VALUES (1,1,1,'2024-04-18','Aspirin 81mg daily'),(2,2,2,'2024-04-15','Gabapentin 300mg twice daily'),(3,3,3,'2024-04-12','Topical steroid cream, apply twice daily'),(4,4,4,'2024-04-10','Multivitamin once daily'),(5,5,5,'2024-04-05','No prescription needed, monitor symptoms'),(6,6,1,'2024-04-19','Blood pressure medication adjustment needed'),(7,7,3,'2024-04-17','Continue current medication regimen');
/*!40000 ALTER TABLE `health_records` ENABLE KEYS */;
UNLOCK TABLES;


DROP TABLE IF EXISTS `appointments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `appointments` (
  `aid` int NOT NULL AUTO_INCREMENT,
  `did` int DEFAULT NULL,
  `pid` int DEFAULT NULL,
  `appointment_date` datetime NOT NULL,
  `Status` enum('scheduled','cancelled','completed') DEFAULT 'scheduled',
  PRIMARY KEY (`aid`),
  KEY `appointments_ibfk_1` (`did`),
  KEY `appointments_ibfk_2` (`pid`),
  CONSTRAINT `appointments_ibfk_1` FOREIGN KEY (`did`) REFERENCES `doctors` (`did`),
  CONSTRAINT `appointments_ibfk_2` FOREIGN KEY (`pid`) REFERENCES `patients` (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appointments`
--

LOCK TABLES `appointments` WRITE;
/*!40000 ALTER TABLE `appointments` DISABLE KEYS */;
INSERT INTO `appointments` VALUES (1,1,3,'2024-04-25 00:00:00','scheduled'),(2,2,4,'2024-04-23 00:00:00','scheduled'),(3,3,6,'2024-04-22 00:00:00','scheduled'),(4,4,8,'2024-04-20 00:00:00','cancelled'),(5,5,5,'2024-04-19 00:00:00','completed'),(6,1,1,'2024-04-26 00:00:00','scheduled');
/*!40000 ALTER TABLE `appointments` ENABLE KEYS */;
UNLOCK TABLES;