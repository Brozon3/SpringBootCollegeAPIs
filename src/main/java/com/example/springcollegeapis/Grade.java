package com.example.springcollegeapis;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer gid;
    private Integer studentID;
    private Integer courseID;
    private Float grade;

    public Integer getGid() { return gid; }

    public void setGid(Integer gid) { this.gid = gid; }

    public Integer getStudentID() { return studentID; }

    public void setStudentID(Integer studentID) { this.studentID = studentID; }

    public Integer getCourseID() { return courseID; }

    public void setCourseID(Integer courseID) { this.courseID = courseID; }

    public Float getGrade() { return grade; }

    public void setGrade(Float grade) { this.grade = grade; }
}
