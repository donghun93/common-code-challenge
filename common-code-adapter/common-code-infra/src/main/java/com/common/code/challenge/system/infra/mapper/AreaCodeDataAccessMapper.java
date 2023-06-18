package com.common.code.challenge.system.infra.mapper;

import com.common.code.challenge.system.domain.entity.AreaCode;
import com.common.code.challenge.system.infra.entity.AreaCodeEntity;
import org.springframework.stereotype.Component;

@Component
public class AreaCodeDataAccessMapper {

    public AreaCode areaCodeEntityToAreaCode(AreaCodeEntity areaCodeEntity) {
        return AreaCode.builder()
                       .code(areaCodeEntity.getCode())
                       .parent((areaCodeEntity.getParent() != null) ? areaCodeEntity.getParent().getCode() : null)
                       .depth(areaCodeEntity.getDepth())
                       .name(areaCodeEntity.getName())
                       .createdAt(areaCodeEntity.getCreatedAt())
                       .modifiedAt(areaCodeEntity.getModifiedAt())
                       .build();
    }
}
