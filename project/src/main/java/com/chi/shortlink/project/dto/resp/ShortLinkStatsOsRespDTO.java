package com.chi.shortlink.project.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShortLinkStatsOsRespDTO {

    /**
     * cnt stat
     */
    private Integer cnt;

    /**
     * operation system
     */
    private String os;

    /**
     * ratio
     */
    private Double ratio;
}
