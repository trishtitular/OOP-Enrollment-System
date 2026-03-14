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
            System.out.println("Student ID: " + s.getPersonID());
            System.out.println("Student Name: " +s.getPersonName());
            System.out.println("Student Program: " +s.getProgram());

        }
    }

    public void updateStudent (Student student){
        for (int i = 0; i < studentLists.size(); i++){
            if(studentLists.get(i).getPersonID()==(student.getPersonID())){
                studentLists.set(i,student);
            }
        }
    }

    public void removeStudent(Student student){
        for (int i = 0; i < studentLists.size(); i++){
            if(studentLists.get(1).getPersonID()==student.getPersonID()){
                studentLists.remove(i);
            }
        }
    }


}
