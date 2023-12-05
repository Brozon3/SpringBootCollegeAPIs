package com.example.springcollegeapis;

import org.springframework.data.repository.CrudRepository;

public interface GradeRepository extends CrudRepository<Grade, Integer> {
    Grade getGradesByStudentID (Integer studentID);
    Grade getGradesByCourseID (Integer courseID);
}
