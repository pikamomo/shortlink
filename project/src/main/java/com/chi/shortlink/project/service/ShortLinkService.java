package com.chi.shortlink.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chi.shortlink.project.dao.entity.ShortLinkDO;
import com.chi.shortlink.project.dto.req.ShortLinkCreateReqDTO;
import com.chi.shortlink.project.dto.req.ShortLinkPageReqDTO;
import com.chi.shortlink.project.dto.req.ShortLinkUpdateReqDTO;
import com.chi.shortlink.project.dto.resp.ShortLinkGroupCountQueryRespDTO;
import com.chi.shortlink.project.dto.resp.ShortLinkPageRespDTO;

import java.util.List;

public interface ShortLinkService extends IService<ShortLinkDO> {
    /**
     * create short link
     * @param requestParam create short link request parameter
     * @return short link information
     */
    Object createShortLink(ShortLinkCreateReqDTO requestParam);

    /**
     * pagination short link
     * @param requestParam request parameter
     * @return pagination result
     */
    IPage<ShortLinkPageRespDTO> pageShortLink(ShortLinkPageReqDTO requestParam);

    /**
     * list group short link count
     * @param requestParam gid list
     * @return
     */
    List<ShortLinkGroupCountQueryRespDTO> listGroupShortLinkCount(List<String> requestParam);

    void updateShortLink(ShortLinkUpdateReqDTO requestParam);
}
