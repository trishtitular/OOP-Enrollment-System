package org.example.model;

public class Course {
    private String courseID;
    private String courseName;
    private String courseProgram;
    private int units;

    public Course(String courseID, String courseName, String courseProgram, int units) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseProgram = courseProgram;
        this.units = units;
    }

    // Getters and Setters
    public String getCourseID() {
        return courseID;
    }
    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseProgram() {
        return courseProgram;
    }
    public void setCourseProgram(String courseProgram) {
        this.courseProgram = courseProgram;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public void displayCourse() {
        System.out.println("Course ID: " + courseID);
        System.out.println("Course Name: " + courseName);
        System.out.println("Program: " + courseProgram);
        System.out.println("Units: " + units + "\n");
    }
}