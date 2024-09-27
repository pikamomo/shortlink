package com.chi.shortlink.project.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.chi.shortlink.project.common.database.BaseDO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * short link object
 */
@Data
@TableName("t_link")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShortLinkDO extends BaseDO {
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
     * click_num
     */
    private Integer clickNum;

    /**
     * group id
     */
    private String gid;

    /**
     * favicon
     */
    private String favicon;
    /**
     * valid 0：valid 1：not valid
     */
    private Integer enableStatus;

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
    @TableField("`describe`")
    private String describe;
}
