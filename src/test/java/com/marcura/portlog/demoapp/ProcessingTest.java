package com.marcura.portlog.demoapp;

import com.marcura.portlog.demoapp.dtos.DemoRequest;
import com.marcura.portlog.demoapp.dtos.DemoResponse;
import com.marcura.portlog.demoapp.services.DemoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProcessingTest {
    private final static DemoRequest request = new DemoRequest("Demo request", 2L, null);

    private final DemoService demoService;

    @Autowired
    public ProcessingTest(DemoService demoService){
        this.demoService = demoService;
    }

    @Test
    public void validateScoreCalculation(){
        DemoResponse response = this.demoService.processRequest(request);
        Assertions.assertNotNull(response);
        Assertions.assertEquals(2L * 1.5, response.getScore(), "Calculated score doesn't match!");
    }
}
