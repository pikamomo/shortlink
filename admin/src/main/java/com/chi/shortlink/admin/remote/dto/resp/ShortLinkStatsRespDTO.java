package com.chi.shortlink.admin.remote.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Short link monitoring response parameters
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShortLinkStatsRespDTO {

    /**
     * Page views
     */
    private Integer pv;

    /**
     * Unique visitors
     */
    private Integer uv;

    /**
     * Unique IPs
     */
    private Integer uip;

    /**
     * Basic access details
     */
    private List<ShortLinkStatsAccessDailyRespDTO> daily;

    /**
     * Region access details (only domestic)
     */
    private List<ShortLinkStatsLocaleCNRespDTO> localeCnStats;

    /**
     * Hourly access details
     */
    private List<Integer> hourStats;

    /**
     * Frequent access IP details
     */
    private List<ShortLinkStatsTopIpRespDTO> topIpStats;

    /**
     * Weekly access details
     */
    private List<Integer> weekdayStats;

    /**
     * Browser access details
     */
    private List<ShortLinkStatsBrowserRespDTO> browserStats;

    /**
     * Operating system access details
     */
    private List<ShortLinkStatsOsRespDTO> osStats;

    /**
     * Visitor access type details
     */
    private List<ShortLinkStatsUvRespDTO> uvTypeStats;

    /**
     * Access device type details
     */
    private List<ShortLinkStatsDeviceRespDTO> deviceStats;

    /**
     * Access network type details
     */
    private List<ShortLinkStatsNetworkRespDTO> networkStats;
}