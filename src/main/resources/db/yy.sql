# MySQL-Front 5.1  (Build 2.7)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;


# Host: localhost    Database: yy
# ------------------------------------------------------
# Server version 5.1.56-community

USE `yy`;

#
# Source for table mobilelocation
#

CREATE TABLE `mobilelocation` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(20) DEFAULT NULL,
  `province` varchar(20) DEFAULT NULL,
  `city` varchar(30) DEFAULT NULL,
  `ctime` datetime DEFAULT NULL,
  `utime` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=236655 DEFAULT CHARSET=utf8;

#
# Source for table sms_bill_log
#

CREATE TABLE `sms_bill_log` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `mobile` varchar(20) DEFAULT NULL,
  `spnum` varchar(20) DEFAULT NULL,
  `msg` varchar(200) DEFAULT NULL,
  `linkid` varchar(50) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `btime` datetime DEFAULT NULL,
  `etime` datetime DEFAULT NULL,
  `province` varchar(20) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `fee` int(11) DEFAULT NULL,
  `sfid` int(11) DEFAULT NULL,
  `cpid` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `syncurl` varchar(200) DEFAULT NULL,
  `parentid` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

#
# Source for table sms_bill_temp
#

CREATE TABLE `sms_bill_temp` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `mobile` varchar(20) DEFAULT NULL,
  `spnum` varchar(20) DEFAULT NULL,
  `msg` varchar(200) DEFAULT NULL,
  `linkid` varchar(50) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `btime` datetime DEFAULT NULL,
  `etime` datetime DEFAULT NULL,
  `province` varchar(20) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `fee` int(11) DEFAULT NULL,
  `sfid` int(11) DEFAULT NULL,
  `cpid` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `sendnum` int(11) DEFAULT NULL,
  `syncurl` varchar(200) DEFAULT NULL,
  `parentid` int(11) DEFAULT NULL,
  `flag` varchar(255) DEFAULT NULL COMMENT '1  上行  2 状态报告  4 完整',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Source for table sms_month_bill_log
#

CREATE TABLE `sms_month_bill_log` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `mobile` varchar(20) DEFAULT NULL,
  `spnum` varchar(30) DEFAULT NULL,
  `msg` varchar(200) DEFAULT NULL,
  `linkid` varchar(50) DEFAULT NULL,
  `regtype` varchar(20) DEFAULT NULL,
  `btime` datetime DEFAULT NULL,
  `etime` datetime DEFAULT NULL,
  `province` varchar(20) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `fee` int(11) DEFAULT NULL,
  `sfid` int(11) DEFAULT NULL,
  `cpid` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `parentid` int(11) DEFAULT NULL,
  `syncurl` varchar(200) DEFAULT NULL,
  `remark` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=145298 DEFAULT CHARSET=utf8;

#
# Source for table sms_wo_bill_log
#

CREATE TABLE `sms_wo_bill_log` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `cpid` int(11) DEFAULT NULL,
  `randomid` varchar(20) DEFAULT NULL,
  `outTradeNo` varchar(50) DEFAULT NULL,
  `timeStamp` varchar(20) DEFAULT NULL,
  `subject` varchar(50) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `quantity` int(10) DEFAULT NULL,
  `totalFee` decimal(10,2) DEFAULT NULL,
  `cpamount` decimal(10,2) DEFAULT NULL,
  `callbackUrl` varchar(200) DEFAULT NULL,
  `callbackData` varchar(50) DEFAULT NULL,
  `appKey` varchar(50) DEFAULT NULL,
  `appName` varchar(50) DEFAULT NULL,
  `iapId` varchar(50) DEFAULT NULL,
  `imsi` varchar(50) DEFAULT NULL,
  `imei` varchar(50) DEFAULT NULL,
  `signature` varchar(100) DEFAULT NULL,
  `resultCode` varchar(20) DEFAULT NULL,
  `resultDescription` varchar(100) DEFAULT NULL,
  `transactionId` varchar(50) DEFAULT NULL,
  `sms` varchar(200) DEFAULT NULL,
  `accessNo` varchar(50) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `chargeResultCode` varchar(100) DEFAULT NULL,
  `syncFlg` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT '0',
  `ctime` datetime DEFAULT NULL,
  `utime` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `inx_wo_linkid` (`transactionId`),
  KEY `inx_wo_cpid` (`cpid`),
  KEY `ind_wo_appkey` (`appKey`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

#
# Source for table tbl_bill_log
#

CREATE TABLE `tbl_bill_log` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `caller` varchar(20) DEFAULT NULL,
  `called` varchar(20) DEFAULT NULL,
  `btime` datetime DEFAULT NULL,
  `etime` datetime DEFAULT NULL,
  `province` varchar(20) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `time` int(11) DEFAULT NULL,
  `fee` int(11) DEFAULT NULL,
  `sfid` int(11) DEFAULT NULL,
  `cpid` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `syncurl` varchar(200) DEFAULT NULL,
  `parentid` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Source for table tbl_bill_temp
#

CREATE TABLE `tbl_bill_temp` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `caller` varchar(20) DEFAULT NULL,
  `called` varchar(20) DEFAULT NULL,
  `btime` datetime DEFAULT NULL,
  `etime` datetime DEFAULT NULL,
  `province` varchar(20) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `time` int(11) DEFAULT NULL,
  `fee` int(11) DEFAULT NULL,
  `sfid` int(11) DEFAULT NULL,
  `cpid` int(11) DEFAULT NULL,
  `sendnum` int(11) DEFAULT NULL,
  `syncurl` varchar(255) DEFAULT NULL,
  `parentid` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Source for table tbl_cp_appinfo
#

CREATE TABLE `tbl_cp_appinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cpid` int(11) DEFAULT NULL,
  `appname` varchar(100) DEFAULT NULL,
  `appkey` varchar(10) DEFAULT NULL,
  `subject` varchar(100) DEFAULT NULL,
  `iapid` varchar(10) DEFAULT NULL,
  `ctime` datetime DEFAULT NULL,
  `utime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

#
# Source for table tbl_cp_called
#

CREATE TABLE `tbl_cp_called` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `cpid` int(11) DEFAULT NULL,
  `called` varchar(50) DEFAULT NULL,
  `cpname` varchar(20) DEFAULT NULL,
  `daylimit` int(11) DEFAULT NULL,
  `monthlimit` int(11) DEFAULT NULL,
  `reduce` int(11) DEFAULT NULL,
  `ctime` datetime DEFAULT NULL,
  `utime` datetime DEFAULT NULL,
  `blackinfo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

#
# Source for table tbl_menu
#

CREATE TABLE `tbl_menu` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `target` varchar(20) DEFAULT NULL,
  `icon` varchar(20) DEFAULT NULL,
  `parentId` int(11) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `ctime` datetime DEFAULT NULL,
  `utime` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

#
# Source for table tbl_mh_called_number
#

CREATE TABLE `tbl_mh_called_number` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `called` varchar(50) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `ctime` datetime DEFAULT NULL,
  `utime` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE KEY `idx_called` (`called`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

#
# Source for table tbl_month
#

CREATE TABLE `tbl_month` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `spid` int(11) DEFAULT NULL,
  `mobileno` varchar(20) DEFAULT NULL,
  `requesttime` varchar(20) DEFAULT NULL,
  `proviecode` varchar(20) DEFAULT NULL,
  `ringno` varchar(20) DEFAULT NULL,
  `subchannelid` varchar(20) DEFAULT NULL,
  `ordertype` varchar(20) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `ctime` datetime DEFAULT NULL,
  `utime` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4397 DEFAULT CHARSET=utf8;

#
# Source for table tbl_noprovice_code
#

CREATE TABLE `tbl_noprovice_code` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `caller` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Source for table tbl_province_reduce
#

CREATE TABLE `tbl_province_reduce` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `called` varchar(30) DEFAULT NULL,
  `province` varchar(20) DEFAULT NULL,
  `reduce` int(11) DEFAULT NULL,
  `daylimit` int(11) DEFAULT NULL,
  `monthlimit` int(11) DEFAULT NULL,
  `ctime` datetime DEFAULT NULL,
  `utime` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=236 DEFAULT CHARSET=utf8;

#
# Source for table tbl_role_menu
#

CREATE TABLE `tbl_role_menu` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `roleid` int(11) DEFAULT NULL,
  `menuid` int(11) DEFAULT NULL,
  `ctime` datetime DEFAULT NULL,
  `utime` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

#
# Source for table tbl_servicenum
#

CREATE TABLE `tbl_servicenum` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `opid` int(11) DEFAULT NULL,
  `spid` int(11) DEFAULT NULL,
  `spname` varchar(20) DEFAULT NULL,
  `called` varchar(50) DEFAULT NULL,
  `fee` int(11) DEFAULT NULL,
  `daylimit` int(11) DEFAULT NULL,
  `monthlimit` int(11) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `memo` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `ctime` datetime DEFAULT NULL,
  `utime` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

#
# Source for table tbl_spinfo
#

CREATE TABLE `tbl_spinfo` (
  `Id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `opid` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `contact` varchar(20) DEFAULT NULL,
  `syncurl` varchar(255) DEFAULT NULL,
  `memo` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `ctime` datetime DEFAULT NULL,
  `utime` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

#
# Source for table tbl_user
#

CREATE TABLE `tbl_user` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `passwd` varchar(20) DEFAULT NULL,
  `showname` varchar(20) DEFAULT NULL,
  `parentId` int(11) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  `ip` varchar(20) DEFAULT NULL,
  `contactMan` varchar(20) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `bankAccount` varchar(30) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `syncurl` varchar(255) DEFAULT NULL,
  `ctime` datetime DEFAULT NULL,
  `utime` datetime DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
