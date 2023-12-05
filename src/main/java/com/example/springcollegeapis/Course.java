package com.example.springcollegeapis;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer courseID;
    private String courseName;
    private String courseNumber;
    private Integer capacity;
    private Integer year;
    private String semester;
    private Integer pid;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) { this.year = year; }

    public String getSemester() { return semester; }

    public void setSemester(String semester) { this.semester = semester; }

    public Integer getPid() { return pid; }

    public void setPid(Integer pid) { this.pid = pid; }

    public Integer getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
