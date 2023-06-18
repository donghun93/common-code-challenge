package com.common.code.challenge.system.rest.exception.handler;

import com.common.code.challenge.system.domain.exception.CityReconstructionException;
import com.common.code.challenge.system.rest.dto.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class CityReconstructionGlobalExceptionHandler extends GlobalExceptionHandler {

    @ExceptionHandler(value = {CityReconstructionException.class})
    public ResponseEntity<BaseResponse<?>> areaCodeExceptionHandler(CityReconstructionException e) {
        log.error("CityReconstructionException: ", e);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                             .body(BaseResponse.error(e.getMessage()));
    }
}
