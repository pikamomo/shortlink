package com.chi.shortlink.project.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.chi.shortlink.project.common.database.BaseDO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@TableName("t_link_stats_today")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LinkStatsTodayDO extends BaseDO {
    /**
     * id
     */
    private Long id;

    /**
     * gid
     */
    private String gid;

    /**
     * full short url
     */
    private String fullShortUrl;

    /**
     * date
     */
    private Date date;

    /**
     * today pv
     */
    private Integer todayPv;

    /**
     * today uv
     */
    private Integer todayUv;

    /**
     * today ip cnt
     */
    private Integer todayUip;
}
