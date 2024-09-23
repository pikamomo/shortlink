package com.chi.shortlink.project.dto.req;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chi.shortlink.project.dao.entity.ShortLinkDO;
import lombok.Data;

/**]
 * short link pagination request dto
 */
@Data
public class ShortLinkPageReqDTO extends Page<ShortLinkDO> {
    /**
     * short link gid
     */
    private String gid;
}
