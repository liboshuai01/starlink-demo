CREATE TABLE `users`
(
    `id`       bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '用户编号',
    `username` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '账号',
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;