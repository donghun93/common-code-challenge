package com.common.code.challenge.system.domain.application.service.dto;

import lombok.Getter;

@Getter
public class CityReconstructionAndBusinessItemDto {
    private Long count;
    private String businessName;

    public CityReconstructionAndBusinessItemDto(Long count, String businessName) {
        this.count = count;
        this.businessName = businessName;
    }
}
