package com.example.springcollegeapis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/grade")
public class GradeController {

    private final GradeRepository gradeRepository;

    @Autowired
    public GradeController(GradeRepository gradesRepository) { this.gradeRepository = gradesRepository; }

    @PostMapping("/add")
    public String addGrade(@RequestParam Integer studentID, @RequestParam Integer courseID,
                           @RequestParam Float gradeValue){
        Grade grade = new Grade();
        grade.setStudentID(studentID);
        grade.setCourseID(courseID);
        grade.setGrade(gradeValue);
        gradeRepository.save(grade);
        return String.format("Added %f grade to student %d for course %d", gradeValue, studentID, courseID);
    }

    @GetMapping("/studentGrades/{id}")
    public Grade getGradesByStudentID(@PathVariable Integer id){ return gradeRepository.getGradesByStudentID(id); }

    @GetMapping("/courseGrades/{id}")
    public Grade getGradesByCourseID(@PathVariable Integer id){ return gradeRepository.getGradesByCourseID(id); }

    @PutMapping("/modify")
    public String modifyGrade(@RequestParam Integer gid, @RequestParam Integer studentID,
                              @RequestParam Integer courseID, @RequestParam Float gradeValue){
        Grade grade = new Grade();
        grade.setGid(gid);
        grade.setStudentID(studentID);
        grade.setCourseID(courseID);
        grade.setGrade(gradeValue);
        gradeRepository.save(grade);
        return String.format("Changed grade for student %d and course %d to %f", studentID, courseID, gradeValue);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteGrade(@PathVariable Integer id) {
        gradeRepository.deleteById(id);
        return String.format("Deleted grade %d", id);
    }
}
