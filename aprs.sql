/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.5.52 : Database - aprs
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`aprs` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;

USE `aprs`;

/*Table structure for table `employee` */

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `employee_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '员工编号',
  `name` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '员工名字',
  `password` int(20) NOT NULL COMMENT '密码',
  PRIMARY KEY (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `employee` */

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `product_id` int(10) NOT NULL COMMENT '商品编号',
  `name` varchar(30) COLLATE utf8_bin NOT NULL COMMENT '商品名称',
  `product_spec` int(10) DEFAULT NULL COMMENT '商品规格',
  `sale_price` decimal(10,0) NOT NULL COMMENT '售价',
  `quantity` int(10) DEFAULT NULL COMMENT '库存数量',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `product` */

/*Table structure for table `purchaseorder` */

DROP TABLE IF EXISTS `purchaseorder`;

CREATE TABLE `purchaseorder` (
  `purchaseOrder_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '采购单号',
  `date` date NOT NULL COMMENT '采购时间',
  `employee_name` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '采购人',
  PRIMARY KEY (`purchaseOrder_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `purchaseorder` */

/*Table structure for table `purchaseorder_detail` */

DROP TABLE IF EXISTS `purchaseorder_detail`;

CREATE TABLE `purchaseorder_detail` (
  `purchaseOrder_id` int(10) NOT NULL COMMENT '采购单号',
  `product_id` int(10) NOT NULL COMMENT '商品号',
  `quantity` int(10) NOT NULL COMMENT '数量',
  `price` decimal(10,0) NOT NULL COMMENT '进货价',
  `name` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '商品名字',
  `spec` int(10) DEFAULT NULL COMMENT '规格',
  PRIMARY KEY (`purchaseOrder_id`,`product_id`),
  KEY `product_id` (`product_id`),
  CONSTRAINT `purchaseorder_detail_ibfk_1` FOREIGN KEY (`purchaseOrder_id`) REFERENCES `purchaseorder` (`purchaseOrder_id`),
  CONSTRAINT `purchaseorder_detail_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `purchaseorder_detail` */

/*Table structure for table `sale` */

DROP TABLE IF EXISTS `sale`;

CREATE TABLE `sale` (
  `sale_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '销售单号',
  `sale_date` date NOT NULL COMMENT '销售时间',
  `sum` decimal(10,0) NOT NULL COMMENT '总额',
  PRIMARY KEY (`sale_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `sale` */

/*Table structure for table `saledetail` */

DROP TABLE IF EXISTS `saledetail`;

CREATE TABLE `saledetail` (
  `sale_id` int(10) NOT NULL COMMENT '销售单号',
  `producet_id` int(10) NOT NULL COMMENT '商品号',
  `product_name` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '商品名',
  `spec` int(10) DEFAULT NULL COMMENT '规格',
  `quantity` int(10) NOT NULL COMMENT '数量',
  `sale_price` decimal(10,0) NOT NULL COMMENT '售价',
  `sum_price` decimal(10,0) NOT NULL COMMENT '总价',
  PRIMARY KEY (`sale_id`,`producet_id`),
  KEY `producet_id` (`producet_id`),
  CONSTRAINT `saledetail_ibfk_1` FOREIGN KEY (`sale_id`) REFERENCES `sale` (`sale_id`),
  CONSTRAINT `saledetail_ibfk_2` FOREIGN KEY (`producet_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `saledetail` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
