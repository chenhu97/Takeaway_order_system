DROP TABLE IF EXISTS ShopCart
 CREATE TABLE ShopCart (
  CartId bigint(18) NOT NULL AUTO_INCREMENT COMMENT '购物车编号',
  FoodId bigint(18) NOT NULL   COMMENT '菜品id,外键',
  Quantity bigint(18)  NOT NULL COMMENT '数量',
  UserId bigint(18) NOT NULL COMMENT '用户id',
  CreateOn datetime DEFAULT now() COMMENT '创建时间',
  UpdateOn datetime DEFAULT now() COMMENT '更新时间',
  PRIMARY KEY (CartId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='购物车表';
