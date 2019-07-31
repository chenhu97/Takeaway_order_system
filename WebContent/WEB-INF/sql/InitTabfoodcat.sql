drop table if EXISTS foodcat;

create table if not EXISTS foodcat(
catId INT not null AUTO_INCREMENT COMMENT'类目编号',
catName VARCHAR(20) not null COMMENT'类目名称',
remark VARCHAR(50) not null COMMENT'备注',
createOn datetime default now() null COMMENT'创建时间',
	PRIMARY KEY(catId)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜品类目表';