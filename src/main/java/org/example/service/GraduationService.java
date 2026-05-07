package org.example.service;

import org.example.model.*;

public class GraduationService implements GraduationReg {

    @Override
    public boolean isStudentEligibleToGraduate(Student student, int requiredUnits){
        boolean isDeptFree = student.getTuitionDeets().getBalance() <=0;
        boolean metRequiredUnits = student.getUnitsCompleted() >= requiredUnits;

        return isDeptFree && metRequiredUnits;
    }

    @Override
    public void generateGradReport(Student student){
        double balance = student.getTuitionDeets().getBalance();

        System.out.println("\n========== GRADUATION AUDIT ==========");
        System.out.println("Candidate Name: " + student.getPersonName());
        System.out.println("Program: " + student.getProgram());
        System.out.println("Units Earned: " + student.getUnitsCompleted());
        System.out.println("Financial Status: " + (balance <= 0 ? "CLEARED" : "HOLD (Balance: " + balance +")"));

        if (student.getTuitionDeets().getBalance() <= 0 && student.getUnitsCompleted() > 0){
            System.out.println("FINAL STATUS: ELIGIBLE FOR GRADUATION");
        }else{
            System.out.println("FINAL STATUS: INELIGIBLE - Check units or balance");
        }
        System.out.println("=======================================");
    }

}
