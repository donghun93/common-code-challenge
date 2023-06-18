package com.common.code.challenge.system.data.init.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class BusinessCode {
    private String code;
    private String name;
    private int orderNumber;
}
