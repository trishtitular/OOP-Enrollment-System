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
        System.out.println(department.getDepartmentName() + " added successfully");
    }

    @Override
    public List<Department> displayAll(){
        return this.departments;
    }

    @Override
    public void updateDepartment(String id, Department updatedDept) {
        for (int i = 0; i < departments.size(); i++) {
            if (departments.get(i).getDepartmentID().equalsIgnoreCase(id)) {
                departments.set(i, updatedDept);
                System.out.println("Department ID: " + id + " updated successfully.");
                return;
            }
        }
        System.out.println("Update failed: Department ID not found.");
    }

    @Override
    public void deleteDepartment(String id) {
        boolean removed = departments.removeIf(d -> d.getDepartmentID().equalsIgnoreCase(id));
        if (removed) {
            System.out.println("Department ID: " + id + " deleted from records.");
        } else {
            System.out.println("Delete failed: Department ID not found.");
        }
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

