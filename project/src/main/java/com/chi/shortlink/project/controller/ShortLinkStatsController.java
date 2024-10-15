package com.chi.shortlink.project.controller;

import com.chi.shortlink.project.common.convention.result.Result;
import com.chi.shortlink.project.common.convention.result.Results;
import com.chi.shortlink.project.dto.req.ShortLinkStatsReqDTO;
import com.chi.shortlink.project.dto.resp.ShortLinkStatsRespDTO;
import com.chi.shortlink.project.service.ShortLinkStatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ShortLinkStatsController {

    private final ShortLinkStatsService shortLinkStatsService;

    @GetMapping("/api/short-link/v1/stats")
    public Result<ShortLinkStatsRespDTO> shortLinkStates(ShortLinkStatsReqDTO requestParam) {
        return Results.success(shortLinkStatsService.oneShortLinkStats(requestParam));
    }

//    /**
//     * short link stats access record in a period
//     * @param requestParam
//     * @return
//     */
//    @GetMapping("/api/short-link/v1/stats/access-record")
//    public Result<IPage<ShortLinkStatsAccessRecordRespDTO>> ShortLinkStatsAccessRecord(ShortLinkStatsAccessRecordReqDTO requestParam) {
//        return Results.success(shortLinkStatsService.shortLinkStatsAccessRecord(requestParam));
//    }


}
