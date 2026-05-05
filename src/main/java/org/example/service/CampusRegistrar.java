package org.example.service;

import org.example.model.Course;
import org.example.model.Student;

public class CampusRegistrar {
    private final StudentReg studentRegistration;
    private final CourseReg courseRegistration;

    public CampusRegistrar(StudentReg studentRegistration, CourseReg courseRegistration){

        this.studentRegistration = studentRegistration;
        this.courseRegistration = courseRegistration;
    }
    public void saveStudent(Student student){
        studentRegistration.saveStudent(student);

    }
    public String displayAllStudent(){
        studentRegistration.displayAllStudent();
        return "Success";

    }
    public String updateStudent(Student student){
        studentRegistration.updateStudent(student);
        return "Success";

    }
    public String removeStudent(Student student){
        studentRegistration.removeStudent(student);
        return "Success";

    }
    public String saveCourse(Course course){
        courseRegistration.saveCourse(course);
        return "Success";

    }
    public String displayAll(){
        courseRegistration.displayAll();
        return "Success";

    }
    public String updateCourse(Course course) {
        courseRegistration.updateCourse(course);
        return "Success";
    }
    public String removeCourse(Course course) {
        courseRegistration.removeCourse(course);
        return "Success";
    }
}
