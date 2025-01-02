package com.chi.shortlink.admin.remote.dto.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Short link monitoring access record response parameters
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShortLinkStatsAccessRecordRespDTO {

    /**
     * Visitor type
     */
    private String uvType;

    /**
     * Browser
     */
    private String browser;

    /**
     * Operating system
     */
    private String os;

    /**
     * IP
     */
    private String ip;

    /**
     * Access network
     */
    private String network;

    /**
     * Access device
     */
    private String device;

    /**
     * Region
     */
    private String locale;

    /**
     * User information
     */
    private String user;

    /**
     * Access time
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}