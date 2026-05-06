package org.example.service;


import org.example.model.*;
import org.example.service.*;

import java.util.*;


public class CampusRegistrar {
    private StudentReg studentRegis;
    private SectionReg sectionRegis;
    private DepartmentReg departmentRegis;
    private CourseReg courseRegis;
    private TuitionFeeReg tuitionFeeRegis;
    private EnrollmentServiceReg enrollmentServiceRegis;
    private GraduationReg graduationRegis;
    private List<Department> departmentList = new ArrayList<>();

    public CampusRegistrar(StudentReg studentRegistration, SectionReg sectionRegistration,
                           DepartmentReg departmentRegistration, CourseReg courseRegistration,
                           TuitionFeeReg tuitionFeeRegistration, EnrollmentServiceReg enrollmentServiceRegistration,GraduationReg graduationRegis) {
        this.studentRegis = studentRegistration;
        this.sectionRegis = sectionRegistration;
        this.departmentRegis = departmentRegistration;
        this.courseRegis = courseRegistration;
        this.tuitionFeeRegis = tuitionFeeRegistration;
        this.enrollmentServiceRegis = enrollmentServiceRegistration;
        this.graduationRegis = graduationRegis;
    }

    // --- STUDENT SERVICES ---

    public void saveStudent(Student student) {
        studentRegis.saveStudent(student);
        System.out.println("Student Name: " + student.getPersonName() + " record saved");
    }

    public void displayAllStudents() {
        System.out.println("\n========== REGISTERED STUDENTS ==========");
        studentRegis.displayAllStudent();
        System.out.println("==========================================");
    }

    public boolean updateStudent(Student student) {
        boolean success = studentRegis.updateStudent(student);
        if (success) {
            System.out.println("Student Name: " + student.getPersonName() + "| " + "Student ID: " + student.getPersonID() + " profile updated");
        } else {
            System.out.println("Error: Student Name:  " + student.getPersonName() + "| " + "Student ID: " + student.getPersonID() + " not found");
        }
        return success;
    }

    public void removeStudent(String id) {
        Student found = ((StudentRegistration) studentRegis).findByStudentID(id);
        if (found != null) {
            studentRegis.removeStudent(found);
            System.out.println("Student (" + id + ") has been successfully removed from records.");
        } else {
            System.out.println("Deletion failed: no record found for Student ID: " + id);
        }
    }

    public void calculateTuitionFee(Student s, int courseUnits) {
        double fee = tuitionFeeRegis.calculateTuitionFee(courseUnits, 0);
        double currentBalance = s.getTuitionDeets().getBalance();

        s.getTuitionDeets().setTotalTuitionFee(currentBalance + fee);
        s.getTuitionDeets().setBalance(currentBalance + fee);

        System.out.println("\n========== TUITION ASSESSMENT ==========");
        System.out.println("Student ID: " + s.getPersonID());
        System.out.println("Student Name: " + s.getPersonName());
        System.out.println("└── Units Added: " + courseUnits);
        System.out.println("└── New Charges: PHP " + String.format("%.2f", fee));
        System.out.println("└── Total Balance: PHP " + String.format("%.2f", s.getTuitionDeets().getBalance()));
        System.out.println("=========================================");
    }

    public void processPayment(String studentID, double amount) {
        Student s = ((StudentRegistration) studentRegis).findByStudentID(studentID);
        if (s != null) {
            tuitionFeeRegis.processPayment(s, amount);
            System.out.println("Payment in Peso " + String.format("%.2f", amount) + " successfully processed " + s.getPersonName());
        } else {
            System.out.println("Error: Student ID: " + studentID + " payment record not found");
        }
    }

    public void checkStudentBalance(String studentID) {
        Student student = ((StudentRegistration) studentRegis).findByStudentID(studentID);
        if (student != null) {
            double bal = student.getTuitionDeets().getBalance();
            String status = (bal <= 0) ? "CLEARED" : "OUTSTANDING";

            System.out.println("\n========== STUDENT ACCOUNT ==========");
            System.out.println("Name: " + student.getPersonName() + " (" + student.getPersonID() + ")");
            System.out.println("└── Balance: PHP " + String.format("%.2f", bal));
            System.out.println("└── Status : " + status);
            System.out.println("=====================================");
        }
    }


    public void saveCourse(Course course) {
        courseRegis.saveCourse(course);
    }

    public void displayAllCourses(double pricePerUnit) {

        double price = TuitionFeeRegistration.PRICE_PER_UNIT;
        System.out.println("\n========== COURSE CATALOG ==========");
        courseRegis.displayAll(price);
        System.out.println("====================================");
    }
    public void updateCourse(Course course){
        courseRegis.updateCourse(course);
    }

    public void removeCourse(String courseID){
        courseRegis.removeCourse(courseID);
    }

    public void saveSection(Section section) {
        sectionRegis.saveSection(section);
    }

    public void enrollStudent(Section sectionName, String studentID) {
        Section section = sectionRegis.findBySectionName(sectionName.getSectionName());
        Student student = ((StudentRegistration) studentRegis).findByStudentID(studentID);

        if (section != null && student != null){
            enrollmentServiceRegis.registerStudentInSection(section, student);
        } else{
            System.out.println("Enrollment Failed: Verify Student ID and Section Name");
        }
    }
    public void conductGraduationAudit(String studentID, int requiredUnits){
        Student s = ((StudentRegistration) studentRegis).findByStudentID(studentID);
        if (s != null){
            graduationRegis.generateGradReport(s);
        } else{
            System.out.println("Audit Error: Student not found");
        }
    }

    // --- INSTITUTIONAL HIERARCHY ---

    public void displayHierarchy() {
        List<Department> departments = departmentRegis.displayAll();
        if (departments.isEmpty()) {
            System.out.println("Notice: No Departments found in registry.");
            return;
        }
        enrollmentServiceRegis.displayDepartmentHierarchy(departments);
    }

    public void saveDept(Department department) {
        Department existing = departmentRegis.findByDepartmentID(department.getDepartmentID());
        if (existing != null) {
            System.out.println("Error: Department ID'" + department.getDepartmentID() + "' already exists.");
            return;
        }
        departmentRegis.saveDepartment(department);
        System.out.println("System: Department " + department.getDepartmentName() + "successfully registered.");
    }
}
