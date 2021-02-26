package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.entity.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.entity.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.service.GroupService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/groups")
public class GroupController {

    public final GroupService groupService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<Group> createGroups(@RequestBody List<Student> students) {
        return groupService.createGroups(students);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Group getGroup(@PathVariable int id) {
        return groupService.getGroup(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Group> getGroups() {
        return groupService.getGroups();
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Group updateGroup(@PathVariable int id, @RequestBody Group group) {
        return groupService.updateGroup(id, group);
    }

}
