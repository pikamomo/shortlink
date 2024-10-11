package com.chi.shortlink.project.dto.req;

import lombok.Data;

/**
 * single short link monitor request parameters
 */
@Data
public class ShortLinkStatsReqDTO {
    /**
     * full short link
     */
    private String fullShortUrl;

    /**
     * group id
     */
    private String gid;

    /**
     * start date
     */
    private String startDate;

    /**
     * end date
     */
    private String endDate;
}
