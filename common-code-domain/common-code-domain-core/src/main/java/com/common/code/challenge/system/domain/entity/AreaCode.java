package com.common.code.challenge.system.domain.entity;


import com.common.code.challenge.system.common.domain.AbstractBaseEntity;

import java.time.LocalDateTime;

// 지역 코드
public class AreaCode extends AbstractBaseEntity {
    private final String code;
    private final String parent;
    private final String name;
    private final int depth;

    public AreaCode(LocalDateTime createdAt, LocalDateTime modifiedAt, String code, String parent, String name, int depth) {
        super(createdAt, modifiedAt);
        this.code = code;
        this.parent = parent;
        this.name = name;
        this.depth = depth;
    }

    private AreaCode(Builder builder) {
        super(builder.createdAt, builder.modifiedAt);
        code = builder.code;
        parent = builder.parent;
        name = builder.name;
        depth = builder.depth;
    }

    public static Builder builder() {
        return new Builder();
    }


    public String getCode() {
        return code;
    }
    public String getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }
    public int getDepth() {
        return depth;
    }


    public static final class Builder {
        private String code;
        private String parent;
        private String name;
        private int depth;
        private LocalDateTime createdAt;
        private LocalDateTime modifiedAt;

        private Builder() {
        }

        public Builder code(String val) {
            code = val;
            return this;
        }


        public Builder parent(String val) {
            parent = val;
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

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder depth(int val) {
            depth = val;
            return this;
        }

        public AreaCode build() {
            return new AreaCode(this);
        }
    }
}
