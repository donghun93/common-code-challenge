package com.common.code.challenge.system.data.init.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AreaCode {
    private final String code;
    private final String name;
    private final int depth;
}
