package com.common.code.challenge.system.data.init.converter;

import com.common.code.challenge.system.data.init.model.AreaCode;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RequiredArgsConstructor
@Component
public class AreaCodeConverter {
    private final ResourceLoader resourceLoader;

    public Map<AreaCode, Map<AreaCode, Map<AreaCode, AreaCode>>> convert() {
        Resource resource = resourceLoader.getResource("classpath:data/area_code_list.txt");
        Map<AreaCode, Map<AreaCode, Map<AreaCode, AreaCode>>> areaCodeMap = new LinkedHashMap<>();
        Map<String, AreaCode> mainAreaMap = new HashMap<>();
        Map<String, AreaCode> middleAreaMap = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), "x-windows-949"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length < 2 || parts[2].equals("폐지")) continue;

                String code = parts[0];
                String name = parts[1];
                String[] names = name.split(" ");

                AreaCode mainArea = null;
                AreaCode middleArea = null;
                AreaCode subArea = null;

                if (names.length >= 1) {
                    String bigCategoryName = names[0];
                    mainAreaMap.putIfAbsent(bigCategoryName, new AreaCode(code, bigCategoryName, 1));
                    mainArea = mainAreaMap.get(bigCategoryName);
                }

                if (names.length >= 2) {
                    String midCategoryName = names[0] + " " + names[1];
                    middleAreaMap.putIfAbsent(midCategoryName, new AreaCode(code, midCategoryName, 2));
                    middleArea = middleAreaMap.get(midCategoryName);
                }

                if (names.length >= 3) {
                    subArea = new AreaCode(code, name, 3);
                }

                if (mainArea != null && middleArea != null && subArea != null) {
                    areaCodeMap.computeIfAbsent(mainArea, k -> new LinkedHashMap<>())
                               .computeIfAbsent(middleArea, k -> new LinkedHashMap<>())
                               .put(subArea, subArea);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return areaCodeMap;
    }
}
