package com.chi.shortlink.admin.remote.dto.resp;

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
     * ID
     */
    private Long id;

    /**
     * Domain
     */
    private String domain;

    /**
     * Short URI
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