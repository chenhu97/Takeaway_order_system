-- StoreCat 店铺类目

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `storecat`;

CREATE TABLE `storecat`(
		`storeCatId` INT NOT NULL AUTO_INCREMENT COMMENT '店铺类目编号',
		`storeCatName` VARCHAR(20) NOT NULL COMMENT '类目名称',
		PRIMARY KEY (`storeCatId`)
)ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT = '店铺类目';

-- 添加约束
-- 添加唯一约束

ALTER TABLE `storecat`
	ADD CONSTRAINT UQ_storecat_storeCatName UNIQUE (`storeCatName`);