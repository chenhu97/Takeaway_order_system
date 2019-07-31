SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for orderitem
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem` (
  `orderItemId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单项编号',
	`orderId` bigint(20) NOT NULL COMMENT '订单表',
  `storeId` bigint(20) NOT NULL COMMENT '外键,店铺Id',
  `foodName` VARCHAR(50) NOT NULL COMMENT '商品名称',
  `quantity` int(11) NOT NULL COMMENT '数量',
  PRIMARY KEY (`orderItemId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='订单项表';