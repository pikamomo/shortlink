package com.chi.shortlink.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chi.shortlink.admin.common.convention.result.Result;
import com.chi.shortlink.admin.common.convention.result.Results;
import com.chi.shortlink.admin.remote.ShortLinkRemoteService;
import com.chi.shortlink.admin.remote.dto.req.ShortLinkCreateReqDTO;
import com.chi.shortlink.admin.remote.dto.req.ShortLinkPageReqDTO;
import com.chi.shortlink.admin.remote.dto.req.ShortLinkUpdateReqDTO;
import com.chi.shortlink.admin.remote.dto.resp.ShortLinkPageRespDTO;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShortLinkController {
    ShortLinkRemoteService shortLinkRemoteService = new ShortLinkRemoteService() {
    };

    /**
     * Create short link
     *
     * @return
     */
    @PostMapping("/api/short-link/admin/v1/create")
    public Result createShortLink(@RequestBody ShortLinkCreateReqDTO requestParam) {
        return shortLinkRemoteService.createShortLink(requestParam);
    }

    /**
     * pagination short link
     *
     * @return
     */
    @GetMapping("/api/short-link/admin/v1/page")
    public Result<IPage<ShortLinkPageRespDTO>> pageShortLink(ShortLinkPageReqDTO requestParam) {
        return shortLinkRemoteService.pageShortLink(requestParam);
    }

    /**
     * update short link
     * @param requestParam
     * @return
     */
    @PostMapping("/api/short-link/admin/v1/update")
    public Result<Void> updateShortLink(@RequestBody ShortLinkUpdateReqDTO requestParam) {
        shortLinkRemoteService.updateShortLink(requestParam);
        return Results.success();
    }
}
