package com.chi.shortlink.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * short link not found controller
 */
@Controller
public class ShortLinkNotFoundController {

    /**
     * short link not found page
     */
    @RequestMapping("/page/notfound")
    public String notfound() {
        return "notfound";
    }
}