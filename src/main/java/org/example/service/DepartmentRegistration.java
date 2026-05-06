package org.example.service;

import org.example.model.*;

import java.util.ArrayList;
import java.util.List;


public class DepartmentRegistration implements DepartmentReg{
    private List<Department> departments;

    public DepartmentRegistration(){
        this.departments = new ArrayList<>();
    }

    @Override
    public void saveDepartment (Department department){
        if (department.getInstructorList() == null){
            department.setInstructorList(new ArrayList<>());
        }
        if (department.getSectionList() == null){
            department.setSectionList(new ArrayList<>());
        }

        departments.add(department);
        System.out.println(department.getDepartmentName() + "added successfully");
    }

    @Override
    public List<Department> displayAll(){
        return this.departments;
    }

    @Override
    public Department findByDepartmentID(String id){
        for (Department d: departments){
            if(d.getDepartmentID().equalsIgnoreCase(id)){
                return d;
            }
        }
        return null;
    }
}

