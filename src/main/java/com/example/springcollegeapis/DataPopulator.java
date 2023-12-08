package com.example.springcollegeapis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
@RequestMapping("/populateDB")
public class DataPopulator {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final EnrollmentRepository enrollmentRepository;
    private final GradeRepository gradeRepository;
    private final ProgramRepository programRepository;

    @Autowired
    public DataPopulator(StudentRepository studentRepository, CourseRepository courseRepository,
                         EnrollmentRepository enrollmentRepository, ProgramRepository programRepository,
                         GradeRepository gradeRepository){
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.enrollmentRepository = enrollmentRepository;
        this.programRepository = programRepository;
        this.gradeRepository = gradeRepository;
    }

    public void addStudents () {
        ArrayList<ArrayList<String>> students = new ArrayList<>();

        ArrayList<String> student1 = new ArrayList<>(Arrays.asList(
                "Pat", "Broders", "broderspatrick@gmail.com", "78 Glenview Terrace",
                "St. John's", "A1E 3H7", "(709) 728-8413"));

        ArrayList<String> student2 = new ArrayList<>(Arrays.asList(
                "Pam", "Burke", "pamelaburke@gmail.com", "78 Glenview Terrace",
                "St. John's", "A1E 3H7", "(709) 763-2473"));

        ArrayList<String> student3 = new ArrayList<>(Arrays.asList(
                "LeBron", "James", "lebronjames@gmail.com", "42 Laker Blvd.",
                "LA", "G0A 7T1", "(448) 123-4567"));

        ArrayList<String> student4 = new ArrayList<>(Arrays.asList(
                "Gunnarsson", "Brampf", "gunnarbramf@gmail.com", "445 South Ave.",
                "Jacksonville", "J0R 1D8", "(986) 893-9812"));

        ArrayList<String> student5 = new ArrayList<>(Arrays.asList(
                "Carol", "Darol", "caroldarol@gmail.com", "9028 Long Rd.",
                "Edmunston", "V0V 7X7", "(010) 101-0101"));

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);

        for (ArrayList<String> studentInfo: students){

            Student student = new Student();
            student.setFirstName(studentInfo.get(0));
            student.setLastName(studentInfo.get(1));
            student.setEmail(studentInfo.get(2));
            student.setAddress(studentInfo.get(3));
            student.setCity(studentInfo.get(4));
            student.setPostal(studentInfo.get(5));
            student.setPhone(studentInfo.get(6));

            studentRepository.save(student);
        }

        System.out.println("Students successfully added to the database.");
    }

    public void addCourses() {
        ArrayList<ArrayList<String>> courses = new ArrayList<>();

        ArrayList<String> course1 = new ArrayList<>(Arrays.asList(
                "Advanced React", "3482", "25", "3",
                "2", "1"));

        ArrayList<String> course2 = new ArrayList<>(Arrays.asList(
                "Video Game Development", "3481", "25", "3",
                "1", "2"));

        courses.add(course1);
        courses.add(course2);

        for (ArrayList<String> courseInfo: courses){

            Course course = new Course();
            course.setCourseName(courseInfo.get(0));
            course.setCourseNumber(courseInfo.get(1));
            course.setCapacity(Integer.parseInt(courseInfo.get(2)));
            course.setYear(Integer.parseInt(courseInfo.get(3)));
            course.setSemester(courseInfo.get(4));
            course.setPid(Integer.parseInt(courseInfo.get(5)));

            courseRepository.save(course);
        }

        System.out.println("Courses successfully added to the database.");
    }

    public void addPrograms() {
        ArrayList<ArrayList<String>> programs = new ArrayList<>();

        ArrayList<String> program1 = new ArrayList<>(Arrays.asList(
                "Software Development for Muggles", "Hogwarts"));

        ArrayList<String> program2 = new ArrayList<>(Arrays.asList(
                "Video Game Development", "Prince Phillip Drive"));

        programs.add(program1);
        programs.add(program2);

        for (ArrayList<String> programInfo: programs){

            Program program = new Program();
            program.setProgramName(programInfo.get(0));
            program.setCampus(programInfo.get(1));

           programRepository.save(program);
        }

        System.out.println("Programs successfully added to the database.");
    }

    public void addEnrollments(){
        ArrayList<ArrayList<String>> enrollments = new ArrayList<>();

        ArrayList<String> enrollment1 = new ArrayList<>(Arrays.asList(
                "1", "2"
        ));

        ArrayList<String> enrollment2 = new ArrayList<>(Arrays.asList(
                "2", "1"
        ));

        ArrayList<String> enrollment3 = new ArrayList<>(Arrays.asList(
                "1", "3"
        ));

        ArrayList<String> enrollment4 = new ArrayList<>(Arrays.asList(
                "2", "5"
        ));

        ArrayList<String> enrollment5 = new ArrayList<>(Arrays.asList(
                "1", "4"
        ));

        enrollments.add(enrollment1);
        enrollments.add(enrollment2);
        enrollments.add(enrollment3);
        enrollments.add(enrollment4);
        enrollments.add(enrollment5);

        for (ArrayList<String> enrollmentInfo: enrollments){

            Enrollment enrollment = new Enrollment();
            enrollment.setStudentID(Integer.parseInt(enrollmentInfo.get(0)));
            enrollment.setCourseID(Integer.parseInt(enrollmentInfo.get(1)));

            enrollmentRepository.save(enrollment);
        }

        System.out.println("Enrollments successfully added to the database.");
    }

    public void addGrades(){
        ArrayList<ArrayList<String>> grades = new ArrayList<>();

        ArrayList<String> grade1 = new ArrayList<>(Arrays.asList(
                "1", "2", "89"
        ));

        ArrayList<String> grade2 = new ArrayList<>(Arrays.asList(
                "2", "1", "100"
        ));

        ArrayList<String> grade3 = new ArrayList<>(Arrays.asList(
                "3", "1", "49"
        ));

        ArrayList<String> grade4 = new ArrayList<>(Arrays.asList(
                "4", "1", "69"
        ));

        ArrayList<String> grade5 = new ArrayList<>(Arrays.asList(
                "5", "2", "50"
        ));

        grades.add(grade1);
        grades.add(grade2);
        grades.add(grade3);
        grades.add(grade4);
        grades.add(grade5);

        for (ArrayList<String> gradeInfo: grades){

            Grade grade = new Grade();
            grade.setStudentID(Integer.parseInt(gradeInfo.get(0)));
            grade.setCourseID(Integer.parseInt(gradeInfo.get(1)));
            grade.setGrade(Float.parseFloat(gradeInfo.get(2)));

            gradeRepository.save(grade);
        }

    }

    @PostMapping("/fill")
    public String fillDB() {
        addStudents();
        addCourses();
        addPrograms();
        addEnrollments();
        addGrades();

        return("Successfully filled the database.");
    }

}
