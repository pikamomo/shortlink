package com.chi.shortlink.admin.remote.dto.resp;

import lombok.Data;

/**
 * Short link group query response parameters
 *
 */
@Data
public class ShortLinkGroupCountQueryRespDTO {

    /**
     * Group identifier
     */
    private String gid;

    /**
     * Number of short links
     */
    private Integer shortLinkCount;
}