package org.example.service;

import org.example.model.*;

public interface GraduationReg {
    boolean isStudentEligibleToGraduate(Student student, int requiredUnits);
    void generateGradReport(Student student);


}
