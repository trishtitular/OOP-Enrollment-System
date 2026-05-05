package org.example.service;

import org.example.model.Department;
import org.example.model.Instructor;

import java.util.ArrayList;
import java.util.List;


public class DepartmentRegistrationService implements DepartmentRegistration {
    private List<Department> departments;
    private List<Instructor> instructorList;

}
    public DepartmentRegistrationService(){
        this.departments = new ArrayList<>();

    }

