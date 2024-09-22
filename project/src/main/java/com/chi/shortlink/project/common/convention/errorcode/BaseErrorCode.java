package com.chi.shortlink.project.common.convention.errorcode;

public enum BaseErrorCode implements IErrorCode {
    // ========== First-Level Macro Error Code: Client Errors ==========
    CLIENT_ERROR("A000001", "Client Error"),

    // ========== Second-Level Macro Error Code: User Registration Errors ==========
    USER_REGISTER_ERROR("A000100", "User Registration Error"),
    USER_NAME_VERIFY_ERROR("A000110", "Username Verification Failure"),
    USER_NAME_EXIST_ERROR("A000111", "Username Already Exists"),
    USER_NAME_SENSITIVE_ERROR("A000112", "Username Contains Sensitive Words"),
    USER_NAME_SPECIAL_CHARACTER_ERROR("A000113", "Username Contains Special Characters"),
    PASSWORD_VERIFY_ERROR("A000120", "Password Verification Failure"),
    PASSWORD_SHORT_ERROR("A000121", "Password Length Insufficient"),
    PHONE_VERIFY_ERROR("A000151", "Phone Format Verification Failure"),

    // ========== Second-Level Macro Error Code: System Request Lacks Idempotent Token ==========
    IDEMPOTENT_TOKEN_NULL_ERROR("A000200", "Idempotent Token is Missing"),
    IDEMPOTENT_TOKEN_DELETE_ERROR("A000201", "Idempotent Token Used or Expired"),

    // ========== First-Level Macro Error Code: System Execution Error ==========
    SERVICE_ERROR("B000001", "System Execution Error"),
    // ========== Second-Level Macro Error Code: System Execution Timeout ==========
    SERVICE_TIMEOUT_ERROR("B000100", "System Execution Timeout"),

    // ========== First-Level Macro Error Code: Third-Party Service Error ==========
    REMOTE_ERROR("C000001", "Error Calling Third-Party Service");


    private final String code;

    private final String message;

    BaseErrorCode(String code, String message) {
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
