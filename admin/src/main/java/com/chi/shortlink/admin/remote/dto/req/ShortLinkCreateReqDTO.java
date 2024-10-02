package com.chi.shortlink.admin.remote.dto.req;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date validDate;

    /**
     * describe
     */
    private String describe;
}
