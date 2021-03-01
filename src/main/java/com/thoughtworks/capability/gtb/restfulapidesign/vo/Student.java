package com.thoughtworks.capability.gtb.restfulapidesign.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class Student {

    private final Long id;

    @NotBlank(message = "学生姓名不为空")
    private String name;

    private Boolean gender;

    private String note;
}
