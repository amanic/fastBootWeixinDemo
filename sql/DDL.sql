-- 微信基础用户信息
CREATE TABLE `wb_wx_user_profile` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `open_id` varchar(255) DEFAULT NULL COMMENT '微信open_id',
  `subscribe` int(1) DEFAULT '1' COMMENT '是否关注：0-否 1-是',
  `nickname` varchar(50) DEFAULT NULL COMMENT '昵称',
  `sex` varchar(2) DEFAULT NULL COMMENT ' 男 女 未知',
  `country` varchar(50) DEFAULT NULL COMMENT '国家',
  `province` varchar(50) DEFAULT NULL COMMENT '省份',
  `city` varchar(50) DEFAULT NULL COMMENT '城市',
  `language` varchar(50) DEFAULT NULL COMMENT '语言',
  `head_img_url` varchar(255) DEFAULT NULL COMMENT '头像地址',
  `group_id` int(50) DEFAULT NULL COMMENT '用户分组id',
  `remark` varchar(255) DEFAULT NULL COMMENT '公众号运营对粉丝备注',
  `tag_ids` varchar(255) DEFAULT NULL COMMENT '用户被打上的标签ID列表',
  `gmt_subscribe` timestamp NULL DEFAULT NULL COMMENT '(取自微信)关注时间',
  `gmt_unsubscribe` timestamp NULL DEFAULT NULL COMMENT '取关时间',
  `latitude` decimal(11,8) DEFAULT NULL COMMENT '最近一次获取到的经度',
  `longitude` decimal(11,8) DEFAULT NULL COMMENT '最近一次获取到的经纬度精度',
  `loc_precision` decimal(11,8) DEFAULT NULL COMMENT '最近一次获取到的经纬度精度',
  `gmt_locate` timestamp NULL DEFAULT NULL COMMENT '最近一次登记经纬度的时间',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  `deleted` int(1) DEFAULT '0' COMMENT '逻辑删除标志，是否删除：0-否 1-是',
  `creator` varchar(50) DEFAULT NULL COMMENT '创建人',
  `gmt_create` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifier` varchar(50) DEFAULT NULL COMMENT '修改人',
  `gmt_modify` timestamp NULL DEFAULT NULL COMMENT '修改时间',
  `union_id` varchar(50) DEFAULT NULL COMMENT '微信unionId',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_open_id` (`open_id`),
  UNIQUE KEY `uk_union_id` (`union_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='微信基础用户信息'

-- 用户信息表
CREATE TABLE `wb_user_profile` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `name` varchar(50) NOT NULL COMMENT '姓名',
  `mobile` varchar(15) NOT NULL COMMENT '手机号',
  `id_card` varchar(50) NOT NULL COMMENT '身份证号码',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `spare_phone1` varchar(50) DEFAULT NULL COMMENT '备用手机号1',
  `spare_phone2` varchar(50) DEFAULT NULL COMMENT '备用手机号2',
  `front_pic` varchar(255) DEFAULT NULL COMMENT '身份证正面照片',
  `back_pic` varchar(255) DEFAULT NULL COMMENT '身份证背面照片',
  `hand_pic` varchar(255) DEFAULT NULL COMMENT '身份证手持照片',
  PRIMARY KEY (`id`),
  KEY `index_mobile` (`mobile`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='用户信息表'





-- 微信用户绑定表
CREATE TABLE `wb_user_binding` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `open_id` varchar(100) NOT NULL,
  `uid` int(11) NOT NULL,
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uindex_uid` (`uid`),
  UNIQUE KEY `uindex_openId` (`open_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='微信用户绑定表'

-- 借款订单表
CREATE TABLE `wx_loan_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `loan_amount` decimal(10,2) NOT NULL DEFAULT '0.00' COMMENT '贷款金额',
  `borrower_uid` int(11) NOT NULL COMMENT '借款人uid',
  `lend_uid` int(11) NOT NULL COMMENT '出借人uid',
  `lend_name` varchar(50) NOT NULL COMMENT '出借人姓名',
  `borrower_name` varchar(50) NOT NULL COMMENT '借款人姓姓名',
  `loan_time` datetime DEFAULT NULL COMMENT '借款日期',
  `repay_time` datetime NOT NULL COMMENT '还款日期',
  `delete` int(1) DEFAULT '0' COMMENT '是否销毁 0:否 1:是',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  KEY `index_lendUid` (`lend_uid`),
  KEY `ndex_borrowerUid` (`borrower_uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='借款订单表'

-- 操作日志表
CREATE TABLE `wb_operate_log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL COMMENT '操作者uid',
  `name` varchar(50) DEFAULT NULL COMMENT '操作者姓名',
  `type` varchar(50) DEFAULT NULL COMMENT '操作类型:直接显示中文',
  `content` varchar(500) DEFAULT NULL COMMENT '操作内容',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`),
  KEY `index_uid` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='操作日志表'

CREATE TABLE `wb_user_loan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL COMMENT '出借人id',
  `name` varchar(30) DEFAULT NULL COMMENT '出借人姓名',
  `loan_amount` decimal(10,2) DEFAULT NULL COMMENT '借款金额',
  `loan_start_time` datetime DEFAULT NULL COMMENT '借款人开时间',
  `loan_end_time` datetime DEFAULT NULL COMMENT '借款结束时间，还款',
  `loan_uid` int(11) DEFAULT NULL COMMENT '借款人id',
  `loan_name` varchar(30) DEFAULT NULL COMMENT '借款人姓名',
  `account` varchar(30) DEFAULT NULL COMMENT '出借人账号',
  `delete` int(1) DEFAULT '0' COMMENT '是否删除0默认，1删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  `loan_type` int(2) DEFAULT '0' COMMENT '借款状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='出借人借条表'



