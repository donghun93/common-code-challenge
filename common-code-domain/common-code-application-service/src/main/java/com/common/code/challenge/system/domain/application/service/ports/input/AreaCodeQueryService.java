package com.common.code.challenge.system.domain.application.service.ports.input;

import com.common.code.challenge.system.domain.application.service.dto.AreaCodeDetailDto;
import com.common.code.challenge.system.domain.application.service.dto.AreaCodeDto;

import java.util.List;

public interface AreaCodeQueryService {
    List<AreaCodeDto> getAllMainAreaCodes();
    List<AreaCodeDto> getAllSubAreaCodes(String code);
    AreaCodeDetailDto getAreaCodeDetail(String code);
}
