package org.example.service;

import org.example.model.Instructor;
import org.example.model.Section;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InstructorRegistrationTest {

    private InstructorRegistration service;
    private Instructor instructor;

    @BeforeEach
    void setUp() {
        service = new InstructorRegistration();
        instructor = new Instructor("Victoria Plaza", "INS-001", "InteProg");
    }


    @Test
    void testDisplayAll() {
        service.save(instructor);
        service.save(new Instructor("Kyla Fritz", "INS-002", "Infoman"));

        List<Instructor> list = service.displayAll();

        assertEquals(2, list.size());
    }


    @Test
    void testDeleteInstructor() {
        service.save(instructor);
        service.deleteInstructor("INS-001");

        Instructor result = service.findByInstructorID("INS-001");
        assertNull(result);
    }
}