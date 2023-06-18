package com.common.code.challenge.system.infra.repository;

import com.common.code.challenge.system.infra.entity.AreaCodeEntity;

import java.util.List;
import java.util.Optional;

public interface AreaCodeQueryRepository {
    List<AreaCodeEntity> findAllMainAreaCode();

    List<AreaCodeEntity> findSubAreaCodeByCode(String code);

    Optional<AreaCodeEntity> findByAreaCode(String code);
}
