/**
 * Employee class — represents an employee in the system.
 * <p>
 * YOUR TASK (Part B):
 * 1. Complete the constructor that takes all 4 parameters
 * 2. Add getters for all fields
 * 3. Add setters with validation:
 * - setName: throw IllegalArgumentException if name is null or empty
 * - setSalary: throw IllegalArgumentException if salary is negative
 * - setDepartment: throw IllegalArgumentException if department is null or empty
 * 4. Override toString() to return a readable string like:
 * "Employee{id=1, name='Ahmed', department='Engineering', salary=3500.0}"
 * 5. Add a getBonus() method that returns 5% of salary (salary * 0.05)
 */
public class Employee {

    private int id;
    private String name;
    private String department;
    private double salary;

    // TODO: Constructor that takes (int id, String name, String department, double salary)
    //       Must validate: name not null/empty, department not null/empty, salary not negative

    public Employee(int id, String name, String department, double salary){
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("Name cannot be null or empty");
        } else if(department == null || department.isBlank()) {
            throw new IllegalArgumentException("Department cannot be null or empty");
        } else if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }


    // TODO: Getters for all 4 fields

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }


    // TODO: Setters for name, department, salary (with validation as described above)
    //       Note: id has no setter — it should not change after creation

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        } else {
            this.name = name;
        }
    }

    public void setDepartment(String department) {
        if (department == null || department.isBlank()) {
            throw new IllegalArgumentException("Department cannot be null or empty");
        } else {
            this.department = department;
        }
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        } else {
            this.salary = salary;
        }
    }


    // TODO: Override toString()
    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', department='" + department + "', salary=" + salary + "}";
    }


    // TODO: getBonus() — returns 5% of salary
    public double getBonus() {
        return salary * 0.05;
    }
}
