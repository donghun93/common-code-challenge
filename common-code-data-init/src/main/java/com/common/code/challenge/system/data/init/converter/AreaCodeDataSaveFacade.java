package com.common.code.challenge.system.data.init.converter;

import com.common.code.challenge.system.data.init.model.AreaCode;
import com.common.code.challenge.system.data.init.repository.AreaBatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Component
public class AreaCodeDataSaveFacade {

    private final AreaBatchRepository areaBatchRepository;

    @Transactional
    public void save(Map<AreaCode, Map<AreaCode, Map<AreaCode, AreaCode>>> areaCodeMap) {
        List<AreaCode> mainAreaData = new ArrayList<>(areaCodeMap.keySet());

        // 대분류 저장
        areaBatchRepository.bulkInsert(mainAreaData, null);

        // 중분류 저장
        for (AreaCode main : areaCodeMap.keySet()) {
            Map<AreaCode, Map<AreaCode, AreaCode>> middleAreaMap = areaCodeMap.get(main);

            List<AreaCode> middleAreaData = new ArrayList<>(middleAreaMap.keySet());
            areaBatchRepository.bulkInsert(middleAreaData, main);

            // 소분류 저장
            for (AreaCode middle : middleAreaMap.keySet()) {
                Map<AreaCode, AreaCode> subAreaMap = middleAreaMap.get(middle);

                List<AreaCode> subAreaData = new ArrayList<>(subAreaMap.keySet());
                areaBatchRepository.bulkInsert(subAreaData, middle);
            }
        }
    }
}
