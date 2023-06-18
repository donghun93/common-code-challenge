package com.common.code.challenge.system.rest;

import com.common.code.challenge.system.domain.application.service.ports.input.CityReconstructionQueryService;
import com.common.code.challenge.system.rest.dto.BaseResponse;
import com.common.code.challenge.system.rest.dto.CityReconstructionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/city/reconstructions")
public class CityReconstructionApiController {

    private final CityReconstructionQueryService cityReconstructionQueryService;

    @GetMapping("/{code}")
    public BaseResponse<CityReconstructionResponse> getCityReconstructionsStatistics(@PathVariable String code) {
        return CityReconstructionResponse.success(cityReconstructionQueryService.getCityReconstructionsStatistics(code));
    }
}
