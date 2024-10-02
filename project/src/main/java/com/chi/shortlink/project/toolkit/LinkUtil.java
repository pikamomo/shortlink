package com.chi.shortlink.project.toolkit;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

import java.util.Date;
import java.util.Optional;

import static com.chi.shortlink.project.common.constant.ShortLinkConstant.DEFAULT_CACHE_VALIED_DATE;

/**
 * shot link util
 */
public class LinkUtil {

    /**
     * get link cache valid date
     * @param validDate
     * @return
     */
    public static long getLinkCacheValidDate(Date validDate) {
        return Optional.ofNullable(validDate)
                .map(each -> DateUtil.between(new Date(), each, DateUnit.MS))
                .orElse(DEFAULT_CACHE_VALIED_DATE);
    }
}
