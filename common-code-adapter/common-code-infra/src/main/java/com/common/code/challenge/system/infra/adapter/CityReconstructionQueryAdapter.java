package com.common.code.challenge.system.infra.adapter;

import com.common.code.challenge.system.domain.application.service.dto.CityReconstructionAndBusinessItemDto;
import com.common.code.challenge.system.domain.application.service.ports.output.CityReconstructionQueryPort;
import com.common.code.challenge.system.domain.entity.AreaCode;
import com.common.code.challenge.system.infra.repository.CityReconstructionQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class CityReconstructionQueryAdapter implements CityReconstructionQueryPort {
    private final CityReconstructionQueryRepository cityReconstructionQueryRepository;

    @Override
    public List<CityReconstructionAndBusinessItemDto> getCityReconstructionsStatistics(AreaCode areaCode) {
        return cityReconstructionQueryRepository.getCityReconstructionsStatistics(areaCode.getDepth(), areaCode.getCode());
    }
}
