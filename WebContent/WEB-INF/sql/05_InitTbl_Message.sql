-- 2.Order 留言

SET FOREIGN_KEY_CHECKS = 0;
-- ------------------------
-- TABLE structure for 'message'
-- ------------------------
Drop TABLE IF EXISTS `message`;

CREATE TABLE `message`(
		`messageId` INT(18) NOT NULL AUTO_INCREMENT COMMENT '留言编号',
		`storeId` INT(18) NOT NULL COMMENT '店铺Id',
		`orderId` INT(18) NOT NULL  COMMENT '订单编号,外键',
		`userId` INT(18) NOT NULL COMMENT '用户编号,外键',
		`createOn` datetime NOT NULL DEFAULT NOW() COMMENT '创建时间',
		`content` VARCHAR(250) NULL DEFAULT '' COMMENT '评论内容',
		PRIMARY KEY (`messageId`) 
)ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '留言';
	
-- 添加约束
-- 添加唯一约束
