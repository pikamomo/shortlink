package com.chi.shortlink.admin.remote.dto.req;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

/**
 * Short link monitoring access record request parameters
 *
 */
@Data
public class ShortLinkStatsAccessRecordReqDTO extends Page {

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