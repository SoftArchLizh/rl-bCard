CREATE TABLE `iis_job_seekers` (
                                   `id` CHAR(36) NOT NULL PRIMARY KEY COMMENT 'UUID',
                                   `name` VARCHAR(100) NOT NULL COMMENT '姓名',
                                   `sex` VARCHAR(10) DEFAULT NULL COMMENT '性别',
                                   `age` INT UNSIGNED DEFAULT NULL COMMENT '年龄',
                                   `tel` VARCHAR(20) NOT NULL COMMENT '电话',
                                   `email` VARCHAR(100) NOT NULL UNIQUE COMMENT '邮箱',
                                   `city` VARCHAR(100) DEFAULT NULL COMMENT '求职城市',
                                   `pwd` VARCHAR(100) NOT NULL COMMENT '密码',
                                   `position` VARCHAR(100) DEFAULT NULL COMMENT '求职职位',
                                   `invite_code` VARCHAR(20) DEFAULT NULL COMMENT '我的邀请码',
                                   `created_at` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '记录添加时间',
                                   `updated_at` DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '记录修改时间',
                                   `is_deleted` TINYINT(1) DEFAULT 0 COMMENT '逻辑删除，1表示已删除，0表示未删除',
                                   `is_active` TINYINT(1) DEFAULT 1 COMMENT '是否启用，1表示启用，0表示未启用',
                                   INDEX `idx_name` (`name`) COMMENT '姓名索引',
                                   INDEX `idx_email` (`email`) COMMENT '邮箱索引'
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='求职者信息表';

-- 插入记录时使用 UUID() 函数生成 UUID
INSERT INTO `iis_job_seekers` (`id`, `name`, `sex`, `age`, `tel`, `email`, `city`, `pwd`, `position`, `invite_code`, `is_deleted`, `is_active`)
VALUES (UUID(), '张三', '男', 25, '12345678901', 'zhangsan@example.com', '北京', 'encrypted_password', '软件工程师', '123456', 0, 1);