package com.chi.shortlink.admin.remote.dto.req;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.util.List;

/**
 * Recycle bin short link pagination request parameters
 *
 */
@Data
public class ShortLinkRecycleBinPageReqDTO extends Page {

    /**
     * Group identifier list
     */
    private List<String> gidList;
}