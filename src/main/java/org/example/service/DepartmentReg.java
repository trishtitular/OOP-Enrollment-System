package org.example.service;

import org.example.model.*;
import java.util.*;

public interface DepartmentReg {
    void saveDepartment(Department department);
    List<Department> displayAll();

    void updateDepartment(String id, Department updatedDept);

    void deleteDepartment(String id);

    Department findByDepartmentID(String id);

}
