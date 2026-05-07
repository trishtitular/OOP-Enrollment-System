package org.example.service;

import org.example.model.Student;
import org.example.model.TuitionFeePayment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentRegistrationTest {

    private StudentRegistration service;
    private Student testStudent;

    @BeforeEach
    void setUp() {
        service = new StudentRegistration();
        TuitionFeePayment payment = new TuitionFeePayment(0.0);
        testStudent = new Student("Trish Titular", "S127", "BSIT");
    }

    @Test
    void testSaveStudent() {
        service.saveStudent(testStudent);

    }

    @Test
    void testRemoveStudent() {
        service.saveStudent(testStudent);

        boolean result = service.removeStudent(testStudent);

        assertTrue(result);
        assertNull(service.findByStudentID("S127"));
    }

}