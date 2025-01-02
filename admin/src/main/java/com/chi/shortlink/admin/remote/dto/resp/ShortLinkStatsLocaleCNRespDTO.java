package com.chi.shortlink.admin.remote.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Short link region monitoring response parameters
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShortLinkStatsLocaleCNRespDTO {

    /**
     * Count
     */
    private Integer cnt;

    /**
     * Region
     */
    private String locale;

    /**
     * Ratio
     */
    private Double ratio;
}