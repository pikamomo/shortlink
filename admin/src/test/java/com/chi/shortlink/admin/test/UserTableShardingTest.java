package com.chi.shortlink.admin.test;

public class UserTableShardingTest {
    public static final String SQL = "CREATE TABLE `t_link_stats_today_%d` (\n" +
            "  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',\n" +
            "  `gid` varchar(32) DEFAULT 'default' COMMENT 'gid',\n" +
            "  `full_short_url` varchar(128) DEFAULT NULL COMMENT 'full short url',\n" +
            "  `date` date DEFAULT NULL COMMENT 'date',\n" +
            "  `today_pv` int(11) DEFAULT '0' COMMENT 'today PV',\n" +
            "  `today_uv` int(11) DEFAULT '0' COMMENT 'today UV',\n" +
            "  `today_uip` int(11) DEFAULT '0' COMMENT 'today IP cnt',\n" +
            "  `create_time` datetime DEFAULT NULL COMMENT 'create time',\n" +
            "  `update_time` datetime DEFAULT NULL COMMENT 'delete time',\n" +
            "  `del_flag` tinyint(1) DEFAULT NULL COMMENT 'delete flag 0：not del 1：del',\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  UNIQUE KEY `idx_unique_full-short-url` (`full_short_url`) USING BTREE\n" +
            ") ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;";

    public static void main(String[] args) {
        for (int i = 0; i < 16; i++) {
            System.out.printf((SQL) + "%n", i);
        }
    }
}
