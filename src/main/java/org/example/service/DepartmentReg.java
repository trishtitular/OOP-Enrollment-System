package org.example.service;

import org.example.model.*;
import java.util.*;

public interface DepartmentReg {
    void saveDepartment(Department department);
    List<Department> displayAll();

}
