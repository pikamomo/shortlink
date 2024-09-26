package com.chi.shortlink.admin.remote.dto.resp;

import lombok.Data;

/**
 * short link count query response object
 */
@Data
public class ShortLinkGroupCountQueryRespDTO {

    private String gid;

    private Integer shortLinkCount;
}
