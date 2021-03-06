CREATE TABLE `t_api_log` (
	`f_id` BIGINT(20) UNSIGNED NOT NULL AUTO_INCREMENT,
	`f_api_desc` VARCHAR(64) NULL DEFAULT NULL COMMENT '接口描述',
	`f_class_method` VARCHAR(128) NULL DEFAULT NULL COMMENT '调用的类方法',
	`f_url` VARCHAR(256) NOT NULL COMMENT '接口url',
	`f_http_method` VARCHAR(8) NOT NULL COMMENT 'http请求方式',
	`f_ip` VARCHAR(46) NULL DEFAULT NULL COMMENT '客户端ip',
	`f_os` VARCHAR(256) NULL DEFAULT NULL COMMENT '操作系统相关信息',
	`f_exception_stack_info` TEXT NULL COMMENT '异常堆栈信息',
	`f_req_start_time` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '请求开始时间',
	`f_req_end_time` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '请求截止时间',
	`f_req_deal_time` INT(11) UNSIGNED NULL DEFAULT NULL COMMENT '请求处理时间（毫秒）',
	`f_req_params` VARCHAR(512) NULL DEFAULT NULL COMMENT '请求的参数信息',
	`f_resp_data` TEXT NULL COMMENT '响应的数据',
	`f_sys_add_time` DATETIME NOT NULL COMMENT '创建时间',
	`f_sys_upd_time` DATETIME NULL DEFAULT NULL COMMENT '更新时间',
	`f_sys_del_time` DATETIME NULL DEFAULT NULL COMMENT '删除时间',
	`f_sys_add_user` BIGINT(20) UNSIGNED NULL DEFAULT NULL COMMENT '新增者',
	`f_sys_upd_user` BIGINT(20) UNSIGNED NULL DEFAULT NULL COMMENT '更新者',
	`f_sys_del_user` BIGINT(20) UNSIGNED NULL DEFAULT NULL COMMENT '删除者',
	`f_sys_del_state` TINYINT(1) UNSIGNED NOT NULL DEFAULT '1' COMMENT '删除状态=={1:正常, 2:已删除}',
	PRIMARY KEY (`f_id`) USING BTREE
)
COMMENT='接口日志记录'
COLLATE='utf8mb4_general_ci'
ENGINE=InnoDB
ROW_FORMAT=DYNAMIC;