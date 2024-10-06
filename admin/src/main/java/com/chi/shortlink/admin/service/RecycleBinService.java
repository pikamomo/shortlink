package com.chi.shortlink.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.chi.shortlink.admin.common.convention.result.Result;
import com.chi.shortlink.admin.dto.req.ShortLinkRecycleBinPageReqDTO;
import com.chi.shortlink.admin.remote.dto.resp.ShortLinkPageRespDTO;

/**
 * URL recycle bin service
 */
public interface RecycleBinService {

    Result<IPage<ShortLinkPageRespDTO>> pageRecycleBinShortLink(ShortLinkRecycleBinPageReqDTO requestParam);
}
