package com.chi.shortlink.project.dto.req;

import lombok.Data;

/**
 * Recycle recover
 */
@Data
public class RecycleBinRecoverReqDTO {

    private String gid;

    private String fullShortUrl;
}
