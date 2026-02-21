package org.example.service;

import org.example.model.Student;

import java.util.ArrayList;

public class ServiceRegistration {
    private ArrayList<Student> studentLists = new ArrayList<>();

    public void saveStudent(Student student){
        studentLists.add(student);
    }

    public void displayAllStudent(){
        for (Student s: studentLists){
            System.out.println("Student ID: " + s.getStudentID());
            System.out.println("Student Name: " +s.getStudentName());
            System.out.println("Student Program: " +s.getStudentID());

        }
    }

    public void updateStudent (Student student){
        for (int i = 0; i < studentLists.size(); i++){
            if(studentLists.get(1).getStudentID()==(student.getStudentID())){
                studentLists.set(i,student);
            }
        }
    }

    public void removeStudent(Student student){
        for (int i = 0; i < studentLists.size(); i++){
            if(studentLists.get(1).getStudentID()==student.getStudentID()){
                studentLists.remove(i);
            }
        }
    }
}
