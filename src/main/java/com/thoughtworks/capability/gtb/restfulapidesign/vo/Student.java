package com.thoughtworks.capability.gtb.restfulapidesign.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private final Long id;
    private String name;
    private Boolean gender;
    private String note;
}
