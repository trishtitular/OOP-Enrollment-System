package org.example.service;

import java.util.*;

import org.example.model.Student;
import org.example.model.Person;

public class StudentRegistration extends Person implements StudentReg{
    static Scanner scan = new Scanner(System.in);
    private final ArrayList<Student> studentLists = new ArrayList<>();

    @Override
    public void saveStudent(Student student) {
        if (findByStudentID(student.getPersonID()) == null) {
            studentLists.add(student);
        } else {
            System.out.println("Error: Student ID " + student.getPersonID() + " exists already.");
        }
    }


    @Override
    public void displayAllStudent() {
        if (studentLists.isEmpty()){
            System.out.println("No student records found");
        }
        for (Student s : studentLists) {
            System.out.println("Student ID: " + s.getPersonID());
            System.out.println("Student Name: " + s.getPersonName());
            System.out.println("Student Program: " + s.getProgram() + "\n");
        }
    }
// update student
    @Override
    public boolean updateStudent(Student student) {
        for (int i = 0; i < studentLists.size(); i++) {
            if (studentLists.get(i).getPersonID().equalsIgnoreCase(student.getPersonID())) {
                studentLists.set(i, student);
                return true;
            }
        }
        return false;
    }
    //remove student
    @Override
    public boolean removeStudent(Student student) {
        for (int i = 0; i < studentLists.size(); i++) {
            if (studentLists.get(i).getPersonID().equalsIgnoreCase(student.getPersonID())) {
                studentLists.remove(i);
                return true;
            }
        }
        return false;
    }
    public Student findByStudentID (String id){
        for (Student s : studentLists){
            if (s.getPersonID().equalsIgnoreCase(id)){
                return s;
            }
        }
        return null;
    }
    @Override
    public void mainTask(){
        System.out.println("Registers students");
    }
}