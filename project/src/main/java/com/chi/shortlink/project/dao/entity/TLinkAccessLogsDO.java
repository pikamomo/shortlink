package com.chi.shortlink.project.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.chi.shortlink.project.common.database.BaseDO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("t_link_access_logs")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TLinkAccessLogsDO extends BaseDO {
    /**
     * id
     */
    private Long id;

    /**
     * full short link
     */
    private String fullShortUrl;

    /**
     * group id
     */
    private String gid;

    /**
     * user info
     */
    private String user;

    /**
     * browser
     */
    private String browser;

    /**
     * operating system
     */
    private String os;

    /**
     * ip
     */
    private String ip;
}
