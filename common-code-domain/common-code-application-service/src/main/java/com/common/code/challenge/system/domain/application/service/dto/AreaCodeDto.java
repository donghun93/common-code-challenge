package com.common.code.challenge.system.domain.application.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class AreaCodeDto {
    private final String code;
    private final String parent;
    private final String name;
    private final int depth;
}
