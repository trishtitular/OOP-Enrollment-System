package org.example.service;

import org.example.model.Course;
import java.util.ArrayList;
import java.util.*;


public class CourseRegistration implements CourseReg{
    private final ArrayList<Course> courseLists = new ArrayList<>();
    private String courseID;

    // allow to add course
    @Override
    public void saveCourse(Course course){
        courseLists.add(course);
        System.out.println(course.getCourseName() + "registered successfully");
    }

    @Override
    public void displayAll(double pricePerUnit){
        if (courseLists.isEmpty()){
            System.out.println("No courses have been registered yet");
            return;
        }
        System.out.println("List of Available Courses");
        for (Course c: courseLists){
            double totalCost = c.getUnits() * pricePerUnit;
            System.out.println("Course ID: " +c.getCourseID() + " | Course Name: " + c.getCourseName() +
                    " | Course Units: " + c.getUnits() + " | Course Tuition Fee:  " +  totalCost + " Pesos");
        }
    }

    @Override
    public void updateCourse(Course updateCourse) {
        for (int i = 0; i < courseLists.size(); i++) {
            if (courseLists.get(i).getCourseID().equalsIgnoreCase(updateCourse.getCourseID())) {
                courseLists.set(i, updateCourse);
                System.out.println(updateCourse.getCourseID() + " updated successfully");
                return;
            }
        }
        System.out.println("Error: Course ID is not registered yet");
    }
        @Override
        public void removeCourse(String courseID){
            boolean removed = courseLists.removeIf(c -> c.getCourseID().equalsIgnoreCase(courseID));
            if (removed) {
                System.out.println(courseID + " removed successfully");
            } else {
                System.out.println("Error: " + courseID + " is not registered yet");
            }
        }

        @Override
        public Course findByCourseID(String id){
            for (Course c : courseLists){
                if(c.getCourseID().equalsIgnoreCase(id)){
                    return c;
                }
            }
            return null;
        }
}
