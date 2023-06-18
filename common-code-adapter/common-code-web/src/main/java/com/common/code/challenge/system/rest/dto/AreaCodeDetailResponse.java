package com.common.code.challenge.system.rest.dto;

import com.common.code.challenge.system.domain.application.service.dto.AreaCodeDetailDto;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class AreaCodeDetailResponse {
    private String code;
    private String parent;
    private String name;
    private int depth;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public AreaCodeDetailResponse(String code, String parent, String name, int depth, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.code = code;
        this.parent = parent;
        this.name = name;
        this.depth = depth;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public static BaseResponse<AreaCodeDetailResponse> success(AreaCodeDetailDto areaCodeDetailDto) {
        return BaseResponse.success(new AreaCodeDetailResponse(
                areaCodeDetailDto.getCode(),
                areaCodeDetailDto.getParent(),
                areaCodeDetailDto.getName(),
                areaCodeDetailDto.getDepth(),
                areaCodeDetailDto.getCreatedAt(),
                areaCodeDetailDto.getModifiedAt()
        ));
    }
}
