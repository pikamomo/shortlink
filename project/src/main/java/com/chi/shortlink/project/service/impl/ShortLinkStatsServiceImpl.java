/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.chi.shortlink.project.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chi.shortlink.project.common.biz.user.UserContext;
import com.chi.shortlink.project.common.convention.exception.ServiceException;
import com.chi.shortlink.project.dao.entity.GroupDO;
import com.chi.shortlink.project.dao.entity.LinkAccessLogsDO;
import com.chi.shortlink.project.dao.entity.LinkAccessStatsDO;
import com.chi.shortlink.project.dao.entity.LinkDeviceStatsDO;
import com.chi.shortlink.project.dao.entity.LinkLocaleStatsDO;
import com.chi.shortlink.project.dao.entity.LinkNetworkStatsDO;
import com.chi.shortlink.project.dao.mapper.LinkGroupMapper;
import com.chi.shortlink.project.dao.mapper.LinkAccessLogsMapper;
import com.chi.shortlink.project.dao.mapper.LinkAccessStatsMapper;
import com.chi.shortlink.project.dao.mapper.LinkBrowserStatsMapper;
import com.chi.shortlink.project.dao.mapper.LinkDeviceStatsMapper;
import com.chi.shortlink.project.dao.mapper.LinkLocaleStatsMapper;
import com.chi.shortlink.project.dao.mapper.LinkNetworkStatsMapper;
import com.chi.shortlink.project.dao.mapper.LinkOsStatsMapper;
import com.chi.shortlink.project.dto.req.ShortLinkGroupStatsAccessRecordReqDTO;
import com.chi.shortlink.project.dto.req.ShortLinkGroupStatsReqDTO;
import com.chi.shortlink.project.dto.req.ShortLinkStatsAccessRecordReqDTO;
import com.chi.shortlink.project.dto.req.ShortLinkStatsReqDTO;
import com.chi.shortlink.project.dto.resp.ShortLinkStatsAccessDailyRespDTO;
import com.chi.shortlink.project.dto.resp.ShortLinkStatsAccessRecordRespDTO;
import com.chi.shortlink.project.dto.resp.ShortLinkStatsBrowserRespDTO;
import com.chi.shortlink.project.dto.resp.ShortLinkStatsDeviceRespDTO;
import com.chi.shortlink.project.dto.resp.ShortLinkStatsLocaleCNRespDTO;
import com.chi.shortlink.project.dto.resp.ShortLinkStatsNetworkRespDTO;
import com.chi.shortlink.project.dto.resp.ShortLinkStatsOsRespDTO;
import com.chi.shortlink.project.dto.resp.ShortLinkStatsRespDTO;
import com.chi.shortlink.project.dto.resp.ShortLinkStatsTopIpRespDTO;
import com.chi.shortlink.project.dto.resp.ShortLinkStatsUvRespDTO;
import com.chi.shortlink.project.service.ShortLinkStatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Short link monitoring interface implementation layer
 */
@Service
@RequiredArgsConstructor
public class ShortLinkStatsServiceImpl implements ShortLinkStatsService {

    private final LinkGroupMapper linkGroupMapper;
    private final LinkAccessStatsMapper linkAccessStatsMapper;
    private final LinkLocaleStatsMapper linkLocaleStatsMapper;
    private final LinkAccessLogsMapper linkAccessLogsMapper;
    private final LinkBrowserStatsMapper linkBrowserStatsMapper;
    private final LinkOsStatsMapper linkOsStatsMapper;
    private final LinkDeviceStatsMapper linkDeviceStatsMapper;
    private final LinkNetworkStatsMapper linkNetworkStatsMapper;

    @Override
    public ShortLinkStatsRespDTO oneShortLinkStats(ShortLinkStatsReqDTO requestParam) {
        checkGroupBelongToUser(requestParam.getGid());
        List<LinkAccessStatsDO> listStatsByShortLink = linkAccessStatsMapper.listStatsByShortLink(requestParam);
        if (CollUtil.isEmpty(listStatsByShortLink)) {
            return null;
        }
        // Basic access data
        LinkAccessStatsDO pvUvUidStatsByShortLink = linkAccessLogsMapper.findPvUvUidStatsByShortLink(requestParam);
        // Basic access details
        List<ShortLinkStatsAccessDailyRespDTO> daily = new ArrayList<>();
        List<String> rangeDates = DateUtil.rangeToList(
                        DateUtil.parse(requestParam.getStartDate()),
                        DateUtil.parse(requestParam.getEndDate()),
                        DateField.DAY_OF_MONTH
                ).stream()
                .map(DateUtil::formatDate)
                .toList();
        rangeDates.forEach(each -> listStatsByShortLink.stream()
                .filter(item -> Objects.equals(each, DateUtil.formatDate(item.getDate())))
                .findFirst()
                .ifPresentOrElse(item -> {
                    ShortLinkStatsAccessDailyRespDTO accessDailyRespDTO = ShortLinkStatsAccessDailyRespDTO.builder()
                            .date(each)
                            .pv(item.getPv())
                            .uv(item.getUv())
                            .uip(item.getUip())
                            .build();
                    daily.add(accessDailyRespDTO);
                }, () -> {
                    ShortLinkStatsAccessDailyRespDTO accessDailyRespDTO = ShortLinkStatsAccessDailyRespDTO.builder()
                            .date(each)
                            .pv(0)
                            .uv(0)
                            .uip(0)
                            .build();
                    daily.add(accessDailyRespDTO);
                }));
        // Regional access details (domestic only)
        List<ShortLinkStatsLocaleCNRespDTO> localeCnStats = new ArrayList<>();
        List<LinkLocaleStatsDO> listedLocaleByShortLink = linkLocaleStatsMapper.listLocaleByShortLink(requestParam);
        int localeCnSum = listedLocaleByShortLink.stream()
                .mapToInt(LinkLocaleStatsDO::getCnt)
                .sum();
        listedLocaleByShortLink.forEach(each -> {
            double ratio = (double) each.getCnt() / localeCnSum;
            double actualRatio = Math.round(ratio * 100.0) / 100.0;
            ShortLinkStatsLocaleCNRespDTO localeCNRespDTO = ShortLinkStatsLocaleCNRespDTO.builder()
                    .cnt(each.getCnt())
                    .locale(each.getProvince())
                    .ratio(actualRatio)
                    .build();
            localeCnStats.add(localeCNRespDTO);
        });
        // Hourly access details
        List<Integer> hourStats = new ArrayList<>();
        List<LinkAccessStatsDO> listHourStatsByShortLink = linkAccessStatsMapper.listHourStatsByShortLink(requestParam);
        for (int i = 0; i < 24; i++) {
            AtomicInteger hour = new AtomicInteger(i);
            int hourCnt = listHourStatsByShortLink.stream()
                    .filter(each -> Objects.equals(each.getHour(), hour.get()))
                    .findFirst()
                    .map(LinkAccessStatsDO::getPv)
                    .orElse(0);
            hourStats.add(hourCnt);
        }
        // High-frequency IP access details
        List<ShortLinkStatsTopIpRespDTO> topIpStats = new ArrayList<>();
        List<HashMap<String, Object>> listTopIpByShortLink = linkAccessLogsMapper.listTopIpByShortLink(requestParam);
        listTopIpByShortLink.forEach(each -> {
            ShortLinkStatsTopIpRespDTO statsTopIpRespDTO = ShortLinkStatsTopIpRespDTO.builder()
                    .ip(each.get("ip").toString())
                    .cnt(Integer.parseInt(each.get("count").toString()))
                    .build();
            topIpStats.add(statsTopIpRespDTO);
        });
        // Weekly access details
        List<Integer> weekdayStats = new ArrayList<>();
        List<LinkAccessStatsDO> listWeekdayStatsByShortLink = linkAccessStatsMapper.listWeekdayStatsByShortLink(requestParam);
        for (int i = 1; i < 8; i++) {
            AtomicInteger weekday = new AtomicInteger(i);
            int weekdayCnt = listWeekdayStatsByShortLink.stream()
                    .filter(each -> Objects.equals(each.getWeekday(), weekday.get()))
                    .findFirst()
                    .map(LinkAccessStatsDO::getPv)
                    .orElse(0);
            weekdayStats.add(weekdayCnt);
        }
        // Browser access details
        List<ShortLinkStatsBrowserRespDTO> browserStats = new ArrayList<>();
        List<HashMap<String, Object>> listBrowserStatsByShortLink = linkBrowserStatsMapper.listBrowserStatsByShortLink(requestParam);
        int browserSum = listBrowserStatsByShortLink.stream()
                .mapToInt(each -> Integer.parseInt(each.get("count").toString()))
                .sum();
        listBrowserStatsByShortLink.forEach(each -> {
            double ratio = (double) Integer.parseInt(each.get("count").toString()) / browserSum;
            double actualRatio = Math.round(ratio * 100.0) / 100.0;
            ShortLinkStatsBrowserRespDTO browserRespDTO = ShortLinkStatsBrowserRespDTO.builder()
                    .cnt(Integer.parseInt(each.get("count").toString()))
                    .browser(each.get("browser").toString())
                    .ratio(actualRatio)
                    .build();
            browserStats.add(browserRespDTO);
        });
        // Operating system access details
        List<ShortLinkStatsOsRespDTO> osStats = new ArrayList<>();
        List<HashMap<String, Object>> listOsStatsByShortLink = linkOsStatsMapper.listOsStatsByShortLink(requestParam);
        int osSum = listOsStatsByShortLink.stream()
                .mapToInt(each -> Integer.parseInt(each.get("count").toString()))
                .sum();
        listOsStatsByShortLink.forEach(each -> {
            double ratio = (double) Integer.parseInt(each.get("count").toString()) / osSum;
            double actualRatio = Math.round(ratio * 100.0) / 100.0;
            ShortLinkStatsOsRespDTO osRespDTO = ShortLinkStatsOsRespDTO.builder()
                    .cnt(Integer.parseInt(each.get("count").toString()))
                    .os(each.get("os").toString())
                    .ratio(actualRatio)
                    .build();
            osStats.add(osRespDTO);
        });
        // Visitor type details
        List<ShortLinkStatsUvRespDTO> uvTypeStats = new ArrayList<>();
        HashMap<String, Object> findUvTypeByShortLink = linkAccessLogsMapper.findUvTypeCntByShortLink(requestParam);
        int oldUserCnt = Integer.parseInt(
                Optional.ofNullable(findUvTypeByShortLink)
                        .map(each -> each.get("oldUserCnt"))
                        .map(Object::toString)
                        .orElse("0")
        );
        int newUserCnt = Integer.parseInt(
                Optional.ofNullable(findUvTypeByShortLink)
                        .map(each -> each.get("newUserCnt"))
                        .map(Object::toString)
                        .orElse("0")
        );
        int uvSum = oldUserCnt + newUserCnt;
        double oldRatio = (double) oldUserCnt / uvSum;
        double actualOldRatio = Math.round(oldRatio * 100.0) / 100.0;
        double newRatio = (double) newUserCnt / uvSum;
        double actualNewRatio = Math.round(newRatio * 100.0) / 100.0;
        ShortLinkStatsUvRespDTO newUvRespDTO = ShortLinkStatsUvRespDTO.builder()
                .uvType("newUser")
                .cnt(newUserCnt)
                .ratio(actualNewRatio)
                .build();
        uvTypeStats.add(newUvRespDTO);
        ShortLinkStatsUvRespDTO oldUvRespDTO = ShortLinkStatsUvRespDTO.builder()
                .uvType("oldUser")
                .cnt(oldUserCnt)
                .ratio(actualOldRatio)
                .build();
        uvTypeStats.add(oldUvRespDTO);
        // Access device type details
        List<ShortLinkStatsDeviceRespDTO> deviceStats = new ArrayList<>();
        List<LinkDeviceStatsDO> listDeviceStatsByShortLink = linkDeviceStatsMapper.listDeviceStatsByShortLink(requestParam);
        int deviceSum = listDeviceStatsByShortLink.stream()
                .mapToInt(LinkDeviceStatsDO::getCnt)
                .sum();
        listDeviceStatsByShortLink.forEach(each -> {
            double ratio = (double) each.getCnt() / deviceSum;
            double actualRatio = Math.round(ratio * 100.0) / 100.0;
            ShortLinkStatsDeviceRespDTO deviceRespDTO = ShortLinkStatsDeviceRespDTO.builder()
                    .cnt(each.getCnt())
                    .device(each.getDevice())
                    .ratio(actualRatio)
                    .build();
            deviceStats.add(deviceRespDTO);
        });
        // Access network type details
        List<ShortLinkStatsNetworkRespDTO> networkStats = new ArrayList<>();
        List<LinkNetworkStatsDO> listNetworkStatsByShortLink = linkNetworkStatsMapper.listNetworkStatsByShortLink(requestParam);
        int networkSum = listNetworkStatsByShortLink.stream()
                .mapToInt(LinkNetworkStatsDO::getCnt)
                .sum();
        listNetworkStatsByShortLink.forEach(each -> {
            double ratio = (double) each.getCnt() / networkSum;
            double actualRatio = Math.round(ratio * 100.0) / 100.0;
            ShortLinkStatsNetworkRespDTO networkRespDTO = ShortLinkStatsNetworkRespDTO.builder()
                    .cnt(each.getCnt())
                    .network(each.getNetwork())
                    .ratio(actualRatio)
                    .build();
            networkStats.add(networkRespDTO);
        });
        return ShortLinkStatsRespDTO.builder()
                .pv(pvUvUidStatsByShortLink.getPv())
                .uv(pvUvUidStatsByShortLink.getUv())
                .uip(pvUvUidStatsByShortLink.getUip())
                .daily(daily)
                .localeCnStats(localeCnStats)
                .hourStats(hourStats)
                .topIpStats(topIpStats)
                .weekdayStats(weekdayStats)
                .browserStats(browserStats)
                .osStats(osStats)
                .uvTypeStats(uvTypeStats)
                .deviceStats(deviceStats)
                .networkStats(networkStats)
                .build();
    }

    @Override
    public ShortLinkStatsRespDTO groupShortLinkStats(ShortLinkGroupStatsReqDTO requestParam) {
        checkGroupBelongToUser(requestParam.getGid());
        List<LinkAccessStatsDO> listStatsByGroup = linkAccessStatsMapper.listStatsByGroup(requestParam);
        if (CollUtil.isEmpty(listStatsByGroup)) {
            return null;
        }
        // Basic access data
        LinkAccessStatsDO pvUvUidStatsByGroup = linkAccessLogsMapper.findPvUvUidStatsByGroup(requestParam);
        // Basic access details
        List<ShortLinkStatsAccessDailyRespDTO> daily = new ArrayList<>();
        List<String> rangeDates = DateUtil.rangeToList(
                        DateUtil.parse(requestParam.getStartDate()),
                        DateUtil.parse(requestParam.getEndDate()),
                        DateField.DAY_OF_MONTH
                ).stream()
                .map(DateUtil::formatDate)
                .toList();
        rangeDates.forEach(each -> listStatsByGroup.stream()
                .filter(item -> Objects.equals(each, DateUtil.formatDate(item.getDate())))
                .findFirst()
                .ifPresentOrElse(item -> {
                    ShortLinkStatsAccessDailyRespDTO accessDailyRespDTO = ShortLinkStatsAccessDailyRespDTO.builder()
                            .date(each)
                            .pv(item.getPv())
                            .uv(item.getUv())
                            .uip(item.getUip())
                            .build();
                    daily.add(accessDailyRespDTO);
                }, () -> {
                    ShortLinkStatsAccessDailyRespDTO accessDailyRespDTO = ShortLinkStatsAccessDailyRespDTO.builder()
                            .date(each)
                            .pv(0)
                            .uv(0)
                            .uip(0)
                            .build();
                    daily.add(accessDailyRespDTO);
                }));
        // Regional access details (domestic only)
        List<ShortLinkStatsLocaleCNRespDTO> localeCnStats = new ArrayList<>();
        List<LinkLocaleStatsDO> listedLocaleByGroup = linkLocaleStatsMapper.listLocaleByGroup(requestParam);
        int localeCnSum = listedLocaleByGroup.stream()
                .mapToInt(LinkLocaleStatsDO::getCnt)
                .sum();
        listedLocaleByGroup.forEach(each -> {
            double ratio = (double) each.getCnt() / localeCnSum;
            double actualRatio = Math.round(ratio * 100.0) / 100.0;
            ShortLinkStatsLocaleCNRespDTO localeCNRespDTO = ShortLinkStatsLocaleCNRespDTO.builder()
                    .cnt(each.getCnt())
                    .locale(each.getProvince())
                    .ratio(actualRatio)
                    .build();
            localeCnStats.add(localeCNRespDTO);
        });
        // Hourly access details
        List<Integer> hourStats = new ArrayList<>();
        List<LinkAccessStatsDO> listHourStatsByGroup = linkAccessStatsMapper.listHourStatsByGroup(requestParam);
        for (int i = 0; i < 24; i++) {
            AtomicInteger hour = new AtomicInteger(i);
            int hourCnt = listHourStatsByGroup.stream()
                    .filter(each -> Objects.equals(each.getHour(), hour.get()))
                    .findFirst()
                    .map(LinkAccessStatsDO::getPv)
                    .orElse(0);
            hourStats.add(hourCnt);
        }
        // High-frequency IP access details
        List<ShortLinkStatsTopIpRespDTO> topIpStats = new ArrayList<>();
        List<HashMap<String, Object>> listTopIpByGroup = linkAccessLogsMapper.listTopIpByGroup(requestParam);
        listTopIpByGroup.forEach(each -> {
            ShortLinkStatsTopIpRespDTO statsTopIpRespDTO = ShortLinkStatsTopIpRespDTO.builder()
                    .ip(each.get("ip").toString())
                    .cnt(Integer.parseInt(each.get("count").toString()))
                    .build();
            topIpStats.add(statsTopIpRespDTO);
        });
        // Weekly access details
        List<Integer> weekdayStats = new ArrayList<>();
        List<LinkAccessStatsDO> listWeekdayStatsByGroup = linkAccessStatsMapper.listWeekdayStatsByGroup(requestParam);
        for (int i = 1; i < 8; i++) {
            AtomicInteger weekday = new AtomicInteger(i);
            int weekdayCnt = listWeekdayStatsByGroup.stream()
                    .filter(each -> Objects.equals(each.getWeekday(), weekday.get()))
                    .findFirst()
                    .map(LinkAccessStatsDO::getPv)
                    .orElse(0);
            weekdayStats.add(weekdayCnt);
        }
        // Browser access details
        List<ShortLinkStatsBrowserRespDTO> browserStats = new ArrayList<>();
        List<HashMap<String, Object>> listBrowserStatsByGroup = linkBrowserStatsMapper.listBrowserStatsByGroup(requestParam);
        int browserSum = listBrowserStatsByGroup.stream()
                .mapToInt(each -> Integer.parseInt(each.get("count").toString()))
                .sum();
        listBrowserStatsByGroup.forEach(each -> {
            double ratio = (double) Integer.parseInt(each.get("count").toString()) / browserSum;
            double actualRatio = Math.round(ratio * 100.0) / 100.0;
            ShortLinkStatsBrowserRespDTO browserRespDTO = ShortLinkStatsBrowserRespDTO.builder()
                    .cnt(Integer.parseInt(each.get("count").toString()))
                    .browser(each.get("browser").toString())
                    .ratio(actualRatio)
                    .build();
            browserStats.add(browserRespDTO);
        });
        // Operating system access details
        List<ShortLinkStatsOsRespDTO> osStats = new ArrayList<>();
        List<HashMap<String, Object>> listOsStatsByGroup = linkOsStatsMapper.listOsStatsByGroup(requestParam);
        int osSum = listOsStatsByGroup.stream()
                .mapToInt(each -> Integer.parseInt(each.get("count").toString()))
                .sum();
        listOsStatsByGroup.forEach(each -> {
            double ratio = (double) Integer.parseInt(each.get("count").toString()) / osSum;
            double actualRatio = Math.round(ratio * 100.0) / 100.0;
            ShortLinkStatsOsRespDTO osRespDTO = ShortLinkStatsOsRespDTO.builder()
                    .cnt(Integer.parseInt(each.get("count").toString()))
                    .os(each.get("os").toString())
                    .ratio(actualRatio)
                    .build();
            osStats.add(osRespDTO);
        });
        // Access device type details
        List<ShortLinkStatsDeviceRespDTO> deviceStats = new ArrayList<>();
        List<LinkDeviceStatsDO> listDeviceStatsByGroup = linkDeviceStatsMapper.listDeviceStatsByGroup(requestParam);
        int deviceSum = listDeviceStatsByGroup.stream()
                .mapToInt(LinkDeviceStatsDO::getCnt)
                .sum();
        listDeviceStatsByGroup.forEach(each -> {
            double ratio = (double) each.getCnt() / deviceSum;
            double actualRatio = Math.round(ratio * 100.0) / 100.0;
            ShortLinkStatsDeviceRespDTO deviceRespDTO = ShortLinkStatsDeviceRespDTO.builder()
                    .cnt(each.getCnt())
                    .device(each.getDevice())
                    .ratio(actualRatio)
                    .build();
            deviceStats.add(deviceRespDTO);
        });
        // Access network type details
        List<ShortLinkStatsNetworkRespDTO> networkStats = new ArrayList<>();
        List<LinkNetworkStatsDO> listNetworkStatsByGroup = linkNetworkStatsMapper.listNetworkStatsByGroup(requestParam);
        int networkSum = listNetworkStatsByGroup.stream()
                .mapToInt(LinkNetworkStatsDO::getCnt)
                .sum();
        listNetworkStatsByGroup.forEach(each -> {
            double ratio = (double) each.getCnt() / networkSum;
            double actualRatio = Math.round(ratio * 100.0) / 100.0;
            ShortLinkStatsNetworkRespDTO networkRespDTO = ShortLinkStatsNetworkRespDTO.builder()
                    .cnt(each.getCnt())
                    .network(each.getNetwork())
                    .ratio(actualRatio)
                    .build();
            networkStats.add(networkRespDTO);
        });
        return ShortLinkStatsRespDTO.builder()
                .pv(pvUvUidStatsByGroup.getPv())
                .uv(pvUvUidStatsByGroup.getUv())
                .uip(pvUvUidStatsByGroup.getUip())
                .daily(daily)
                .localeCnStats(localeCnStats)
                .hourStats(hourStats)
                .topIpStats(topIpStats)
                .weekdayStats(weekdayStats)
                .browserStats(browserStats)
                .osStats(osStats)
                .deviceStats(deviceStats)
                .networkStats(networkStats)
                .build();
    }

    @Override
    public IPage<ShortLinkStatsAccessRecordRespDTO> shortLinkStatsAccessRecord(ShortLinkStatsAccessRecordReqDTO requestParam) {
        checkGroupBelongToUser(requestParam.getGid());
        LambdaQueryWrapper<LinkAccessLogsDO> queryWrapper = Wrappers.lambdaQuery(LinkAccessLogsDO.class)
                .eq(LinkAccessLogsDO::getFullShortUrl, requestParam.getFullShortUrl())
                .between(LinkAccessLogsDO::getCreateTime, requestParam.getStartDate(), requestParam.getEndDate())
                .eq(LinkAccessLogsDO::getDelFlag, 0)
                .orderByDesc(LinkAccessLogsDO::getCreateTime);
        IPage<LinkAccessLogsDO> linkAccessLogsDOIPage = linkAccessLogsMapper.selectPage(requestParam, queryWrapper);
        if (CollUtil.isEmpty(linkAccessLogsDOIPage.getRecords())) {
            return new Page<>();
        }
        IPage<ShortLinkStatsAccessRecordRespDTO> actualResult = linkAccessLogsDOIPage.convert(each -> BeanUtil.toBean(each, ShortLinkStatsAccessRecordRespDTO.class));
        List<String> userAccessLogsList = actualResult.getRecords().stream()
                .map(ShortLinkStatsAccessRecordRespDTO::getUser)
                .toList();
        List<Map<String, Object>> uvTypeList = linkAccessLogsMapper.selectUvTypeByUsers(
                requestParam.getGid(),
                requestParam.getFullShortUrl(),
                requestParam.getEnableStatus(),
                requestParam.getStartDate(),
                requestParam.getEndDate(),
                userAccessLogsList
        );
        actualResult.getRecords().forEach(each -> {
            String uvType = uvTypeList.stream()
                    .filter(item -> Objects.equals(each.getUser(), item.get("user")))
                    .findFirst()
                    .map(item -> item.get("uvType"))
                    .map(Object::toString)
                    .orElse("Old visitor");  // "Old visitor"
            each.setUvType(uvType);
        });
        return actualResult;
    }

    @Override
    public IPage<ShortLinkStatsAccessRecordRespDTO> groupShortLinkStatsAccessRecord(ShortLinkGroupStatsAccessRecordReqDTO requestParam) {
        checkGroupBelongToUser(requestParam.getGid());
        IPage<LinkAccessLogsDO> linkAccessLogsDOIPage = linkAccessLogsMapper.selectGroupPage(requestParam);
        if (CollUtil.isEmpty(linkAccessLogsDOIPage.getRecords())) {
            return new Page<>();
        }
        IPage<ShortLinkStatsAccessRecordRespDTO> actualResult = linkAccessLogsDOIPage
                .convert(each -> BeanUtil.toBean(each, ShortLinkStatsAccessRecordRespDTO.class));
        List<String> userAccessLogsList = actualResult.getRecords().stream()
                .map(ShortLinkStatsAccessRecordRespDTO::getUser)
                .toList();
        List<Map<String, Object>> uvTypeList = linkAccessLogsMapper.selectGroupUvTypeByUsers(
                requestParam.getGid(),
                requestParam.getStartDate(),
                requestParam.getEndDate(),
                userAccessLogsList
        );
        actualResult.getRecords().forEach(each -> {
            String uvType = uvTypeList.stream()
                    .filter(item -> Objects.equals(each.getUser(), item.get("user")))
                    .findFirst()
                    .map(item -> item.get("uvType"))
                    .map(Object::toString)
                    .orElse("Old visitor");  // "Old visitor"
            each.setUvType(uvType);
        });
        return actualResult;
    }

    public void checkGroupBelongToUser(String gid) throws ServiceException {
        String username = Optional.ofNullable(UserContext.getUsername())
                .orElseThrow(() -> new ServiceException("User not logged in"));
        LambdaQueryWrapper<GroupDO> queryWrapper = Wrappers.lambdaQuery(GroupDO.class)
                .eq(GroupDO::getGid, gid)
                .eq(GroupDO::getUsername, username);
        List<GroupDO> groupDOList = linkGroupMapper.selectList(queryWrapper);
        if (CollUtil.isEmpty(groupDOList)) {
            throw new ServiceException("User information does not match the group identifier");
        }
    }
}