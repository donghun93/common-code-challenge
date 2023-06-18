package com.common.code.challenge.system.domain.application.service.ports.output;

import com.common.code.challenge.system.domain.entity.AreaCode;

import java.util.List;

public interface AreaCodeQueryPort {
    List<AreaCode> findMainAreaCods();
    List<AreaCode> findSubAreaCods(String code);
    AreaCode findByAreaCode(String code);
}
