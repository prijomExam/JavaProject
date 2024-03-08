import java.sql.*;
import java.util.Scanner;

// Student class to represent each student
class Student {
    private int id;
    private String name;
    private boolean present;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.present = false; // Initially, student is marked absent
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isPresent() {
        return present;
    }

    public void markPresent() {
        this.present = true;
    }

    public void markAbsent() {
        this.present = false;
    }
}

// AttendanceManager class to manage attendance of students
class AttendanceManager {
    private Connection connection;

    public  AttendanceManager() {
        try {
            // Connect to MySQL database
            String url = "jdbc:mysql://localhost:3306/ams_db";
            String user = "root";
            String password = "";
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace(); // Print stack trace for debugging
        }
    }

    // Method to add a student to the attendance list
    public void addStudent(String name) {
        String query = "INSERT INTO students (name) VALUES (?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println(name + " added successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to remove a student from the attendance list
    public void removeStudent(int id) {
        String query = "DELETE FROM students WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Student with ID " + id + " removed successfully.");
            } else {
                System.out.println("Student with ID " + id + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to mark a student as present
    public void markPresent(int id) {
        updateAttendance(id, true);
    }

    // Method to mark a student as absent
    public void markAbsent(int id) {
        updateAttendance(id, false);
    }

    private void updateAttendance(int id, boolean present) {
        String query = "UPDATE students SET present = ? WHERE id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setBoolean(1, present);
            preparedStatement.setInt(2, id);
            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Attendance for student with ID " + id + " updated successfully.");
            } else {
                System.out.println("Student with ID " + id + " not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to print the attendance status of all students
    public void printAttendance() {
        String query = "SELECT * FROM students";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("Attendance Status:");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                boolean present = resultSet.getBoolean("present");
                System.out.println("ID: " + id + ", Name: " + name + ", Present: " + (present ? "Yes" : "No"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AttendanceManager attendanceManager = new AttendanceManager();

        while (true) {
            System.out.println("\nOptions:");
            System.out.println("1. Add student");
            System.out.println("2. Remove student");
            System.out.println("3. Mark present");
            System.out.println("4. Mark absent");
            System.out.println("5. View attendance");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter name of student to add: ");
                    String addName = scanner.nextLine();
                    attendanceManager.addStudent(addName);
                    break;
                case 2:
                    System.out.print("Enter ID of student to remove: ");
                    int removeId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    attendanceManager.removeStudent(removeId);
                    break;
                case 3:
                    System.out.print("Enter ID of student to mark present: ");
                    int presentId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    attendanceManager.markPresent(presentId);
                    break;
                case 4:
                    System.out.print("Enter ID of student to mark absent: ");
                    int absentId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    attendanceManager.markAbsent(absentId);
                    break;
                case 5:
                    attendanceManager.printAttendance();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
