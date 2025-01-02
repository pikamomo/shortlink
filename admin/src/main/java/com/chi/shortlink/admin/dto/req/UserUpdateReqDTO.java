package com.chi.shortlink.admin.dto.req;

import lombok.Data;

/**
 * User update request parameters
 *
 */
@Data
public class UserUpdateReqDTO {

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
}