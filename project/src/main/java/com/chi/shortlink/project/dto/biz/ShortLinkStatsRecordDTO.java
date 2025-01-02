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

package com.chi.shortlink.project.dto.biz;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Short link statistics entity
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShortLinkStatsRecordDTO {

    /**
     * Full short link
     */
    private String fullShortUrl;

    /**
     * Access user IP
     */
    private String remoteAddr;

    /**
     * Operating system
     */
    private String os;

    /**
     * Browser
     */
    private String browser;

    /**
     * Operating device
     */
    private String device;

    /**
     * Network
     */
    private String network;

    /**
     * UV
     */
    private String uv;

    /**
     * UV access flag
     */
    private Boolean uvFirstFlag;

    /**
     * UIP access flag
     */
    private Boolean uipFirstFlag;

    /**
     * Message queue unique identifier
     */
    private String keys;

    /**
     * Current time
     */
    private Date currentDate;
}