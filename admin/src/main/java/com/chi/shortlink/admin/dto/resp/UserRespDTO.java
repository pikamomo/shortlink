package com.chi.shortlink.admin.dto.resp;

import com.chi.shortlink.admin.serialize.PhoneDesensitizationSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

/**
 * user response parameter
 */
@Data
public class UserRespDTO {
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
    @JsonSerialize(using = PhoneDesensitizationSerializer.class)
    private String phone;

    /**
     * mail
     */
    private String mail;
}
