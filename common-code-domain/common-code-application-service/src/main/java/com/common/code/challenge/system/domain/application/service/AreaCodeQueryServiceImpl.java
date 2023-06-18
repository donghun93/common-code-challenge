package com.common.code.challenge.system.domain.application.service;

import com.common.code.challenge.system.domain.application.service.dto.AreaCodeDetailDto;
import com.common.code.challenge.system.domain.application.service.dto.AreaCodeDto;
import com.common.code.challenge.system.domain.application.service.mapper.AreaCodeDataMapper;
import com.common.code.challenge.system.domain.application.service.ports.input.AreaCodeQueryService;
import com.common.code.challenge.system.domain.application.service.ports.output.AreaCodeQueryPort;
import com.common.code.challenge.system.domain.entity.AreaCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
class AreaCodeQueryServiceImpl implements AreaCodeQueryService {

    private final AreaCodeQueryPort areaCodeQueryPort;
    private final AreaCodeDataMapper areaCodeDataMapper;

    @Override
    public List<AreaCodeDto> getAllMainAreaCodes() {
        List<AreaCode> mainAreaCods = areaCodeQueryPort.findMainAreaCods();
        return mainAreaCods.stream().map(areaCodeDataMapper::areaCodeToAreaCodeDto).collect(Collectors.toList());
    }

    @Override
    public List<AreaCodeDto> getAllSubAreaCodes(String parentCode) {
        List<AreaCode> subAreaCods = areaCodeQueryPort.findSubAreaCods(parentCode);
        return subAreaCods.stream().map(areaCodeDataMapper::areaCodeToAreaCodeDto).collect(Collectors.toList());
    }

    @Override
    public AreaCodeDetailDto getAreaCodeDetail(String code) {
        return areaCodeDataMapper.areaCodeToAreaCodeDetailDto(areaCodeQueryPort.findByAreaCode(code));
    }
}
