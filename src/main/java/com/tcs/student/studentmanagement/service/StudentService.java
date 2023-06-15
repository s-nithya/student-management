package com.tcs.student.studentmanagement.service;

import com.tcs.student.studentmanagement.Student;
import com.tcs.student.studentmanagement.exception.StudentAlreadyExistsException;
import com.tcs.student.studentmanagement.exception.StudentNotFoundException;
import com.tcs.student.studentmanagement.repo.IStudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    Logger log = LoggerFactory.getLogger(StudentService.class);


    @Autowired
    IStudentRepository studentRepo;


    public String addStudent(Student student) throws StudentAlreadyExistsException {
        log.trace("Entry addStudent method");

        Optional<Student> opStu = studentRepo.findById(student.getRollNo());

        if (opStu.isPresent()) {
            throw new StudentAlreadyExistsException("Student already exist for roll number:" + student.getRollNo());
        } else {
            studentRepo.save(student);
        }
        log.trace("Exit addStudent method");


        return "Student Added Successfully";
    }


    public List<Student> getStudents() {
        return studentRepo.findAll();
    }

    public String updateStudent(int rollNo) throws StudentNotFoundException {
        Optional<Student> studentOp = studentRepo.findById(rollNo);
        if (studentOp.isPresent()) {
            Student student = studentOp.get();
            student.setGrade("D");
            studentRepo.save(student);
            return "Student updated successfully";
        } else {
            throw new StudentNotFoundException("Student Not Found");
        }

    }


    public String deleteStudent(int rollNo) throws StudentNotFoundException {
        Optional<Student> studentOp = studentRepo.findById(rollNo);

        if (studentOp.isPresent()) {
            studentRepo.deleteById(rollNo);
            return "Student deleted";
        } else {
            throw new StudentNotFoundException("No student found for id " + rollNo);
        }

    }

}
