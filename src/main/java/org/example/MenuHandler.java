package org.example;

import org.example.model.*;
import org.example.service.*;
import java.util.*;

public class MenuHandler {
    private final Scanner scan;
    private final CampusRegistrar registrar;
    private final SectionRegistration sectionService;
    private CourseRegistration courseService = new CourseRegistration();
    private InstructorRegistration instructorService = new InstructorRegistration();

    public MenuHandler(Scanner scan, CampusRegistrar registrar,
                       SectionReg sectionService, CourseReg courseService,
                       InstructorReg instructor) {
        this.scan = new Scanner(System.in);
        this.registrar = registrar;
        this.sectionService = (SectionRegistration) sectionService;
        this.courseService = (CourseRegistration) courseService;
    }

    public void handleCourseMenu() {
        System.out.println("\n--- [Course Management] ---");
        System.out.println("a. Add Course | b. View Catalog | c. Update Course | d. Remove Course");
        System.out.print("Select an option: ");
        String option = scan.nextLine().toLowerCase();

        switch (option){
            case "a":
                System.out.print("Enter Course ID: "); String id = scan.nextLine();
                System.out.print("Enter Course Name: "); String name = scan.nextLine();
                System.out.print("Enter Course Program: "); String prog = scan.nextLine();
                System.out.print("Enter Course Units: ");
                int units = scan.nextInt();
                scan.nextLine();
                registrar.saveCourse(new Course(id, name, prog, units));
                break;

            case "b":
                registrar.displayAllCourses(1350.0);
                break;

            case "c":
                System.out.print("Enter Course ID to Update: "); String uId = scan.nextLine();
                System.out.print("Enter New Name: "); String uName = scan.nextLine();
                System.out.print("Enter New Program: "); String uProg = scan.nextLine();
                System.out.print("Enter New Units: ");
                int uUnits = scan.nextInt();
                scan.nextLine();
                registrar.updateCourse(new Course(uId, uName, uProg, uUnits));
                break;
            case "d":
                System.out.print("Enter Course ID to remove: ");
                registrar.removeCourse(scan.nextLine());
                break;
            default:
                System.out.println("Invalid selection.");
        }
    }

    public void handleSectionMenu() {
        System.out.println("\n--- [Section Management] ---");
        System.out.println("a. Add | b. View All | c. Update | d. Delete");
        System.out.print("Select an option: ");
        String opt = scan.nextLine().toLowerCase();

        switch (opt){
            case"a":
                System.out.print("Enter Section Name: "); String name = scan.nextLine();
                System.out.print("EnterMax Capacity: ");
                int cap = scan.nextInt();
                scan.nextLine();
                registrar.saveSection(new Section(name, cap, new ArrayList<>(), null));
                break;
            case "b":
                List<Section> list = sectionService.displayAll();
                if (list.isEmpty()) {
                    System.out.println("No sections registered.");
                } else {
                    for (Section s : list) {
                        System.out.println("- " + s.getSectionName() + " (Capacity: " + s.getMaxCapacity() + ")");
                    }
                }
                break;
            case "c":
                System.out.print("Enter Old Name: "); String old = scan.nextLine();
                System.out.print("Enter New Name: "); String nName = scan.nextLine();
                System.out.print("Enter New Capacity: ");
                int nCap = scan.nextInt();
                scan.nextLine();
                sectionService.updateSection(old, new Section(nName, nCap, new ArrayList<>(), null));
                break;
            case "d":
                System.out.print("Enter Name to delete: ");
                sectionService.deleteSection(scan.nextLine());
                break;
        }
    }
    public void handleInstructorMenu(){
        System.out.println("\n--- [Instructor Management] ---");
        System.out.println("a. Register Instructor");
        System.out.println("b. Display All Instructors");
        System.out.println("c. Update Instructor");
        System.out.println("d. Assign to Section");
        System.out.print("Select an option: ");

        String opt = scan.nextLine().toLowerCase();

        switch (opt) {
            case "a":
                System.out.print("Enter Instructor ID: "); String id = scan.nextLine();
                System.out.print("Enter Instructor Name: "); String name = scan.nextLine();
                System.out.print("Enter Expertise: "); String exp = scan.nextLine();
                instructorService.save(new Instructor(name, id, exp));
                break;

            case "b":
                List<Instructor> list = instructorService.displayAll();
                if (list.isEmpty()) {
                    System.out.println("No instructor records found.");
                } else {
                    for (Instructor i : list) {
                        i.displayInstructor();
                    }
                }
                break;

            case "c":
                System.out.print("Enter Instructor ID to Update: ");
                String updateId = scan.nextLine();
                Instructor found = instructorService.findByInstructorID(updateId);

                if (found != null) {
                    System.out.print("Enter New Name: ");
                    String nName = scan.nextLine();
                    System.out.print("Enter New Courses: ");
                    String nCourse = scan.nextLine();

                    found.updateInstructorDetails(nName, nCourse);
                } else {
                    System.out.println("Instructor not found.");
                }
                break;

            case "d":
                System.out.print("Enter Instructor ID: "); String insId = scan.nextLine();
                System.out.print("Enter Section Name: "); String secN = scan.nextLine();

                Instructor insObj = instructorService.findByInstructorID(insId);
                Section secObj = sectionService.findBySectionName(secN);

                if (insObj != null && secObj != null) {
                    instructorService.assignInstructorToSection(insObj, secObj);
                } else {
                    System.out.println("Error: Linking failed. Check ID and Section Name.");
                }
                break;

            default:
                System.out.println("Invalid selection.");
                break;
        }
    }
    public void handleTuitionFeeMenu(){
        System.out.println("\n--- [Tuition & Financial Management] ---");
        System.out.println("a. Assess Tuition (Add Units) | b. Process Payment | c. Check Balance");
        System.out.print("Select: ");
        String opt = scan.nextLine().toLowerCase();

        switch (opt) {
            case "a":
                System.out.print("Enter Student ID: "); String sId = scan.nextLine();
                System.out.print("Enter Units to add: "); int u = scan.nextInt(); scan.nextLine();
                Student stud = ((StudentRegistration)registrar.getStudentRegis()).findByStudentID(sId);
                if (stud != null) registrar.calculateTuitionFee(stud, u);
                else System.out.println("Student not found.");
                break;
            case "b":
                System.out.print("Enter Student ID: "); String pId = scan.nextLine();
                System.out.print("Enter Payment Amount: "); double amt = scan.nextDouble(); scan.nextLine();
                registrar.processPayment(pId, amt);
                break;
            case "c":
                System.out.print("Enter Student ID: "); String cId = scan.nextLine();
                registrar.checkStudentBalance(cId);
                break;
        }
    }

    public void handleDeptMenu() {
        System.out.println("\n--- [ DEPARTMENT MANAGEMENT ] ---");
        System.out.println("1. Register New Department ");
        System.out.println("2. View Institutional Hierarchy");
        System.out.println("3. Update Department Details");
        System.out.println("4. Remove Department )1");
        System.out.println("-------------------------------------------------");
        System.out.println("5. Assign Section to Department");
        System.out.println("6. Assign Course to Department");
        System.out.println("7. Assign Instructor to Department");
        System.out.println("0. Return to Main Menu");
        System.out.print("Selection: ");

        String opt = scan.nextLine();

        switch (opt) {
            case "1":
                System.out.print("Enter Dept ID: "); String dId = scan.nextLine();
                System.out.print("Enter Dept Name: "); String dName = scan.nextLine();

                registrar.saveDept(new Department(dId, dName, new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
                break;

            case "2":
                registrar.displayHierarchy();
                break;

            case "3":
                System.out.print("Enter Dept ID to Update: "); String updateId = scan.nextLine();
                System.out.print("Enter New Name: "); String nName = scan.nextLine();

                Department updatedDept = new Department(updateId, nName, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
                ((DepartmentRegistration)registrar.getDepartmentRegis()).updateDepartment(updateId, updatedDept);
                break;

            case "4":
                System.out.print("Enter Dept ID to Delete: "); String delId = scan.nextLine();
                ((DepartmentRegistration)registrar.getDepartmentRegis()).deleteDepartment(delId);
                break;

            case "5":
                System.out.print("Enter Dept ID: "); String sDeptId = scan.nextLine();
                System.out.print("Enter Section Name: "); String sName = scan.nextLine();

                Department deptS = ((DepartmentRegistration)registrar.getDepartmentRegis()).findByDepartmentID(sDeptId);
                Section sec = sectionService.findBySectionName(sName);

                if (deptS != null && sec != null) {
                    deptS.addSection(sec);
                    System.out.println("Section " + sName + " linked to " + deptS.getDepartmentName());
                } else {
                    System.out.println("Error: Department or Section not found.");
                }
                break;

            case "6":
                System.out.print("Dept ID: "); String cDeptId = scan.nextLine();
                System.out.print("Course ID: "); String cId = scan.nextLine();

                Department deptC = ((DepartmentRegistration)registrar.getDepartmentRegis()).findByDepartmentID(cDeptId);
                Course cou = courseService.findByCourseID(cId);

                if (deptC != null && cou != null) {
                    deptC.addCourse(cou);
                    System.out.println("Course " + cId + " linked to " + deptC.getDepartmentName());
                } else {
                    System.out.println("Error: Department or Course not found.");
                }
                break;

            case "7":
                System.out.print("Enter Dept ID: "); String iDeptId = scan.nextLine();
                System.out.print("Enter Instructor ID: "); String insId = scan.nextLine();

                Department deptI = ((DepartmentRegistration)registrar.getDepartmentRegis()).findByDepartmentID(iDeptId);
                Instructor ins = instructorService.findByInstructorID(insId);

                if (deptI != null && ins != null) {
                    deptI.addInstructor(ins);
                    System.out.println("Instructor " + ins.getPersonName() + " assigned to " + deptI.getDepartmentName());
                } else {
                    System.out.println("Error: Department or Instructor not found.");
                }
                break;

            case "0":
                return;

            default:
                System.out.println("Invalid Selection.");
                break;
        }
    }
}
