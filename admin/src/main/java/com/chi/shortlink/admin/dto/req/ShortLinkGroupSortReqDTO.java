package com.chi.shortlink.admin.dto.req;

import lombok.Data;

/**
 * short link group create parameter
 */
@Data
public class ShortLinkGroupSortReqDTO {
    /**
     * group gid
     */
    private String gid;

    /**
     * sort order
     */
    private Integer sortOrder;
}
