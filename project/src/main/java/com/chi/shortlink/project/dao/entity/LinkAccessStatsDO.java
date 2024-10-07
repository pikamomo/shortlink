package com.chi.shortlink.project.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.chi.shortlink.project.common.database.BaseDO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * base visit stats entity
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("t_link_access_stats")
public class LinkAccessStatsDO extends BaseDO {
    /**
     * id
     */
    private Long id;

    /**
     * group id
     */
    private String gid;

    /**
     * full short link
     */
    private String fullShortUrl;

    /**
     * date
     */
    private Date date;

    /**
     * page views
     */
    private Integer pv;

    /**
     * Unique Visitors
     */
    private Integer uv;

    /**
     * 独立ip数
     */
    private Integer uip;

    /**
     * hour
     */
    private Integer hour;

    /**
     * week
     */
    private Integer weekday;
}
