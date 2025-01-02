/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.chi.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chi.shortlink.admin.dao.entity.GroupDO;
import com.chi.shortlink.admin.dto.req.ShortLinkGroupSortReqDTO;
import com.chi.shortlink.admin.dto.req.ShortLinkGroupUpdateReqDTO;
import com.chi.shortlink.admin.dto.resp.ShortLinkGroupRespDTO;

import java.util.List;

/**
 * Short Link Group Service Interface
 *
 */
public interface GroupService extends IService<GroupDO> {

    /**
     * Add a new short link group
     *
     * @param groupName Short link group name
     */
    void saveGroup(String groupName);

    /**
     * Add a new short link group
     *
     * @param username  Username
     * @param groupName Short link group name
     */
    void saveGroup(String username, String groupName);

    /**
     * Query user short link group collection
     *
     * @return User short link group collection
     */
    List<ShortLinkGroupRespDTO> listGroup();

    /**
     * Update short link group
     *
     * @param requestParam Update link group parameters
     */
    void updateGroup(ShortLinkGroupUpdateReqDTO requestParam);

    /**
     * Delete short link group
     *
     * @param gid Short link group identifier
     */
    void deleteGroup(String gid);

    /**
     * Sort short link group
     *
     * @param requestParam Short link group sort parameters
     */
    void sortGroup(List<ShortLinkGroupSortReqDTO> requestParam);
}