package com.chi.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chi.shortlink.admin.dao.entity.UserDO;
import com.chi.shortlink.admin.dto.req.UserRegisterReqDTO;
import com.chi.shortlink.admin.dto.resp.UserRespDTO;

/**
 * User Interface
 */
public interface UserService extends IService<UserDO> {

    /**
     * return user information according to username
     * @param username
     * @return user response entity
     */
    UserRespDTO getUserByUsername(String username);

    /**
     * check username is existed
     * @param username
     * @return True: existed, False: not existed
     */
    Boolean hasUsername(String username);

    /**
     * user register
     * @param requestParam
     */
    void register(UserRegisterReqDTO requestParam);
}
