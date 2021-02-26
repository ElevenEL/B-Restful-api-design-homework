package com.thoughtworks.capability.gtb.restfulapidesign.entity;


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

    public Group updateByGroup(Group group) {
        if (group.getName() != null) {
            this.name = group.getName();
        }

        if (group.getNote() != null) {
            this.note = group.getNote();
        }

        if (group.getStuId() != null) {
            this.stuId = group.getStuId();
        }

        return this;
    }
}