package org.example.service;

import org.example.model.Course;
import java.util.*;

public interface CourseReg {
    void saveCourse(Course course);
    void displayAll(double pricePerUnit);
    void updateCourse(Course updateCourse);
    void removeCourse(String courseID);
    Course findByID(String id);

}
