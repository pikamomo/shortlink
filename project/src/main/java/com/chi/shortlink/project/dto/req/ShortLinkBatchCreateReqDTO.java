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

package com.chi.shortlink.project.dto.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * Short link batch creation request object
 *
 */
@Data
public class ShortLinkBatchCreateReqDTO {

    /**
     * Original link collection
     */
    private List<String> originUrls;

    /**
     * Description collection
     */
    private List<String> describes;

    /**
     * Group identifier
     */
    private String gid;

    /**
     * Creation type 0: API creation 1: Console creation
     */
    private Integer createdType;

    /**
     * Validity period type 0: Permanent 1: Custom
     */
    private Integer validDateType;

    /**
     * Validity period
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date validDate;
}