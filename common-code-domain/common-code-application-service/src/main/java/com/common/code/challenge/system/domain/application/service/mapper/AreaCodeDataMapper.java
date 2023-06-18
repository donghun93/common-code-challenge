package com.common.code.challenge.system.domain.application.service.mapper;

import com.common.code.challenge.system.domain.application.service.dto.AreaCodeDetailDto;
import com.common.code.challenge.system.domain.application.service.dto.AreaCodeDto;
import com.common.code.challenge.system.domain.entity.AreaCode;
import org.springframework.stereotype.Component;

@Component
public class AreaCodeDataMapper {

    public AreaCodeDto areaCodeToAreaCodeDto(AreaCode areaCode) {
        return AreaCodeDto.builder()
                          .code(areaCode.getCode())
                          .name(areaCode.getName())
                          .depth(areaCode.getDepth())
                          .parent(areaCode.getParent())
                          .build();
    }

    public AreaCodeDetailDto areaCodeToAreaCodeDetailDto(AreaCode areaCode) {
        return AreaCodeDetailDto.builder()
                                .code(areaCode.getCode())
                                .name(areaCode.getName())
                                .parent(areaCode.getParent())
                                .depth(areaCode.getDepth())
                                .createdAt(areaCode.getCreatedAt())
                                .modifiedAt(areaCode.getModifiedAt())
                                .build();
    }
}
