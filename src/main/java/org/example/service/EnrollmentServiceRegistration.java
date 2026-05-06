package org.example.service;

import org.example.model.*;
import java.util.*;

public class EnrollmentServiceRegistration implements EnrollmentRegService{

    @Override
    public void registerStudentInSection(Section section, Student student) {
        System.out.println("\n========== ENROLLMENT PROCESSING ==========");

        // 1. Check Financial Status (Using your logic)
        if (student.getTuitionDeets().getBalance() > 0) {
            System.out.println("Status: DENIED");
            System.out.println("└── Reason: Outstanding Balance of $" +
                    String.format("%.2f", student.getTuitionDeets().getBalance()));
        }
        // 2. Check Section Capacity
        else if (section.getStudentList().size() >= section.getMaxCapacity()) {
            System.out.println("Status: DENIED");
            System.out.println("└── Reason: Section [" + section.getSectionName() + "] is at Max Capacity (" + section.getMaxCapacity() + ")");
        }
        // 3. Successful Enrollment
        else {
            section.getStudentList().add(student);
            System.out.println("Status: SUCCESS");
            System.out.println("└── Student: " + student.getPersonName());
            System.out.println("└── Section: " + section.getSectionName());
            System.out.println("    Current Fill: " + section.getStudentList().size() + "/" + section.getMaxCapacity());
        }

        System.out.println("===========================================");
    }

    @Override
    public void displayDepartmentHierarchy(List<Department> departments) {
        System.out.println("\n========== INSTITUTIONAL HIERARCHY ==========");

        for (Department dept : departments) {
            System.out.println("\nDepartment: " + dept.getDepartmentName());

            if (dept.getSectionList().isEmpty()) {
                System.out.println("   └── (No sections assigned)");
                continue;
            }

            for (Section sec : dept.getSectionList()) {
                String insName = (sec.getInstructorAssigned() != null) ?
                        sec.getInstructorAssigned().getPersonName() : "TBA";

                System.out.println("   └── Section: " + sec.getSectionName() + " | Instructor: " + insName);

                if (sec.getCourse() != null) {
                    System.out.println("       Course: " + sec.getCourse().getCourseName() +
                            " (" + sec.getCourse().getCourseID() + ")");
                }

                if (sec.getStudentList().isEmpty()) {
                    System.out.println("       └── (No students enrolled)");
                } else {
                    for (Student s : sec.getStudentList()) {
                        // Check if student has paid while listing them
                        String payStatus = (s.getTuitionDeets().getBalance() <= 0) ? "[PAID]" : "[PENDING]";
                        System.out.println("       └── Student: " + payStatus + " " + s.getPersonName());
                    }
                }
            }
        }
        System.out.println("\n=============================================");
    }




}
