package com.chi.shortlink.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chi.shortlink.project.dao.entity.ShortLinkDO;
import com.chi.shortlink.project.dto.req.ShortLinkCreateReqDTO;

public interface ShortLinkService extends IService<ShortLinkDO> {
    /**
     * create short link
     * @param requestParam create short link request parameter
     * @return short link information
     */
    Object createShortLink(ShortLinkCreateReqDTO requestParam);
}
