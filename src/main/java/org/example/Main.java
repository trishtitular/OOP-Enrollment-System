package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Student stud = new Student();
        Student stud1 = new Student();

        stud.setStudentID("00123");
        stud.setStudentName("John Doe");
        stud.setProgram("Information Technology");

        stud1.setStudentID("00124");
        stud1.setStudentName("Jane Doe");
        stud1.setProgram("Information Technology");

        Course cour = new Course();

        cour.setCourseID("001");
        cour.setCourseName("Integrative Programming");
        cour.setProgram("Information Technology");


        stud.display();
        stud1.display();
        cour.display();



    }
}