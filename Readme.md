# OOP Enrollment System

---
Author: Trish Lorraine Titular

**Encapsulation** 


![](src/main/resources/images/OOPEncapOutput.png)

**Inheritance**

inheritance
![](src/main/resources/images/InheritanceInstructor.png)

**Abstraction**

Person Abstraction
![personAbstraction.png](src/main/resources/images/personAbstraction.png)
Instructor Abstraction
![instructorAbstraction.png](src/main/resources/images/instructorAbstraction.png)
Student Abstraction
![studentAbstraction.png](src/main/resources/images/studentAbstraction.png)

## Campus Registrar System

A console-based Java application designed to streamline and administrative tasks.
The system follows a layered architecture to manage relationships of different entities.

---
**System Architecture**
The system is organized into unique layers for separations of packages:
 - Models: Data containers representing the entities which are Course, Department, Instructor,
Person, Section, Student and TuitionFeePayment
 - Services: The logical layers that handles the CRUD operations and campus registrar rules.
   (CourseRegistration,DepartmentRegistration and more)
 - Campus Registrar: A central coordinator that connect the background services.
 - MenuHandler: Another controller that manages sub-menus and user input to make Main much cleaner.
---
**Key Features**
1. Student & Course Management
    Registration: Add students and course with unique IDs and specific academic programs.
    Catalog: Maintain a full course catalog including unit values and program requirements.
    Tuition Calculation: Automatically calculates fees at a rate of 1,350.00 Pesos per unit.

2. Departmental Hierarchy & Linkage
    Institutional Mapping: Link Sections, Courses, and Instructors to specific Departments. 
    Hierarchy Tool: Generate a visual tree view showing the organization from the Department level down to the 
    individual enrolled students.

3. Tuition Fee & Academic Operations
     Enrollment Gatekeeping: Checks student balance and section capacity before allowing enrollment.  
     Tuition Payments: Process payments and track outstanding balances.

4. Graduation Audit:
    Conduct unit audits to determine if a student has met their required unit goal and completed the TuitionFee.

---
**Testing & Quality Assurance**
The system includes a comprehensive JUnit 5 test suite to ensure the reliability of the business logic. The tests focus 
on preventing common data errors and validating strict university rules.
To run the tests:
1. Navigate the src/test/java
2. Select Run Test to view the pass or fail results.
---
**Usage Logic & Workflow**
To ensure all entities are correctly linked, follow this specific menu workflow:

Step 1: Initial Setup
    Option 1: Register a New Student.
    Option 3 -> a: Add a Course to the catalog.
    Option 5 -> a: Register an Instructor.
    Option 4 -> a: Create a Section (Set the Max Capacity).

Step 2: Department Configuration 
    Option 6 -> 1: Register a New Department.
    Option 6 -> 5, 6, & 7: Link your created Section, Course, and Instructor to the Department.
    Option 5 -> d: Assign the Instructor to a specific Section.

Step 3: Financial Clearance
    Option 8 -> a: Assess Tuition for the student based on units.
    Option 8 -> b: Process a Payment. Students must have a balance of 0.00 to enroll.
    Option 8 -> c: Verify the balance is cleared.

Step 4: Enrollment & Finalization
    Option 7: Enroll the Student in a Section. (This will only succeed if the student is paid and the section has space).
    Option 6 ->2: View the Institutional Hierarchy to see the completed linkage.
    Option 9: Conduct a Graduation Audit to check unit progress.
