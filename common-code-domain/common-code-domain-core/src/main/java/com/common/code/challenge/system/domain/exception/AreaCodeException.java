package com.common.code.challenge.system.domain.exception;

import com.common.code.challenge.system.common.domain.exception.DomainException;


public class AreaCodeException extends DomainException {
    public AreaCodeException(String message) {
        super(message);
    }

    public AreaCodeException(String message, Throwable cause) {
        super(message, cause);
    }
}
