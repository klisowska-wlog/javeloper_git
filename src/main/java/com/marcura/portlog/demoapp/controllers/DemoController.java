package com.marcura.portlog.demoapp.controllers;

import com.marcura.portlog.demoapp.dtos.DemoRequest;
import com.marcura.portlog.demoapp.dtos.DemoResponse;
import com.marcura.portlog.demoapp.services.DemoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
@Slf4j
public class DemoController {
    private final DemoService demoService;

    @Autowired
    public DemoController(DemoService demoService){
        this.demoService = demoService;
    }

    @GetMapping("/get")
    @Operation(summary = "Demo GET API")
    @ApiResponse(responseCode = "200", description = "Example response")
    public ResponseEntity<DemoResponse> getDemoResponse(@RequestParam String name, @RequestParam Long numVal) {
        log.info("GET request received with params name: {}, numVal: {}", name, numVal);
        DemoResponse response = this.demoService.processRequest(new DemoRequest(name, numVal, null));

        if(response == null){
            log.warn("Request couldn't be processed properly!");
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(response);
    }

    @PostMapping("/post")
    @Operation(summary = "Demo POST API")
    @ApiResponse(responseCode = "404", description = "Failed validation or insufficient parameters", content = @Content)
    @ApiResponse(responseCode = "200", description = "Processed response")
    public ResponseEntity<DemoResponse> processRequest(@Valid @RequestBody DemoRequest request) {
        DemoResponse response = this.demoService.processRequest(request);
        log.info("POST request received with body {}", request.toString());
        if(response == null){
            log.warn("Request couldn't be processed properly!");
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(response);
    }
}
