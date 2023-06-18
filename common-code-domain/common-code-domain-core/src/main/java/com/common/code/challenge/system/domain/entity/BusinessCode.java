package com.common.code.challenge.system.domain.entity;

import com.common.code.challenge.system.common.domain.AbstractBaseEntity;

import java.time.LocalDateTime;

// 사업 구분 코드
public class BusinessCode extends AbstractBaseEntity {
    private final String code;
    private final String name;
    private final int orderNumber;

    public BusinessCode(LocalDateTime createdAt, LocalDateTime modifiedAt, String code, String name, int orderNumber) {
        super(createdAt, modifiedAt);
        this.code = code;
        this.name = name;
        this.orderNumber = orderNumber;
    }

    private BusinessCode(Builder builder) {
        super(builder.createdAt, builder.modifiedAt);
        code = builder.code;
        name = builder.name;
        orderNumber = builder.orderNumber;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
    public int getOrderNumber() {
        return orderNumber;
    }

    public static final class Builder {
        private String code;
        private String name;
        private int orderNumber;
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder code(String val) {
            code = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder createdAt(LocalDateTime val) {
            createdAt = val;
            return this;
        }

        public Builder modifiedAt(LocalDateTime val) {
            modifiedAt = val;
            return this;
        }

        public Builder orderNumber(int val) {
            orderNumber = val;
            return this;
        }

        public BusinessCode build() {
            return new BusinessCode(this);
        }
    }
}
