package com.common.code.challenge.system.rest;

import com.common.code.challenge.system.domain.application.service.dto.AreaCodeDetailDto;
import com.common.code.challenge.system.domain.application.service.dto.AreaCodeDto;
import com.common.code.challenge.system.domain.application.service.ports.input.AreaCodeQueryService;
import com.common.code.challenge.system.rest.dto.AreaCodeDetailResponse;
import com.common.code.challenge.system.rest.dto.AreaCodeResponse;
import com.common.code.challenge.system.rest.dto.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/areas")
public class AreaCodeApiController {

    private final AreaCodeQueryService areaCodeQueryService;

    @GetMapping("/main")
    public BaseResponse<AreaCodeResponse> getAllMainAreaCodes() {
        List<AreaCodeDto> mainAreaCodes = areaCodeQueryService.getAllMainAreaCodes();
        return AreaCodeResponse.success(mainAreaCodes);
    }

    @GetMapping("/sub/{parentCode}")
    public BaseResponse<AreaCodeResponse> getAllSubAreaCodes(@PathVariable String parentCode) {
        List<AreaCodeDto> areaCodes = areaCodeQueryService.getAllSubAreaCodes(parentCode);
        return AreaCodeResponse.success(areaCodes);
    }

    @GetMapping("/detail/{code}")
    public BaseResponse<AreaCodeDetailResponse> getAreaCodeDetail(@PathVariable String code) {
        AreaCodeDetailDto areaCodeDetail = areaCodeQueryService.getAreaCodeDetail(code);
        return AreaCodeDetailResponse.success(areaCodeDetail);
    }
}
