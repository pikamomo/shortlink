package com.chi.shortlink.admin.controller;

import com.chi.shortlink.admin.common.convention.result.Result;
import com.chi.shortlink.admin.remote.ShortLinkRemoteService;
import com.chi.shortlink.admin.remote.dto.req.ShortLinkStatsReqDTO;
import com.chi.shortlink.admin.remote.dto.resp.ShortLinkStatsRespDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ShortLinkStatsController {

    ShortLinkRemoteService shortLinkRemoteService = new ShortLinkRemoteService() {
    };

    /**
     * get short link stats
     */
    @GetMapping("/api/short-link/admin/v1/stats")
    public Result<ShortLinkStatsRespDTO> shortLinkStats(ShortLinkStatsReqDTO requestParam) {
        return shortLinkRemoteService.oneShortLinkStats(requestParam);
    }


//    /**
//     * short link stats access record in a period
//     * @param requestParam
//     * @return
//     */
//    @GetMapping("/api/short-link/admin/v1/stats/access-record")
//    public Result<IPage<ShortLinkStatsAccessRecordRespDTO>> ShortLinkStatsAccessRecord(ShortLinkStatsAccessRecordReqDTO requestParam) {
//        return shortLinkRemoteService.shortLinkStatsAccessRecord(requestParam);
//    }
}

