import java.util.List;

/**
 * Main — demonstrate your Employee Management System.
 *
 * YOUR TASKS:
 *   Part C — Create Manager and Intern objects, demonstrate polymorphism
 *   Part D — Add try/catch blocks for exception handling
 *
 * This file should compile and run, printing output that proves
 * all your code works correctly.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("=== PART A: Salary Utilities ===");

        System.out.println("Annual salary (3000/month): " + SalaryUtils.calculateAnnualSalary(3000));
        System.out.println("Tax on 25000: " + SalaryUtils.calculateTax(25000));
        System.out.println("Tax on 50000: " + SalaryUtils.calculateTax(50000));
        System.out.println("Tax on 8000: " + SalaryUtils.calculateTax(8000));
        System.out.println("Net salary of 25000: " + SalaryUtils.calculateNetSalary(25000));
        System.out.println("After 10% raise on 3000: " + SalaryUtils.applyRaise(3000, 10));

        System.out.println("\n=== PART B: Employee Manager ===");
        // TODO: Create an EmployeeManager
        EmployeeManager em = new EmployeeManager();

        // TODO: Create and add at least 3 employees to it
        Employee e1 = new Employee(1, "Ahmed", "Engineering", 3500.0);
        Employee e2 = new Employee(2, "Sara", "HR", 2800.0);
        Employee e3 = new Employee(3, "Khalid", "Engineering", 4000.0);

        // TODO: Demonstrate findById (found + not found)
        em.addEmployee(e1);
        em.addEmployee(e2);
        em.addEmployee(e3);

        // TODO: Demonstrate getEmployeesByDepartment
        System.out.println("Total employees: " + em.getEmployeeCount());
        System.out.println("findById(2): " + em.findById(2));
        System.out.println("findById(99): " + em.findById(99));

        System.out.println("Engineering employees:");
        List<Employee> engineers = em.getEmployeesByDepartment("engineering");
        for (Employee e : engineers) {
            System.out.println("  " + e);
        }

        System.out.println("Bonus for Ahmed: " + e1.getBonus());


        System.out.println("\n=== PART C: Inheritance & Polymorphism ===");
        // TODO: Create at least 1 Manager and 1 Intern
        Manager m1 = new Manager(4, "Fatima", "IT", 6000.0, 8);
        Intern i1 = new Intern(5, "Ali", "Marketing", 1200.0, "UoB");

        // TODO: Add all employees (Employee, Manager, Intern) to the manager
        em.addEmployee(m1);
        em.addEmployee(i1);

        System.out.println(m1);
        System.out.println(i1);

        // TODO: Loop through getAllEmployees() and call getBonus() on each
        //       Print: "<name> bonus: <amount>" for each one
        //       This demonstrates polymorphism — same method call, different behavior
        System.out.println("\nBonus per employee:");
        for (Employee e : em.getAllEmployees()) {
            System.out.println("  " + e.getName() + " bonus: " + e.getBonus());
        }


        System.out.println("\n=== PART D: Exception Handling ===");
        // TODO: Use try/catch to demonstrate:

        //   1. Trying to remove an employee that doesn't exist
        try {
            em.removeEmployee(999);
        } catch (IllegalArgumentException ex) {
            System.out.println("Remove non-existing ID: " + ex.getMessage());
        }

        //   2. Trying to promote an employee that's already a Manager
        try {
            em.promoteToManager(4, 5);
        } catch (IllegalArgumentException ex) {
            System.out.println("Promote existing manager: " + ex.getMessage());
        }

        //   3. Trying to create an Employee with invalid data (negative salary)
        try {
            Employee invalid = new Employee(10, "Test", "Finance", -500.0);
        } catch (IllegalArgumentException ex) {
            System.out.println("Negative salary: " + ex.getMessage());
        }

        // Each try/catch should print the error message gracefully
        System.out.println("\nPromoting Ahmed (ID 1) to Manager:");
        Manager promoted = em.promoteToManager(1, 3);
        System.out.println(promoted);

    }
}
