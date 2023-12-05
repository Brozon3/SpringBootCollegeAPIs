package com.example.springcollegeapis;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Program {
    @Id
    @GeneratedValue
    private Integer pid;
    private String programName;
    private String campus;

    public Integer getPid() { return pid; }

    public void setPid(Integer pid) { this.pid = pid; }

    public String getProgramName() { return programName; }

    public void setProgramName(String programName) { this.programName = programName; }

    public String getCampus() { return campus; }

    public void setCampus(String campus) { this.campus = campus; }
}
