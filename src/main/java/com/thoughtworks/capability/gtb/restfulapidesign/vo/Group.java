package com.thoughtworks.capability.gtb.restfulapidesign.vo;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@AllArgsConstructor
public class Group {

    private final int id;

    @NotBlank(message = "组名不为空")
    private String name;

    private String note;

    @NotEmpty(message = "学生ID不为空")
    private Set<Long> stuId;
}