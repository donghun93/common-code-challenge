package com.common.code.challenge.system.data.init.converter;

import com.common.code.challenge.system.data.init.model.CityReconstruction;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Component
public class CityReconstructionConverter {
    private final ObjectMapper mapper;
    private final ResourceLoader resourceLoader;
    public List<CityReconstruction> convert() {
        Resource resource = resourceLoader.getResource("classpath:data/city_reconstruction_list.json");

        try {
            String jsonData = new String(Files.readAllBytes(resource.getFile().toPath()));
            Map<String, Object> map = mapper.readValue(jsonData, new TypeReference<>() {});
            return mapper.convertValue(map.get("DATA"), new TypeReference<>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
