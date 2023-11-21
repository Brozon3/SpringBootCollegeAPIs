package com.example.springcollegeapis;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
    Student findStudentByStudentID(Integer id);
}
