package org.example.service;

import org.example.model.*;
import java.util.*;

public interface EnrollmentRegService {
    void registerStudentInSection (Section section, Student student);
    void displayDepartmentHierarchy(List<Department> departments);
}
