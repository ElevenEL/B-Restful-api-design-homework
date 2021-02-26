package com.thoughtworks.capability.gtb.restfulapidesign.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
    private final Long id;
    private String name;
    private Boolean gender;
    private String note;

    public Student updateByStudent(Student student) {
        if (student.getName() != null) {
            this.name = student.getName();
        }
        if (student.getGender() != null) {
            this.gender = student.getGender();
        }
        if (student.getNote() != null) {
            this.note = student.getNote();
        }
        return this;
    }
}
