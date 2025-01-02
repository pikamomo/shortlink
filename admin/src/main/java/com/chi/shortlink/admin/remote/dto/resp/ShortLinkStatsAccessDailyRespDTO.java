package com.chi.shortlink.admin.remote.dto.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * Short link basic access monitoring response parameters
 *
 */
@Data
public class ShortLinkStatsAccessDailyRespDTO {

    /**
     * Date
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date date;

    /**
     * Page views
     */
    private Integer pv;

    /**
     * Unique visitors
     */
    private Integer uv;

    /**
     * Unique IPs
     */
    private Integer uip;
}