/*
 Navicat Premium Data Transfer

 Source Server         : mysql03
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : 192.168.2.62:3307
 Source Schema         : mybatis

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 30/07/2020 09:41:03
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for department
-- ----------------------------
DROP TABLE IF EXISTS `department`;
create table department (
  `id` int(11) not null auto_increment,
  `department_name` varchar(255) default null ,
  primary key (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=UTF8;