package org.example.service;

import org.example.model.Section;
import org.example.model.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SectionRegistrationTest {

    private SectionRegistration service;
    private Section testSection;

    @BeforeEach
    void setUp() {
        service = new SectionRegistration();
        testSection = new Section("IT1A", 30, null, null);
    }

    @Test
    void testAddStudentToSection() {
        service.saveSection(testSection);
        Student student = new Student("S001", "David Mac", "IT");

        service.addStudentToSection("IT1A", student);

        assertEquals(1, testSection.getStudentList().size());
    }


    @Test
    void testUpdateSection() {
        service.saveSection(testSection);
        Section newSection = new Section("IT2B", 30, null, null);

        service.updateSection("IT1A", newSection);

        assertNull(service.findBySectionName("IT1A"));
        assertNotNull(service.findBySectionName("IT2B"));
    }

    @Test
    void testDeleteSection() {
        service.saveSection(testSection);
        service.deleteSection("IT1A");

        assertNull(service.findBySectionName("IT1A"));
    }

    @Test
    void testDisplayAll() {
        service.saveSection(testSection);
        List<Section> list = service.displayAll();
        assertEquals(1, list.size());
    }
}