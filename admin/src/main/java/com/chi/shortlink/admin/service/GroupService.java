package com.chi.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chi.shortlink.admin.dao.entity.GroupDO;
import com.chi.shortlink.admin.dto.req.ShortLinkGroupUpdateReqDTO;
import com.chi.shortlink.admin.dto.resp.ShortLinkGroupRespDTO;

import java.util.List;

/**
 * short link group Interface
 */
public interface GroupService extends IService<GroupDO> {
    /**
     * create group
     * @param groupName
     */
    void saveGroup(String groupName);

    List<ShortLinkGroupRespDTO> listGroup();

    Void updateGroup(ShortLinkGroupUpdateReqDTO requestParam);

    void deleteGroup(String gid);
}
