package com.common.code.challenge.system.domain.application.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class AreaCodeDetailDto {
    private String code;
    private String parent;
    private String name;
    private int depth;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
