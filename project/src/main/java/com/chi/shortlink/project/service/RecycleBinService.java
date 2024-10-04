package com.chi.shortlink.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chi.shortlink.project.dao.entity.ShortLinkDO;
import com.chi.shortlink.project.dto.req.RecycleBinSaveReqDTO;

public interface RecycleBinService extends IService<ShortLinkDO> {

    /**
     * save recycle bin
     * @param requestParam
     */
    void saveRecycleBin(RecycleBinSaveReqDTO requestParam);
}
