package com.chi.shortlink.project.dto.resp;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

/**
 * short link pagination response dto
 */
@Data
public class ShortLinkPageRespDTO {
    /**
     * id
     */
    private Long id;

    /**
     * domain
     */
    private String domain;

    /**
     * short link
     */
    private String shortUri;

    /**
     * full short link
     */
    private String fullShortUrl;

    /**
     * origin_url
     */
    private String originUrl;

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
    private Date validDate;

    /**
     * describe
     */
    @TableField("`describe`")
    private String describe;

    /**
     * favicon
     */
    private String favicon;
}
