import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class EmployeeManagementSystem {
    private List<Employee> employees;

    public EmployeeManagementSystem() {
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        System.out.println("Employee added successfully.");
    }

    public void viewAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
    }

    public void searchEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                System.out.println("Employee found: " + employee);
                return;
            }
        }
        System.out.println("Employee not found with ID: " + id);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeManagementSystem ems = new EmployeeManagementSystem();

        while (true) {
            System.out.println("\nEmployee Management System Menu:");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (choice == 1) {
                System.out.print("Enter employee ID: ");
                int id = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                System.out.print("Enter employee name: ");
                String name = scanner.nextLine();
                System.out.print("Enter employee salary: ");
                double salary = scanner.nextDouble();
                ems.addEmployee(new Employee(id, name, salary));
            } else if (choice == 2) {
                ems.viewAllEmployees();
            } else if (choice == 3) {
                System.out.print("Enter employee ID to search: ");
                int searchId = scanner.nextInt();
                ems.searchEmployeeById(searchId);
            } else if (choice == 4) {
                System.out.println("Exiting Employee Management System. Goodbye!");
                System.exit(0);
            } else {
                System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
