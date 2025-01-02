package com.chi.shortlink.admin.dto.req;

import lombok.Data;

/**
 * Recycle bin save functionality
 *
 */
@Data
public class RecycleBinSaveReqDTO {

    /**
     * Group identifier
     */
    private String gid;

    /**
     * Full short link
     */
    private String fullShortUrl;
}