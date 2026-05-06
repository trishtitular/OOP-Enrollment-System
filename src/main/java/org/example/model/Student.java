package org.example.model;


public class Student extends Person {
    private String program;
    private TuitionFeePayment tuitionDeets;
    private int unitsCompleted;

    public Student(String PersonName, String PersonID, String program){
        super(PersonName, PersonID);
        this.program = program;
        this.tuitionDeets = new TuitionFeePayment(0);
    }
    public String getProgram(){
        return program;
    }
    public void setProgram(String program) {
        this.program = program;
    }

    public String getPersonName() {
        return super.getPersonName();
    }

    public void setPersonName(String personName){
        super.setPersonName(personName);
    }
    public TuitionFeePayment getTuitionDeets(){
        return tuitionDeets;
    }

    public void displayStudent(){
        System.out.println("Student ID: " + getPersonID());
        System.out.println("Student Name: " + getPersonName());
        System.out.println("Program: " + getProgram() + "\n");
    }
    public int getUnitsCompleted() {
        return unitsCompleted;
    }

    public void setUnitsCompleted(int unitsCompleted) {
        this.unitsCompleted = unitsCompleted;
    }

    // Helper method to add units incrementally
    public void addUnits(int units) {
        this.unitsCompleted += units;
    }

    @Override
    public void mainTask(){
        System.out.println("Student New Knowledge");
    }

}
