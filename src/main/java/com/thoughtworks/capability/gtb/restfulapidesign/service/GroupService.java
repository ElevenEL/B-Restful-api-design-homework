package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.entity.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.entity.Student;

import java.util.List;

public interface GroupService {
    List<Group> createGroups(List<Student> students);

    Group getGroup(int id);

    List<Group> getGroups();

    Group updateGroup(int id, Group group);
}
