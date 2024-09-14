package com.chi.shortlink.admin.dto.req;

import lombok.Data;

/**
 * user update parameter
 */
@Data
public class UserUpdaterReqDTO {

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
}
