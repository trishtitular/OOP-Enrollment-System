package org.example.model;

public class Student extends Person {
    private String program;

    public Student(){

    }
    public Student(String program){
        this.program = program;
    }
    public String getProgram(){
        return program;
    }
    public void setProgram(String Program){
        this.program = program;
    }
}
