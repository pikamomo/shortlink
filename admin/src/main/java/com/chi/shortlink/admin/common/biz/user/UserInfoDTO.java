package com.chi.shortlink.admin.common.biz.user;

import com.alibaba.fastjson2.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * user information object
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInfoDTO {

    /**
     * user ID
     */
    @JSONField(name = "id")
    private String userId;

    /**
     * username
     */
    private String username;

    /**
     * realname
     */
    private String realName;
}