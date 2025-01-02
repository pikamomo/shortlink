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

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chi.shortlink.admin.common.convention.result.Result;
import com.chi.shortlink.admin.remote.dto.req.ShortLinkRecycleBinPageReqDTO;
import com.chi.shortlink.admin.remote.dto.resp.ShortLinkPageRespDTO;

/**
 * URL Recycle Bin Service Interface
 *
 */
public interface RecycleBinService {

    /**
     * Paginate query recycle bin short links
     *
     * @param requestParam Request parameters
     * @return Return parameter package
     */
    Result<Page<ShortLinkPageRespDTO>> pageRecycleBinShortLink(ShortLinkRecycleBinPageReqDTO requestParam);
}