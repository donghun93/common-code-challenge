package com.common.code.challenge.system.data.init.converter;

import com.common.code.challenge.system.data.init.model.BusinessCode;
import com.common.code.challenge.system.data.init.model.CityReconstruction;
import com.common.code.challenge.system.data.init.repository.BusinessCodeBatchRepository;
import com.common.code.challenge.system.data.init.repository.CityReconstructionBatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class CityReconstructionAndBusinessCodeDataSaveFacade {

    private final BusinessCodeBatchRepository businessCodeBatchRepository;
    private final CityReconstructionBatchRepository cityReconstructionBatchRepository;

    @Transactional
    public void save(List<CityReconstruction> cityReconstructions) {
        List<BusinessCode> businessCode = getBusinessCode(cityReconstructions);
        businessCodeBatchRepository.bulkInsert(businessCode);

        List<CityReconstruction> newCityReconstruction =
                createBusinessTypeNameToBusinessCode(cityReconstructions, businessCode);
        cityReconstructionBatchRepository.bulkInsert(newCityReconstruction);
    }

    private List<BusinessCode> getBusinessCode(List<CityReconstruction> cityReconstructions) {
        List<String> businessCodes = cityReconstructions.stream()
                                                        .map(CityReconstruction::getBtyp_nm)
                                                        .distinct()
                                                        .collect(Collectors.toList());

        AtomicInteger orderNumber = new AtomicInteger(1);

        return businessCodes.stream()
                            .map(data -> BusinessCode.builder()
                                                     .code(String.format("BIZ_CD_%03d", orderNumber.get()))
                                                     .name(data)
                                                     .orderNumber(orderNumber.getAndIncrement())
                                                     .build())
                            .collect(Collectors.toList());
    }

    private List<CityReconstruction> createBusinessTypeNameToBusinessCode(List<CityReconstruction> cityReconstructions,
                                                                          List<BusinessCode> businessCode) {
        List<CityReconstruction> newCityReconstruction = new ArrayList<>(cityReconstructions);

        Map<String, String> businessCodeMap = businessCode.stream()
                                                          .collect(Collectors.toMap(
                                                                  BusinessCode::getName, BusinessCode::getCode));
        newCityReconstruction.forEach(cityReconstruction -> {
            String businessTypeName = cityReconstruction.getBtyp_nm();
            if (businessCodeMap.containsKey(businessTypeName)) {
                cityReconstruction.setBtyp_nm(businessCodeMap.get(businessTypeName));
            }
        });

        return newCityReconstruction;
    }
}
