package com.chi.shortlink.admin.dto.resp;

import lombok.Data;

/**
 * User response parameters
 *
 */
@Data
public class UserActualRespDTO {

    /**
     * id
     */
    private Long id;

    /**
     * Username
     */
    private String username;

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