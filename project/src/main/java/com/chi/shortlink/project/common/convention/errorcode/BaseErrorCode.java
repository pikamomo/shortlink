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

package com.chi.shortlink.project.common.convention.errorcode;

/**
 * Base Error Code Definition
 */
public enum BaseErrorCode implements IErrorCode {

    // ========== Primary Macro Error Code Client Error ==========
    CLIENT_ERROR("A000001", "Client error"),

    // ========== Secondary Macro Error Code User Registration Error ==========
    USER_REGISTER_ERROR("A000100", "User registration error"),
    USER_NAME_VERIFY_ERROR("A000110", "Username verification failed"),
    USER_NAME_EXIST_ERROR("A000111", "Username already exists"),
    USER_NAME_SENSITIVE_ERROR("A000112", "Username contains sensitive words"),
    USER_NAME_SPECIAL_CHARACTER_ERROR("A000113", "Username contains special characters"),
    PASSWORD_VERIFY_ERROR("A000120", "Password verification failed"),
    PASSWORD_SHORT_ERROR("A000121", "Password is too short"),
    PHONE_VERIFY_ERROR("A000151", "Phone format verification failed"),

    // ========== Secondary Macro Error Code System Request Missing Idempotent Token ==========
    IDEMPOTENT_TOKEN_NULL_ERROR("A000200", "Idempotent token is null"),
    IDEMPOTENT_TOKEN_DELETE_ERROR("A000201", "Idempotent token has been used or expired"),

    // ========== Secondary Macro Error Code System Request Operation Frequent ==========
    FLOW_LIMIT_ERROR("A000300", "The system is busy, please try again later"),

    // ========== Primary Macro Error Code System Execution Error ==========
    SERVICE_ERROR("B000001", "System execution error"),
    // ========== Secondary Macro Error Code System Execution Timeout ==========
    SERVICE_TIMEOUT_ERROR("B000100", "System execution timeout"),

    // ========== Primary Macro Error Code Third-Party Service Error ==========
    REMOTE_ERROR("C000001", "Third-party service error");

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