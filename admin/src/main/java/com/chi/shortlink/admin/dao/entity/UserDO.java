package com.chi.shortlink.admin.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.chi.shortlink.admin.common.database.BaseDO;
import lombok.Data;

/**
 * user dao entity
 */
@Data
@TableName("t_user")
public class UserDO extends BaseDO {

    /**
     * id
     */
    private Long id;

    /**
     * username
     */
    private String username;

    /**
     * password
     */
    private String password;

    /**
     * real_name
     */
    private String realName;

    /**
     * phone
     */
    private String phone;

    /**
     * mail
     */
    private String mail;

    /**
     * deletion_time
     */
    private Long deletionTime;

}
