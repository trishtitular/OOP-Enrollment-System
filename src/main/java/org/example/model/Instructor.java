package org.example.model;

public class Instructor extends Person {
    private String courses;

    public Instructor (String PersonName, String PersonID, String courses){
        super (PersonName, PersonID);
        this.courses = courses;
    }

    public String getCourses(){
        return courses;
    }

    public void setCourses(String courses){
        this.courses = courses;

    }
    public void displayInstructor(){
        System.out.println("--- Instructor Profile ---");
        System.out.println("ID: " + getPersonID());
        System.out.println("Name: " + getPersonName());
        System.out.println("Assigned Courses: " + (courses == null || courses.isEmpty() ? "None" : courses));
        System.out.println("--------------------------");
    }

    public void updateInstructorDetails(String newName, String newCourses) {
        if (newName != null && !newName.isEmpty()) {
            this.setPersonName(newName);
        }
        if (newCourses != null && !newCourses.isEmpty()) {
            this.courses = newCourses;
        }
        System.out.println("Instructor " + getPersonID() + " updated successfully.");
    }

    @Override
    public void mainTask(){
        System.out.println(getPersonName() + "is an instructor who is assigned to: " + courses);
    }


    @Override
    public String toString() {
        return "Instructor [ID=" + getPersonID() + ", Name=" + getPersonName() + ", Courses=" + courses + "]";
    }

}
