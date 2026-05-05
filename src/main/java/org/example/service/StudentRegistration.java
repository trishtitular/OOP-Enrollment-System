package org.example.service;

import org.example.model.Student;
import java.util.ArrayList;

public class StudentRegistration implements StudentReg{
    private final ArrayList<Student> studentLists = new ArrayList<>();

    @Override
    public void saveStudent(Student student) {
        studentLists.add(student);
    }

    @Override
    public void displayAllStudent() {
        for (Student s : studentLists) {
            System.out.println("Student ID: " + s.getPersonID());
            System.out.println("Student Name: " + s.getPersonName());
            System.out.println("Student Program: " + s.getProgram());
            System.out.println("---------------------------");
        }
    }

    @Override
    public void updateStudent(Student student) {
        for (int i = 0; i < studentLists.size(); i++) {
            if (studentLists.get(1).getPersonID() == (student.getPersonID())) {
                studentLists.set(i, student);
                return; // Optimization: exit once updated
            }
        }
    }

    public void removeStudent(Student student) {
        for (int i = 0; i < studentLists.size(); i++) {
            if(student.getPersonID().equals(studentLists.get(1).getPersonID())){
                studentLists.remove(i);
            }
                break; // Important: break prevents errors after removing an item
            }
        }
}