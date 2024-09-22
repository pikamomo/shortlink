package com.chi.shortlink.admin.common.enums;

import com.chi.shortlink.admin.common.convention.errorcode.IErrorCode;

public enum UserErrorCodeEnum implements IErrorCode {

    USER_TOKEN_FAIL("A000200", "USER TOKEN FAIL"),
    USER_NULL("B000200", "USER NOT EXISTED"),
    USERNAME_EXIST("B000201", "USERNAME EXISTED"),
    USER_EXIST("B000202", "USER EXISTED"),
    USER_SAVE_ERROR("B000203", "USER SAVE FAILED");

    private final String code;

    private final String message;

    UserErrorCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
