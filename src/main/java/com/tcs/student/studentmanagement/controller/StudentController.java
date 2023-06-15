package com.tcs.student.studentmanagement.controller;

import com.tcs.student.studentmanagement.Student;
import com.tcs.student.studentmanagement.exception.StudentAlreadyExistsException;
import com.tcs.student.studentmanagement.exception.StudentNotFoundException;
import com.tcs.student.studentmanagement.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    Logger log = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;


    @PostMapping("/add")
    public String addStudent(@RequestBody Student student) throws StudentAlreadyExistsException {
        log.trace("Entry addStudent method");
        log.debug("Adding student");

        String message = studentService.addStudent(student);
        log.info("student added");
        log.trace("Exit addStudent method");
        return message;
    }

    @GetMapping("/get")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PutMapping("/update/{rollNo}")
    public String updateStudent(@PathVariable("rollNo") int rollNo) throws StudentNotFoundException {
        return studentService.updateStudent(rollNo);

    }

    @DeleteMapping("/delete/{rollNo}")
    public String deleteStudent(@PathVariable("rollNo") int rollNo) throws StudentNotFoundException {
        return studentService.deleteStudent(rollNo);
    }
}
