package com.common.code.challenge.system.common.domain.valueobject;

public enum CafeStatus {
    OPERATE("운영"), 
    SUSPENSION("일시중단")
    ;

    CafeStatus(String message) {
        this.message = message;
    }

    private final String message;


    public static String getName(String message) {
        for (CafeStatus status : CafeStatus.values()) {
            if (status.getMessage().equals(message)) {
                return status.name();
            }
        }
        return null;
    }

    public String getMessage() {
        return message;
    }
}
