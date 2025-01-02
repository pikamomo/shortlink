package com.chi.shortlink.admin.dto.req;

import lombok.Data;

/**
 * Short link group creation parameters
 *
 */
@Data
public class ShortLinkGroupSaveReqDTO {

    /**
     * Group name
     */
    private String name;
}