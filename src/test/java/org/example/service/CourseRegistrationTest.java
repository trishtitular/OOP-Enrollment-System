package org.example.service;

import org.example.model.Course;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseRegistrationTest {
    private CourseRegistration courseService;
    private Course itCourse;

    @BeforeEach
    void setUp() {

        courseService = new CourseRegistration();
        // Course(ID, Name,Course Program Units)
        itCourse = new Course("IT101", "Java Programming", "BSIT", 3);
    }

    @Test
    void testSaveAndFindCourse() {
        courseService.saveCourse(itCourse);
        Course found = courseService.findByCourseID("IT101");

        assertNotNull(found, "The course should be found in the list");
        assertEquals("Java Programming", found.getCourseName());
    }

    @Test
    void testRemoveCourse() {
        courseService.saveCourse(itCourse);
        courseService.removeCourse("IT101");

        Course found = courseService.findByCourseID("IT101");
        assertNull(found, "The course should no longer exist after removal");
    }

    @Test
    void testUpdateCourse() {

        courseService.saveCourse(itCourse);

        Course updatedIT = new Course("IT101", "Advanced Java", "BSIT" +
                "BSIT", 4);
        courseService.updateCourse(updatedIT);

        Course result = courseService.findByCourseID("IT101");
        assertEquals("Advanced Java", result.getCourseName());
        assertEquals(4, result.getUnits());
    }

    @Test
    void testFindNonExistentCourse() {
        Course found = courseService.findByCourseID("MATH101");

        assertNull(found, "Should return null for IDs that do not exist");
    }
}