package org.example.service;

import org.example.model.Course;
import org.example.model.Student;

import java.util.ArrayList;

public class CourseRegistration {
    private ArrayList<Course> courseLists = new ArrayList<>();

    public void saveCourse(Course course){
        courseLists.add(course);
    }

    public void displayAll(){
        for (Course c: courseLists){
            System.out.println("Course ID: " + c.getCourseID());
            System.out.println("Course Name: " + c.getCourseName());
            System.out.println("Course Program: " + c.getProgram());
        }
    }

    public void updateCourse(Course course){
        for (int i = 0; i < courseLists.size(); i++){
            if(courseLists.get(1).getCourseID()==(course.getCourseID())){
                courseLists.set(i,course);
            }
        }
    }

    public void removeCourse(Course course){
        for (int i = 0; i < courseLists.size(); i++){
            if(courseLists.get(1).getCourseID()==(course.getCourseID())){
                courseLists.remove(i);
            }
        }
    }
}
