package com.chi.shortlink.project.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * valid date type enum
 */
@RequiredArgsConstructor
public enum ValidDateTypeEnum {

    PERMANENT(0),

    CUSTOM(1);

    @Getter
    private final int type;
}
