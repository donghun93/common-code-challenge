package com.common.code.challenge.system.domain.application.service.ports.input;

import com.common.code.challenge.system.domain.application.service.dto.CityReconstructionStatisticsDto;

public interface CityReconstructionQueryService {
    CityReconstructionStatisticsDto getCityReconstructionsStatistics(String code);
}
