package com.chi.shortlink.admin.remote.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Short link creation response object
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShortLinkCreateRespDTO {

    /**
     * Group identifier
     */
    private String gid;

    /**
     * Original link
     */
    private String originUrl;

    /**
     * Short link
     */
    private String fullShortUrl;
}