package com.chi.shortlink.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * manage user controller
 */
@RestController
public class UserController {
    /**
     * get user by username
     */
    @GetMapping("/api/shortlink/v1/user/{username}")
    public String getUserByUsername(@PathVariable String username){

        return "Hi" + username;
    }
}
