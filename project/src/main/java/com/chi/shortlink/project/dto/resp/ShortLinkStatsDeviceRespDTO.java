package com.chi.shortlink.project.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShortLinkStatsDeviceRespDTO {

    /**
     * cnt stat
     */
    private Integer cnt;

    /**
     * device stat
     */
    private String device;

    /**
     * ratio
     */
    private Double ratio;
}
