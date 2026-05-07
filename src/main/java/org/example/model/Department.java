package org.example.model;

import java.util.List;

public class Department {
    private String departmentID;
    private String departmentName;
    private List<Instructor> instructorList;
    private List<Section> sectionList;
    private List<Course> courseList;

    public Department (String departmentID,String departmentName,List<Instructor> instructorList, List<Section> sectionList,List<Course> courseList){
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.instructorList = instructorList;
        this.sectionList = sectionList;
        this.courseList = courseList;
    }

    public String getDepartmentID(){
        return departmentID;
    }

    public void setDepartmentID(String departmentID){
        this.departmentID = departmentID;
    }

    public String getDepartmentName(){
        return  departmentName;
    }

    public void setDepartmentName(String DepartmentName){
        this.departmentName = departmentName;
    }

    public List<Instructor> getInstructorList(){
        return instructorList;
    }

    public void setInstructorList(List<Instructor> instructorList){
        this.instructorList = instructorList;
    }

    public List<Section> getSectionList(){
        return sectionList;
    }

    public void setSectionList(List<Section> sectionList){
        this.sectionList = sectionList;
    }

    public List<Course> getCourseList(){
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
    public void addInstructor (Instructor instructor){
        this.instructorList.add(instructor);
    }
    public void addSection(Section section){
        this.sectionList.add(section);
    }
    public void addCourse (Course course){
        this.courseList.add(course);
    }

    public void displayDepartment() {
        System.out.println("\n========================================");
        System.out.println("DEPARTMENT REPORT: " + getDepartmentName() + " (ID: " + getDepartmentID() + ")");
        System.out.println("========================================");

        System.out.println("Faculty Members:");
        if (instructorList == null || instructorList.isEmpty()) {
            System.out.println("No instructors assigned.");
        } else {
            for (Instructor ins : instructorList) {
                System.out.println("Prof. " + ins.getPersonName());
            }
        }

        System.out.println("\nManaged Sections:");
        if (sectionList == null || sectionList.isEmpty()) {
            System.out.println("   - No sections registered.");
        } else {
            for (Section sec : sectionList) {
                System.out.println(" - " + sec.getSectionName() + " (" + sec.getStudentList().size() + " Students)");
            }
        }
        System.out.println("========================================\n");
    }
    @Override
    public String toString(){
        return departmentName + " (ID: " + departmentID + " )";
    }
}
