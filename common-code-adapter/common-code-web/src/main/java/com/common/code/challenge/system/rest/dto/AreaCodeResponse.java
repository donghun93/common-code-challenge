package com.common.code.challenge.system.rest.dto;

import com.common.code.challenge.system.domain.application.service.dto.AreaCodeDto;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class AreaCodeResponse {
    private int totalCount;
    private int depth;
    private List<AreaCodeResponseItem> items;

    public AreaCodeResponse(int totalCount, int depth, List<AreaCodeResponseItem> items) {
        this.totalCount = totalCount;
        this.depth = depth;
        this.items = items;
    }

    public static BaseResponse<AreaCodeResponse> success(List<AreaCodeDto> mainAreaCodes) {
        return BaseResponse.success(new AreaCodeResponse(
                mainAreaCodes.size(),
                (mainAreaCodes.size() > 0) ? mainAreaCodes.get(0).getDepth() : 0,
                mainAreaCodes.stream().map(AreaCodeResponseItem::new).collect(Collectors.toList()))
        );
    }


    @Getter
    static class AreaCodeResponseItem {
        private String code;
        private String name;

        public AreaCodeResponseItem(AreaCodeDto areaCodeDto) {
            this.code = areaCodeDto.getCode();
            this.name = areaCodeDto.getName();
        }
    }
}
