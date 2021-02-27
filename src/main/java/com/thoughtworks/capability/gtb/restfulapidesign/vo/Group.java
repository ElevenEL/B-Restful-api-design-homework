package com.thoughtworks.capability.gtb.restfulapidesign.vo;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class Group {
    private final int id;
    private String name;
    private String note;
    private Set<Long> stuId;
}