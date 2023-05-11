package com.marcura.portlog.demoapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DemoRequest {
    String name;
    Long numVal;
    List<String> values;
}
