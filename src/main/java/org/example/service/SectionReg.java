package org.example.service;
import org.example.model.*;

import java.util.*;

public interface SectionReg {
    void saveSection(Section section);
    void addStudentToSection(String sectionName, Student student);
    List<Section> displayAll();
    Section findBySectionName(String sectionName);
    void updateSection(String oldSectionName, Section updateSection);
    void deleteSection(String sectionName);
}
