package com.chi.shortlink.admin.remote.dto.req;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

/**
 * single short link stats access record request dto
 */
@Data
public class ShortLinkStatsAccessRecordReqDTO extends Page {
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
