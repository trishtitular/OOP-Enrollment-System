package org.example.service;

import org.example.model.Student;

import java.util.ArrayList;

public class StudentRegistration implements StudentReg {
    private final ArrayList<Student> studentLists = new ArrayList<>();

    @Override
    public void saveStudent(Student student){
        studentLists.add(student);
    }

    @Override
    public void displayAllStudent(){
        for (Student s: studentLists){
            System.out.println("Student ID: " + s.getPersonID());
            System.out.println("Student Name: " +s.getPersonName());
            System.out.println("Student Program: " +s.getProgram());

        }
    }

    @Override
    public void updateStudent (Student student){
        for (int i = 0; i < studentLists.size(); i++){
            if(studentLists.get(i).getPersonID().equals(student.getPersonID())){
                studentLists.set(i,student);
            }
        }
    }

    @Override
    public void removeStudent(Student student){
        for (int i = 0; i < studentLists.size(); i++){
            if(studentLists.get(1).getPersonID().equals(student.getPersonID()))
                studentLists.remove(i);
        }
    }


}
