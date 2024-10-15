package com.chi.shortlink.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chi.shortlink.project.dto.req.ShortLinkStatsAccessRecordReqDTO;
import com.chi.shortlink.project.dto.req.ShortLinkStatsReqDTO;
import com.chi.shortlink.project.dto.resp.ShortLinkStatsAccessRecordRespDTO;
import com.chi.shortlink.project.dto.resp.ShortLinkStatsRespDTO;

public interface ShortLinkStatsService {

    /**
     * get single short link monitoring data
     * @param requestParam
     * @return
     */
    ShortLinkStatsRespDTO oneShortLinkStats(ShortLinkStatsReqDTO requestParam);

    /**
     *  get short link monitoring data in a period
     * @param requestParam
     * @return
     */
    IPage<ShortLinkStatsAccessRecordRespDTO> shortLinkStatsAccessRecord(ShortLinkStatsAccessRecordReqDTO requestParam);
}
