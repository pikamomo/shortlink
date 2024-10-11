package com.chi.shortlink.project.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * monitor single short link response parameters
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShortLinkStatsRespDTO {
    /**
     * pv
     */
    private Integer pv;

    /**
     * uv
     */
    private Integer uv;

    /**
     * unique ip
     */
    private Integer uip;

    /**
     * simple access data
     */
    private List<ShortLinkStatsAccessDailyRespDTO> daily;

    /**
     * region
     */
    private List<ShortLinkStatsLocaleCNRespDTO> localeCnStats;

    /**
     * statistics by hour
     */
    private List<Integer> hourStats;

//    /**
//     * statistics of high-frequency IP
//     */
//    private List<ShortLinkStatsTopIpRespDTO> topIpStats;

    /**
     * statistics by week
     */
    private List<Integer> weekdayStats;

    /**
     * browser stat
     */
    private List<ShortLinkStatsBrowserRespDTO> browserStats;

    /**
     * operating system stat
     */
    private List<ShortLinkStatsOsRespDTO> osStats;

//    /**
//     * visit source stat
//     */
//    private List<ShortLinkStatsUvRespDTO> uvTypeStats;

    /**
     * device stat
     */
    private List<ShortLinkStatsDeviceRespDTO> deviceStats;

//    /**
//     * network stat
//     */
//    private List<ShortLinkStatsNetworkRespDTO> networkStats;
}
