package com.chi.shortlink.project.service;

import com.chi.shortlink.project.dto.req.ShortLinkStatsReqDTO;
import com.chi.shortlink.project.dto.resp.ShortLinkStatsRespDTO;

public interface ShortLinkStatsService {

    /**
     * get single short link monitoring data
     * @param requestParam
     * @return
     */
    ShortLinkStatsRespDTO oneShortLinkStats(ShortLinkStatsReqDTO requestParam);
}
