package com.example.springcollegeapis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseController(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    @PostMapping("/add")
    public String addCourse(@RequestParam Integer courseID, @RequestParam String courseName,
                            @RequestParam String courseNumber, @RequestParam Integer capacity) {
        Course course = new Course();
        course.setCourseID(courseID);
        course.setCourseName(courseName);
        course.setCourseNumber(courseNumber);
        course.setCapacity(capacity);
        courseRepository.save(course);
        return String.format("Added %s to the course table.", courseName);
    }

    @GetMapping("/find/{id}")
    public Course findCourseByID(@PathVariable Integer id){
        return courseRepository.findCourseByCourseID(id);
    }

    @GetMapping("/list")
    public Iterable<Course> getCourses(){
        return courseRepository.findAll();
    }
}
