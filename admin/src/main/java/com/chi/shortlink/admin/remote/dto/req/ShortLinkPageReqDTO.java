package com.chi.shortlink.admin.remote.dto.req;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

/**
 * Short link pagination request parameters
 *
 */
@Data
public class ShortLinkPageReqDTO extends Page {

    /**
     * Group identifier
     */
    private String gid;

    /**
     * Order identifier
     */
    private String orderTag;
}