package com.chi.shortlink.project.dto.req;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chi.shortlink.project.dao.entity.LinkAccessLogsDO;
import lombok.Data;

/**
 * single short link stats access record request dto
 */
@Data
public class ShortLinkStatsAccessRecordReqDTO extends Page<LinkAccessLogsDO> {
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
