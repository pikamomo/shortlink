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

package com.chi.shortlink.project.dto.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * Short link pagination response parameters
 *
 */
@Data
public class ShortLinkPageRespDTO {

    /**
     * id
     */
    private Long id;

    /**
     * Domain
     */
    private String domain;

    /**
     * Short link
     */
    private String shortUri;

    /**
     * Full short link
     */
    private String fullShortUrl;

    /**
     * Original link
     */
    private String originUrl;

    /**
     * Group identifier
     */
    private String gid;

    /**
     * Validity type 0: Permanent 1: Custom
     */
    private Integer validDateType;

    /**
     * Enable status 0: Enabled 1: Disabled
     */
    private Integer enableStatus;

    /**
     * Validity date
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date validDate;

    /**
     * Creation time
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    /**
     * Description
     */
    private String describe;

    /**
     * Website identifier
     */
    private String favicon;

    /**
     * Historical PV
     */
    private Integer totalPv;

    /**
     * Today's PV
     */
    private Integer todayPv;

    /**
     * Historical UV
     */
    private Integer totalUv;

    /**
     * Today's UV
     */
    private Integer todayUv;

    /**
     * Historical UIP
     */
    private Integer totalUip;

    /**
     * Today's UIP
     */
    private Integer todayUip;
}