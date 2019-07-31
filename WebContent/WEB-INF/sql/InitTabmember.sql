drop table if EXISTS member;

create table if not EXISTS member(
UserId INT not null AUTO_INCREMENT COMMENT'用户编号',
UserName VARCHAR(20) not null COMMENT'用户名称',
NickName VARCHAR(20) not null COMMENT'昵称',
UserPass VARCHAR(30) not null COMMENT'密码',
Sex VARCHAR(2) not null COMMENT'性别',
Address VARCHAR(50) not null COMMENT'地址',
Phone BIGINT not null COMMENT'联系电话',
CreateOn datetime default now() null COMMENT'注册时间',
	PRIMARY KEY(UserId)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户';
ALTER TABLE member
Add CONSTRAINT CK_member_sex CHECK (Sex = '男' or Sex = '女');
ALTER TABLE member
Add CONSTRAINT UQ_member_userName UNIQUE(UserName);