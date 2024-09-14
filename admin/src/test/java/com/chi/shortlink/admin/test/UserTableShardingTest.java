package com.chi.shortlink.admin.test;

public class UserTableShardingTest {
    public static final String SQL = "CREATE TABLE `t_user_%d` (\n" +
            "  `id` bigint(20) DEFAULT NULL COMMENT 'ID',\n" +
            "  `username` varchar(255) DEFAULT NULL COMMENT 'Username',\n" +
            "  `password` varchar(512) DEFAULT NULL COMMENT 'Password',\n" +
            "  `real_name` varchar(255) DEFAULT NULL COMMENT 'Realname',\n" +
            "  `phone` varchar(128) DEFAULT NULL COMMENT 'Phone',\n" +
            "  `mail` varchar(512) DEFAULT NULL COMMENT 'mail',\n" +
            "  `deletion_time` bigint(20) DEFAULT NULL COMMENT 'deletion_time',\n" +
            "  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'create_time',\n" +
            "  `update_time` datetime DEFAULT NULL COMMENT 'update_time',\n" +
            "  `del_flag` tinyint(1) DEFAULT NULL COMMENT 'del_flag 0: undelete 1:delete',\n" +
            "  UNIQUE KEY `idx_unique_username` (`username`) USING BTREE\n" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;";
    public static void main(String[] args) {
        for (int i = 0; i < 16; i++) {
            System.out.printf((SQL) + "%n", i);
        }
    }
}
