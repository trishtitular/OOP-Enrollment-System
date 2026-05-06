package org.example.service;

import org.example.model.*;

public class GraduationService implements GraduationReg {

    @Override
    public boolean isStudentEligibleToGraduate(Student student, int requiredUnits){
        boolean isDeptFree = student.getTuitionDeets().getBalance() <=0;
        boolean metRequiredUnits = true;

        return isDeptFree && metRequiredUnits;
    }

    @Override
    public void generateGradReport(Student student){
        double balance = student.getTuitionDeets().getBalance();

        System.out.println("\n========== GRADUATION AUDIT ==========");
        System.out.println("Candidate Name: " + student.getPersonName());
        System.out.println("Program: " + student.getProgram());
        System.out.println("Financial Status: " + (balance <= 0 ? "CLEARED" : "HOLD (Balance: " + balance +")"));

        if (balance <= 0){
            System.out.println("FINAL STATUS: ELIBLE FOR GRADUATION");
        }else{
            System.out.println("FINAL STATUS: INELIGIBLE - Please settle balance ");
        }
        System.out.println("=======================================");
    }

}
