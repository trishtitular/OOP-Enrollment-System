package org.example;

import org.example.model.Course;
import org.example.model.Student;
import org.example.service.CampusRegistrar;
import org.example.service.CourseRegistration;
import org.example.service.StudentRegistration;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Course cour = new Course();

        cour.setCourseID("001");
        cour.setCourseName("Integrative Programming");
        cour.setProgram("Information Technology");

        cour.display();

        Scanner scanner = new Scanner(System.in);
        CampusRegistrar campusRegistrar = new CampusRegistrar(new StudentRegistration(), new CourseRegistration());

        int choice = 0;

        do {
            System.out.println("\n[1] Save Student");
            System.out.println("[2] Display Student");
            System.out.println("[3] Update Student");
            System.out.println("[4] Remove Student");
            System.out.print("Enter Choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Student ID: ");
                    int studentID = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Student Name: ");
                    String studentName = scanner.nextLine();

                    System.out.print("Enter Program: ");
                    String program = scanner.nextLine();

                    Student student = new Student();

                    student.getPersonID();
                    student.setPersonName(studentName);
                    student.setProgram(program);
                    campusRegistrar.saveStudent(student);
                    break;

                case 2:
                    campusRegistrar.displayAllStudent();
                    break;




            }

        } while (choice != 4);

        scanner.close();
    }
}