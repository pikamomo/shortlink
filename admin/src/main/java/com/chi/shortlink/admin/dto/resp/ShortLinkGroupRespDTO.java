package com.chi.shortlink.admin.dto.resp;

import lombok.Data;

@Data
public class ShortLinkGroupRespDTO {
    /**
     * group id
     */
    private String gid;

    /**
     * group name
     */
    private String name;

    /**
     * group username
     */
    private String username;

    /**
     * group sort
     */
    private Integer sortOrder;
}
