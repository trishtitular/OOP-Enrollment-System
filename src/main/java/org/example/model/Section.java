package org.example.model;
import java.util.*;


public class Section {
    private String sectionName;
    private int maxCapacity;
    private List<Student> studentList;
    private Course course;
    private Instructor instructorAssigned;

    public Section (String sectionName, int maxCapacity, List<Student> studentList,Instructor instructorAssigned ){
        this.sectionName = sectionName;
        this.maxCapacity = maxCapacity;
        this.studentList = studentList != null ? studentList : new ArrayList<>();
        this.instructorAssigned = instructorAssigned;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName){
        this.sectionName = sectionName;
    }

    public int getMaxCapacity(){
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Instructor getInstructorAssigned() {
        return instructorAssigned;
    }

    public void setInstructorAssigned(Instructor instructorAssigned) {
        this.instructorAssigned = instructorAssigned;
    }
    public void displaySection() {
        System.out.println("Section: " + sectionName);

        System.out.println("Instructor: " + (instructorAssigned != null ? instructorAssigned.getPersonName() : "Pending"));

        if (course != null) {
            System.out.println("Course: " + course.getCourseName() + " (" + course.getCourseID() + ")");
        } else {
            System.out.println("Course: Pending");
        }

        System.out.println("Total Students: " + studentList.size() + "/" + maxCapacity);
        if (studentList.isEmpty()) {
            System.out.println("Student List: (No students enrolled)");
        } else {
            System.out.print("Student List: ");
            for (int i = 0; i < studentList.size(); i++) {
                System.out.print(studentList.get(i).getPersonName() + (i < studentList.size() - 1 ? ", " : ""));
            }
            System.out.println();
        }
        System.out.println("-----------------------------------");
    }
    @Override
    public String toString() {
        return sectionName + " [" + studentList.size() + "/" + maxCapacity + "]";
    }
}
