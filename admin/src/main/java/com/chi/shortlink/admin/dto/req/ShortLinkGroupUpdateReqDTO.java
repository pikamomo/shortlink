package com.chi.shortlink.admin.dto.req;

import lombok.Data;

/**
 * Short link group update parameters
 *
 */
@Data
public class ShortLinkGroupUpdateReqDTO {

    /**
     * Group identifier
     */
    private String gid;

    /**
     * Group name
     */
    private String name;
}