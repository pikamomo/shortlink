package com.chi.shortlink.admin.test;

public class UserTableShardingTest {
    public static final String SQL = "CREATE TABLE `t_group_%d` (\n" +
            "  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',\n" +
            "  `gid` varchar(32) DEFAULT NULL COMMENT 'group id',\n" +
            "  `name` varchar(64) DEFAULT NULL COMMENT 'group name',\n" +
            "  `username` varchar(256) DEFAULT NULL COMMENT 'group username',\n" +
            "  `sort_order` int(3) DEFAULT NULL COMMENT 'group sort',\n" +
            "  `create_time` datetime DEFAULT NULL COMMENT 'create time',\n" +
            "  `update_time` datetime DEFAULT NULL COMMENT 'update time',\n" +
            "  `del_flag` tinyint(1) DEFAULT NULL COMMENT 'del flag 0：not del 1：del',\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  UNIQUE KEY `idx_unique_username_gid` (`gid`,`username`) USING BTREE\n" +
            ") ENGINE=InnoDB AUTO_INCREMENT=1835535319841714179 DEFAULT CHARSET=utf8mb4;";
    public static void main(String[] args) {
        for (int i = 0; i < 16; i++) {
            System.out.printf((SQL) + "%n", i);
        }
    }
}
