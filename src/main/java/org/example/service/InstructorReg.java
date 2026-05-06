package org.example.service;

import org.example.model.Instructor;
import org.example.model.Section;
import java.util.*;

public interface InstructorReg {
    void save(Instructor instructor);
    Instructor findByInstructorID(String id);
    List<Instructor> displayAll();
    void updateInstructor(String id, Instructor updated);
    void deleteInstructor(String id);
    void assignInstructorToSection(Instructor instructor, Section section); // Add this
}