package com.chi.shortlink.admin.dto.req;

import lombok.Data;

/**
 * Short link group sorting parameters
 *
 */
@Data
public class ShortLinkGroupSortReqDTO {

    /**
     * Group ID
     */
    private String gid;

    /**
     * Sort order
     */
    private Integer sortOrder;
}