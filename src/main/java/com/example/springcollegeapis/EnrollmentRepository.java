package com.example.springcollegeapis;

import org.springframework.data.repository.CrudRepository;

public interface EnrollmentRepository extends CrudRepository<Enrollment, Integer>{
    Enrollment findEnrollmentByCourseID (Integer courseID);
    Enrollment findEnrollmentByStudentID (Integer studentID);
}
