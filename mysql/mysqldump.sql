-- MySQL dump 10.13  Distrib 5.6.31, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: food
-- ------------------------------------------------------
-- Server version	5.6.31-0ubuntu0.15.10.1

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
-- Current Database: `food`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `food` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `food`;

--
-- Table structure for table `Menu`
--

DROP TABLE IF EXISTS `Menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Menu` (
  `Item_ID` int(10) DEFAULT NULL,
  `Item_Name` varchar(40) DEFAULT NULL,
  `Item_Price` float DEFAULT NULL,
  `Item_Type` varchar(15) DEFAULT NULL,
  `Item_Category` varchar(40) DEFAULT NULL,
  `R_ID` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Menu`
--

LOCK TABLES `Menu` WRITE;
/*!40000 ALTER TABLE `Menu` DISABLE KEYS */;
INSERT INTO `Menu` VALUES (101,'Mixed Green Salad',495,'VEG','Starter',1),(102,'Cream of Mushroom Soup',325,'VEG','Starter',1),(103,'Cheese Platter',895,'VEG','Starter',1),(104,'Chicken Noodles Clear Soup',350,'NON-VEG','Starter',1),(105,'Mexican Chicken Tostadas',525,'NON-VEG','Starter',1),(106,'Vegetable Noodles clear Soup',325,'VEG','Starter',1),(107,'Pistabhari Gulab Jamun',350,'VEG','Dessert',1),(108,'Classical Tiramisu',455,'VEG','Dessert',1),(109,'Rasmalai',350,'VEG','Dessert',1),(110,'Mango Pudding',350,'VEG','Dessert',1),(111,'Seasonal Fruit Platter',300,'VEG','Dessert',1),(112,'Panna Cotta',445,'NON-VEG','Dessert',1),(113,'Crispy Mix Veg',155,'VEG','Starter',21),(114,'Chang\'s Favorite Soup',100,'VEG','Starter',21),(115,'Mongolian Chicken',230,'NON-VEG','Starter',21),(116,'Spring Roll Prawn',250,'VEG','Starter',21),(117,'Tom Yum Soup',100,'NON-VEG','Starter',21),(118,'Ying Yang Soup',120,'NON-VEG','Starter',21),(119,'Cashew Nut Vegetables',165,'NON-VEG','Main Course',21),(120,'Exotic Greens',230,'VEG','Main Course',21),(121,'Mandarin Chowmein',175,'VEG','Main Course',21),(122,'Pan-Fried Noodle',175,'VEG','Main Course',21),(123,'Oyster Fish/Prawn',330,'NON-VEG','Main Course',21),(124,'Singapore Fish/Prawn',320,'NON-VEG','Main Course',21),(125,'Hongkong Fish/Prawn',330,'NON-VEG','Main Course',21),(126,'American Chopsuey Vegetables',165,'NON-VEG','Main Course',21),(127,'Shangsi Crabmeat Soup',180,'NON-VEG','Starter',22),(128,'Chicken And Vegetable Clear Soup with To',190,'NON-VEG','Starter',22),(129,'Vegetable Sweet Corn Soup',165,'VEG','Starter',22),(130,'Chicken Wonton Clear Soup',175,'NON-VEG','Starter',22),(131,'Duckmeat And Chinese Gabbage Soup',185,'NON-VEG','Starter',22),(132,'Mixed Vegetables Kung Pao Style',335,'NON-VEG','Main Course',22),(133,'Wook Tossed Greens With Garlic',425,'VEG','Main Course',22),(134,'Exotic Vegetables in Maoshi Sauce',355,'VEG','Main Course',22),(135,'King Prawns Hubei',595,'NON-VEG','Main Course',22),(136,'Fish In Devil\'s Sauce',525,'NON-VEG','Main Course',22),(137,'Mainland Sundae',145,'VEG','Desserts',22),(138,'Orange Creme brulee',145,'VEG','Desserts',22),(139,'Coconut Caramel Custard',155,'VEG','Desserts',22),(140,'Chocolate Fondue',195,'VEG','Desserts',22),(141,'Choice Of Ice-Creams (2 Scoops)',110,'VEG','Desserts',22),(142,'Kimling Special Soup',150,'NON-VEG','Starter',23),(143,'chicken Wonton Soup',120,'NON-VEG','Starter',23),(144,'Tangy Vegetables',180,'VEG','Starter',23),(145,'Peking Soup',110,'VEG','Starter',23),(146,'veg Dragon Roll',190,'VEG','starter',23),(147,'Lamb Boneless In Black Bean Sauce',325,'NON-VEG','Main Course',23),(148,'Pork Sweet N Sour',285,'NON-VEG','Main Course',23),(149,'Spicy Hot Fish',300,'NON-VEG','Main Course',23),(150,'Veg Chefs Special',210,'VEG','Main Course',23),(151,'Paneer Hong Kong',200,'VEG','Main Course',23),(152,'Spicy TamYam Soup',110,'VEG','Starter',24),(153,'Veg Dimsum',160,'VEG','Starter',24),(154,'Crispy Veg In Black Pepper',170,'VEG','Starter',24),(155,'Pan Fried Chicken',200,'NON-VEG','Starter',24),(156,'Chicken Lollypop',190,'NON-VEG','Starter',24),(157,'Malaysian Curry',290,'VEG','Main Course',24),(158,'Veg Green Curry',270,'VEG','Main Course',24),(159,'Chicken Hot Garlic',190,'NON-VEG','Main Course',24),(160,'Chicken Manchurian',190,'NON-VEG','Main Course',24),(161,'Chicken Hakka Noodles',220,'NON-VEG','Main Course',24),(162,'Brownie With Hot Chocolate Sauce',130,'VEG','Dessert',24),(163,'Brownie With Vanilla Ice Cream',130,'VEG','Dessert',24),(164,'Honey Noodle With Ice Cream',130,'VEG','Dessert',24),(165,'Corn Cream',210,'VEG','Starter',25),(166,'Veg Satay',230,'VEG','Starter',25),(167,'Spring Roll Schezwan Style',210,'VEG','Starter',25),(168,'String Chicken',320,'NON-VEG','Starter',25),(169,'Chicken Wrapped Prawn',375,'NON-VEG','Starter',25),(170,'Chicken Chowmein',275,'NON-VEG','Main Course',25),(171,'Chilli Pork',330,'NON-VEG','Main Course',25),(172,'Manchurian Veg Balls',210,'VEG','Main Course',25),(173,'American Chopsuey',210,'VEG','Main Course',25),(174,'Vegetable Chowmein',210,'VEG','Main Course',25),(175,'Banana Fried With Honey',150,'VEG','Dessert',25),(176,'Fried Noodles With Honey',150,'VEG','Dessert',25),(177,'Pasta Alla Ricotta',475,'VEG','Starter',26),(178,'Pesto Pizza',505,'VEG','Starter',26),(179,'Ravioli',495,'VEG','Starter',26),(180,'Risotto',380,'VEG','Starter',26),(181,'Garlic Bread',140,'VEG','Starter',26),(182,'Lasagne',250,'VEG','Main Course',26),(183,'Pesto Pasta',300,'VEG','Main Course',26),(184,'Salad',190,'VEG','Main Course',26),(185,'Garlic Cheddar Chicken',500,'NON-VEG','Main Course',26),(186,'Sphagetti',400,'VEG','Main Course',26),(187,'Red Velvet Cake',200,'VEG','Dessert',26),(188,'Panna Cotta',250,'VEG','Dessert',26),(189,'Gelato',300,'VEG','Dessert',26),(200,'Chocolate CheeseCake',180,'VEG','Dessert',26),(201,'Cannoli',210,'VEG','Dessert',26),(202,'Cheese Chilly Toast',80,'VEG','Starter',27),(203,'Veg Brushetta',90,'VEG','Starter',27),(204,'Chicken Hot Dog',100,'NON-VEG','Starter',27),(205,'Chicken Brushetta',130,'NON-VEG','Starter',27),(206,'Chicken Tikki',100,'NON-VEG','Starter',27),(207,'Barbeque Chicken Sandwich',100,'NON-VEG','Main Course',27),(208,'Cheezie Paneer Roll',110,'VEG','Main Course',27),(209,'Classic Burger',80,'NON-VEG','Main Course',27),(210,'Fiery Aloo Roll',80,'VEG','Main Course',27),(211,'Chicken Mint Roll',110,'NON-VEG','Main Course',27),(212,'Mango Slush',70,'VEG','Dessert',27),(213,'Walnut Brownie Sundae',60,'VEG','Dessert',27),(214,'Vanilla IceCream Sundae',30,'VEG','Dessert',27),(215,'Cheesy Margherita',300,'VEG','Main Course',28),(216,'Picante Paneer',470,'VEG','Main Course',28),(217,'Spanish Sunshine',530,'VEG','Main Course',28),(218,'The Famous Five',500,'VEG','Main Course',28),(219,'Tandoori Chicken',530,'NON-VEG','Main Course',28),(220,'Veggie Medley',350,'VEG','Main Course',28),(221,'Chicken Overload',570,'NON-VEG','Main Course',28),(222,'Chicken Kheema Pizza',450,'NON-VEG','Main Course',28),(223,'The Wild West BBQ',530,'NON-VEG','Main Course',28),(224,'Salami Feast',400,'NON-VEG','Main Course',28),(225,'The Berliner',500,'NON-VEG','Main Course',28),(226,'Choco Lava Cake',90,'VEG','Dessert',28),(227,'Golden Mousse Cake',100,'VEG','Dessert',28),(228,'Garlic Breadsticks',100,'VEG','Starter',28),(229,'Stuffed Garlic Bread',120,'VEG','Starter',28),(230,'Chicken Wings',250,'VEG','Starter',28),(231,'Burger Pizza Premium',160,'NON-VEG','Main Course',28),(232,'Burger Pizza Premium',100,'VEG','Main Course',28),(233,'Margherita Veg Pizza',150,'VEG','Main Course',28),(234,'Doubly Cheese Margherita',250,'VEG','Main Course',28),(235,'Kuka',25,'VEG','Dessert',51),(236,'Cold Coffee',35,'VEG','Dessert',51),(237,'Cold Coffee',35,'VEG','Dessert',15);
/*!40000 ALTER TABLE `Menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Restaurants`
--

DROP TABLE IF EXISTS `Restaurants`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Restaurants` (
  `R_ID` int(5) DEFAULT NULL,
  `R_Name` varchar(20) DEFAULT NULL,
  `R_Type` varchar(20) DEFAULT NULL,
  `R_Location` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Restaurants`
--

LOCK TABLES `Restaurants` WRITE;
/*!40000 ALTER TABLE `Restaurants` DISABLE KEYS */;
INSERT INTO `Restaurants` VALUES (1,'Feast','Indian','Raja Bahadur Road'),(2,'Chingari','Indian','Raja Bahadur Road'),(3,'Vaishali','Indian','FC Road'),(4,'Desi Aroma','Indian','Baren Road'),(5,'Raqabdaar','Indian','Baren Road'),(6,'The urban Chulah','Indian','Vimannagar'),(7,'Lazeez','Indian','Vimannagar'),(8,'Mughal Darbaar','Indian','Kalyani Nagar'),(9,'Punjabi Rasoi','Indian','Koregaon Park'),(10,'Biryani House','Indian','Nigdi'),(11,' Goodluck','Cafe','Deccan Gymkhana'),(12,'East Street Cafe','Cafe','Virman Plaza'),(13,'Chai Express','Cafe','Kothrud'),(14,'Hard Rock Cafe','Cafe','Koregaon Park'),(15,'Farzi Cafe','Cafe','Kalyani Nagar'),(16,'Durga Cafe','Cafe','Kothrud'),(17,'Cafe Colombia','Cafe','Kalyani Nagar'),(18,'Sauteed Stories','Cafe','Koregaon Park'),(19,'Cafe Bistro','Cafe','Satara Road'),(20,'German Bakery','Cafe','Koregaon Park'),(21,'Chang\'s','Chinese','Viman Nagar'),(22,'Mainland China','Chinese','Pimpri'),(23,'Kimling Rush','Chinese','Pimple Saudagar'),(24,'Kimchi','Chinese','Kharadi'),(25,'Smokin\'Lee\'s','Chinese','Chinchwad'),(26,'Little Italy','Italian','Chinchwad'),(27,'Pasta La Pizza','Italian','Pimple Saudagar'),(28,'Oven Story','Italian','Pimple Saudagar'),(29,'Domino\'s','Italian','Chinchwad'),(30,'Italian','Italian','Aundh'),(31,'Gustozo','Continental','Baner'),(32,'Cafe 1730','Continental','Koregaon Park'),(33,'Polka Dots','Continental','Kalyani Nagar'),(34,'tien','Continental','Model Colony'),(35,'The Gazebo','Continental','Pimple Gurav'),(36,'Bay Leaf Bistro','Mexican','Pimple Saudagar'),(37,'Mezza 9','Mexican','Hinjewadi'),(38,'Skittles','Mexican','Wakad'),(39,'Boston Food Truck','Mexican','Wakad'),(40,'Picantos','Mexican','Vimannagar'),(41,'The Burger House','American','Koregaon Park'),(42,'The Zodiac','American','Baner'),(43,'Burger King','American','Vimannagar'),(44,'lo-cal','American','Aundh'),(45,'seven','American','Koregaon Park'),(46,'Cafe Cool','SwastatMasta','Akurdi'),(47,'Creamy Town','SwastatMasta','Akurdi'),(48,'Sujata Mastani','SwastatMasta','Chinchwad'),(49,'Arihant Hotel','SwastatMasta','Chinchwad'),(50,'Delhi Swad','SwastatMasta','Akurdi'),(51,'Cafe Creme','SwastatMasta','Akurdi');
/*!40000 ALTER TABLE `Restaurants` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `o_id` int(20) NOT NULL,
  `Item_Name` varchar(40) NOT NULL,
  `R_ID` int(5) NOT NULL,
  `u_id` int(20) NOT NULL,
  `Item_ID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'Chicken Wings',28,3,230),(1,'Chicken Wings',28,3,230),(1,'',1,7,101),(1,'',1,7,122201),(1,'',1,7,101),(1,'',1,7,102),(1,'',1,7,103),(1,'',1,7,104),(1,'',1,7,105),(1,'',1,7,106),(1,'',1,7,107),(1,'',1,7,108),(1,'',1,7,109),(1,'',1,7,110),(1,'',1,7,111),(1,'',1,7,112),(8,'',1,7,101),(8,'',1,7,102),(8,'',1,7,103),(8,'',1,7,104),(8,'',1,7,105),(8,'',1,7,106),(8,'',1,7,107),(8,'',1,7,108),(8,'',1,7,109),(8,'',1,7,110),(8,'',1,7,111),(8,'',1,7,112),(9,'',27,7,202),(9,'',27,7,208),(9,'',27,7,214),(10,'',26,7,177),(10,'',26,7,184),(10,'',26,7,201),(11,'',1,7,101),(11,'',1,7,102),(11,'',1,7,103),(11,'',1,7,104),(12,'',1,7,101),(12,'',1,7,104),(13,'',26,7,177),(13,'',26,7,184),(13,'',26,7,201);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordertable`
--

DROP TABLE IF EXISTS `ordertable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ordertable` (
  `o_id` int(20) NOT NULL AUTO_INCREMENT,
  `u_id` int(30) DEFAULT NULL,
  `R_ID` int(20) NOT NULL,
  `total` int(20) NOT NULL,
  `dateAndTime` varchar(50) DEFAULT NULL,
  `status` varchar(20) NOT NULL DEFAULT 'PENDING',
  PRIMARY KEY (`o_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordertable`
--

LOCK TABLES `ordertable` WRITE;
/*!40000 ALTER TABLE `ordertable` DISABLE KEYS */;
INSERT INTO `ordertable` VALUES (1,7,1,5165,'2016-09-28 11:15:36','PENDING'),(2,7,1,5165,'2016-09-28 11:17:40','PENDING'),(3,7,1,5165,'2016-09-28 11:18:26','PENDING'),(4,7,1,5165,'2016-09-28 11:19:17','PENDING'),(5,7,1,5165,'2016-09-28 11:20:16','PENDING'),(6,7,1,5165,'2016-09-28 11:22:24','PENDING'),(7,7,1,5165,'2016-09-28 11:27:37','PENDING'),(8,7,1,5165,'2016-09-28 11:28:36','PENDING'),(9,7,27,220,'2016-09-29 18:28:31','PENDING'),(10,7,26,875,'2016-09-29 18:47:11','PENDING'),(11,7,1,2065,'2016-09-29 18:58:16','PENDING'),(12,7,1,845,'2016-09-29 19:07:20','PENDING'),(13,7,26,875,'2016-10-02 05:22:48','PENDING');
/*!40000 ALTER TABLE `ordertable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usertable`
--

DROP TABLE IF EXISTS `usertable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usertable` (
  `u_id` int(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usertable`
--

LOCK TABLES `usertable` WRITE;
/*!40000 ALTER TABLE `usertable` DISABLE KEYS */;
INSERT INTO `usertable` VALUES (1,'lalit','bhalerao'),(2,'vishakha','sharma'),(3,'sakshi','kanpile'),(4,'kirankumar','kanaje'),(5,'1','1'),(6,'r','r'),(7,'k','k');
/*!40000 ALTER TABLE `usertable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendortable`
--

DROP TABLE IF EXISTS `vendortable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vendortable` (
  `v_id` int(20) NOT NULL AUTO_INCREMENT,
  `v_username` varchar(20) NOT NULL,
  `v_password` varchar(20) NOT NULL,
  PRIMARY KEY (`v_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendortable`
--

LOCK TABLES `vendortable` WRITE;
/*!40000 ALTER TABLE `vendortable` DISABLE KEYS */;
INSERT INTO `vendortable` VALUES (1,'feast','feast'),(2,'lalit','bhalerao'),(3,'abc','pqr'),(4,'krupali','suki'),(5,'andya','andya'),(6,'urbanchulah','1234');
/*!40000 ALTER TABLE `vendortable` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-10-02 10:06:00
