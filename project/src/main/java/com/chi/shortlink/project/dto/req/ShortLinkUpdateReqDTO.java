package com.chi.shortlink.project.dto.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * update short link request dto
 */
@Data
public class ShortLinkUpdateReqDTO {

    /**
     * origin_url
     */
    private String originUrl;

    /**
     * full short url
     */
    private String fullShortUrl;
    /**
     * group id
     */
    private String gid;

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
