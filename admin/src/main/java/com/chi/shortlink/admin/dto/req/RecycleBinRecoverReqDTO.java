package com.chi.shortlink.admin.dto.req;

import lombok.Data;

/**
 * Recycle bin recovery functionality
 *
 */
@Data
public class RecycleBinRecoverReqDTO {

    /**
     * Group identifier
     */
    private String gid;

    /**
     * Full short link
     */
    private String fullShortUrl;
}