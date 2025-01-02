package com.chi.shortlink.admin.dto.resp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.chi.shortlink.admin.common.serialize.PhoneDesensitizationSerializer;
import lombok.Data;

/**
 * User response parameters
 *
 */
@Data
public class UserRespDTO {

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
    @JsonSerialize(using = PhoneDesensitizationSerializer.class)
    private String phone;

    /**
     * Email
     */
    private String mail;
}