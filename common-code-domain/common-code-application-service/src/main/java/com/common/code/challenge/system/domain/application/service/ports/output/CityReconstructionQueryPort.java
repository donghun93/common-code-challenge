package com.common.code.challenge.system.domain.application.service.ports.output;

import com.common.code.challenge.system.domain.application.service.dto.CityReconstructionAndBusinessItemDto;
import com.common.code.challenge.system.domain.entity.AreaCode;

import java.util.List;

public interface CityReconstructionQueryPort {
    List<CityReconstructionAndBusinessItemDto> getCityReconstructionsStatistics(AreaCode areaCode);
}
