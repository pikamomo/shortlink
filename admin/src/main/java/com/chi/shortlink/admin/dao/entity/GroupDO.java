package com.chi.shortlink.admin.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.chi.shortlink.admin.common.database.BaseDO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * short link group data object
 */
@Data
@TableName("t_group")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupDO extends BaseDO {
    /**
     * id
     */
    private Long id;

    /**
     * group id
     */
    private String gid;

    /**
     * group name
     */
    private String name;

    /**
     * group username
     */
    private String username;

    /**
     * group sort
     */
    private Integer sortOrder;
}
