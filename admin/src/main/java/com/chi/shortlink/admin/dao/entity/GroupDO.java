package com.chi.shortlink.admin.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.chi.shortlink.admin.common.database.BaseDO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Short link group entity
 *
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
     * Group identifier
     */
    private String gid;

    /**
     * Group name
     */
    private String name;

    /**
     * Username who created the group
     */
    private String username;

    /**
     * Group sort order
     */
    private Integer sortOrder;
}