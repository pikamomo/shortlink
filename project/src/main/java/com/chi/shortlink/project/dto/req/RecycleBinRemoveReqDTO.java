package com.chi.shortlink.project.dto.req;

import lombok.Data;

/**
 * Recycle remove
 */
@Data
public class RecycleBinRemoveReqDTO {

    private String gid;

    private String fullShortUrl;
}
