package com.chi.shortlink.project.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * short link redirect object
 */
@Data
@TableName("t_link_goto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShortLinkGotoDO {
    /**
     * id
     */
    private Long id;

    /**
     * short link id
     */
    private String gid;

    /**
     * short link
     */
    private String fullShortUrl;
}
