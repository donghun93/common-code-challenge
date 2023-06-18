package com.common.code.challenge.system.domain.entity;

import com.common.code.challenge.system.common.domain.AbstractBaseEntity;

import java.time.LocalDateTime;

// 정비사업
public class CityReconstruction extends AbstractBaseEntity {
    public CityReconstruction(LocalDateTime createdAt, LocalDateTime modifiedAt) {
        super(createdAt, modifiedAt);
    }
}
