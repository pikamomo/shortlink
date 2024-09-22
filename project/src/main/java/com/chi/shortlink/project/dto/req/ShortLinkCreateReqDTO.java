package com.chi.shortlink.project.dto.req;

import lombok.Data;

import java.util.Date;

/**
 * create short link request dto
 */
@Data
public class ShortLinkCreateReqDTO {

    /**
     * domain
     */
    private String domain;

    /**
     * origin_url
     */
    private String originUrl;

    /**
     * group id
     */
    private String gid;

    /**
     * create type 0：interface 1：console
     */
    private Integer createdType;

    /**
     * due time 0：premanent 1：custom
     */
    private Integer validDateType;

    /**
     * valid time
     */
    private Date validDate;

    /**
     * describe
     */
    private String describe;
}
