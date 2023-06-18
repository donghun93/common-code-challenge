package com.common.code.challenge.system.data.init;

import com.common.code.challenge.system.data.init.loader.AreaCodeDataLoader;
import com.common.code.challenge.system.data.init.loader.CityReconstructionAndBusinessCodeDataLoader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class DataInitializer {

    private final AreaCodeDataLoader areaCodeDataLoader;
    private final CityReconstructionAndBusinessCodeDataLoader cityReconstructionAndBusinessCodeDataLoader;

    @Async
    @EventListener(ApplicationReadyEvent.class)
    public void initialization() {
        log.info("Data Initialization Start");

        areaCodeDataLoader.load();
        cityReconstructionAndBusinessCodeDataLoader.load();
    }
}
