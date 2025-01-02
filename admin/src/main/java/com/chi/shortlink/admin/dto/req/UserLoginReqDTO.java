package com.chi.shortlink.admin.dto.req;

import lombok.Data;

/**
 * User login request parameters
 *
 */
@Data
public class UserLoginReqDTO {

    /**
     * Username
     */
    private String username;

    /**
     * Password
     */
    private String password;
}