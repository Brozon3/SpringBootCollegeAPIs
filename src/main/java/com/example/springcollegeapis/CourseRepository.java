package com.example.springcollegeapis;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Integer>{
    Course findCourseByCourseID (Integer id);
}
