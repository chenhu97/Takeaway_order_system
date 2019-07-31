drop table if EXISTS foods;

create table if not EXISTS foods(
FoodId INT not null AUTO_INCREMENT COMMENT'菜品id',
StoreId BIGINT not null COMMENT'店铺id',
CatId INT not null COMMENT'菜品类目id',
FoodName VARCHAR(20) not null COMMENT'菜品名称',
Remark VARCHAR(10) not null COMMENT'备注',
Picpath VARCHAR(50) not null COMMENT'图片路径',
Price int not null COMMENT'价格',
CreateOn datetime default now() COMMENT'创建时间',
	PRIMARY KEY(FoodId)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜品表';

Alter table foods 
add constraint FK_foods_catId_footcat_catId FOREIGN KEY(CatId) REFERENCES foodcat(CatId);
Alter table foods 
add constraint FK_foods_storeId_store_storeId FOREIGN KEY(StoreId) REFERENCES store(StoreId);