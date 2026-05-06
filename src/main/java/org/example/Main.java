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
        TuitionFeeReg tuitionService = new TuitionFeeRegistration();
        EnrollmentServiceReg enrollmentService = new EnrollmentServiceRegistration();
        GraduationReg graduationService = new GraduationService();

        CampusRegistrar registrar = new CampusRegistrar(
                studentService,
                sectionService,
                departmentService,
                courseService,
                tuitionService,
                enrollmentService,
                graduationService
        );
        MenuHandler ui = new MenuHandler(registrar, sectionService);


        Scanner scan = new Scanner (System.in);
        boolean isRunning = true;

        System.out.println("=============================================");
        System.out.println("   CAMPUS REGISTRAR MANAGEMENT SYSTEM       ");
        System.out.println("=============================================");

        while (isRunning){
            System.out.println("/n--- MAIN MENU---");
            System.out.println("1. Register New Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Course Management (Add/View/Update/Remove");
            System.out.println("4. Section Management (Add Section");
            System.out.println("5. Enroll Student in Section");
            System.out.println("6. Asses Tuition");
            System.out.println("7. Process Tuition Payment");
            System.out.println("8. Check Student Account and Balance");
            System.out.println("9. Conduct Graduation Audit");
            System.out.println("10. Institutional Hierarchy (Department Management)");
            System.out.println("0. Exit");
            System.out.print(" Select an option: ");

            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice){
                // fix case 1 -> student name: student id record saved
                case 1:
                    System.out.print("Enter Full Name: "); String studName = scan.nextLine();
                    System.out.print("Enter Student ID: "); String studId = scan.nextLine();
                    System.out.print("Enter Program: "); String prog = scan.nextLine();
                    registrar.saveStudent(new Student(studName, studId, prog));
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
                    System.out.print("Enter Student ID: ");
                    String enrollStudID = scan.nextLine();
                    System.out.print("Enter Section Name: ");
                    String targetSection = scan.nextLine();
                    registrar.enrollStudent(new Section(targetSection, 0,null, null), enrollStudID);
                    break;
                case 6:
                    System.out.print("Enter Student ID: "); String billId = scan.nextLine();
                    System.out.print("Enter Units to add: "); int units = scan.nextInt();
                    Student bStudent = studentService.findByStudentID(billId);
                    if (bStudent != null) registrar.calculateTuitionFee(bStudent, units);
                    else System.out.println("Error: Student record not found.");
                    break;

                case 7:
                    System.out.print("Enter Student ID: ");
                    String payID = scan.nextLine();
                    System.out.print("Enter Amount:  ");
                    double amount = scan.nextDouble();
                    System.out.print(" Pesos");
                    registrar.processPayment(payID, amount);
                    break;

                case 8:
                    System.out.print("Enter Student ID: ");
                    String checkID = scan.nextLine();
                    registrar.checkStudentBalance(checkID);
                    break;

                case 9:
                    System.out.print("Enter Student ID: ");
                    String gradID = scan.nextLine();
                    System.out.print("Enter Required Units Goal:  ");
                    int goal = scan.nextInt();
                    registrar.conductGraduationAudit(gradID, goal);
                    break;

                case 10:
                    ui.handleDeptMenu();
                    break;

                case 0:
                    isRunning = false;
                    System.out.println("System Shutting Down. GoodBye!");
                    break;
                default:
                    System.out.println("Invalid Selection. Try again");
            }
        }
        scan.close();

    }

}