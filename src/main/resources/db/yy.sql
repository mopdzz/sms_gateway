# MySQL-Front 5.1  (Build 2.7)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;


# Host: localhost    Database: test
# ------------------------------------------------------
# Server version 5.1.56-community

#
# Source for table tbl_user
#

CREATE TABLE `tbl_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `passwd` varchar(20) DEFAULT NULL,
  `role` int(11) DEFAULT '10',
  `ctime` datetime DEFAULT NULL,
  `utime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

#
# Dumping data for table tbl_user
#

INSERT INTO `tbl_user` (`id`,`name`,`passwd`,`role`,`ctime`,`utime`) VALUES (1,'test','test',1,'2014-12-12','2014-12-12');
INSERT INTO `tbl_user` (`id`,`name`,`passwd`,`role`,`ctime`,`utime`) VALUES (29,'name','passwd',10,'2014-12-18 23:03:07','2014-12-18 23:03:07');

/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
