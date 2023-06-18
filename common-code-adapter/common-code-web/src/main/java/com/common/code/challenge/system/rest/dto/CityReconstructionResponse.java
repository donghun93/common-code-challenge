package com.common.code.challenge.system.rest.dto;

import com.common.code.challenge.system.domain.application.service.dto.CityReconstructionAndBusinessItemDto;
import com.common.code.challenge.system.domain.application.service.dto.CityReconstructionStatisticsDto;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class CityReconstructionResponse {
    private String code;
    private String name;
    private int total;
    private List<CityReconstructionItem> items;

    public CityReconstructionResponse(String code, String name, Long total, List<CityReconstructionItem> items) {
        this.code = code;
        this.name = name;
        this.total = Math.toIntExact(total);
        this.items = items;
    }

    public static BaseResponse<CityReconstructionResponse> success(
            CityReconstructionStatisticsDto cityReconstructionStatisticsDto) {
        return BaseResponse.success(new CityReconstructionResponse(
                cityReconstructionStatisticsDto.getAreaCodeDto().getCode(),
                cityReconstructionStatisticsDto.getAreaCodeDto().getName(),
                cityReconstructionStatisticsDto.getCityReconstructionAndBusinessItemDtos().stream()
                                               .mapToLong(CityReconstructionAndBusinessItemDto::getCount)
                                               .sum(),
                cityReconstructionStatisticsDto.getCityReconstructionAndBusinessItemDtos().stream()
                        .map(CityReconstructionItem::new)
                        .collect(Collectors.toList()))
        );
    }

    @Getter
    static class CityReconstructionItem {
        private Long count;
        private String businessName;

        public CityReconstructionItem(CityReconstructionAndBusinessItemDto cityReconstructionAndBusinessItemDto) {
            this.count = cityReconstructionAndBusinessItemDto.getCount();
            this.businessName = cityReconstructionAndBusinessItemDto.getBusinessName();
        }
    }
}
