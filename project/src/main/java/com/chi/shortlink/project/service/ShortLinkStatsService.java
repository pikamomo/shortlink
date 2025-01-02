package com.chi.shortlink.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chi.shortlink.project.dto.req.ShortLinkGroupStatsAccessRecordReqDTO;
import com.chi.shortlink.project.dto.req.ShortLinkGroupStatsReqDTO;
import com.chi.shortlink.project.dto.req.ShortLinkStatsAccessRecordReqDTO;
import com.chi.shortlink.project.dto.req.ShortLinkStatsReqDTO;
import com.chi.shortlink.project.dto.resp.ShortLinkStatsAccessRecordRespDTO;
import com.chi.shortlink.project.dto.resp.ShortLinkStatsRespDTO;

/**
 * Short link monitoring interface layer
 *
 */
public interface ShortLinkStatsService {

    /**
     * Get monitoring data for a single short link
     *
     * @param requestParam Request parameters for getting short link monitoring data
     * @return Short link monitoring data
     */
    ShortLinkStatsRespDTO oneShortLinkStats(ShortLinkStatsReqDTO requestParam);

    /**
     * Get monitoring data for grouped short links
     *
     * @param requestParam Request parameters for getting grouped short link monitoring data
     * @return Grouped short link monitoring data
     */
    ShortLinkStatsRespDTO groupShortLinkStats(ShortLinkGroupStatsReqDTO requestParam);

    /**
     * Access monitoring data for a single short link within a specified time
     *
     * @param requestParam Request parameters for getting short link access record monitoring data
     * @return Access record monitoring data
     */
    IPage<ShortLinkStatsAccessRecordRespDTO> shortLinkStatsAccessRecord(ShortLinkStatsAccessRecordReqDTO requestParam);

    /**
     * Access monitoring data for grouped short links within a specified time
     *
     * @param requestParam Request parameters for getting grouped short link access record monitoring data
     * @return Grouped access record monitoring data
     */
    IPage<ShortLinkStatsAccessRecordRespDTO> groupShortLinkStatsAccessRecord(ShortLinkGroupStatsAccessRecordReqDTO requestParam);
}