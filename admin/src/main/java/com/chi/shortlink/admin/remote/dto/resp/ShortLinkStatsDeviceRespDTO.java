package com.chi.shortlink.admin.remote.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Short link access device monitoring response parameters
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShortLinkStatsDeviceRespDTO {

    /**
     * Count
     */
    private Integer cnt;

    /**
     * Device type
     */
    private String device;

    /**
     * Ratio
     */
    private Double ratio;
}