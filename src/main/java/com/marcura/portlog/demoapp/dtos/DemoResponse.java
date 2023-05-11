package com.marcura.portlog.demoapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DemoResponse {
    String description;
    Double score;
    List<String> values;
}
