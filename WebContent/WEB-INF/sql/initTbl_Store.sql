/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50718
Source Host           : localhost:23306
Source Database       : tos

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2019-07-04 20:00:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for store
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store` (
  `StoreId` bigint NOT NULL AUTO_INCREMENT COMMENT '店铺id',
  `StoreName` varchar(20) NOT NULL COMMENT '店铺名称',
  `StoreLogName` varchar(20) NOT NULL COMMENT '店铺账号',
  `StorePass` varchar(20) NOT NULL COMMENT '店铺登入密码',
  `StoreBoss` varchar(20) NOT NULL COMMENT '经营者',
  `Address` varchar(20) NOT NULL COMMENT '店铺地址',
  `Phone` bigint NOT NULL COMMENT '联系电话',
  `StorecatId` bigint NOT NULL COMMENT '路径',
  `Status` bigint NOT NULL COMMENT '状态',
	`announce` VARCHAR(255) NULL COMMENT '公告',
  `CreateOn` datetime DEFAULT NOW() COMMENT'创建时间',
 `Storepic` varchar(255) DEFAULT '' comment '图片路径',
  PRIMARY KEY (`StoreId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='店铺表';
ALTER TABLE `store`
Add CONSTRAINT `uq_store_StoreLogName` Unique Key(`StoreLogName`);
ALTER TABLE `store`
Add CONSTRAINT `uq_store_StoreName` Unique Key(`StoreName`);

-- ----------------------------
-- Records of store
-- ----------------------------
