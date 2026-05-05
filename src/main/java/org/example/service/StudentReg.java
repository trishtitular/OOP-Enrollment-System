package org.example.service;

import org.example.model.Student;

public interface StudentReg {
    void saveStudent(Student student);
    void displayAllStudent();
    Student findByID(String id);
    default boolean updateStudent(Student student) {
        return false;
    }
    default boolean removeStudent(Student student) {
        return false;
    }
}
