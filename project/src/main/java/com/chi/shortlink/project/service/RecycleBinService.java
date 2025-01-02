/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.chi.shortlink.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.chi.shortlink.project.dao.entity.ShortLinkDO;
import com.chi.shortlink.project.dto.req.RecycleBinRecoverReqDTO;
import com.chi.shortlink.project.dto.req.RecycleBinRemoveReqDTO;
import com.chi.shortlink.project.dto.req.RecycleBinSaveReqDTO;
import com.chi.shortlink.project.dto.req.ShortLinkRecycleBinPageReqDTO;
import com.chi.shortlink.project.dto.resp.ShortLinkPageRespDTO;

/**
 * Recycle Bin Management Interface Layer
 *
 */
public interface RecycleBinService extends IService<ShortLinkDO> {

    /**
     * Save to Recycle Bin
     *
     * @param requestParam Request parameters
     */
    void saveRecycleBin(RecycleBinSaveReqDTO requestParam);

    /**
     * Paginated query of short links
     *
     * @param requestParam Paginated query request parameters for short links
     * @return Paginated result of short links
     */
    IPage<ShortLinkPageRespDTO> pageShortLink(ShortLinkRecycleBinPageReqDTO requestParam);

    /**
     * Recover short links from Recycle Bin
     *
     * @param requestParam Request parameters for recovering short links
     */
    void recoverRecycleBin(RecycleBinRecoverReqDTO requestParam);

    /**
     * Remove short links from Recycle Bin
     *
     * @param requestParam Request parameters for removing short links
     */
    void removeRecycleBin(RecycleBinRemoveReqDTO requestParam);
}