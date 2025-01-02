/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.chi.shortlink.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chi.shortlink.admin.dao.entity.UserDO;
import com.chi.shortlink.admin.dto.req.UserLoginReqDTO;
import com.chi.shortlink.admin.dto.req.UserRegisterReqDTO;
import com.chi.shortlink.admin.dto.req.UserUpdateReqDTO;
import com.chi.shortlink.admin.dto.resp.UserLoginRespDTO;
import com.chi.shortlink.admin.dto.resp.UserRespDTO;

/**
 * User Service Interface
 *
 */
public interface UserService extends IService<UserDO> {

    /**
     * Query user information by username
     *
     * @param username Username
     * @return User response entity
     */
    UserRespDTO getUserByUsername(String username);

    /**
     * Check if the username exists
     *
     * @param username Username
     * @return True if the username exists, False otherwise
     */
    Boolean hasUsername(String username);

    /**
     * Register user
     *
     * @param requestParam Register user request parameters
     */
    void register(UserRegisterReqDTO requestParam);

    /**
     * Update user by username
     *
     * @param requestParam Update user request parameters
     */
    void update(UserUpdateReqDTO requestParam);

    /**
     * User login
     *
     * @param requestParam User login request parameters
     * @return User login response parameters Token
     */
    UserLoginRespDTO login(UserLoginReqDTO requestParam);

    /**
     * Check if the user is logged in
     *
     * @param username Username
     * @param token    User login Token
     * @return User login status
     */
    Boolean checkLogin(String username, String token);

    /**
     * Logout
     *
     * @param username Username
     * @param token    User login Token
     */
    void logout(String username, String token);
}