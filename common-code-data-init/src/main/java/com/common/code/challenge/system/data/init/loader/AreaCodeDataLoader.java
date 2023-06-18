package com.common.code.challenge.system.data.init.loader;

import com.common.code.challenge.system.data.init.converter.AreaCodeConverter;
import com.common.code.challenge.system.data.init.converter.AreaCodeDataSaveFacade;
import com.common.code.challenge.system.data.init.model.AreaCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@RequiredArgsConstructor
@Component
public class AreaCodeDataLoader {
    private final AreaCodeConverter areaCodeConverter;
    private final AreaCodeDataSaveFacade areaCodeDataSaveFacade;

    public void load() {
        Map<AreaCode, Map<AreaCode, Map<AreaCode, AreaCode>>> areaCodeMap = areaCodeConverter.convert();
        areaCodeDataSaveFacade.save(areaCodeMap);
    }
}
