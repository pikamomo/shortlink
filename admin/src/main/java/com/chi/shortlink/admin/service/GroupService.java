package com.chi.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chi.shortlink.admin.dao.entity.GroupDO;

/**
 * short link group Interface
 */
public interface GroupService extends IService<GroupDO> {
    /**
     * create group
     * @param groupName
     */
    void saveGroup(String groupName);

}
