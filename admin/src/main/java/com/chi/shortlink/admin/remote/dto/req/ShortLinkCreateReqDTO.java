package com.chi.shortlink.admin.remote.dto.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * Short link creation request object
 *
 */
@Data
public class ShortLinkCreateReqDTO {

    /**
     * Domain
     */
    private String domain;

    /**
     * Original link
     */
    private String originUrl;

    /**
     * Group identifier
     */
    private String gid;

    /**
     * Creation type 0: API creation 1: Console creation
     */
    private Integer createdType;

    /**
     * Validity type 0: Permanent 1: Custom
     */
    private Integer validDateType;

    /**
     * Validity date
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date validDate;

    /**
     * Description
     */
    private String describe;
}