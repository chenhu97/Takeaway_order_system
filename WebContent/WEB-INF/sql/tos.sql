/*
Navicat MySQL Data Transfer

Source Server         : blog4th
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : tos

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2019-07-15 13:54:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `AdminId` int(16) NOT NULL AUTO_INCREMENT COMMENT '会员id',
  `AdminName` varchar(250) NOT NULL COMMENT '会员名称',
  `AdminPass` varchar(250) NOT NULL COMMENT '会员密码',
  `AdminSex` varchar(250) NOT NULL COMMENT '性别',
  `Phone` int(50) NOT NULL COMMENT '联系方式',
  PRIMARY KEY (`AdminId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='管理员表';

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', 'admin', '123', '男', '1234567897');

-- ----------------------------
-- Table structure for announce
-- ----------------------------
DROP TABLE IF EXISTS `announce`;
CREATE TABLE `announce` (
  `AnnounceId` bigint(18) NOT NULL AUTO_INCREMENT COMMENT '公告编号',
  `AdminId` bigint(18) NOT NULL COMMENT '管理员id,外键',
  `Title` varchar(50) NOT NULL DEFAULT '最新公告' COMMENT '公告标题',
  `Content` varchar(200) NOT NULL DEFAULT '' COMMENT '内容',
  `PicPath` varchar(200) DEFAULT '' COMMENT '公告图片路径',
  `CreateOn` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `UpdateOn` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`AnnounceId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='公告表';

-- ----------------------------
-- Records of announce
-- ----------------------------
INSERT INTO `announce` VALUES ('1', '1', '一周品牌惠', '品牌正餐立减20元起', null, '2019-07-12 10:59:40', null);
INSERT INTO `announce` VALUES ('2', '1', '专星送', '轻盈一餐,点亮夏日味蕾', null, '2019-07-12 10:59:40', null);
INSERT INTO `announce` VALUES ('3', '1', '饿了么&大麦网', '莫文蔚25周年演唱会', null, '2019-07-12 10:59:40', null);
INSERT INTO `announce` VALUES ('4', '1', '首购超会', '超会月卡买一赠一', null, '2019-07-12 10:59:41', null);
INSERT INTO `announce` VALUES ('5', '1', '版本更新', '新版本上线,建议及时更新,享受新版本带来的优质服务', null, '2019-07-12 10:59:41', null);
INSERT INTO `announce` VALUES ('6', '2', '测试数据', '如果这条能够在非admin管理员进行跳转得到,则未设置防跳转过滤器', null, '2019-07-12 10:59:41', null);

-- ----------------------------
-- Table structure for favorite
-- ----------------------------
DROP TABLE IF EXISTS `favorite`;
CREATE TABLE `favorite` (
  `FavoriteId` int(11) NOT NULL AUTO_INCREMENT COMMENT '收藏列表id',
  `StoreId` bigint(20) NOT NULL COMMENT '店铺id',
  `UserId` bigint(20) NOT NULL COMMENT '用户id',
  PRIMARY KEY (`FavoriteId`),
  KEY `FK_favorite_StoreId_store_StoreId` (`StoreId`),
  CONSTRAINT `FK_favorite_StoreId_store_StoreId` FOREIGN KEY (`StoreId`) REFERENCES `store` (`StoreId`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='收藏表';

-- ----------------------------
-- Records of favorite
-- ----------------------------
INSERT INTO `favorite` VALUES ('13', '2', '1');

-- ----------------------------
-- Table structure for foodcat
-- ----------------------------
DROP TABLE IF EXISTS `foodcat`;
CREATE TABLE `foodcat` (
  `catId` int(11) NOT NULL AUTO_INCREMENT COMMENT '类目编号',
  `catName` varchar(20) NOT NULL COMMENT '类目名称',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  `StoreId` bigint(20) NOT NULL COMMENT '店铺id',
  `createOn` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`catId`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8 COMMENT='菜品类目表';

-- ----------------------------
-- Records of foodcat
-- ----------------------------
INSERT INTO `foodcat` VALUES ('21', '汉堡', null, '2', null);
INSERT INTO `foodcat` VALUES ('22', '饮料', null, '2', null);
INSERT INTO `foodcat` VALUES ('23', '小吃', null, '2', null);
INSERT INTO `foodcat` VALUES ('24', '鸡肉卷', null, '2', null);
INSERT INTO `foodcat` VALUES ('25', '果汁类', null, '11', null);
INSERT INTO `foodcat` VALUES ('26', '奶茶', null, '11', null);
INSERT INTO `foodcat` VALUES ('28', '找新鲜', null, '11', null);
INSERT INTO `foodcat` VALUES ('29', '周麻婆新品', null, '1', null);
INSERT INTO `foodcat` VALUES ('30', '麻婆经典', null, '1', null);
INSERT INTO `foodcat` VALUES ('31', '印度飞饼', null, '1', null);
INSERT INTO `foodcat` VALUES ('32', '麻婆特色', null, '1', null);
INSERT INTO `foodcat` VALUES ('33', '麻婆蒸品', null, '1', null);
INSERT INTO `foodcat` VALUES ('34', '麻婆煲仔', null, '1', null);
INSERT INTO `foodcat` VALUES ('35', '主食', null, '1', null);

-- ----------------------------
-- Table structure for foods
-- ----------------------------
DROP TABLE IF EXISTS `foods`;
CREATE TABLE `foods` (
  `FoodId` int(11) NOT NULL AUTO_INCREMENT COMMENT '菜品id',
  `StoreId` bigint(20) NOT NULL COMMENT '店铺id',
  `CatId` int(11) NOT NULL COMMENT '菜品类目id',
  `FoodName` varchar(20) NOT NULL COMMENT '菜品名称',
  `Remark` varchar(10) NOT NULL COMMENT '备注',
  `Picpath` varchar(50) NOT NULL COMMENT '图片路径',
  `Price` int(11) NOT NULL COMMENT '价格',
  `CreateOn` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`FoodId`),
  KEY `FK_foods_catId_footcat_catId` (`CatId`),
  KEY `FK_foods_storeId_store_storeId` (`StoreId`),
  CONSTRAINT `FK_foods_catId_footcat_catId` FOREIGN KEY (`CatId`) REFERENCES `foodcat` (`catId`),
  CONSTRAINT `FK_foods_storeId_store_storeId` FOREIGN KEY (`StoreId`) REFERENCES `store` (`StoreId`)
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8 COMMENT='菜品表';

-- ----------------------------
-- Records of foods
-- ----------------------------
INSERT INTO `foods` VALUES ('33', '2', '21', '香辣鸡腿堡', '绝壁不是人工鸡', '/upload/8bbd61779dee4a3d86fba12e03c598ef.jpg', '15', '2019-07-15 10:49:56');
INSERT INTO `foods` VALUES ('34', '2', '21', '番茄牛肉堡', '蔬菜和牛肉更配哦', '/upload/21c1f243d38444328a302fdaf0960e7c.jpg', '15', '2019-07-15 10:56:19');
INSERT INTO `foods` VALUES ('35', '2', '21', '至尊七虾堡', '美味虾肉', '/upload/59110a9c1bad480794737a4f861e9046.jpg', '16', '2019-07-15 10:59:17');
INSERT INTO `foods` VALUES ('36', '2', '21', '双层鸡腿堡', '双层更带劲', '/upload/554fadd3308242b085f669dda5ab32a9.jpg', '20', '2019-07-15 11:00:09');
INSERT INTO `foods` VALUES ('37', '2', '21', '新奥尔良鸡腿堡', '现烤鸡腿肉', '/upload/59875e6940e04bbe9fe7e6d43235b9a9.jpg', '15', '2019-07-15 11:01:06');
INSERT INTO `foods` VALUES ('38', '2', '22', '百事可乐（中杯）', '带冰块更带劲', '/upload/744ea11bf4624d0d930294d25e5c90d1.jpg', '10', '2019-07-15 11:03:45');
INSERT INTO `foods` VALUES ('39', '2', '22', '百事可乐（大杯）', '大杯更足', '/upload/e8fd83cc198743b8b2a34b4e8c09d300.jpg', '12', '2019-07-15 11:04:21');
INSERT INTO `foods` VALUES ('40', '2', '22', '美连达', '美连达', '/upload/3ef21dd597d7481ab18c3c7cd4fea5f2.jpg', '12', '2019-07-15 11:09:19');
INSERT INTO `foods` VALUES ('41', '2', '24', '墨西哥鸡肉卷', '墨西哥风味', '/upload/8651f9f4b65a4cb6b1d4daa66b6401a1.jpg', '15', '2019-07-15 11:11:40');
INSERT INTO `foods` VALUES ('42', '2', '24', '老北京鸡肉卷', '老北京地道风味', '/upload/c4befc1ee98649129521324c011534a7.jpg', '15', '2019-07-15 11:12:39');
INSERT INTO `foods` VALUES ('43', '2', '24', '奥尔良鸡肉卷', '奥尔良烤肉', '/upload/bf8ea26046584126b8fe18269afdb326.jpg', '15', '2019-07-15 11:13:14');
INSERT INTO `foods` VALUES ('44', '2', '23', '上校鸡块', '3快一份', '/upload/d11e51fc3aaf4ee0a1b830760dad997f.jpg', '16', '2019-07-15 11:14:02');
INSERT INTO `foods` VALUES ('45', '2', '23', '鸡米花', '盒装', '/upload/c7f355c489054940b92deee93a0a69e0.jpg', '8', '2019-07-15 11:14:37');
INSERT INTO `foods` VALUES ('46', '2', '23', '烤翅', '一对', '/upload/5c6af4fc6aac42e9b78abb47dfaf160c.jpg', '15', '2019-07-15 11:18:07');
INSERT INTO `foods` VALUES ('47', '2', '23', '炸翅', '一对', '/upload/5818a9411e2d46d3b864dd04ef2f6f67.jpg', '16', '2019-07-15 11:18:48');
INSERT INTO `foods` VALUES ('48', '2', '23', '薯条', '盒装', '/upload/41b147a9b0754e15b6e1dc9c71de1678.jpg', '15', '2019-07-15 11:19:17');
INSERT INTO `foods` VALUES ('49', '11', '25', '柠檬汁', '鲜榨柠檬汁，新鲜纯正', '/upload/6589856cb44a4d3eb723686244c1ac09.jpg', '12', null);
INSERT INTO `foods` VALUES ('50', '11', '25', '金桔柠檬', '鲜榨金桔汁加柠檬汁', '/upload/8ec03d7a71ee4188a971cf54bd4dd306.jpg', '13', null);
INSERT INTO `foods` VALUES ('51', '11', '25', '柠檬蜜', '鲜榨柠檬汁搭配蜂蜜', '/upload/3466ddfd2540440ca21ab66e54a2ac52.jpg', '17', null);
INSERT INTO `foods` VALUES ('52', '11', '25', '柠檬养乐多', '限制冷饮', '/upload/70e6d056b61c40c0aa747af986c005a2.jpg', '15', null);
INSERT INTO `foods` VALUES ('53', '11', '25', '蜜茶', '由蜂蜜和水搭配', '/upload/9d5d35fbc6a54819ad97ef0fcc15fbca.jpg', '15', null);
INSERT INTO `foods` VALUES ('54', '11', '28', '红茶玛奇朵', '拿铁系饮料', '/upload/e59091d64a324fe2a4f862a2b3a3b7f4.jpg', '15', null);
INSERT INTO `foods` VALUES ('55', '11', '26', '水果奶盖', '水果加鲜奶', '/upload/010263c94cbe40d69d579d77f6da4994.jpg', '16', '2019-07-15 12:08:02');
INSERT INTO `foods` VALUES ('56', '11', '26', '椰果奶茶', '经典奶茶', '/upload/f30b0526ecaf4d47b49a367089275631.jpg', '12', '2019-07-15 12:09:17');
INSERT INTO `foods` VALUES ('57', '11', '26', '珍珠奶茶', '珍珠多多', '/upload/e6a2f9f9d4c74750b12294226f7581e0.jpg', '12', '2019-07-15 12:09:50');
INSERT INTO `foods` VALUES ('58', '11', '26', '波霸奶茶', '店长推荐', '/upload/5392d7f2720c4a2abb5f3b5ba379b188.jpg', '15', null);
INSERT INTO `foods` VALUES ('59', '11', '25', '四季春茶', '好喝不腻', '/upload/2b6cc222da744dc1aedba2f14a941d95.jpg', '16', '2019-07-15 12:12:14');
INSERT INTO `foods` VALUES ('60', '1', '29', '海带苗排骨汤', '新品优惠', '/upload/61db7e7309014b68b8075541c9d73171.jpg', '33', '2019-07-15 12:40:31');
INSERT INTO `foods` VALUES ('61', '1', '29', '蛋香丝瓜', '新品优惠', '/upload/83e51508707045fb9fe5b9fef916f72e.jpg', '17', '2019-07-15 12:43:20');
INSERT INTO `foods` VALUES ('62', '1', '29', '上汤红觅茶', '新品优惠', '/upload/635d79bf57904c25b2efa2389ffc338d.jpg', '21', '2019-07-15 12:45:00');
INSERT INTO `foods` VALUES ('63', '1', '29', '水煮牛肉', '新品优惠', '/upload/916dde58b6fb4d38aaccdfcc05a80789.jpg', '49', '2019-07-15 12:45:35');
INSERT INTO `foods` VALUES ('64', '1', '30', '笋干五花肉', '新鲜笋干加优质五花肉', '/upload/df21a25f35e2402aadde7b326e170004.jpg', '22', '2019-07-15 12:48:03');
INSERT INTO `foods` VALUES ('65', '1', '30', '麻婆豆腐', '进店必点', '/upload/17378f206a7e4f278ad97f408690079b.jpg', '2', '2019-07-15 12:48:45');
INSERT INTO `foods` VALUES ('66', '1', '30', '麻婆酸菜鱼', '酸菜开胃', '/upload/31955dbc5eb74e10886dd163ba67d530.png', '38', '2019-07-15 12:49:50');
INSERT INTO `foods` VALUES ('67', '1', '30', '麻婆脆皮鸭', '经典好吃', '/upload/2e26772bee614843b673aee4352dd9cd.png', '28', '2019-07-15 12:50:39');
INSERT INTO `foods` VALUES ('68', '1', '29', '麻婆怀旧水煮鱼', '怀旧不过时', '/upload/f8319b19c90340b1afacdf732c7f964a.png', '38', '2019-07-15 12:51:45');
INSERT INTO `foods` VALUES ('69', '1', '30', '麻婆水煮三国', '水煮三国', '/upload/481dbb13c75249aa9a44e4e2804591b1.png', '36', '2019-07-15 12:52:39');
INSERT INTO `foods` VALUES ('70', '1', '30', '紫苏田鸡王', '田鸡王', '/upload/3bb32af00b4b49f09d8254aa5b2152e1.png', '47', '2019-07-15 12:53:15');
INSERT INTO `foods` VALUES ('71', '1', '30', '周麻婆飘香鱼', '飘香鱼', '/upload/94cb3d8ff9ca4e7892bd672f96749cdf.jpg', '68', '2019-07-15 12:54:18');
INSERT INTO `foods` VALUES ('72', '1', '30', '剁椒鱼头', '剁椒鱼头', '/upload/e29891d09e6544c2aee66ccc68873a5d.jpg', '34', '2019-07-15 12:54:46');
INSERT INTO `foods` VALUES ('73', '1', '31', '榴莲飞饼', '口味独特', '/upload/76c2e4b0371c4f638aa2571fe564b5f3.jpg', '28', '2019-07-15 12:56:44');
INSERT INTO `foods` VALUES ('74', '1', '31', '麻辣飞饼', '加辣', '/upload/1945f03a1bb742c894c1952abe8059d4.jpg', '19', '2019-07-15 12:57:17');
INSERT INTO `foods` VALUES ('75', '1', '29', '葱花飞饼', '葱花飞饼', '/upload/dd65cd579cc5442baa874bc5beb4bd60.jpg', '19', '2019-07-15 12:57:46');
INSERT INTO `foods` VALUES ('76', '1', '29', '蛋黄香葱飞饼', '（咸）', '/upload/69110088c8944605bcc19980a280b972.jpg', '19', '2019-07-15 12:58:20');
INSERT INTO `foods` VALUES ('77', '1', '31', '香肉飞腿火饼', '（咸）', '/upload/cbe92a52bc8a4411a60bfeb1b23522a4.jpg', '19', '2019-07-15 12:58:50');
INSERT INTO `foods` VALUES ('78', '1', '31', '水果双拼飞饼', '（甜）', '/upload/98fa7d8b6c71481bb9e418f14ced7934.jpg', '19', '2019-07-15 12:59:25');
INSERT INTO `foods` VALUES ('79', '1', '32', '泰式咖喱鸡', '咖喱鸡', '/upload/851f474a77914e4f8d5313745570d57a.jpg', '36', '2019-07-15 13:00:38');
INSERT INTO `foods` VALUES ('80', '1', '32', '乡村回锅肉', '独特回锅肉', '/upload/1ebc6064fdce45cc8bf8014e8aa49c1b.png', '20', '2019-07-15 13:01:25');
INSERT INTO `foods` VALUES ('81', '1', '32', '可乐排骨', '可乐排骨', '/upload/1ba0906a1c7942d1970e036dcf7622b4.jpg', '35', '2019-07-15 13:07:20');
INSERT INTO `foods` VALUES ('82', '1', '32', '榕城荔枝肉', '荔枝肉', '/upload/78e2a8c2ccf141cc8c3b8e27a765bea8.png', '20', '2019-07-15 13:09:07');
INSERT INTO `foods` VALUES ('83', '1', '32', '农家小炒肉', '小炒肉', '/upload/9a0f9d9b236249e7a5eee18e0a20485c.png', '25', '2019-07-15 13:09:52');
INSERT INTO `foods` VALUES ('84', '1', '35', '蟹田米饭', '管饱', '/upload/0addea15b4e04c69875856c094674384.jpg', '2', '2019-07-15 13:12:41');
INSERT INTO `foods` VALUES ('85', '1', '35', '芋泥酥', '清脆爽口', '/upload/7a7c30234ea64b77807da424d07f304c.jpg', '9', '2019-07-15 13:13:20');
INSERT INTO `foods` VALUES ('86', '1', '34', '石锅鲜笋', '新鲜竹笋', '/upload/62e08ef853fc4cc994ce5eacfe0398a7.png', '20', '2019-07-15 13:14:45');
INSERT INTO `foods` VALUES ('87', '1', '34', '石锅鸭血', '大补血', '/upload/ea9afbe1e06b43f2b33073d06bbee303.png', '15', '2019-07-15 13:15:31');
INSERT INTO `foods` VALUES ('88', '1', '33', '营养蒸蛋', '营养美容', '/upload/643897904aaa43c1b7fc9357efd844be.png', '13', '2019-07-15 13:16:48');
INSERT INTO `foods` VALUES ('89', '1', '33', '双味鱼头', '多滋多味', '/upload/14851a87bd2942cb9eb80eab9fbcbf98.png', '41', '2019-07-15 13:18:06');
INSERT INTO `foods` VALUES ('90', '1', '33', '梅菜扣肉', '梅菜扣肉', '/upload/3e07cf3c2818419c909727a7e8a393af.jpg', '26', '2019-07-15 13:18:40');

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `UserId` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `UserName` varchar(20) NOT NULL COMMENT '用户名称',
  `NickName` varchar(20) NOT NULL COMMENT '昵称',
  `UserPass` varchar(10) NOT NULL COMMENT '密码',
  `Sex` varchar(2) NOT NULL COMMENT '性别',
  `Address` varchar(50) NOT NULL COMMENT '地址',
  `Phone` bigint(20) NOT NULL COMMENT '联系电话',
  `CreateOn` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  PRIMARY KEY (`UserId`),
  UNIQUE KEY `UQ_member_userName` (`UserName`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('1', 'user1', '用户1', '123', '男', '连江', '13067251625', '2019-01-01 00:00:00');
INSERT INTO `member` VALUES ('2', 'user2', '用户2', '123', '女', '马尾', '13067251625', '2019-01-02 00:00:00');
INSERT INTO `member` VALUES ('3', 'user3', '用户3', '123', '男', '台江', '13067251625', '2019-01-03 00:00:00');
INSERT INTO `member` VALUES ('4', 'user4', '用户4', '123', '男', '鼓楼', '13067251625', '2019-01-04 00:00:00');
INSERT INTO `member` VALUES ('5', 'user5', '用户5', '123', '男', '仓山', '13067251625', '2019-01-05 00:00:00');
INSERT INTO `member` VALUES ('6', 'user6', '用户6', '123', '男', '城门', '13067251625', '2019-01-06 00:00:00');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `storeId` bigint(18) NOT NULL,
  `messageId` int(18) NOT NULL AUTO_INCREMENT COMMENT '留言编号',
  `orderId` int(18) NOT NULL COMMENT '订单编号,外键',
  `UserId` int(18) NOT NULL COMMENT '用户编号,外键',
  `FoodName` varchar(250) DEFAULT '' COMMENT '菜品名称',
  `createOn` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `content` varchar(250) DEFAULT '' COMMENT '评论内容',
  PRIMARY KEY (`messageId`),
  KEY `storeId` (`storeId`),
  KEY `orderId` (`orderId`),
  KEY `userId` (`UserId`),
  CONSTRAINT `message_ibfk_1` FOREIGN KEY (`storeId`) REFERENCES `store` (`StoreId`),
  CONSTRAINT `message_ibfk_3` FOREIGN KEY (`UserId`) REFERENCES `member` (`UserId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='留言';

-- ----------------------------
-- Records of message
-- ----------------------------

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `orderId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单编号',
  `payId` bigint(20) NOT NULL COMMENT '支付编号',
  `userId` int(11) NOT NULL COMMENT '外键,用户编号',
  `money` double NOT NULL COMMENT '订单付款金额',
  `status` int(5) NOT NULL COMMENT '订单状态',
  `remark` varchar(50) DEFAULT NULL COMMENT '备注',
  `createOn` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updateOn` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='订单表';

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('1', '20190714010201', '2', '125', '-2', null, '2019-07-14 01:02:01', '2019-07-14 01:02:01');
INSERT INTO `order` VALUES ('2', '20190714010229', '2', '125', '-2', null, '2019-07-14 01:02:29', '2019-07-14 01:02:29');
INSERT INTO `order` VALUES ('3', '20190714014546', '2', '125', '-2', null, '2019-07-14 01:45:47', '2019-07-14 01:45:47');

-- ----------------------------
-- Table structure for orderitem
-- ----------------------------
DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem` (
  `orderItemId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单项编号',
  `orderId` bigint(20) NOT NULL COMMENT '订单表',
  `storeId` bigint(20) NOT NULL COMMENT '外键,店铺Id',
  `foodName` varchar(50) NOT NULL COMMENT '商品名称',
  `quantity` int(11) NOT NULL COMMENT '数量',
  PRIMARY KEY (`orderItemId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='订单项表';

-- ----------------------------
-- Records of orderitem
-- ----------------------------
INSERT INTO `orderitem` VALUES ('1', '3', '2', '水果蛋糕', '1');
INSERT INTO `orderitem` VALUES ('2', '3', '2', '巧克力蛋糕', '1');

-- ----------------------------
-- Table structure for store
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store` (
  `StoreId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '店铺id',
  `StoreName` varchar(20) NOT NULL COMMENT '店铺名称',
  `StoreLogName` varchar(20) NOT NULL COMMENT '店铺账号',
  `StorePass` varchar(20) NOT NULL COMMENT '店铺登入密码',
  `storeBoss` varchar(20) NOT NULL COMMENT '经营者',
  `Address` varchar(20) NOT NULL COMMENT '店铺地址',
  `Phone` bigint(20) NOT NULL COMMENT '联系电话',
  `StorecatId` bigint(20) NOT NULL COMMENT '路径',
  `status` bigint(20) NOT NULL COMMENT '状态',
  `announce` varchar(255) DEFAULT NULL COMMENT '公告',
  `createOn` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `storepic` varchar(255) DEFAULT '' COMMENT '图片路径',
  PRIMARY KEY (`StoreId`),
  UNIQUE KEY `uq_store_StoreLogName` (`StoreLogName`),
  UNIQUE KEY `uq_store_StoreName` (`StoreName`),
  KEY `FK_store_StorecatId_2_storecat_StorecatId` (`StorecatId`),
  CONSTRAINT `FK_store_StorecatId_2_storecat_StorecatId` FOREIGN KEY (`StorecatId`) REFERENCES `storecat` (`storecatId`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COMMENT='店铺表';

-- ----------------------------
-- Records of store
-- ----------------------------
INSERT INTO `store` VALUES ('1', '周麻婆', 'user1', '123456', '李根', '周麻婆(台江万象店)', '17583977313', '1', '1', '店铺升级.菜品更新.欢迎老顾客下单！', '2019-07-10 00:00:00', '/upload/65ac31df258947ac8c143573e2081b62.jpg');
INSERT INTO `store` VALUES ('2', '贝克汉堡', 'user2', '123456', '林文星', '贝克汉堡(福建师大店)', '14513892098', '2', '1', '十年品牌面食老店！认真努力做好每一份餐！祝您用餐愉快，天天好心情！', '2019-07-09 00:00:00', '/upload/ef0a64c32b4f465d8c8d231cecdfe9de.jpg');
INSERT INTO `store` VALUES ('3', '草本汤', 'user3', '123456', '刘民', '草本汤(台江苏宁店)', '17172618284', '3', '1', '食物的最可贵品质莫过于坚持原味，品牌的最可贵的品质莫过于坚持初心', '2019-07-09 00:00:00', '/upload/19babdc7feba4bdea4c5f9c91c4c6de8.jpg');
INSERT INTO `store` VALUES ('4', '一米香', 'user4', '123456', '刘二', '一米香(台江万达店)', '17583977313', '4', '1', '我们会努力做好，谢谢你们这么久以来的支持与厚爱，谢谢！', '2019-07-09 00:00:00', '/upload/6d49af6934c54d9594286291ef8f2a27.jpg');
INSERT INTO `store` VALUES ('5', '清口清汤面', 'user5', '123456', '曼玲', '清口清汤面(台江宝龙店)', '13174805562', '5', '1', '欢迎品尝！全国连锁品质保证！我们选用优质食材', '2019-07-09 00:00:00', '/upload/dfa7229f6273444693cd19160b800833.jpg');
INSERT INTO `store` VALUES ('6', '大小姐的饭', 'user6', '123456', '范生', '大小姐的饭(台江万达店)', '16541854036', '6', '1', '欢迎品尝！全国连锁品质保证！我们选用优质食材', '2019-07-09 00:00:00', '/upload/8390e6d6526445b4877e734c342f7287.jpg');
INSERT INTO `store` VALUES ('7', '三米周铺', 'user7', '123456', '周平', '三米粥铺(福州台江宝龙店)', '14763985440', '7', '1', '食物的最可贵品质莫过于坚持原味，品牌的最可贵的品质莫过于坚持初心', '2019-07-09 00:00:00', '/upload/f48b79e12b2d46bcbdc76b411c751b6c.jpg');
INSERT INTO `store` VALUES ('8', '米眷粥坊', 'user8', '123456', '陆朋', '米眷粥坊(台江万达店)', '15509525026', '8', '1', '我们会努力做好，谢谢你们这么久以来的支持与厚爱，谢谢！', '2019-07-09 00:00:00', '/upload/34f4e2e89f5f4984a481611f059c9915.png');
INSERT INTO `store` VALUES ('9', '汉堡王', 'user9', '123456', '司徒河', '汉堡王(台江万达店)', '15687667031', '9', '1', '我们会努力做好，谢谢你们这么久以来的支持与厚爱，谢谢！', '2019-07-09 00:00:00', '/upload/84d33a7c1114455a978e236a8c9aad9e.jpg');
INSERT INTO `store` VALUES ('10', '马格丽塔', 'user10', '123456', '秦海', '马格丽塔(台江冠亚店)', '16057914511', '10', '1', '食物的最可贵品质莫过于坚持原味，品牌的最可贵的品质莫过于坚持初心', '2019-07-09 00:00:00', '/upload/0bbe5c449df740c8a50363035cac856c.jpg');
INSERT INTO `store` VALUES ('11', '一点点', 'user11', '123456', '林文星', '一点点(福建师大店)', '12345678912', '12', '1', '第一网红奶茶店，你值得信赖，贵也是有道理的', '2019-07-09 00:00:00', '/upload/93775dbfa23348e39f0cad63cd89539b.jpg');

-- ----------------------------
-- Table structure for storecat
-- ----------------------------
DROP TABLE IF EXISTS `storecat`;
CREATE TABLE `storecat` (
  `storecatId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '类别id',
  `storecatName` varchar(20) NOT NULL COMMENT '类别名称',
  PRIMARY KEY (`storecatId`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COMMENT='店铺类别表';

-- ----------------------------
-- Records of storecat
-- ----------------------------
INSERT INTO `storecat` VALUES ('1', '美食');
INSERT INTO `storecat` VALUES ('2', '快餐便当');
INSERT INTO `storecat` VALUES ('3', '特色菜系');
INSERT INTO `storecat` VALUES ('4', '异国料理');
INSERT INTO `storecat` VALUES ('5', '小吃夜宵');
INSERT INTO `storecat` VALUES ('6', '甜品饮品');
INSERT INTO `storecat` VALUES ('7', '果蔬生鲜');
INSERT INTO `storecat` VALUES ('8', '商店超市');
INSERT INTO `storecat` VALUES ('9', '鲜花绿植');
INSERT INTO `storecat` VALUES ('10', '早餐');
INSERT INTO `storecat` VALUES ('11', '午餐');
INSERT INTO `storecat` VALUES ('12', '下午茶');
INSERT INTO `storecat` VALUES ('13', '晚餐');
INSERT INTO `storecat` VALUES ('14', '夜宵');
