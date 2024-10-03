package com.chi.shortlink.admin.controller;

import com.chi.shortlink.admin.common.convention.result.Result;
import com.chi.shortlink.admin.remote.ShortLinkRemoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * URL title controller
 */
@RestController
@RequiredArgsConstructor
public class UrlTitleController {
    ShortLinkRemoteService shortLinkRemoteService = new ShortLinkRemoteService() {
    };
    @GetMapping("/api/short-link/admin/v1/title")
    public Result<String> getTitleByUrl(@RequestParam("url") String url) {
        return shortLinkRemoteService.getTitleByUrl(url);
    }
}
