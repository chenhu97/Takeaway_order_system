DROP TABLE IF EXISTS Announce;
 CREATE TABLE Announce (
  AnnounceId bigint(18) NOT NULL AUTO_INCREMENT COMMENT '公告编号',
  AdminId bigint(18) NOT NULL   COMMENT '管理员id,外键',
	Title VARCHAR(50) not NULL DEFAULT '最新公告' COMMENT '公告标题',
  Content varchar(200) NOT NULL DEFAULT '' COMMENT '内容',
	PicPath VARCHAR(200) DEFAULT '' COMMENT '公告图片路径',
  CreateOn datetime DEFAULT now() COMMENT '创建时间',
  UpdateOn datetime DEFAULT now() COMMENT '更新时间',
  PRIMARY KEY (AnnounceId)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='公告表';
