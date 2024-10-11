package com.chi.shortlink.project.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShortLinkStatsAccessDailyRespDTO {

    /**
     * date
     */
    private String date;

    /**
     * page views
     */
    private Integer pv;

    /**
     * unique visitors
     */
    private Integer uv;

    /**
     * unique ip
     */
    private Integer uip;
}
