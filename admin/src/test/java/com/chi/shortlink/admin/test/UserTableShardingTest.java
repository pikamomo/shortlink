package com.chi.shortlink.admin.test;

public class UserTableShardingTest {
    public static final String SQL = "CREATE TABLE `t_link_%d` (\n" +
            "  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',\n" +
            "  `domain` varchar(128) DEFAULT NULL COMMENT 'domain',\n" +
            "  `short_uri` varchar(8) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT 'short link',\n" +
            "  `full_short_url` varchar(128) DEFAULT NULL COMMENT 'full short link',\n" +
            "  `origin_url` varchar(1024) DEFAULT NULL COMMENT 'origin_url',\n" +
            "  `click_num` int(11) DEFAULT '0' COMMENT 'click_num',\n" +
            "  `gid` varchar(32) DEFAULT NULL COMMENT 'group id',\n" +
            "  `favicon` varchar(256) DEFAULT NULL COMMENT 'favicon url',\n" +
            "  `enable_status` tinyint(1) DEFAULT NULL COMMENT 'valid 0：valid 1：not valid',\n" +
            "  `created_type` tinyint(1) DEFAULT NULL COMMENT 'create type 0：interface 1：console',\n" +
            "  `valid_date_type` tinyint(1) DEFAULT NULL COMMENT 'due time 0：premanent 1：custom',\n" +
            "  `valid_date` datetime DEFAULT NULL COMMENT 'valid time',\n" +
            "  `describe` varchar(1024) DEFAULT NULL COMMENT 'describe',\n" +
            "  `create_time` datetime DEFAULT NULL COMMENT 'create time',\n" +
            "  `update_time` datetime DEFAULT NULL COMMENT 'update time',\n" +
            "  `del_flag` tinyint(1) DEFAULT NULL COMMENT 'del flag 0：not del 1：del',\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  UNIQUE KEY `idx_unique_full_short_url` (`full_short_url`) USING BTREE\n" +
            ") ENGINE=InnoDB AUTO_INCREMENT=1837703808471810050 DEFAULT CHARSET=utf8mb4;";
    public static void main(String[] args) {
        for (int i = 0; i < 16; i++) {
            System.out.printf((SQL) + "%n", i);
        }
    }
}
