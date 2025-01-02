package com.chi.shortlink.admin.dto.req;

import lombok.Data;

/**
 * Recycle bin removal functionality
 *
 */
@Data
public class RecycleBinRemoveReqDTO {

    /**
     * Group identifier
     */
    private String gid;

    /**
     * Full short link
     */
    private String fullShortUrl;
}