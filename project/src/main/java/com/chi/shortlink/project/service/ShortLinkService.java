package com.chi.shortlink.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chi.shortlink.project.dao.entity.ShortLinkDO;
import com.chi.shortlink.project.dto.biz.ShortLinkStatsRecordDTO;
import com.chi.shortlink.project.dto.req.ShortLinkBatchCreateReqDTO;
import com.chi.shortlink.project.dto.req.ShortLinkCreateReqDTO;
import com.chi.shortlink.project.dto.req.ShortLinkPageReqDTO;
import com.chi.shortlink.project.dto.req.ShortLinkUpdateReqDTO;
import com.chi.shortlink.project.dto.resp.ShortLinkBatchCreateRespDTO;
import com.chi.shortlink.project.dto.resp.ShortLinkCreateRespDTO;
import com.chi.shortlink.project.dto.resp.ShortLinkGroupCountQueryRespDTO;
import com.chi.shortlink.project.dto.resp.ShortLinkPageRespDTO;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

import java.util.List;

/**
 * Short link interface layer
 *
 */
public interface ShortLinkService extends IService<ShortLinkDO> {

    /**
     * Create short link
     *
     * @param requestParam Request parameters for creating short link
     * @return Short link creation information
     */
    ShortLinkCreateRespDTO createShortLink(ShortLinkCreateReqDTO requestParam);

    /**
     * Create short link using distributed lock
     *
     * @param requestParam Request parameters for creating short link
     * @return Short link creation information
     */
    ShortLinkCreateRespDTO createShortLinkByLock(ShortLinkCreateReqDTO requestParam);

    /**
     * Batch create short links
     *
     * @param requestParam Request parameters for batch creating short links
     * @return Batch create short link response parameters
     */
    ShortLinkBatchCreateRespDTO batchCreateShortLink(ShortLinkBatchCreateReqDTO requestParam);

    /**
     * Update short link
     *
     * @param requestParam Request parameters for updating short link
     */
    void updateShortLink(ShortLinkUpdateReqDTO requestParam);

    /**
     * Paginated query of short links
     *
     * @param requestParam Request parameters for paginated query of short links
     * @return Paginated result of short links
     */
    IPage<ShortLinkPageRespDTO> pageShortLink(ShortLinkPageReqDTO requestParam);

    /**
     * Query the number of short links in the group
     *
     * @param requestParam Request parameters for querying the number of short links in the group
     * @return Response for querying the number of short links in the group
     */
    List<ShortLinkGroupCountQueryRespDTO> listGroupShortLinkCount(List<String> requestParam);

    /**
     * Short link redirection
     *
     * @param shortUri Short link suffix
     * @param request  HTTP request
     * @param response HTTP response
     */
    void restoreUrl(String shortUri, ServletRequest request, ServletResponse response);

    /**
     * Short link statistics
     *
     * @param shortLinkStatsRecord Short link statistics entity parameters
     */
    void shortLinkStats(ShortLinkStatsRecordDTO shortLinkStatsRecord);
}