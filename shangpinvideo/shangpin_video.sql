/*
Navicat MySQL Data Transfer

Source Server         : qujie
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : shangpin_video

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-11-18 18:04:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `bgm_info`
-- ----------------------------
DROP TABLE IF EXISTS `bgm_info`;
CREATE TABLE `bgm_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `author` varchar(255) DEFAULT NULL COMMENT '歌手名',
  `name` varchar(255) DEFAULT NULL COMMENT '音乐名',
  `path` varchar(255) DEFAULT NULL COMMENT '音乐播放路径',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='背景音乐信息表';

-- ----------------------------
-- Records of bgm_info
-- ----------------------------

-- ----------------------------
-- Table structure for `comments`
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `video_id` bigint(20) DEFAULT NULL COMMENT '视频id',
  `from_user_id` bigint(20) DEFAULT NULL COMMENT '评论人用户id',
  `content` varchar(255) DEFAULT NULL COMMENT '留言内容',
  `create_time` datetime DEFAULT NULL COMMENT '留言时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='留言评论表';

-- ----------------------------
-- Records of comments
-- ----------------------------

-- ----------------------------
-- Table structure for `personal_data`
-- ----------------------------
DROP TABLE IF EXISTS `personal_data`;
CREATE TABLE `personal_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `signature` varchar(128) DEFAULT NULL COMMENT '个性签名',
  `school` varchar(50) DEFAULT NULL COMMENT '学校',
  `gender` tinyint(3) DEFAULT NULL COMMENT '下拉选，0为男 1为女',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `place` varchar(20) DEFAULT NULL COMMENT '地区',
  `email` varchar(30) DEFAULT NULL COMMENT '邮箱',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `userId` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='个人资料表';

-- ----------------------------
-- Records of personal_data
-- ----------------------------
INSERT INTO `personal_data` VALUES ('2', '1', '白茶清欢无别事，我在等风也等你', '北京电影学院', '0', null, '杭州', '11111@qq.com', '2018-11-18 18:03:21', null);

-- ----------------------------
-- Table structure for `search_records`
-- ----------------------------
DROP TABLE IF EXISTS `search_records`;
CREATE TABLE `search_records` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL COMMENT '搜索内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='搜索记录表';

-- ----------------------------
-- Records of search_records
-- ----------------------------

-- ----------------------------
-- Table structure for `signature_history`
-- ----------------------------
DROP TABLE IF EXISTS `signature_history`;
CREATE TABLE `signature_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户id',
  `content` varchar(100) DEFAULT NULL COMMENT '个性签名内容',
  `like_counts` int(11) DEFAULT NULL COMMENT '点赞数',
  `create_time` datetime DEFAULT NULL COMMENT '签名创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='个性签名历史记录表';

-- ----------------------------
-- Records of signature_history
-- ----------------------------

-- ----------------------------
-- Table structure for `user_fans`
-- ----------------------------
DROP TABLE IF EXISTS `user_fans`;
CREATE TABLE `user_fans` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '被关注者用户id',
  `fans_id` bigint(20) DEFAULT NULL COMMENT '关注者用户id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='粉丝关系表';

-- ----------------------------
-- Records of user_fans
-- ----------------------------

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `phone` varchar(255) DEFAULT NULL COMMENT '用户手机号',
  `username` varchar(20) NOT NULL COMMENT '用户名',
  `password` varchar(64) NOT NULL COMMENT '登录密码',
  `face_image` varchar(128) DEFAULT NULL COMMENT '我的头像，如果没有默认给一张',
  `nickname` varchar(30) DEFAULT NULL COMMENT '昵称',
  `fans_counts` int(20) DEFAULT NULL COMMENT '用户粉丝数量',
  `follow_counts` int(11) DEFAULT NULL COMMENT '用户关注的人数量',
  `receive_like_counts` int(20) DEFAULT NULL COMMENT '用户收到的点赞/收藏数量',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=1025 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1001', '', 'test-imooc-1111', '9999', '/path000999', '慕课网好牛十分牛~', '123456', '111', '222');
INSERT INTO `user_info` VALUES ('1002', '18170037792', '瞿杰', '123123', null, '瞿杰', '0', '0', '0');
INSERT INTO `user_info` VALUES ('1003', '15172294874', '阿狸', '123123', null, null, null, null, null);
INSERT INTO `user_info` VALUES ('1004', '15172294874', '阿呆', '123123', './123.jpg', null, '0', '0', '0');
INSERT INTO `user_info` VALUES ('1005', '15877895246', '李三', 'b51e8dbebd4ba8a8f342190a4b9f08d7', '/456.jpg', '李三', '0', '0', '0');
INSERT INTO `user_info` VALUES ('1006', '15877895246', '李四', '43bc2a744ffec6df5102feb84bed7b27', '/456.jpg', '李四', '0', '0', '0');
INSERT INTO `user_info` VALUES ('1007', null, 'eer', 'e10adc3949ba59abbe56e057f20f883e', null, 'eer', '0', '0', '0');
INSERT INTO `user_info` VALUES ('1008', null, 'qujie', 'e10adc3949ba59abbe56e057f20f883e', null, 'qujie', '0', '0', '0');
INSERT INTO `user_info` VALUES ('1009', null, '老李', '2b70b97a95bd400866322757f0cab6d8', null, '老李', '0', '0', '0');
INSERT INTO `user_info` VALUES ('1010', null, '李洁', '4297f44b13955235245b2497399d7a93', null, '李洁', '0', '0', '0');
INSERT INTO `user_info` VALUES ('1016', null, 'qujie123', '4297f44b13955235245b2497399d7a93', null, 'qujie123', '0', '0', '0');
INSERT INTO `user_info` VALUES ('1017', null, '123123', '4297f44b13955235245b2497399d7a93', null, '123123', '0', '0', '0');
INSERT INTO `user_info` VALUES ('1018', null, 'ht', 'eb5e48e74123cacc52761302ea4a7d22', null, 'ht', '0', '0', '0');
INSERT INTO `user_info` VALUES ('1019', null, 'dasd', 'e27a0cf503d07f7e58417600e7848f03', null, 'dasd', '0', '0', '0');
INSERT INTO `user_info` VALUES ('1020', null, 'desd', 'e27a0cf503d07f7e58417600e7848f03', null, 'desd', '0', '0', '0');
INSERT INTO `user_info` VALUES ('1021', null, 'qujieNo1', '4297f44b13955235245b2497399d7a93', null, 'qujieNo1', '0', '0', '0');
INSERT INTO `user_info` VALUES ('1022', null, 'work', '4297f44b13955235245b2497399d7a93', null, 'work', '0', '0', '0');
INSERT INTO `user_info` VALUES ('1023', null, '曲解', '4297f44b13955235245b2497399d7a93', null, '曲解', '0', '0', '0');
INSERT INTO `user_info` VALUES ('1024', null, 'likai', '202cb962ac59075b964b07152d234b70', null, 'likai', '0', '0', '0');

-- ----------------------------
-- Table structure for `user_report`
-- ----------------------------
DROP TABLE IF EXISTS `user_report`;
CREATE TABLE `user_report` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `deal_user_id` bigint(20) DEFAULT NULL COMMENT '被举报用户id',
  `deal_video_id` bigint(20) DEFAULT NULL COMMENT '被举报视频id',
  `title` varchar(128) DEFAULT NULL COMMENT '举报标题：如违法色情暴力',
  `content` varchar(255) DEFAULT NULL COMMENT '举报具体内容(用户输入)',
  `reporter_user_id` bigint(20) DEFAULT NULL COMMENT '举报人用户id',
  `create_time` datetime DEFAULT NULL COMMENT '举报创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='举报信息表';

-- ----------------------------
-- Records of user_report
-- ----------------------------

-- ----------------------------
-- Table structure for `videos`
-- ----------------------------
DROP TABLE IF EXISTS `videos`;
CREATE TABLE `videos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) DEFAULT NULL COMMENT '发布者用户id',
  `bgm_id` bigint(20) DEFAULT NULL COMMENT '背景音乐id',
  `video_desc` varchar(255) DEFAULT NULL COMMENT '视频内容描述',
  `video_path` varchar(255) DEFAULT NULL COMMENT '上传路径',
  `video_seconds` float(6,2) DEFAULT NULL COMMENT '视频播放秒数',
  `video_width` int(10) DEFAULT NULL COMMENT '视频宽度',
  `video_height` int(10) DEFAULT NULL COMMENT '视频高度',
  `cover_path` varchar(255) DEFAULT NULL COMMENT '视频封面路径',
  `like_counts` bigint(20) DEFAULT NULL COMMENT '点赞数',
  `status` tinyint(2) DEFAULT NULL COMMENT '视频状态：1，发布成功 2，禁止播放(管理员权限操作)',
  `create_time` datetime DEFAULT NULL COMMENT '上传时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='视频表';

-- ----------------------------
-- Records of videos
-- ----------------------------
