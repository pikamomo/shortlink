package com.chi.shortlink.admin.remote.dto.req;

import lombok.Data;

/**
 * Short link monitoring request parameters
 *
 */
@Data
public class ShortLinkStatsReqDTO {

    /**
     * Full short link
     */
    private String fullShortUrl;

    /**
     * Group identifier
     */
    private String gid;

    /**
     * Start date
     */
    private String startDate;

    /**
     * End date
     */
    private String endDate;

    /**
     * Enable status 0: Enabled 1: Disabled
     */
    private Integer enableStatus;
}