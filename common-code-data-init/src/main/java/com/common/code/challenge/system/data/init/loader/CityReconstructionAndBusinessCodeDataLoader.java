package com.common.code.challenge.system.data.init.loader;

import com.common.code.challenge.system.data.init.converter.CityReconstructionAndBusinessCodeDataSaveFacade;
import com.common.code.challenge.system.data.init.converter.CityReconstructionConverter;
import com.common.code.challenge.system.data.init.model.CityReconstruction;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class CityReconstructionAndBusinessCodeDataLoader {

    private final CityReconstructionConverter cityReconstructionConverter;
    private final CityReconstructionAndBusinessCodeDataSaveFacade cityReconstructionAndBusinessCodeDataSaveFacade;

    public void load() {
        List<CityReconstruction> cityReconstructions = cityReconstructionConverter.convert();
        cityReconstructionAndBusinessCodeDataSaveFacade.save(cityReconstructions);
    }
}
