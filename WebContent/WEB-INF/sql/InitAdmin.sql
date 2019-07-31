/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50718
Source Host           : localhost:23306
Source Database       : tos

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2019-07-05 18:54:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `AdminId` int(16) NOT NULL AUTO_INCREMENT COMMENT '会员id',
  `AdminName` varchar(250) NOT NULL COMMENT '会员名称',
  `AdminPass` varchar(250) NOT NULL COMMENT '会员密码',
  `AdminSex` varchar(250) NOT NULL COMMENT '性别',
  `Phone` BIGINT NOT NULL COMMENT '联系方式',
  PRIMARY KEY (`AdminId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员表';

-- ----------------------------
-- Records of admin
-- ----------------------------
