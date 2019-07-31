/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50718
Source Host           : localhost:23306
Source Database       : tos

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2019-07-05 18:54:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for orderrecord
-- ----------------------------
DROP TABLE IF EXISTS `orderrecord`;
CREATE TABLE `orderrecord` (
  `RecordId` int(16) NOT NULL AUTO_INCREMENT COMMENT '历史订单编号',
  `StoreId` int(16) NOT NULL COMMENT '店铺id',
  `FoodId` int(16) NOT NULL COMMENT '商品编号',
  `Status` varchar(250) NOT NULL COMMENT '状态',
  `Price` int(16) NOT NULL COMMENT '价格',
  `CreateOn` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`RecordId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='历史订单表';

-- ----------------------------
-- Records of orderrecord
-- ----------------------------
