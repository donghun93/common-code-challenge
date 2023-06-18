package com.common.code.challenge.system.common.domain;

import java.time.LocalDateTime;

public abstract class AbstractBaseEntity {
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public AbstractBaseEntity(LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }
}
