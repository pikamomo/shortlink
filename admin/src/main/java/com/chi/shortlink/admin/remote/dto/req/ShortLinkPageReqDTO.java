package com.chi.shortlink.admin.remote.dto.req;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

/**
 * ]
 * short link pagination request dto
 */
@Data
public class ShortLinkPageReqDTO extends Page {
    /**
     * short link gid
     */
    private String gid;

    /**
     * get order type
     */
    private String orderByTag;
}
