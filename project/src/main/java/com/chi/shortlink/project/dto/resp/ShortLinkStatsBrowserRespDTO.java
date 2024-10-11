package com.chi.shortlink.project.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShortLinkStatsBrowserRespDTO {

    /**
     * stat count
     */
    private Integer cnt;

    /**
     * browser
     */
    private String browser;

    /**
     * ratio
     */
    private Double ratio;
}

