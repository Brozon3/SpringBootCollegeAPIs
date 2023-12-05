package com.example.springcollegeapis;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer eid;
    private Integer courseID;
    private Integer studentID;

    public Integer getEid() { return eid; }

    public void setEid(Integer eid) { this.eid = eid; }

    public Integer getCourseID() { return courseID; }

    public void setCourseID(Integer courseID) { this.courseID = courseID; }

    public Integer getStudentID() { return studentID; }

    public void setStudentID(Integer studentID) { this.studentID = studentID; }
}
