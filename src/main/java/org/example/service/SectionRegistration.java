package org.example.service;
import org.example.model.*;

import java.util.*;

public class SectionRegistration implements SectionReg {
    private List<Section> sections;

    public SectionRegistration(){
        this.sections = new ArrayList<>();
    }

    @Override
    public void saveSection(Section section){
        sections.add(section);
        System.out.println(section.getSectionName() + " saved successfully");
    }

    @Override
    public List<Section> displayAll(){
        return sections;
    }

    @Override
    public Section findBySectionName(String sectionName){
        for (Section s : sections){
            if(s.getSectionName().equalsIgnoreCase(sectionName)){
                return s;
            }
        }
        return null;
    }

    @Override
    public void addStudentToSection(String sectionName, Student student) {
        Section foundSection = findBySectionName(sectionName);

        if (foundSection != null) {
            if (foundSection.getStudentList().size() < foundSection.getMaxCapacity()) {
                foundSection.getStudentList().add(student);
                System.out.println(student.getPersonName() + " successfully enrolled in " + sectionName);
            } else {
                System.out.println("Enrollment failed " + sectionName + " is already full (Max Capacity: " +
                        foundSection.getMaxCapacity() + ")");
            }
        } else {
            System.out.println("No record found for this section");
        }
    }

    @Override
    public void updateSection(String oldSectionName, Section updateSection){
        for (int i = 0; i < sections.size(); i++) {
            if (sections.get(i).getSectionName().equalsIgnoreCase(oldSectionName)) {
                sections.set(i, updateSection);
                System.out.println(oldSectionName + " section successfully updated to " + updateSection.getSectionName());
                return;
            }
        }
    }

    @Override
    public void deleteSection(String sectionName){
        for (int i = 0; i <sections.size(); i++ ){
            if (sections.get(i).getSectionName().equalsIgnoreCase(sectionName)) {
                sections.remove(i);
                System.out.println("Section " + sectionName + " has been deleted.");
                return;
            }
        }
        System.out.println("Cannot delete. Section does not exist");
    }
}
