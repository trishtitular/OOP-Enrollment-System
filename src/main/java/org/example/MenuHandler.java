package org.example;

import org.example.model.*;
import org.example.service.*;
import java.util.*;

public class MenuHandler {
    private final Scanner scan;
    private final CampusRegistrar registrar;
    private final SectionRegistration sectionService;
    private CourseRegistration courseService = new CourseRegistration();

    public MenuHandler(CampusRegistrar registrar,
                       SectionRegistration sectionService,
                       CourseRegistration courseService) {
        this.scan = new Scanner(System.in);
        this.registrar = registrar;
        this.sectionService = sectionService;
        this.courseService = courseService;
    }

    public MenuHandler(CampusRegistrar registrar, SectionReg sectionService) {

        this.scan = new Scanner(System.in);
        this.registrar = registrar;
        this.sectionService = (SectionRegistration) sectionService;
        this.courseService = courseService;
    }

    public void handleCourseMenu(){
        System.out.println("\n--- [Course Management] ---");
        System.out.println("a. Add Course | b. View Catalog | c. Update Course | d. Remove Course");
        System.out.println("Select an option: ");
        String option = scan.nextLine().toLowerCase();

        if (option.equals("a")){
            System.out.print("Enter Course ID: ");
            String courseID = scan.nextLine();
            System.out.print("Enter Course Name: ");
            String courseName = scan.nextLine();
            System.out.print("Enter Course Program: ");
            String courseProg = scan.nextLine();
            System.out.print("Enter Course Units: ");
            int courseUnits = scan.nextInt();
            registrar.saveCourse(new Course(courseID, courseName, courseProg, courseUnits));
        } else if (option.equals("b")){
            registrar.displayAllCourses(1350.0);
        } else if (option.equals("c")){
            System.out.print("Enter Course ID to Update: ");
            String courseID = scan.nextLine();
            System.out.print("Enter New Course Name: ");
            String courseName = scan.nextLine();
            System.out.print("Enter New Course Program: ");
            String courseProg = scan.nextLine();
            System.out.print("Enter New Course Units: ");
            int courseUnits = scan.nextInt();
            scan.nextLine();
            registrar.updateCourse(new Course(courseID, courseName, courseProg, courseUnits));
        }else if (option.equals("d")){
            System.out.println("Enter Course ID to remove: ");
            registrar.removeCourse(scan.nextLine());
        }

    }
    public void handleSectionMenu() {
        System.out.println("\n--- [Section Management] ---");
        System.out.println("a. Add | b. View All | c. Update | d. Delete"); // Added 'c'
        System.out.print("Select an option: ");
        String opt = scan.nextLine().toLowerCase();

        if (opt.equals("a")) {
            System.out.print("Enter Section Name: ");
            String sectionName = scan.nextLine();
            System.out.print("Enter Max Capacity: ");
            int sectionCapacity = scan.nextInt();
            scan.nextLine();
            registrar.saveSection(new Section(sectionName, sectionCapacity, new ArrayList<>(), null));
        } else if (opt.equals("b")) {
            List<Section> list = sectionService.displayAll();
            for (Section s : list) {
                System.out.println("- " + s.getSectionName() + " (Section Max Capacity: " + s.getMaxCapacity() + ")");
            }
        } else if (opt.equals("c")) { // NEW UPDATE LOGIC
            System.out.print("Enter OLD Section Name: ");
            String oldName = scan.nextLine();
            System.out.print("Enter NEW Section Name: ");
            String newName = scan.nextLine();
            System.out.print("Enter NEW Capacity: ");
            int cap = scan.nextInt();
            scan.nextLine();
            sectionService.updateSection(oldName, new Section(newName, cap, new ArrayList<>(), null));
        } else if (opt.equals("d")) {
            System.out.print("Enter Name to delete: ");
            sectionService.deleteSection(scan.nextLine());
        }
    }
    public void handleDeptMenu() {
        System.out.println("\n--- [Department Management] ---");
        System.out.println("a. Register Dept | b. View Hierarchy");
        System.out.print("Select an option: ");
        String opt = scan.nextLine().toLowerCase();

        if (opt.equals("a")) {
            System.out.print("Enter Department ID: "); String deptID = scan.nextLine();
            System.out.print("Dept Name: "); String deptName = scan.nextLine();
            registrar.saveDept(new Department(deptID, deptName, new ArrayList<>(), new ArrayList<>()));
        } else {
            registrar.displayHierarchy();
        }
    }

}
