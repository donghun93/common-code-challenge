package com.common.code.challenge.system.infra.repository;

import com.common.code.challenge.system.domain.application.service.dto.CityReconstructionAndBusinessItemDto;

import java.util.List;

public interface CityReconstructionQueryRepository {
    List<CityReconstructionAndBusinessItemDto> getCityReconstructionsStatistics(int depth, String code);
}
