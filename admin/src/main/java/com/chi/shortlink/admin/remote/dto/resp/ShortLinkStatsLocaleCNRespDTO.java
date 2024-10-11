package com.chi.shortlink.admin.remote.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShortLinkStatsLocaleCNRespDTO {

    /**
     * statistics
     */
    private Integer cnt;

    /**
     * region
     */
    private String locale;

    /**
     * ratio
     */
    private Double ratio;
}
