package com.common.code.challenge.system.infra.adapter;

import com.common.code.challenge.system.domain.application.service.ports.output.AreaCodeQueryPort;
import com.common.code.challenge.system.domain.entity.AreaCode;
import com.common.code.challenge.system.domain.exception.AreaCodeNotFoundException;
import com.common.code.challenge.system.infra.entity.AreaCodeEntity;
import com.common.code.challenge.system.infra.mapper.AreaCodeDataAccessMapper;
import com.common.code.challenge.system.infra.repository.AreaCodeQueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class AreaCodeQueryAdapter implements AreaCodeQueryPort {

    private final AreaCodeQueryRepository areaCodeQueryRepository;
    private final AreaCodeDataAccessMapper areaCodeDataAccessMapper;

    @Override
    public List<AreaCode> findMainAreaCods() {
        List<AreaCodeEntity> areaCodeEntities = areaCodeQueryRepository.findAllMainAreaCode();
        return areaCodeEntities.stream()
                               .map(areaCodeDataAccessMapper::areaCodeEntityToAreaCode)
                               .collect(Collectors.toList());
    }

    @Override
    public List<AreaCode> findSubAreaCods(String parentCode) {
        List<AreaCodeEntity> areaCodeEntities = areaCodeQueryRepository.findSubAreaCodeByCode(parentCode);
        return areaCodeEntities.stream()
                               .map(areaCodeDataAccessMapper::areaCodeEntityToAreaCode)
                               .collect(Collectors.toList());
    }

    @Override
    public AreaCode findByAreaCode(String code) {
        return areaCodeDataAccessMapper.areaCodeEntityToAreaCode(areaCodeQueryRepository.findByAreaCode(code)
                                       .orElseThrow(() -> new AreaCodeNotFoundException("Area Code Not Found : " + code)));
    }
}
