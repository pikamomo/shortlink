package com.chi.shortlink.project.dto.resp;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * monitor single short link record response parameters in a period
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShortLinkStatsAccessRecordRespDTO {
    /**
     *
     */
    private String uvType;

    /**
     * browser
     */
    private String browser;

    /**
     * operating system
     */
    private String os;

    /**
     * ip
     */
    private String ip;

    /**
     * network
     */
    private String network;

    /**
     * device
     */
    private String device;

    /**
     * locale
     */
    private String locale;

    private String user;

    /**
     * create_time
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
