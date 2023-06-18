package com.common.code.challenge.system.rest.exception.handler;

import com.common.code.challenge.system.rest.dto.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
public abstract class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponse<?>> exceptionHandler(Exception e) {
        log.error("ExceptionHandler: ", e);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                             .body(BaseResponse.error(e.getMessage()));
    }
}
