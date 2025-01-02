package com.chi.shortlink.admin.remote.dto.req;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * Short link update request object
 *
 */
@Data
public class ShortLinkUpdateReqDTO {

    /**
     * Original link
     */
    private String originUrl;

    /**
     * Full short link
     */
    private String fullShortUrl;

    /**
     * Original group identifier
     */
    private String originGid;

    /**
     * Group identifier
     */
    private String gid;

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