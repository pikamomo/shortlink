package com.chi.shortlink.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chi.shortlink.project.dao.entity.ShortLinkDO;
import com.chi.shortlink.project.dto.req.RecycleBinSaveReqDTO;
import com.chi.shortlink.project.dto.req.ShortLinkPageReqDTO;
import com.chi.shortlink.project.dto.resp.ShortLinkPageRespDTO;

public interface RecycleBinService extends IService<ShortLinkDO> {

    /**
     * save recycle bin
     * @param requestParam
     */
    void saveRecycleBin(RecycleBinSaveReqDTO requestParam);

    /**
     * pagination short link
     * @param requestParam request parameter
     * @return pagination result
     */
    IPage<ShortLinkPageRespDTO> pageShortLink(ShortLinkPageReqDTO requestParam);
}
