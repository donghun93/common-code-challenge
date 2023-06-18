package com.common.code.challenge.system.rest.exception.handler;

import com.common.code.challenge.system.domain.exception.AreaCodeException;
import com.common.code.challenge.system.rest.dto.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class AreaCodeGlobalExceptionHandler extends GlobalExceptionHandler {

    @ExceptionHandler(value = {AreaCodeException.class})
    public ResponseEntity<BaseResponse<?>> areaCodeExceptionHandler(AreaCodeException e) {
        log.error("AreaCodeException: ", e);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                             .body(BaseResponse.error(e.getMessage()));
    }

}
