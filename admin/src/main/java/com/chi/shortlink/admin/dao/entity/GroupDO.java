package com.chi.shortlink.admin.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * short link group data object
 */
@Data
@TableName("t_group")
public class GroupDO {
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

    /**
     * create time
     */
    private Date createTime;

    /**
     * update time
     */
    private Date updateTime;

    /**
     * del flag 0：not del 1：del
     */
    private int delFlag;
}
