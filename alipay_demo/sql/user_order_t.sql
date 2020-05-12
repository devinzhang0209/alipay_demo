/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : order_db

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2020-05-12 15:37:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_order_t
-- ----------------------------
DROP TABLE IF EXISTS `user_order_t`;
CREATE TABLE `user_order_t` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单Id',
  `user_id` varchar(64) DEFAULT NULL COMMENT '用户Id',
  `order_no` varchar(64) NOT NULL COMMENT '订单号',
  `order_amount` decimal(16,4) NOT NULL COMMENT '订单金额',
  `order_status` int(11) NOT NULL COMMENT '0 待付款 1 已付款 -1 已取消',
  `create_time` varchar(32) NOT NULL COMMENT '创建时间',
  `last_update_time` varchar(32) NOT NULL COMMENT '最后修改时间',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4;
