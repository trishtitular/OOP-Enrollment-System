package org.example.service;

import org.example.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EnrollmentServiceRegistrationTest {

    private EnrollmentServiceRegistration enrollmentService;
    private Section testSection;
    private Student testStudent;

    @BeforeEach
    void setUp() {
        enrollmentService = new EnrollmentServiceRegistration();

        TuitionFeePayment payment = new TuitionFeePayment(0.0);
        testStudent = new Student("S101", "Anna Marie", "IT");

        testSection = new Section("IT2D", 25, null, null);
    }

    @Test
    void testSuccessfulEnrollment() {
        enrollmentService.registerStudentInSection(testSection, testStudent);

        assertEquals(1, testSection.getStudentList().size());
        assertEquals("Anna Marie", testSection.getStudentList().get(0).getPersonName());
    }

    @Test
    void testDeniedDueToBalance() {
        testStudent.getTuitionDeets().setBalance(500.00);

        enrollmentService.registerStudentInSection(testSection, testStudent);

        assertTrue(testSection.getStudentList().isEmpty());
    }


    @Test
    void testDisplayHierarchyNoErrors() {
        assertDoesNotThrow(() -> {
            enrollmentService.displayDepartmentHierarchy(new ArrayList<>());
        });
    }
}