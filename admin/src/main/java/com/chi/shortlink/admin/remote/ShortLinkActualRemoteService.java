package com.chi.shortlink.admin.remote;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chi.shortlink.admin.common.convention.result.Result;
import com.chi.shortlink.admin.config.OpenFeignConfiguration;
import com.chi.shortlink.admin.dto.req.RecycleBinRecoverReqDTO;
import com.chi.shortlink.admin.dto.req.RecycleBinRemoveReqDTO;
import com.chi.shortlink.admin.dto.req.RecycleBinSaveReqDTO;
import com.chi.shortlink.admin.remote.dto.req.ShortLinkBatchCreateReqDTO;
import com.chi.shortlink.admin.remote.dto.req.ShortLinkCreateReqDTO;
import com.chi.shortlink.admin.remote.dto.req.ShortLinkUpdateReqDTO;
import com.chi.shortlink.admin.remote.dto.resp.ShortLinkBatchCreateRespDTO;
import com.chi.shortlink.admin.remote.dto.resp.ShortLinkCreateRespDTO;
import com.chi.shortlink.admin.remote.dto.resp.ShortLinkGroupCountQueryRespDTO;
import com.chi.shortlink.admin.remote.dto.resp.ShortLinkPageRespDTO;
import com.chi.shortlink.admin.remote.dto.resp.ShortLinkStatsAccessRecordRespDTO;
import com.chi.shortlink.admin.remote.dto.resp.ShortLinkStatsRespDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Short link remote service
 */
@FeignClient(
        value = "short-link-project",
        url = "${aggregation.remote-url:}",
        configuration = OpenFeignConfiguration.class
)
public interface ShortLinkActualRemoteService {

    /**
     * Create short link
     *
     * @param requestParam Create short link request parameters
     * @return Short link creation response
     */
    @PostMapping("/api/short-link/v1/create")
    Result<ShortLinkCreateRespDTO> createShortLink(@RequestBody ShortLinkCreateReqDTO requestParam);

    /**
     * Batch create short links
     *
     * @param requestParam Batch create short links request parameters
     * @return Short link batch creation response
     */
    @PostMapping("/api/short-link/v1/create/batch")
    Result<ShortLinkBatchCreateRespDTO> batchCreateShortLink(@RequestBody ShortLinkBatchCreateReqDTO requestParam);

    /**
     * Update short link
     *
     * @param requestParam Update short link request parameters
     */
    @PostMapping("/api/short-link/v1/update")
    void updateShortLink(@RequestBody ShortLinkUpdateReqDTO requestParam);

    /**
     * Paginate query short links
     *
     * @param gid      Group identifier
     * @param orderTag Order type
     * @param current  Current page
     * @param size     Number of items per page
     * @return Query short link response
     */
    @GetMapping("/api/short-link/v1/page")
    Result<Page<ShortLinkPageRespDTO>> pageShortLink(@RequestParam("gid") String gid,
                                                     @RequestParam("orderTag") String orderTag,
                                                     @RequestParam("current") Long current,
                                                     @RequestParam("size") Long size);

    /**
     * Query total number of group short links
     *
     * @param requestParam Group short link total request parameters
     * @return Query group short link total response
     */
    @GetMapping("/api/short-link/v1/count")
    Result<List<ShortLinkGroupCountQueryRespDTO>> listGroupShortLinkCount(@RequestParam("requestParam") List<String> requestParam);

    /**
     * Get title by URL
     *
     * @param url Target website address
     * @return Website title
     */
    @GetMapping("/api/short-link/v1/title")
    Result<String> getTitleByUrl(@RequestParam("url") String url);

    /**
     * Save to recycle bin
     *
     * @param requestParam Request parameters
     */
    @PostMapping("/api/short-link/v1/recycle-bin/save")
    void saveRecycleBin(@RequestBody RecycleBinSaveReqDTO requestParam);

    /**
     * Paginate query recycle bin short links
     *
     * @param gidList Group identifier list
     * @param current Current page
     * @param size    Number of items per page
     * @return Query short link response
     */
    @GetMapping("/api/short-link/v1/recycle-bin/page")
    Result<Page<ShortLinkPageRespDTO>> pageRecycleBinShortLink(@RequestParam("gidList") List<String> gidList,
                                                               @RequestParam("current") Long current,
                                                               @RequestParam("size") Long size);

    /**
     * Recover short link
     *
     * @param requestParam Short link recovery request parameters
     */
    @PostMapping("/api/short-link/v1/recycle-bin/recover")
    void recoverRecycleBin(@RequestBody RecycleBinRecoverReqDTO requestParam);

    /**
     * Remove short link
     *
     * @param requestParam Short link removal request parameters
     */
    @PostMapping("/api/short-link/v1/recycle-bin/remove")
    void removeRecycleBin(@RequestBody RecycleBinRemoveReqDTO requestParam);

    /**
     * Access single short link monitoring data within a specified time
     *
     * @param fullShortUrl Full short link
     * @param gid          Group identifier
     * @param startDate    Start date
     * @param endDate      End date
     * @return Short link monitoring information
     */
    @GetMapping("/api/short-link/v1/stats")
    Result<ShortLinkStatsRespDTO> oneShortLinkStats(@RequestParam("fullShortUrl") String fullShortUrl,
                                                    @RequestParam("gid") String gid,
                                                    @RequestParam("enableStatus") Integer enableStatus,
                                                    @RequestParam("startDate") String startDate,
                                                    @RequestParam("endDate") String endDate);

    /**
     * Access group short link monitoring data within a specified time
     *
     * @param gid       Group identifier
     * @param startDate Start date
     * @param endDate   End date
     * @return Group short link monitoring information
     */
    @GetMapping("/api/short-link/v1/stats/group")
    Result<ShortLinkStatsRespDTO> groupShortLinkStats(@RequestParam("gid") String gid,
                                                      @RequestParam("startDate") String startDate,
                                                      @RequestParam("endDate") String endDate);

    /**
     * Access single short link monitoring access record data within a specified time
     *
     * @param fullShortUrl Full short link
     * @param gid          Group identifier
     * @param startDate    Start date
     * @param endDate      End date
     * @param current      Current page
     * @param size         Number of items per page
     * @return Short link monitoring access record information
     */
    @GetMapping("/api/short-link/v1/stats/access-record")
    Result<Page<ShortLinkStatsAccessRecordRespDTO>> shortLinkStatsAccessRecord(@RequestParam("fullShortUrl") String fullShortUrl,
                                                                               @RequestParam("gid") String gid,
                                                                               @RequestParam("startDate") String startDate,
                                                                               @RequestParam("endDate") String endDate,
                                                                               @RequestParam("enableStatus") Integer enableStatus,
                                                                               @RequestParam("current") Long current,
                                                                               @RequestParam("size") Long size);

    /**
     * Access group short link monitoring access record data within a specified time
     *
     * @param gid       Group identifier
     * @param startDate Start date
     * @param endDate   End date
     * @param current   Current page
     * @param size      Number of items per page
     * @return Group short link monitoring access record information
     */
    @GetMapping("/api/short-link/v1/stats/access-record/group")
    Result<Page<ShortLinkStatsAccessRecordRespDTO>> groupShortLinkStatsAccessRecord(@RequestParam("gid") String gid,
                                                                                    @RequestParam("startDate") String startDate,
                                                                                    @RequestParam("endDate") String endDate,
                                                                                    @RequestParam("current") Long current,
                                                                                    @RequestParam("size") Long size);
}