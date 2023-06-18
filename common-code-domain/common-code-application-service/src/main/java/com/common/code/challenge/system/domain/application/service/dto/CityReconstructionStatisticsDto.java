package com.common.code.challenge.system.domain.application.service.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class CityReconstructionStatisticsDto {
    private AreaCodeDto areaCodeDto;
    private List<CityReconstructionAndBusinessItemDto> cityReconstructionAndBusinessItemDtos;

    private CityReconstructionStatisticsDto(AreaCodeDto areaCodeDto, List<CityReconstructionAndBusinessItemDto> cityReconstructionAndBusinessItemDtos) {
        this.areaCodeDto = areaCodeDto;
        this.cityReconstructionAndBusinessItemDtos = cityReconstructionAndBusinessItemDtos;
    }

    public static CityReconstructionStatisticsDto of(AreaCodeDto areaCodeDto,
                                                     List<CityReconstructionAndBusinessItemDto> cityReconstructionAndBusinessItemDtos) {
        return new CityReconstructionStatisticsDto(areaCodeDto, cityReconstructionAndBusinessItemDtos);
    }
}
