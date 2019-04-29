/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : boc

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2018-11-23 09:24:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `content_info`
-- ----------------------------
DROP TABLE IF EXISTS `content_info`;
CREATE TABLE `content_info` (
  `con_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '标注内容或病变性质id',
  `content` varchar(255) NOT NULL COMMENT '标注内容或病变性质：如，溃疡、红斑......（将来会做增加或删除）',
  `remark` varchar(2000) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`con_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='标注内容结果信息表';

-- ----------------------------
-- Records of content_info
-- ----------------------------

-- ----------------------------
-- Table structure for `label_detail`
-- ----------------------------
DROP TABLE IF EXISTS `label_detail`;
CREATE TABLE `label_detail` (
  `lab_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '标注信息id',
  `is_labeled` tinyint(4) NOT NULL DEFAULT '0' COMMENT '图片是否被标注过：0表示未标注过；1表示标注过',
  `is_valid` tinyint(4) NOT NULL DEFAULT '0' COMMENT '普通用户的标注信息是否有效：0表示有效；1表示无效',
  `type` varchar(100) DEFAULT NULL COMMENT '图片类型：0表示正常；1表示不正常',
  `location` varchar(255) DEFAULT NULL COMMENT '病变位置：只有4个值，食道、胃、小肠、结肠',
  `px_info` text NOT NULL COMMENT '标注位置的像素信息，json格式',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '标注信息的创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '标注信息的更新时间',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '标注信息是否被删除：0表示没删除；1表示已删除',
  `uid` varchar(50) NOT NULL COMMENT '引入标注人信息表user_info的主键',
  `pic_id` varchar(50) NOT NULL COMMENT '引入图片信息表picture_info的主键',
  `con_id` varchar(50) NOT NULL COMMENT '引入标注内容结果信息表content_info的主键',
  `lab_remark` varchar(2000) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`lab_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='标注信息表';

-- ----------------------------
-- Records of label_detail
-- ----------------------------

-- ----------------------------
-- Table structure for `picture_info`
-- ----------------------------
DROP TABLE IF EXISTS `picture_info`;
CREATE TABLE `picture_info` (
  `pic_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '图片信息id',
  `pic_uuid` varchar(255) NOT NULL COMMENT '图片的名字',
  `pic_path` varchar(1000) NOT NULL COMMENT '压缩包解压后图片存放的绝对路径',
  `pic_folder` varchar(255) NOT NULL COMMENT '压缩包解压后图片所在文件夹的名字',
  `patient` varchar(255) NOT NULL COMMENT '图片信息所属的患者姓名',
  `uid` varchar(50) NOT NULL COMMENT '引用用户标注人信息表user_info的主键，用于普通用户只能查看个人文件夹的权限',
  `pic_desc` varchar(2000) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`pic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='图片信息表';

-- ----------------------------
-- Records of picture_info
-- ----------------------------

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `uid` int(20) NOT NULL AUTO_INCREMENT COMMENT '医生用户id',
  `uname` varchar(255) NOT NULL COMMENT '用户医生的姓名',
  `upwd` varchar(255) NOT NULL COMMENT '用户医生的登录密码',
  `uage` varchar(10) NOT NULL COMMENT '用户医生的年龄',
  `upower` varchar(255) NOT NULL COMMENT '用户角色权限，只有super和ordinary两类',
  `color` varchar(255) NOT NULL COMMENT '用户标注信息的背景色',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '用户信息的创建时间',
  `update_time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '用户信息的修改时间',
  `is_delete` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否已删除用户：0表示否，用户存在，没删除；1表示用户已删除',
  `remark` varchar(2000) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户医生标注人信息表';

-- ----------------------------
-- Records of user_info
-- ----------------------------
