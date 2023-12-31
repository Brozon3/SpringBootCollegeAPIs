package com.example.springcollegeapis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @PostMapping("/add")
    public String addStudent(@RequestParam String firstName,
                             @RequestParam String lastName, @RequestParam String email,
                             @RequestParam String address, @RequestParam String city,
                             @RequestParam String postal, @RequestParam String phone){
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        student.setAddress(address);
        student.setCity(city);
        student.setPostal(postal);
        student.setPhone(phone);
        studentRepository.save(student);
        return String.format("Added %s %s to the student table.", firstName, lastName);
    }

    @GetMapping("/list")
    public Iterable<Student> getStudents() { return studentRepository.findAll(); }

    @GetMapping("/view/{id}")
    public Student viewStudent(@PathVariable Integer id) { return studentRepository.findStudentByStudentID(id); }

    @PutMapping("/modify")
    public String modifyStudent(@RequestParam Integer studentID, @RequestParam String firstName,
                                @RequestParam String lastName, @RequestParam String email,
                                @RequestParam String address, @RequestParam String city,
                                @RequestParam String postal, @RequestParam String phone){
        Student student = new Student();
        student.setStudentID(studentID);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        student.setAddress(address);
        student.setCity(city);
        student.setPostal(postal);
        student.setPhone(phone);
        studentRepository.save(student);

        return String.format("Changed student details for %s %s.", firstName, lastName);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        studentRepository.deleteById(id);
        return String.format("Deleted student %d from database.", id);
    }
}
