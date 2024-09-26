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
     * group sort
     */
    private Integer sortOrder;

    /**
     * group short link count
     */
    public Integer shortLinkCount;
}
