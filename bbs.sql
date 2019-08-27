/*
Navicat MySQL Data Transfer

Source Server         : 1903
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : bbs

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2019-07-25 16:55:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `m_id` varchar(50) NOT NULL,
  `u_id_from` varchar(50) NOT NULL COMMENT '留言用户的ID',
  `u_id_to` varchar(50) DEFAULT NULL COMMENT '指定留言用户信息ID',
  `m_content` varchar(500) DEFAULT NULL COMMENT '留言信息',
  `create_time` date DEFAULT NULL,
  `update_time` date DEFAULT NULL,
  PRIMARY KEY (`m_id`,`u_id_from`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('5811f41198fd4914a80d5d825181966f', 'gongcj', 'asdsdfsd', '士大夫大师傅但是手动阀', '2019-07-25', '2019-07-25');
INSERT INTO `message` VALUES ('eaa1370270484fdeb8d18ac91a4d0147', 'gongcj', '所有人', '我是你爸爸', '2019-07-25', '2019-07-25');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `u_id` varchar(50) NOT NULL COMMENT '用户主键',
  `u_password` varchar(255) NOT NULL COMMENT '密码',
  `u_sale` varchar(50) NOT NULL COMMENT '加密盐值',
  `create_time` date DEFAULT NULL COMMENT '创建用户时间',
  `update_time` date DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('gongcj', 'aef51cf420fb2b8dad6e8fc13161ce87', '0acdf32034544b2e82b280c34bc87b52', '2019-07-25', '2019-07-25');
