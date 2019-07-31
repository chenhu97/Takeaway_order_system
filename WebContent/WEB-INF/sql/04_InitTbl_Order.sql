-- 1.Order 订单表

SET FOREIGN_KEY_CHECKS = 0;
-- ------------------------
-- TABLE structure for `order`
-- ------------------------
Drop TABLE IF EXISTS `order`;

CREATE TABLE `order`(
		`orderId` BIGINT NOT NULL AUTO_INCREMENT COMMENT '订单编号',
		`payId` BIGINT NOT NULL COMMENT '支付编号',
		`userId` INT NOT NULL COMMENT '外键,用户编号',
		`money` DOUBLE NOT NULL COMMENT '订单付款金额',
		`status` INT(5) NOT NULL COMMENT '订单状态',
		`remark` VARCHAR(50) NULL COMMENT '备注',
 	   `createOn` datetime NOT NULL DEFAULT NOW() COMMENT '创建时间',
		`updateOn` datetime NOT NULL DEFAULT NOW() COMMENT '修改时间',
		 PRIMARY KEY (`orderId`)
)ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '订单表';
	
-- 添加约束
-- 添加唯一约束
