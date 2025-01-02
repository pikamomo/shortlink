package com.chi.shortlink.admin.remote.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Short link operating system monitoring response parameters
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShortLinkStatsOsRespDTO {

    /**
     * Count
     */
    private Integer cnt;

    /**
     * Operating system
     */
    private String os;

    /**
     * Ratio
     */
    private Double ratio;
}