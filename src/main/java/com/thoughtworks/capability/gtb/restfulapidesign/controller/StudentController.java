package com.thoughtworks.capability.gtb.restfulapidesign.controller;


import com.thoughtworks.capability.gtb.restfulapidesign.vo.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/students")
public class StudentController {

    public final StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<Student> createStudent(@RequestBody List<Student> studentList) {
        log.info("create students , request: {}", studentList);
        return studentService.createStudents(studentList);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public void deleteStudent(@PathVariable long id) {
        log.info("delete student by id: {}", id);
        studentService.deleteStudent(id);
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Student getStudent(@PathVariable long id) {
        log.info("get student by id: {}", id);
        return studentService.getStudent(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getStudents(@RequestParam(required = false) Boolean gender) {
        log.info("get all students by gender: {}", gender);
        return studentService.getStudents(gender);
    }

    @RequestMapping(path = "/{id}", method = {RequestMethod.PATCH, RequestMethod.PUT})
    @ResponseStatus(HttpStatus.CREATED)
    public Student updateStudent(@PathVariable long id, @RequestBody Student student) {
        log.info("update student by id: {}", id);
        return studentService.updateStudent(id, student);
    }

}
