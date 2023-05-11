package com.marcura.portlog.demoapp.services;

import com.marcura.portlog.demoapp.dtos.DemoRequest;
import com.marcura.portlog.demoapp.dtos.DemoResponse;

public interface DemoService {
    DemoResponse processRequest(DemoRequest request);
}
