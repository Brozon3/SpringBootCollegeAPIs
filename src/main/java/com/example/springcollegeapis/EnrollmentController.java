package com.example.springcollegeapis;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/enrollment")
public class EnrollmentController {

    private final EnrollmentRepository enrollmentRepository;

    @Autowired
    public EnrollmentController(EnrollmentRepository enrollmentRepository) { this.enrollmentRepository = enrollmentRepository; }

    @PostMapping("/add")
    public String addStudentToCourse(@RequestParam Integer courseID, @RequestParam Integer studentID){
        Enrollment enrollment = new Enrollment();
        enrollment.setCourseID(courseID);
        enrollment.setStudentID(studentID);
        enrollmentRepository.save(enrollment);
        return String.format("Added %d to the enrollment table for course %d", studentID, courseID);
    }

    @GetMapping("/courseList/{id}")
    public Enrollment getEnrollmentByCourseID(@PathVariable Integer id){ return enrollmentRepository.findEnrollmentByCourseID(id); }

    @GetMapping("/studentList/{id}")
    public Enrollment getEnrollmentByStudentID(@PathVariable Integer id){ return enrollmentRepository.findEnrollmentByStudentID(id); }

    @PutMapping("/modify")
    public String modifyEnrollment(@RequestParam Integer eid, @RequestParam Integer courseID,
                                   @RequestParam Integer studentID){
        Enrollment enrollment = new Enrollment();
        enrollment.setEid(eid);
        enrollment.setCourseID(courseID);
        enrollment.setStudentID(studentID);
        enrollmentRepository.save(enrollment);
        return String.format("Changed enrollment details for student %d and course %d.", studentID, courseID);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEnrollment(@PathVariable Integer id) {
        enrollmentRepository.deleteById(id);
        return String.format("Deleted program %d", id);
    }
}
