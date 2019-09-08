/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50622
Source Host           : 127.0.0.1:3306
Source Database       : drugmanagement

Target Server Type    : MYSQL
Target Server Version : 50622
File Encoding         : 65001

Date: 2019-09-08 18:58:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cid` int(11) NOT NULL DEFAULT '0',
  `cname` varchar(255) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('0', '中药材', '0');
INSERT INTO `category` VALUES ('1', '中成药', '0');
INSERT INTO `category` VALUES ('2', '中西成药', '0');
INSERT INTO `category` VALUES ('3', '化学原料药', '0');
INSERT INTO `category` VALUES ('4', '抗生素', '0');
INSERT INTO `category` VALUES ('5', '放射性药品', '0');

-- ----------------------------
-- Table structure for `medicine`
-- ----------------------------
DROP TABLE IF EXISTS `medicine`;
CREATE TABLE `medicine` (
  `mid` varchar(255) NOT NULL DEFAULT '',
  `mname` varchar(255) DEFAULT NULL,
  `mshortname` varchar(255) DEFAULT NULL,
  `mnors` varchar(255) DEFAULT NULL,
  `marea` varchar(255) DEFAULT NULL,
  `mlot` varchar(255) DEFAULT NULL,
  `minpri` double DEFAULT NULL,
  `mwpri` double DEFAULT NULL,
  `mpri` double DEFAULT NULL,
  `mnum` int(11) DEFAULT NULL,
  `mcon` varchar(255) DEFAULT NULL,
  `mcate` varchar(255) DEFAULT NULL,
  `jtime` datetime DEFAULT NULL,
  `musetime` date DEFAULT NULL,
  `memo` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`mid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of medicine
-- ----------------------------
INSERT INTO `medicine` VALUES ('0001', '感冒灵颗粒', '西方', '20*12', '回龙唱', 'T001', '23.1', '26.1', '30', '1000', '长白山摇曳有限公司', '抗生素', '2019-08-01 00:00:00', '2019-09-28', '摇摆');
INSERT INTO `medicine` VALUES ('0003', '云南白药', '云南', '20*12', '天哭', 'T009', '12', '18.6', '25', '1000', '福建公司', '中西成药', '2019-08-01 00:00:00', '2019-09-28', 'HUJIAN');
INSERT INTO `medicine` VALUES ('0004', '铁打损伤', '西方', '20*12', '回龙场', 'T005', '13.5', '16.7', '20.1', '100', '天堂', '中药材', '2019-09-01 12:38:59', '2019-09-26', '天堂联盟');

-- ----------------------------
-- Table structure for `salesorder`
-- ----------------------------
DROP TABLE IF EXISTS `salesorder`;
CREATE TABLE `salesorder` (
  `soid` varchar(255) NOT NULL DEFAULT '',
  `mid` varchar(255) DEFAULT NULL,
  `mname` varchar(255) DEFAULT NULL,
  `snum` int(11) DEFAULT NULL,
  `price` double(6,0) DEFAULT NULL,
  `person` varchar(255) DEFAULT NULL COMMENT '操作人',
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`soid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of salesorder
-- ----------------------------
INSERT INTO `salesorder` VALUES ('132c4a4aaafd4b1ebb41a2ab822d3f5c', '0004', '铁打损伤', '10', '20', 'admin', '0');
INSERT INTO `salesorder` VALUES ('2', '0001', '感冒灵颗粒', '2', '2', null, '1');
INSERT INTO `salesorder` VALUES ('20bd7ad19c7043eea80e43c0f83733e4', '0002', '冬虫夏草', '7', '40', 'admin', '1');
INSERT INTO `salesorder` VALUES ('2b1ba90f7cd040afa807caacff49c56f', '0002', '20', '10', '100', null, '1');
INSERT INTO `salesorder` VALUES ('3546377454e04b73985ad7858409bffb', '0002', '20', '4', '100', 'admin', '1');
INSERT INTO `salesorder` VALUES ('40cf934a3f4a4d0eb77ca395a651076f', '0004', '铁打损伤', '16', '20', 'admin', '0');
INSERT INTO `salesorder` VALUES ('4e9cac2ae33e4934911ab84fd78d3677', '0002', '20', '10', '100', null, '1');
INSERT INTO `salesorder` VALUES ('62562061cb494383a66a59db7cd04c46', '0003', '云南白药', '8', '121', 'admin', '1');
INSERT INTO `salesorder` VALUES ('7f6802fb58f54857adf641898519c5ff', '0004', '铁打损伤', '35', '20', 'admin', '0');
INSERT INTO `salesorder` VALUES ('8819959ac17342b4a8726452bdc4641a', '0002', '20', '2', '100', null, '1');
INSERT INTO `salesorder` VALUES ('8b3a001bf8c84f23a1fd3a0bf68445dd', '0002', '20', '6', '100', null, '1');
INSERT INTO `salesorder` VALUES ('959007792ffe482f890239ea73fc9751', '0001', '感冒灵颗粒', '1', '2', 'admin', '1');
INSERT INTO `salesorder` VALUES ('a91cb7e2388f444fa10fb175b76761e4', '0002', '20', '1', '100', null, '1');
INSERT INTO `salesorder` VALUES ('aa4561796c1c478398fa090cb823d6b8', '0004', '铁打损伤', '8', '20', 'admin', '0');
INSERT INTO `salesorder` VALUES ('bdc752593f094632a204823c866893c1', '0002', '20', '1', '100', null, '1');
INSERT INTO `salesorder` VALUES ('d6a1f211a85749369a924617724d144b', '0002', '20', '4', '100', null, '1');
INSERT INTO `salesorder` VALUES ('d85b4f7ba19f4647ab0e27b02c95d114', '0001', '感冒灵颗粒', '1', '35', 'admin', '1');
INSERT INTO `salesorder` VALUES ('ede57c41bd9f4fd98d8595db2d95bd84', '0002', '20', '10', '100', 'admin', '1');
INSERT INTO `salesorder` VALUES ('f19a2ea6f99649668355a8c39b961980', '0002', '20', '1', '100', null, '1');
INSERT INTO `salesorder` VALUES ('fcda3bd0c7104e51a0b26cc99a202512', '0002', '20', '1', '100', null, '1');

-- ----------------------------
-- Table structure for `staff`
-- ----------------------------
DROP TABLE IF EXISTS `staff`;
CREATE TABLE `staff` (
  `staffid` varchar(255) NOT NULL DEFAULT '',
  `staffname` varchar(20) DEFAULT NULL,
  `staffsex` varchar(2) DEFAULT NULL,
  `stafftel` varchar(12) DEFAULT NULL,
  `staffadd` varchar(40) DEFAULT NULL,
  `staffcard` varchar(40) DEFAULT NULL,
  `staffzip` varchar(6) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`staffid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of staff
-- ----------------------------
INSERT INTO `staff` VALUES ('0a065cd61538401e942a0d7154798bd8', '车凌飞', '男', '18231231232', '欧洲', '14118119970918014', '不翻汤', '0');
INSERT INTO `staff` VALUES ('cdd57195b57a420391eb6cfdf30f2bb0', '张大大', '女', '18435997612', '哥伦比亚', '12313141323412', '加辣', '0');
INSERT INTO `staff` VALUES ('d65faa93bf1b480db9c841c90723cd8c', '张大卫', '男', '18435997612', '哥伦比亚', '11102010001231231', '这既是名', null);

-- ----------------------------
-- Table structure for `stock`
-- ----------------------------
DROP TABLE IF EXISTS `stock`;
CREATE TABLE `stock` (
  `id` varchar(255) NOT NULL,
  `mid` varchar(255) DEFAULT '',
  `mname` varchar(255) DEFAULT NULL,
  `mprice` double(6,0) DEFAULT NULL,
  `mnum` int(11) DEFAULT NULL,
  `spid` varchar(255) DEFAULT NULL,
  `stime` datetime DEFAULT NULL,
  `ytime` date DEFAULT NULL,
  `stype` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stock
-- ----------------------------
INSERT INTO `stock` VALUES ('0765aaa38ed144a2b870ffeef6538b18', '0004', '铁打损伤', '20', '65', '天堂', '2019-09-01 12:38:59', '2019-09-26', '中药材', '0');
INSERT INTO `stock` VALUES ('6717d3ed5ae94e84b34581234048f99e', '0004', '铁打损伤', '20', '100', '天堂', '2019-09-01 12:38:59', '2019-09-26', '中药材', '0');
INSERT INTO `stock` VALUES ('a3aa26703190460fb8298992ef4991ec', '0004', '铁打损伤', '20', '66', '天堂', '2019-09-01 12:38:59', '2019-09-26', '中药材', '0');
INSERT INTO `stock` VALUES ('d6cb1e9bddcd40a6b2c56ed262a9fbd8', '0003', '云南白药', '121', '8', '福建公司', '2019-08-03 11:16:09', '2019-08-29', '化学原料药', '0');
INSERT INTO `stock` VALUES ('ef17389f8fe9488794f086460333bf9b', '0001', '感冒灵颗粒', '35', '5', '长白山摇曳有限公司', '2019-08-01 11:15:54', '2019-08-18', '中西成药', '0');
INSERT INTO `stock` VALUES ('ff6166d46de74466aa7c0a8696010f02', '1', '1', '23', '12', '天堂', '2019-09-01 19:17:15', '2019-09-01', '放射性药品', '1');

-- ----------------------------
-- Table structure for `supplier`
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `id` varchar(255) NOT NULL,
  `spid` varchar(255) DEFAULT '',
  `spname` varchar(255) DEFAULT NULL,
  `sparea` varchar(255) DEFAULT NULL,
  `spmeno` varchar(255) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES ('1e1449c06bc542999a575c443d867a58', '0000002', '天堂', '天堂之路', '嗯哼', '0');
INSERT INTO `supplier` VALUES ('23813a78dd7b47b382fe62918d49ac60', '0000003', '长白山摇曳有限公司', '长白上', '你是风儿  那是沙  残差', '0');
INSERT INTO `supplier` VALUES ('dfc081ce9bf14f6da920be0ae6fe9616', '0000001', '福建公司', '福建', '我是你', '0');

-- ----------------------------
-- Table structure for `sys_permission`
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `permission` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('101', 'vip', null, 'vip');

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` varchar(255) NOT NULL,
  `rolename` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `del_flag` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'admin', '0', '0');
INSERT INTO `sys_role` VALUES ('2', 'manager', '0', '0');
INSERT INTO `sys_role` VALUES ('3', 'user', '0', '0');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `sys_id` varchar(255) NOT NULL,
  `sys_createTime` datetime DEFAULT NULL,
  `sys_userAge` int(11) DEFAULT NULL,
  `sys_userLogin` varchar(255) DEFAULT NULL,
  `sys_userName` varchar(255) DEFAULT NULL,
  `sys_userPassWord` varchar(255) DEFAULT NULL,
  `sys_file` varchar(255) DEFAULT NULL,
  `sys_status` varchar(11) DEFAULT NULL,
  `sys_role` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`sys_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('9e4bfb1734ef41c0ae3ceededcedc188', '2019-05-18 21:05:43', '29', 'user', 'lgy', '123', '/uploadFile/th0xp0rw34f.jpg', '0', '3');
INSERT INTO `sys_user` VALUES ('a8fd5d2725f8411090cc1edb87d323f8', '2018-12-21 00:00:00', '12', 'admin', '32', '123', '/uploadFile/意大利马纳罗拉+悬崖上的小镇+五渔村4k高清风景壁纸_彼岸图网.jpg', '0', '1');
INSERT INTO `sys_user` VALUES ('9a78daef208c473982443e6905c9a698', '2019-08-30 23:27:43', '21', 'lgy', '李国琰', '123456', '/uploadFile/意大利马纳罗拉+悬崖上的小镇+五渔村4k高清风景壁纸_彼岸图网.jpg', '0', '2');
