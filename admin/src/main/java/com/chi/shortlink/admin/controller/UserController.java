package com.chi.shortlink.admin.controller;

import cn.hutool.core.bean.BeanUtil;
import com.chi.shortlink.admin.common.convention.result.Result;
import com.chi.shortlink.admin.common.convention.result.Results;
import com.chi.shortlink.admin.dto.req.UserLoginReqDTO;
import com.chi.shortlink.admin.dto.req.UserRegisterReqDTO;
import com.chi.shortlink.admin.dto.req.UserUpdaterReqDTO;
import com.chi.shortlink.admin.dto.resp.UserActualRespDTO;
import com.chi.shortlink.admin.dto.resp.UserLoginRespDTO;
import com.chi.shortlink.admin.dto.resp.UserRespDTO;
import com.chi.shortlink.admin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * manage user controller
 */
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * get user by username
     */
    @GetMapping("/api/short-link/v1/user/{username}")
    public Result<UserRespDTO> getUserByUsername(@PathVariable String username) {
        return Results.success(userService.getUserByUsername(username));
    }

    /**
     * get user by username full phone number
     */
    @GetMapping("/api/short-link/v1/actual/user/{username}")
    public Result<UserActualRespDTO> getActualUserByUsername(@PathVariable String username) {
        return Results.success(BeanUtil.toBean(userService.getUserByUsername(username), UserActualRespDTO.class));
    }

    /**
     * check username is existed
     */
    @GetMapping("/api/short-link/v1/user/has-username")
    public Result<Boolean> hasUserNAME(@RequestParam("username") String username) {
        return Results.success(userService.hasUsername(username));
    }

    /**
     * user register
     */
    @PostMapping("/api/short-link/v1/user")
    public Result<Void> result(@RequestBody UserRegisterReqDTO requestParam) {
        userService.register(requestParam);
        return Results.success();
    }

    /**
     * update information
     */
    @PutMapping("/api/short-link/v1/user")
    public Result<Void> update(@RequestBody UserUpdaterReqDTO requestParam) {
        userService.update(requestParam);
        return Results.success();
    }

    /**
     * login
     */
    @PostMapping("/api/short-link/v1/user/login")
    public Result<UserLoginRespDTO> login(@RequestBody UserLoginReqDTO requestParam) {
        return Results.success(userService.login(requestParam));
    }

    @GetMapping("/api/short-link/v1/user/check-login")
    public Result<Boolean> checkLogin(@RequestParam("username") String username, @RequestParam("token") String token) {
        return Results.success(userService.checkLogin(username, token));
    }
}
