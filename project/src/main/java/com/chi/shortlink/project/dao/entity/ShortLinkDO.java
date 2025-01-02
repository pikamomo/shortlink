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

package com.chi.shortlink.project.dao.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.chi.shortlink.project.common.database.BaseDO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Short Link Entity
 *
 */
@Data
@Builder
@TableName("t_link")
@NoArgsConstructor
@AllArgsConstructor
public class ShortLinkDO extends BaseDO {

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
     * Click count
     */
    private Integer clickNum;

    /**
     * Group identifier
     */
    private String gid;

    /**
     * Enable status 0: enabled 1: not enabled
     */
    private Integer enableStatus;

    /**
     * Creation type 0: API creation 1: console creation
     */
    private Integer createdType;

    /**
     * Validity type 0: permanent 1: custom
     */
    private Integer validDateType;

    /**
     * Validity date
     */
    private Date validDate;

    /**
     * Description
     */
    @TableField("`describe`")
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
     * Historical UV
     */
    private Integer totalUv;

    /**
     * Historical UIP
     */
    private Integer totalUip;

    /**
     * Today's PV
     */
    @TableField(exist = false)
    private Integer todayPv;

    /**
     * Today's UV
     */
    @TableField(exist = false)
    private Integer todayUv;

    /**
     * Today's UIP
     */
    @TableField(exist = false)
    private Integer todayUip;

    /**
     * Deletion time
     */
    private Long delTime;
}