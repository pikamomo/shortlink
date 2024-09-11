package com.chi.shortlink.admin.dto.resp;

import lombok.Data;

@Data
public class UserActualRespDTO {
    /**
     * id
     */
    private Long id;

    /**
     * username
     */
    private String username;


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
