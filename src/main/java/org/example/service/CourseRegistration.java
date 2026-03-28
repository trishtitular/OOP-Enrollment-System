package org.example.service;

import org.example.model.Course;


import java.util.ArrayList;

public class CourseRegistration implements CourseReg{
    private final ArrayList<Course> courseLists = new ArrayList<>();

    @Override
    public void saveCourse(Course course){
        courseLists.add(course);
    }

    @Override
    public void displayAll(){
        for (Course c: courseLists){
            System.out.println("Course ID: " + c.getCourseID());
            System.out.println("Course Name: " + c.getCourseName());
            System.out.println("Course Program: " + c.getProgram());
        }
    }

    @Override
    public void updateCourse(Course course){
        for (int i = 0; i < courseLists.size(); i++){
            if (courseLists.get(1).getCourseID() == (course.getCourseID())) {
                courseLists.set(i, course);
            }
        }
    }

    @Override
    public void removeCourse(Course course){
        for (int i = 0; i < courseLists.size(); i++){
            if(course.getCourseID().equals(courseLists.get(1).getCourseID())){
                courseLists.remove(i);
            }
        }
    }

}
