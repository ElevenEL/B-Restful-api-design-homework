package com.thoughtworks.capability.gtb.restfulapidesign.service.impl;

import com.thoughtworks.capability.gtb.restfulapidesign.entity.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.entity.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.service.GroupService;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@NoArgsConstructor
public class GroupServiceImpl implements GroupService {

    @Setter
    private int initialCapacity = 6;
    private final List<List<Student>> studentGroup = new ArrayList<>();
    private List<Group> groups;

    @Override
    public List<Group> createGroups(List<Student> students) {

        studentGroup.clear();

        for (int i = 0; i < Math.min(students.size(), initialCapacity); i++)
            studentGroup.add(new ArrayList<>());


        for (int index = 0; index < students.size(); index++)
            studentGroup.get(index % initialCapacity).add(students.get(index));

        groups = new ArrayList<>(studentGroup.size());
        for (int groupId = 1; groupId <= studentGroup.size(); groupId++) {
            groups.add(new Group(groupId,
                    "team " + groupId,
                    "note",
                    studentGroup.get(groupId - 1).stream().map(Student::getId).collect(Collectors.toSet())));
        }
        return groups;
    }

    @Override
    public Group getGroup(int id) {
        return groups.get(id - 1);
    }

    @Override
    public List<Group> getGroups() {
        return groups;
    }

    @Override
    public Group updateGroup(int groupId, Group group) {
        return getGroup(groupId).updateByGroup(group);
    }
}
