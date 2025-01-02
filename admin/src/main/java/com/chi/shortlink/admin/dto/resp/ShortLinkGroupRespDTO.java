package com.chi.shortlink.admin.dto.resp;

import lombok.Data;

/**
 * Short link group response entity
 *
 */
@Data
public class ShortLinkGroupRespDTO {

    /**
     * Group identifier
     */
    private String gid;

    /**
     * Group name
     */
    private String name;

    /**
     * Group sort order
     */
    private Integer sortOrder;

    /**
     * Number of short links in the group
     */
    private Integer shortLinkCount;
}