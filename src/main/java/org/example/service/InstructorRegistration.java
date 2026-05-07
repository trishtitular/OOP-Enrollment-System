package org.example.service;

import org.example.model.Instructor;
import org.example.model.Section;

import java.util.*;

public class InstructorRegistration implements InstructorReg {
    private List<Instructor> instructors = new ArrayList<>();

    @Override
    public void save(Instructor instructor){
        instructors.add(instructor);
        System.out.println("Instructor ID: " + instructor.getPersonName()+ " record saved");
    }

    @Override
    public Instructor findByInstructorID(String id){
        for (Instructor i : instructors){
            if (i.getPersonID().equalsIgnoreCase(id)){
                return i;
            }
        }
        return null;
    }

    @Override
    public List<Instructor> displayAll(){
        if(instructors.isEmpty()){
            System.out.println("No instructor records found");
        }
        for (Instructor i : instructors){
            System.out.println("Instructor Name: " + i.getPersonName() + "| Instructor ID: " +i.getPersonID() );
        }
        return instructors;
    }

    @Override
    public void updateInstructor(String id, Instructor updated){
        for (int i = 0; i < instructors.size(); i++){
            if (instructors.get(i).getPersonID().equalsIgnoreCase(id)) {
                instructors.set(i, updated);
                System.out.println("Instructor Name: " + instructors.get(i).getPersonName() + " updated");
                return;
            }
        }
    }
    @Override
    public void deleteInstructor(String id){
        for (int i =0; i < instructors.size(); i++){
            if (instructors.get(i).getPersonID().equalsIgnoreCase(id)){
                instructors.remove(i);
                System.out.println("Instructor Name: " + instructors.get(i).getPersonName() + " deleted");
                return;
            }
        }
        System.out.println("Cannot find ID");
    }

    @Override
    public void assignInstructorToSection(Instructor instructor, Section section){
        section.setInstructorAssigned(instructor);
        System.out.println(instructor.getPersonName() + "is assigned successfully to " + section.getSectionName());
    }



}
