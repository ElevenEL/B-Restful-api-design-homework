package com.thoughtworks.capability.gtb.restfulapidesign.service.impl;

import com.thoughtworks.capability.gtb.restfulapidesign.entity.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final Map<Long, Student> studentMap;

    @Override
    public List<Student> createStudents(List<Student> students) {
        List<Student> createdStudents = students.stream()
                .filter(student -> !studentMap.containsKey(student.getId()))
                .peek(student -> studentMap.put(student.getId(), student))
                .collect(Collectors.toList());
        if (createdStudents.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "All students have already been created!!");
        }
        return createdStudents;
    }

    @Override
    public void deleteStudent(Long id) {
        if (Objects.isNull(studentMap.remove(id))) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "studentID can't find !!");
        }
    }

    @Override
    public Student getStudent(Long id) {
        Student student = studentMap.get(id);
        if (Objects.isNull(student)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "studentID can't find !!");
        }
        return student;
    }

    @Override
    public List<Student> getStudents(Boolean gender) {
        return Objects.isNull(gender) ? new ArrayList<>(studentMap.values())
                : studentMap.values()
                .stream()
                .filter(student -> gender.equals(student.getGender())).collect(Collectors.toList());
    }

    @Override
    public Student updateStudent(Long id, Student newStudent) {

        return getStudent(id).updateByStudent(newStudent);
    }
}
