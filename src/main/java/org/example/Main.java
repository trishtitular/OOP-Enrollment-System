package org.example;

import org.example.model.*;
import org.example.service.*;
import org.example.MenuHandler.*;


import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        StudentReg studentService = new StudentRegistration();
        SectionReg sectionService = new SectionRegistration();
        DepartmentReg departmentService = new DepartmentRegistration();
        CourseReg courseService = new CourseRegistration();
        InstructorReg instructorService = new InstructorRegistration();
        TuitionFeeReg tuitionService = new TuitionFeeRegistration();
        EnrollmentServiceReg enrollmentService = new EnrollmentServiceRegistration();
        GraduationReg graduationService = new GraduationService();

        CampusRegistrar registrar = new CampusRegistrar(
                studentService,
                sectionService,
                departmentService,
                courseService,
                instructorService,
                tuitionService,
                enrollmentService,
                graduationService
        );
        Scanner scan = new Scanner (System.in);
        MenuHandler ui = new MenuHandler(scan, registrar, sectionService, courseService, instructorService);

        boolean isRunning = true;

        System.out.println("=============================================");
        System.out.println("   CAMPUS REGISTRAR MANAGEMENT SYSTEM       ");
        System.out.println("=============================================");

        while (isRunning){
            System.out.println("\n--- MAIN MENU---");
            System.out.println("1. Register New Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Course Management (Add/View/Update/Display/Remove)");
            System.out.println("4. Section Management (Add Section/View/Update/Display/Remove)");
            System.out.println("5. Instructor Management(Register/Assign/View)");
            System.out.println("6. Department Management");
            System.out.println("7. Enroll Student in Section");
            System.out.println("8. Tuition & Financial Management");
            System.out.println("9. Conduct Graduation Audit");
            System.out.println("10. Exit");
            System.out.print(" Select an option: ");

            if (!scan.hasNextInt()) {
                System.out.println("Invalid input. Please enter a main menu option number");
                scan.nextLine();
                continue;
            }

            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice){

                case 1:
                    System.out.print("Enter Student ID: "); String studId = scan.nextLine();
                    System.out.print("Enter Full Name: "); String studName = scan.nextLine();
                    System.out.print("Enter Program: "); String prog = scan.nextLine();
                    registrar.saveStudent(new Student(studId, studName, prog));
                    break;

                case 2:
                    registrar.displayAllStudents();
                    break;

                case 3:
                    ui.handleCourseMenu();
                    break;

                case 4:
                    ui.handleSectionMenu();
                    break;

                case 5:
                    ui.handleInstructorMenu();
                    break;

                case 6:
                    ui.handleDeptMenu();
                    break;

                case 7:
                    System.out.print("Enter Student ID: ");
                    String enrollStudID = scan.nextLine();
                    System.out.print("Enter Section Name: ");
                    String targetSection = scan.nextLine();
                    registrar.enrollStudent(new Section(targetSection, 0,null, null), enrollStudID);
                    break;

                case 8:
                    ui.handleTuitionFeeMenu();
                    break;

                case 9:
                    System.out.print("Enter Student ID: ");
                    String gradID = scan.nextLine();
                    System.out.print("Enter Required Units Goal:  ");
                    int goal = scan.nextInt();
                    registrar.conductGraduationAudit(gradID, goal);
                    break;

                case 10:
                    isRunning = false;
                    System.out.println("THANK YOU FOR USING MY CAMPUS REGISTRAR! GOODBYE!");
                    break;
                default:
                    System.out.println("Invalid Selection. Try again");
            }
        }
        scan.close();

    }

}