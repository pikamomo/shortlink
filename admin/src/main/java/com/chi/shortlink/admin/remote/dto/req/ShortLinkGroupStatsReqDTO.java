package com.chi.shortlink.admin.remote.dto.req;

import lombok.Data;

/**
 * Group short link monitoring request parameters
 *
 */
@Data
public class ShortLinkGroupStatsReqDTO {

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
}