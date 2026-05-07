package org.example.service;

import org.example.model.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentRegistrationTest {

    private DepartmentRegistration service;
    private Department testDept;

    @BeforeEach
    void setUp() {
        service = new DepartmentRegistration();
        testDept = new Department("IT-01", "Information Technology",null, null, null);
    }

    @Test
    void testSaveAndFindDepartment() {
        service.saveDepartment(testDept);

        Department result = service.findByDepartmentID("IT-01");

        assertNotNull(result);
        assertEquals("Information Technology", result.getDepartmentName());
    }

    @Test
    void testListInitializationOnSave() {
        // Even if we send a department with null lists, your code fixes it
        Department nullListDept = new Department("ENG-01", "Engineering",null,null,null);
        nullListDept.setInstructorList(null);

        service.saveDepartment(nullListDept);

        Department result = service.findByDepartmentID("ENG-01");
        assertNotNull(result.getInstructorList()); // Should be empty ArrayList, not null
    }

    @Test
    void testUpdateDepartment() {
        service.saveDepartment(testDept);

        Department newData = new Department("IT-01", "Computer Science",null,null,null);
        service.updateDepartment("IT-01", newData);

        Department result = service.findByDepartmentID("IT-01");
        assertEquals("Computer Science", result.getDepartmentName());
    }

    @Test
    void testDeleteDepartment() {
        service.saveDepartment(testDept);
        service.deleteDepartment("IT-01");

        Department result = service.findByDepartmentID("IT-01");
        assertNull(result);
    }

    @Test
    void testDisplayAll() {
        service.saveDepartment(testDept);
        service.saveDepartment(new Department("HR-01", "Human Resources",null,null,null));

        List<Department> allDepts = service.displayAll();
        assertEquals(2, allDepts.size());
    }
}