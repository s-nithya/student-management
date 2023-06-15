package com.tcs.student.studentmanagement.repo;

import com.tcs.student.studentmanagement.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Integer> {

    @Transactional
    public void deleteByNameIgnoreCase(String name);


}
