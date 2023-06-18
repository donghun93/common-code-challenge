package com.common.code.challenge.system.domain.application.service;

import com.common.code.challenge.system.domain.application.service.dto.CityReconstructionAndBusinessItemDto;
import com.common.code.challenge.system.domain.application.service.dto.CityReconstructionStatisticsDto;
import com.common.code.challenge.system.domain.application.service.mapper.AreaCodeDataMapper;
import com.common.code.challenge.system.domain.application.service.ports.input.CityReconstructionQueryService;
import com.common.code.challenge.system.domain.application.service.ports.output.AreaCodeQueryPort;
import com.common.code.challenge.system.domain.application.service.ports.output.CityReconstructionQueryPort;
import com.common.code.challenge.system.domain.entity.AreaCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
class CityReconstructionQueryServiceImpl implements CityReconstructionQueryService {

    private final AreaCodeQueryPort areaCodeQueryPort;
    private final CityReconstructionQueryPort cityReconstructionQueryPort;
    private final AreaCodeDataMapper areaCodeDataMapper;

    @Override
    public CityReconstructionStatisticsDto getCityReconstructionsStatistics(String code) {
        AreaCode areaCode = areaCodeQueryPort.findByAreaCode(code);

        List<CityReconstructionAndBusinessItemDto> cityReconstructionsStatistics =
                cityReconstructionQueryPort.getCityReconstructionsStatistics(areaCode);

        return CityReconstructionStatisticsDto.of(
                areaCodeDataMapper.areaCodeToAreaCodeDto(areaCode), cityReconstructionsStatistics);
    }
}
