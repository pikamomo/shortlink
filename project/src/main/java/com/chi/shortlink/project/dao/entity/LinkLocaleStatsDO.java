package com.chi.shortlink.project.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.chi.shortlink.project.common.database.BaseDO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@TableName("t_link_locale_stats")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LinkLocaleStatsDO extends BaseDO {
    /**
     * id
     */
    private Long id;

    /**
     * full short link
     */
    private String fullShortUrl;

    /**
     * group id
     */
    private String gid;

    /**
     * date
     */
    private Date date;

    /**
     * visit count
     */
    private Integer cnt;

    /**
     * province
     */
    private String province;

    /**
     * city
     */
    private String city;

    /**
     * city code
     */
    private String adcode;

    /**
     * country
     */
    private String country;
}
