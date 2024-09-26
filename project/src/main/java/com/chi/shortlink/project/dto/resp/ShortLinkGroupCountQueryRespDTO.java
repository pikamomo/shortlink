package com.chi.shortlink.project.dto.resp;

import lombok.Data;

/**
 * short link count query response object
 */
@Data
public class ShortLinkGroupCountQueryRespDTO {

    private String gid;

    private Integer shortLinkCount;
}
