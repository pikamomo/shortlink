package com.chi.shortlink.admin.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.chi.shortlink.admin.common.database.BaseDO;
import lombok.Data;

/**
 * User persistence layer entity
 *
 */
@Data
@TableName("t_user")
public class UserDO extends BaseDO {

    /**
     * id
     */
    private Long id;

    /**
     * Username
     */
    private String username;

    /**
     * Password
     */
    private String password;

    /**
     * Real name
     */
    private String realName;

    /**
     * Phone number
     */
    private String phone;

    /**
     * Email
     */
    private String mail;

    /**
     * Deletion timestamp
     */
    private Long deletionTime;
}