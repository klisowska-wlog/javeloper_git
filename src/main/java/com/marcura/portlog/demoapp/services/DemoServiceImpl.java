package com.marcura.portlog.demoapp.services;

import com.marcura.portlog.demoapp.dtos.DemoRequest;
import com.marcura.portlog.demoapp.dtos.DemoResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@Slf4j
public class DemoServiceImpl implements DemoService{
    private static final Double multiplier = 1.5;

    @Override
    @Cacheable("demo-process-cache")
    public DemoResponse processRequest(DemoRequest request) {
        log.info("Processing request {}", request.toString());
        if(!StringUtils.hasText(request.getName())){
            log.warn("No name provided so request considered invalid!");
            return null;
        }

        DemoResponse response = new DemoResponse();
        response.setScore(request.getNumVal() * multiplier);
        response.setDescription("Result calculated");
        response.setValues(request.getValues());

        return response;
    }
}
