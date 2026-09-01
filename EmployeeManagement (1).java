import java.util.*;

class EmployeeManagement {

    Scanner sc = new Scanner(System.in);

    int[] employeeId = new int[50];
    String[] employeeName = new String[50];
    String[] department = new String[50];
    double[] salary = new double[50];

    int count = 0;

    // Add Employee
    void addEmployee() {
        System.out.println("\nEnter Employee ID:");
        employeeId[count] = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Employee Name:");
        employeeName[count] = sc.nextLine();

        System.out.println("Enter Department:");
        department[count] = sc.nextLine();

        System.out.println("Enter Salary:");
        salary[count] = sc.nextDouble();

        count++;

        System.out.println("Employee added successfully!");
    }

    // Display Employees
    void displayEmployees() {

        if (count == 0) {
            System.out.println("\nNo employee records found.");
            return;
        }

        System.out.println("\n----- Employee Details -----");

        for (int i = 0; i < count; i++) {
            System.out.println("\nEmployee " + (i + 1));
            System.out.println("ID         : " + employeeId[i]);
            System.out.println("Name       : " + employeeName[i]);
            System.out.println("Department : " + department[i]);
            System.out.println("Salary     : " + salary[i]);
        }
    }

    // Search Employee
    void searchEmployee() {

        System.out.println("\nEnter Employee ID to search:");
        int id = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < count; i++) {

            if (employeeId[i] == id) {
                System.out.println("\nEmployee Found!");
                System.out.println("ID         : " + employeeId[i]);
                System.out.println("Name       : " + employeeName[i]);
                System.out.println("Department : " + department[i]);
                System.out.println("Salary     : " + salary[i]);

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Employee not found.");
        }
    }

    // Update Employee
    void updateEmployee() {

        System.out.println("\nEnter Employee ID to update:");
        int id = sc.nextInt();
        sc.nextLine();

        boolean found = false;

        for (int i = 0; i < count; i++) {

            if (employeeId[i] == id) {

                System.out.println("Enter new name:");
                employeeName[i] = sc.nextLine();

                System.out.println("Enter new department:");
                department[i] = sc.nextLine();

                System.out.println("Enter new salary:");
                salary[i] = sc.nextDouble();

                System.out.println("Employee details updated successfully!");

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Employee not found.");
        }
    }

    // Delete Employee
    void deleteEmployee() {

        System.out.println("\nEnter Employee ID to delete:");
        int id = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < count; i++) {

            if (employeeId[i] == id) {

                for (int j = i; j < count - 1; j++) {
                    employeeId[j] = employeeId[j + 1];
                    employeeName[j] = employeeName[j + 1];
                    department[j] = department[j + 1];
                    salary[j] = salary[j + 1];
                }

                count--;

                System.out.println("Employee deleted successfully!");

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Employee not found.");
        }
    }

    public static void main(String[] args) {

        EmployeeManagement obj = new EmployeeManagement();

        Scanner sc = new Scanner(System.in);

        int choice;

        do {
            System.out.println("\n==============================");
            System.out.println("   EMPLOYEE MANAGEMENT SYSTEM");
            System.out.println("==============================");
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.println("==============================");

            System.out.println("Enter your choice:");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    obj.addEmployee();
                    break;

                case 2:
                    obj.displayEmployees();
                    break;

                case 3:
                    obj.searchEmployee();
                    break;

                case 4:
                    obj.updateEmployee();
                    break;

                case 5:
                    obj.deleteEmployee();
                    break;

                case 6:
                    System.out.println("Thank you for using Employee Management System!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}
