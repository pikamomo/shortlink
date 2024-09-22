package com.chi.shortlink.project.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * create short link response dto
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShortLinkCreateRespDTO {

    /**
     * group id
     */
    private String gid;

    /**
     * origin_url
     */
    private String originUrl;

    /**
     * full Short Url
     */
    private String fullShortUrl;
}
