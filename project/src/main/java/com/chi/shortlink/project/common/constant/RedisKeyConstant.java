package com.chi.shortlink.project.common.constant;

/**
 * redis key constant
 */
public class RedisKeyConstant {

    /**
     * shot link redirect prefix
     */
    public static final String GOTO_SHORT_LINK_KEY = "short-link_goto_%s";

    /**
     * shot link redirect lock
     */
    public static final String LOCK_GOTO_SHORT_LINK_KEY = "short-link_lock_goto_%s";
}
