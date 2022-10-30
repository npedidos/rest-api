-- MySQL dump 10.13  Distrib 8.0.31, for Linux (x86_64)
--
-- Host: localhost    Database: npedidos
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Dumping data for table `exclude_days`
--

LOCK TABLES `exclude_days` WRITE;
/*!40000 ALTER TABLE `exclude_days` DISABLE KEYS */;
INSERT INTO `exclude_days` VALUES (7,'2022-10-23'),(2,'2022-10-26'),(9,'2022-11-01'),(10,'2022-11-02'),(5,'2022-11-06'),(4,'2022-11-17'),(1,'2022-11-18'),(3,'2022-12-02'),(6,'2022-12-08'),(8,'2022-12-27');
/*!40000 ALTER TABLE `exclude_days` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `food_dishes`
--

LOCK TABLES `food_dishes` WRITE;
/*!40000 ALTER TABLE `food_dishes` DISABLE KEYS */;
INSERT INTO `food_dishes` VALUES (1,'Tiramisù',4),(2,'Pork Sausage Roll',3),(3,'Tacos',5),(4,'Seafood Paella',3),(5,'French Fries with Sausages',7),(6,'Pork Sausage Roll',6),(7,'Caesar Salad',10),(8,'French Fries with Sausages',9),(9,'Salmon Nigiri',9),(10,'Chicken Wings',7),(11,'French Fries with Sausages',2),(12,'Mushroom Risotto',10),(13,'Stinky Tofu',1),(14,'Pierogi',3),(15,'Chicken Parm',1),(16,'Tiramisù',3),(17,'Ebiten maki',10),(18,'French Toast',10),(19,'Katsu Curry',2),(20,'Caprese Salad',5),(21,'Linguine with Clams',3),(22,'Chicken Milanese',7),(23,'Fish and Chips',3),(24,'California Maki',3),(25,'Kebab',9),(26,'Som Tam',5),(27,'Pasta Carbonara',1),(28,'Cheeseburger',8),(29,'Pork Belly Buns',8),(30,'Teriyaki Chicken Donburi',1),(31,'Tacos',1),(32,'Chicken Parm',6),(33,'Ricotta Stuffed Ravioli',8),(34,'Lasagne',4),(35,'Chicken Fajitas',3),(36,'Teriyaki Chicken Donburi',4),(37,'Pasta and Beans',8),(38,'Pierogi',2),(39,'Pasta and Beans',1),(40,'French Fries with Sausages',8),(41,'Chicken Milanese',7),(42,'Pasta and Beans',10),(43,'Lasagne',4),(44,'Pasta Carbonara',1),(45,'Salmon Nigiri',9),(46,'Tiramisù',3),(47,'Philadelphia Maki',7),(48,'Chicken Parm',3),(49,'Pork Belly Buns',1),(50,'Ricotta Stuffed Ravioli',10),(51,'Pork Sausage Roll',10),(52,'Chicken Parm',4),(53,'French Fries with Sausages',7),(54,'Mushroom Risotto',8),(55,'Pasta Carbonara',8),(56,'Sushi',6),(57,'Caesar Salad',7),(58,'Meatballs with Sauce',3),(59,'Risotto with Seafood',8),(60,'Scotch Eggs',3),(61,'Pizza',4),(62,'Pork Sausage Roll',7),(63,'Bruschette with Tomato',7),(64,'Hummus',2),(65,'Vegetable Soup',2),(66,'Tacos',9),(67,'French Toast',10),(68,'Linguine with Clams',5),(69,'Pizza',1),(70,'Pork Belly Buns',10),(71,'Pappardelle alla Bolognese',6),(72,'Sushi',1),(73,'Risotto with Seafood',8),(74,'Chicken Milanese',9),(75,'Stinky Tofu',4),(76,'Fettuccine Alfredo',6),(77,'California Maki',3),(78,'Caprese Salad',2),(79,'Cauliflower Penne',9),(80,'Ricotta Stuffed Ravioli',1),(81,'Seafood Paella',5),(82,'Pho',5),(83,'Poke',4),(84,'Risotto with Seafood',8),(85,'Caprese Salad',9),(86,'Pork Sausage Roll',10),(87,'Hummus',10),(88,'Ricotta Stuffed Ravioli',3),(89,'Fettuccine Alfredo',7),(90,'Chicken Parm',8),(91,'Seafood Paella',3),(92,'Vegetable Soup',8),(93,'Poke',7),(94,'Mushroom Risotto',7),(95,'Seafood Paella',1),(96,'Ebiten maki',8),(97,'Chilli con Carne',7),(98,'Fettuccine Alfredo',8),(99,'Caesar Salad',1),(100,'French Toast',1);
/*!40000 ALTER TABLE `food_dishes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `menus`
--

LOCK TABLES `menus` WRITE;
/*!40000 ALTER TABLE `menus` DISABLE KEYS */;
INSERT INTO `menus` VALUES (1,'2022-10-26'),(2,'2022-11-29'),(3,'2022-10-23'),(4,'2022-10-26'),(5,'2022-11-06'),(6,'2022-10-23'),(7,'2022-10-30'),(8,'2022-10-24'),(9,'2022-11-21'),(10,'2022-10-30');
/*!40000 ALTER TABLE `menus` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `menus_has_food_dishes`
--

LOCK TABLES `menus_has_food_dishes` WRITE;
/*!40000 ALTER TABLE `menus_has_food_dishes` DISABLE KEYS */;
INSERT INTO `menus_has_food_dishes` VALUES (1,1),(2,1),(3,1),(4,1),(5,1),(6,1),(7,1),(8,1),(9,1),(10,1),(1,2),(2,2),(3,2),(4,2),(5,2),(6,2),(7,2),(8,2),(9,2),(10,2),(1,3),(2,3),(3,3),(4,3),(5,3),(6,3),(7,3),(8,3),(9,3),(10,3);
/*!40000 ALTER TABLE `menus_has_food_dishes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'2022-12-31 07:59:05',5),(2,'2023-01-08 16:11:37',11),(3,'2022-10-31 18:44:30',36),(4,'2022-11-13 15:25:34',28),(5,'2022-11-21 18:08:57',20),(6,'2022-10-27 00:03:40',13),(7,'2022-12-06 19:57:20',5),(8,'2022-10-28 10:15:48',40),(9,'2022-10-29 18:04:55',8),(10,'2022-10-30 02:45:42',48),(11,'2022-11-16 17:29:28',4),(12,'2022-11-20 23:45:40',25),(13,'2022-10-29 07:12:56',34),(14,'2022-11-07 04:02:19',6),(15,'2022-10-24 14:10:24',3),(16,'2022-10-24 17:43:45',21),(17,'2022-12-06 23:37:22',32),(18,'2022-10-24 17:32:56',19),(19,'2022-11-19 07:51:09',12),(20,'2022-11-03 02:32:26',13),(21,'2022-10-25 14:04:15',36),(22,'2022-10-25 02:14:09',23),(23,'2022-11-29 02:49:57',31),(24,'2022-10-25 21:25:53',44),(25,'2022-11-03 10:12:18',22),(26,'2022-11-27 21:06:53',17),(27,'2022-11-24 21:56:01',27),(28,'2022-10-25 02:38:48',8),(29,'2022-11-11 18:29:50',19),(30,'2022-11-23 03:09:35',44),(31,'2022-10-29 06:00:46',13),(32,'2022-11-10 08:43:43',3),(33,'2022-12-25 08:53:30',28),(34,'2022-11-03 13:37:52',36),(35,'2022-12-31 17:01:45',10),(36,'2022-12-24 19:13:31',50),(37,'2022-10-29 07:35:01',2),(38,'2022-11-12 03:45:54',26),(39,'2022-11-12 13:40:59',11),(40,'2022-10-27 21:17:40',23),(41,'2022-11-04 17:29:23',33),(42,'2022-11-03 03:09:24',22),(43,'2022-11-04 14:35:01',26),(44,'2022-11-24 02:27:10',42),(45,'2022-10-27 21:22:43',1),(46,'2022-11-10 15:47:57',46),(47,'2022-12-20 08:19:55',12),(48,'2022-11-03 10:42:52',31),(49,'2022-12-07 00:48:36',49),(50,'2022-11-13 15:17:15',27);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `orders_has_food_dishes`
--

LOCK TABLES `orders_has_food_dishes` WRITE;
/*!40000 ALTER TABLE `orders_has_food_dishes` DISABLE KEYS */;
INSERT INTO `orders_has_food_dishes` VALUES (1,1),(2,1),(3,1),(4,1),(5,1),(6,1),(7,1),(8,1),(9,1),(10,1),(11,1),(12,1),(13,1),(14,1),(15,1),(16,1),(17,1),(18,1),(19,1),(20,1),(21,1),(22,1),(23,1),(24,1),(25,1),(26,1),(27,1),(28,1),(29,1),(30,1),(31,1),(32,1),(33,1),(34,1),(35,1),(36,1),(37,1),(38,1),(39,1),(40,1),(41,1),(42,1),(43,1),(44,1),(45,1),(46,1),(47,1),(48,1),(49,1),(50,1),(1,2),(2,2),(3,2),(4,2),(5,2),(6,2),(7,2),(8,2),(9,2),(10,2),(11,2),(12,2),(13,2),(14,2),(15,2),(16,2),(17,2),(18,2),(19,2),(20,2),(21,2),(22,2),(23,2),(24,2),(25,2),(26,2),(27,2),(28,2),(29,2),(30,2),(31,2),(32,2),(33,2),(34,2),(35,2),(36,2),(37,2),(38,2),(39,2),(40,2),(41,2),(42,2),(43,2),(44,2),(45,2),(46,2),(47,2),(48,2),(49,2),(50,2),(1,3),(2,3),(3,3),(4,3),(5,3),(6,3),(7,3),(8,3),(9,3),(10,3),(11,3),(12,3),(13,3),(14,3),(15,3),(16,3),(17,3),(18,3),(19,3),(20,3),(21,3),(22,3),(23,3),(24,3),(25,3),(26,3),(27,3),(28,3),(29,3),(30,3),(31,3),(32,3),(33,3),(34,3),(35,3),(36,3),(37,3),(38,3),(39,3),(40,3),(41,3),(42,3),(43,3),(44,3),(45,3),(46,3),(47,3),(48,3),(49,3),(50,3),(1,4),(2,4),(3,4),(4,4),(5,4),(6,4),(7,4),(8,4),(9,4),(10,4),(11,4),(12,4),(13,4),(14,4),(15,4),(16,4),(17,4),(18,4),(19,4),(20,4),(21,4),(22,4),(23,4),(24,4),(25,4),(26,4),(27,4),(28,4),(29,4),(30,4),(31,4),(32,4),(33,4),(34,4),(35,4),(36,4),(37,4),(38,4),(39,4),(40,4),(41,4),(42,4),(43,4),(44,4),(45,4),(46,4),(47,4),(48,4),(49,4),(50,4),(1,5),(2,5),(3,5),(4,5),(5,5),(6,5),(7,5),(8,5),(9,5),(10,5),(11,5),(12,5),(13,5),(14,5),(15,5),(16,5),(17,5),(18,5),(19,5),(20,5),(21,5),(22,5),(23,5),(24,5),(25,5),(26,5),(27,5),(28,5),(29,5),(30,5),(31,5),(32,5),(33,5),(34,5),(35,5),(36,5),(37,5),(38,5),(39,5),(40,5),(41,5),(42,5),(43,5),(44,5),(45,5),(46,5),(47,5),(48,5),(49,5),(50,5),(1,6),(2,6),(3,6),(4,6),(5,6),(6,6),(7,6),(8,6),(9,6),(10,6),(11,6),(12,6),(13,6),(14,6),(15,6),(16,6),(17,6),(18,6),(19,6),(20,6),(21,6),(22,6),(23,6),(24,6),(25,6),(26,6),(27,6),(28,6),(29,6),(30,6),(31,6),(32,6),(33,6),(34,6),(35,6),(36,6),(37,6),(38,6),(39,6),(40,6),(41,6),(42,6),(43,6),(44,6),(45,6),(46,6),(47,6),(48,6),(49,6),(50,6),(1,7),(2,7),(3,7),(4,7),(5,7),(6,7),(7,7),(8,7),(9,7),(10,7),(11,7),(12,7),(13,7),(14,7),(15,7),(16,7),(17,7),(18,7),(19,7),(20,7),(21,7),(22,7),(23,7),(24,7),(25,7),(26,7),(27,7),(28,7),(29,7),(30,7),(31,7),(32,7),(33,7),(34,7),(35,7),(36,7),(37,7),(38,7),(39,7),(40,7),(41,7),(42,7),(43,7),(44,7),(45,7),(46,7),(47,7),(48,7),(49,7),(50,7),(1,8),(2,8),(3,8),(4,8),(5,8),(6,8),(7,8),(8,8),(9,8),(10,8),(11,8),(12,8),(13,8),(14,8),(15,8),(16,8),(17,8),(18,8),(19,8),(20,8),(21,8),(22,8),(23,8),(24,8),(25,8),(26,8),(27,8),(28,8),(29,8),(30,8),(31,8),(32,8),(33,8),(34,8),(35,8),(36,8),(37,8),(38,8),(39,8),(40,8),(41,8),(42,8),(43,8),(44,8),(45,8),(46,8),(47,8),(48,8),(49,8),(50,8),(1,9),(2,9),(3,9),(4,9),(5,9),(6,9),(7,9),(8,9),(9,9),(10,9),(11,9),(12,9),(13,9),(14,9),(15,9),(16,9),(17,9),(18,9),(19,9),(20,9),(21,9),(22,9),(23,9),(24,9),(25,9),(26,9),(27,9),(28,9),(29,9),(30,9),(31,9),(32,9),(33,9),(34,9),(35,9),(36,9),(37,9),(38,9),(39,9),(40,9),(41,9),(42,9),(43,9),(44,9),(45,9),(46,9),(47,9),(48,9),(49,9),(50,9),(1,10),(2,10),(3,10),(4,10),(5,10),(6,10),(7,10),(8,10),(9,10),(10,10),(11,10),(12,10),(13,10),(14,10),(15,10),(16,10),(17,10),(18,10),(19,10),(20,10),(21,10),(22,10),(23,10),(24,10),(25,10),(26,10),(27,10),(28,10),(29,10),(30,10),(31,10),(32,10),(33,10),(34,10),(35,10),(36,10),(37,10),(38,10),(39,10),(40,10),(41,10),(42,10),(43,10),(44,10),(45,10),(46,10),(47,10),(48,10),(49,10),(50,10);
/*!40000 ALTER TABLE `orders_has_food_dishes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `settings`
--

LOCK TABLES `settings` WRITE;
/*!40000 ALTER TABLE `settings` DISABLE KEYS */;
INSERT INTO `settings` VALUES (1,'mra_jfg_llu','Esse voluptas nemo autem delectus. Non inventore iusto dolorum aut molestias. Cum voluptas laboriosam esse magni ea qui. Dicta voluptas necessitatibus veritatis. Et aut consequatur.','Eos incidunt cumque eveniet et consequatur dolores.'),(2,'zwh_sbd_wwe','Iure est ad dicta molestiae optio. Necessitatibus rerum sed ad reiciendis qui labore. Pariatur expedita sit rerum molestiae repellendus.','Vero in quas.'),(3,'wsj_tml_ijc','Id sed consequatur dolor similique qui reiciendis. Adipisci voluptatum eveniet itaque officia veniam accusamus. Nihil sit accusantium aut in omnis ut. Qui excepturi accusamus magni sequi. Tempore voluptas cumque ipsum.','Optio vel suscipit et mollitia minima.'),(4,'iot_yzn_nik','Similique veritatis atque at et sed qui rerum. Nam sint consequatur occaecati quod aut quo rerum. Aperiam explicabo quidem.','Qui est adipisci numquam natus est.'),(5,'cqf_ojv_jix','Debitis officia id sunt iste at perspiciatis consequatur. Dolorem rem et non nam fuga numquam. Aspernatur voluptas magni sapiente cum.','Fugiat et.'),(6,'sri_xcv_quh','Id deserunt sed. Consequatur perferendis recusandae consectetur ipsa consequatur beatae nihil. Vitae neque voluptas facere.','Molestiae molestias voluptatem et nesciunt.'),(7,'laz_qoy_vhm','Corrupti animi iusto neque quia consequatur. Quidem voluptas ut est ut ea. Libero rerum dolorem consequatur non sunt.','Nihil repellat nihil rerum doloribus.'),(8,'zsu_aez_evb','Laudantium et facilis. Qui voluptas voluptatem rerum velit quae. Et nisi sunt consequatur animi rerum voluptas. Quam natus voluptate. Aliquam inventore illo ab eius accusamus harum voluptatum.','Aut et ut ea delectus.'),(9,'lid_hge_xvk','Recusandae nam velit iure ut minus enim. Enim maiores earum iure est. Nisi hic excepturi repudiandae laborum et. Omnis dolore adipisci eos et sed. Impedit nobis quae nulla.','Et illum explicabo dolores provident.'),(10,'yvc_sqy_lqn','Magni incidunt et nam et. Quibusdam est aut consectetur a illum illo. Nobis aut rerum repudiandae fugiat est dolorem est. Perferendis cupiditate amet qui aliquid temporibus aperiam. Adipisci et numquam autem vel et fugit.','Unde sit autem corporis nostrum.');
/*!40000 ALTER TABLE `settings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `types_dishes`
--

LOCK TABLES `types_dishes` WRITE;
/*!40000 ALTER TABLE `types_dishes` DISABLE KEYS */;
INSERT INTO `types_dishes` VALUES (1,'Lisa Honda'),(2,'Mary A. Richman'),(3,'Adam Baum'),(4,'George Washington Sleptier'),(5,'Carlotta Tendant'),(6,'Raney Schauer'),(7,'Xavier Breath'),(8,'Liz Onnia'),(9,'Frank N. Sense'),(10,'Emile Eaton');
/*!40000 ALTER TABLE `types_dishes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'trent.murphy','$2a$10$pefXeIvCDZhpRgjEy4Pj4OJfXLY/tDeH5WjiRRD7C5Txhg/CdDEh.','edmundo.ebert@yahoo.com'),(2,'warren.stracke','$2a$10$pJ0xnqI7NySNiMutCZslpeQoRNPdA7VEPJ0gZTKXLw4XqYHWJjEVG','cameron.berge@hotmail.com'),(3,'vilma.spencer','$2a$10$R3EhldVpF5EdZFJLYiGcwOoxitd5Lb2WQaG1AtSGsAoD/Nkm9gVJu','maud.schaefer@gmail.com'),(4,'coleman.kemmer','$2a$10$4lXTQqyZhMaQb.rQ5EGj3.TS.Xuyt8yKwMZsQJkC0sHaa7nQZRa8K','guy.leffler@gmail.com'),(5,'santos.purdy','$2a$10$ElmKD/mhusy6SsWZt8rWDeC4Tp0AyGNPXlXULy4Ys6tzTVJ001Boa','kelle.ullrich@hotmail.com'),(6,'carmelo.padberg','$2a$10$hJU7P8oP5GUmrC91./LAOumoGILablokIC9sGAZxbyy8ynNeS/xaG','billy.toy@gmail.com'),(7,'talia.satterfield','$2a$10$rpLieL6LwJpGGxgps30.4e08ejPiPx4nXDgyt51dAKNZQuB7AQWEe','audria.leffler@gmail.com'),(8,'pat.balistreri','$2a$10$GRIfA2S5C9fl7bSzMNiuXOp5TrBxNPZ/TJVwtR7v2hJhrtvPLaiIO','dannie.aufderhar@hotmail.com'),(9,'jake.funk','$2a$10$a9SkDK6xcI.rs1A4188rJuoQXkDeGQnnlFZGAlbo4/R3dE0WBFdrW','glory.zulauf@gmail.com'),(10,'dino.mcglynn','$2a$10$QdDWhsUu3zZ9G.gesPOQj.F8WAbU5i2tYRsiZkEftxqTPKjbEYh7i','dreama.crona@gmail.com'),(11,'pamella.jakubowski','$2a$10$jlKf37MPK9I8UEtIkWy/8.vZiTv43DIlv3HXBwlH.qTXyRTk2rgZy','napoleon.raynor@hotmail.com'),(12,'vince.mann','$2a$10$l2WDyebi/2pNHmPGFSmM3.lAarevOyhynNPxGjO1oyXJ6vetS3faW','norberto.wiza@yahoo.com'),(13,'deana.oreilly','$2a$10$ghg/aKqW8Zkbt.5jVd/YV.RbSife.eynAWD4fAqlXeIn67JhEpBXe','brendon.wehner@gmail.com'),(14,'marcelo.thompson','$2a$10$V9GyX/68hAAnzACvJb8J1OHND.S8F1XobpFBIG1utR3bBL5fNARju','dwayne.spencer@yahoo.com'),(15,'danette.hegmann','$2a$10$tZU0MYJDNM17szA2.Fpx0eTW.omorTq/pEzI54AJTJ5Gw48fTqvyS','jeffrey.stark@hotmail.com'),(16,'maragret.toy','$2a$10$AJwGRKvSTTbW2kAY5GQiYemvp/DcN/3w45EjD1xJzoT0KrN04S96i','arlena.ward@gmail.com'),(17,'shawnta.gerlach','$2a$10$wk6Jt8iAmWYtBRqDHANGNuJrguyFGAA8H0Xz8eULfZ8/vMVI66CgO','dixie.yundt@yahoo.com'),(18,'christy.mayert','$2a$10$0/LlH.I2XrPNae12FNEn2.m8cdQwVvLMGap3GceQm8eFS3dLj8piS','marina.hane@yahoo.com'),(19,'cheyenne.kuhic','$2a$10$5UZP.T55Wp1uyJRiqAJBQu57YuWf8utd5Wpoi1PxgUZRZFOnWnQDK','buster.hermann@yahoo.com'),(20,'lavonia.konopelski','$2a$10$Nem9mEC0phetz01ohXIkO.5QPgs4X1Oa4969mdR2XgEcaLJTaewzO','susanne.toy@hotmail.com'),(21,'douglass.beahan','$2a$10$n2SR3tAkhVXKaMlrYoM30.vBEPOgdA1rfa/1Gm3sVeMNQRlNK55QC','hyun.leuschke@hotmail.com'),(22,'jone.nicolas','$2a$10$4e6I8NH5xJ5VTDE.Q4lBz.WvSJM4f4OwH0dqGk2yyKRizQ6BodJ.S','lincoln.shields@hotmail.com'),(23,'cherise.heidenreich','$2a$10$DYNOijpU8Hr6WAB0IYBULOPrDnk6.dyeyQitYz//B.AMq2y9tKOGe','cheyenne.purdy@yahoo.com'),(24,'roselee.funk','$2a$10$I4DrJpd3f4Xyxj4KSRVr0eEEd7xmOJxfHvdV3VPXS9Ebv20doVkiC','rosario.mcclure@hotmail.com'),(25,'isreal.macgyver','$2a$10$q3sqJ/2aqU1w9PR21sp0Jef7H8yQk5KjaTiSyuk3G2mygLeu/buDy','so.wyman@hotmail.com'),(26,'alaine.corwin','$2a$10$kok3Qfm2w0jriLHY6pbtQuvVHEfbBt6O0gzaLZVqcOjzgRBLI4eFS','adalberto.gutmann@gmail.com'),(27,'maegan.stokes','$2a$10$P8K1ZlELJbrXSFT518u8tOzNL.aW8lIKOEBzpJE17E6nl6IR.hrFe','michel.waters@gmail.com'),(28,'donovan.daniel','$2a$10$3pTWGJHL9E0AX/YGoXi4IuSAVZeuPw/HXpCsdY5dVFSz.Cd/e/Lbq','antoine.rodriguez@yahoo.com'),(29,'vanita.crist','$2a$10$CqaFgL0JZKDgGK.Zq2pbLOr5LhBTle0iMnE2rBCyLy4SmmCRq9J2q','ben.paucek@gmail.com'),(30,'ricky.zieme','$2a$10$DfMVaAFP9eZ0XvSY7FToze27OHBZZB4Tbn8JuwY9feN6irlNH0xgO','sharmaine.dietrich@hotmail.com'),(31,'randolph.romaguera','$2a$10$9lZBYf74C0bmbKaWqJfvI.610edFrUp0Kshie55hvaisx2LqwtbbG','spencer.fahey@gmail.com'),(32,'rocio.gulgowski','$2a$10$2VKVyNzvMsQa1m.xwkjvj.dKCMuaECJWHwdujQyHfvU68sLkmWDwi','angel.schuster@hotmail.com'),(33,'julissa.bednar','$2a$10$1kqC9KMlxNNfoLms8teDcu1oDZifSg3t.2vNezdajschqhce3qApu','tyree.doyle@hotmail.com'),(34,'sofia.upton','$2a$10$W5wRAU3x68/2gsGOz8Y4rugF9VjM3By3mDQ/jp1F64.n0F3WpahtC','dale.lakin@gmail.com'),(35,'gerald.willms','$2a$10$OqxzHiI4ervusDad74mrkeQTwvdAQusYkOBjHMgs5Aa5X7Pt9rjK2','augustus.blanda@gmail.com'),(36,'lauran.feest','$2a$10$X.BEL32IdZghJWW1xzUnue2/lwEYYfSHHOuhRT68FtCxKeJwAdm8i','refugia.dooley@yahoo.com'),(37,'hai.homenick','$2a$10$BtbPk9fT5keaEqBu7buxcOfyWD5pXVgBepsmb1i8p56RNjQL4hMGS','pedro.oberbrunner@hotmail.com'),(38,'carey.mertz','$2a$10$68ZBkjCsA6BnpWO1ZMZTkePyEvarhGUpcQ/MZzU8kGFNvqZIcN5y2','george.wolf@yahoo.com'),(39,'ignacio.pacocha','$2a$10$XKHLrSWetmRTWjje5p3uIecVs8nmgangt/aqf1yFyss9csJzzbLae','vincenzo.kshlerin@gmail.com'),(40,'saul.sporer','$2a$10$ss8yERPC49LBBY1irNotc.Q8OxNyTuTIFH2WAumX8KWnCf/N.unBS','alphonso.fisher@hotmail.com'),(41,'adaline.streich','$2a$10$zNxGNkV985u8x6p0XTNA7.G3WFLYUhFeKJxeqBjUhuOioPilCMzuS','laure.kessler@hotmail.com'),(42,'agatha.rath','$2a$10$O2KpOTaIclKmKJnD3ACzn.tgWr4Xgr4KRShycupbV05S3MZz4htFq','delana.schneider@yahoo.com'),(43,'ayanna.bahringer','$2a$10$UyRnGaGarNYni.UYUxaNQuiA5FRdSm6XkCF5AsZzFcLAJwBoUuAw2','lady.balistreri@gmail.com'),(44,'jacquelin.gutkowski','$2a$10$aBq2J24zFFJHxYgI.afBT./6VTH93/5FLmZVpRIBFzH6UvussLiyS','haywood.hessel@gmail.com'),(45,'gala.bogisich','$2a$10$kx2UUGMMJSE6Y1wzAiDg8uIKlpNjXxtEqgExnFjxd6Z7KkmmlBqYu','angelika.bogisich@yahoo.com'),(46,'luther.rodriguez','$2a$10$Liq1WPqeq1w9.qqzShjSMuFNSTRWLBJI5haFs/IMmlseA/FsFeQg6','romeo.schoen@gmail.com'),(47,'guadalupe.kunze','$2a$10$GF6ioCPn7iDc2thYD01X3.fF4S1gFd.75cXOT9hxlcccNM2mT3ow.','laverne.botsford@hotmail.com'),(48,'marilee.cormier','$2a$10$Y5A6vMxB87fV.t2DA8gjKOZYpCfF5jfHuCPQrIh2ye.O4igkkW9iu','earle.maggio@gmail.com'),(49,'demarcus.ondricka','$2a$10$Qlaj3LlFpASucRt1JE0wIuEs7GwdmqcxgDzIcVqxoGVOyCPs1fcem','nia.rogahn@gmail.com'),(50,'scott.bernhard','$2a$10$ILS4SsgoCwR1rjf84OyS3e9Gm/FAeDuwrcWjR88LUpRODWkmywcIy','bruno.jacobi@yahoo.com');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'npedidos'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-23  0:07:15
