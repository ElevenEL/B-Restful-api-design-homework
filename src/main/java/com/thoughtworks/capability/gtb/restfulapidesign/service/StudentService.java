package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.vo.Student;

import java.util.List;

public interface StudentService {

    List<Student> createStudents(List<Student> students);

    void deleteStudent(Long id);

    Student getStudent(Long id);

    List<Student> getStudents(Boolean gender);

    Student updateStudent(Long id, Student student);

}
