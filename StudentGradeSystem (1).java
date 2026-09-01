import java.util.*;

class StudentGradeSystem
{
    Scanner sc = new Scanner(System.in);

    // Student variables
    int studentId;
    String studentName;

    // Subject marks
    int javaMarks;
    int dbmsMarks;
    int dsaMarks;
    int mathsMarks;
    int pythonMarks;

    // Result variables
    int totalMarks;
    double percentage;
    String grade;

    boolean studentAdded = false;

    void menu()
    {
        System.out.println("\n========== Student Grade System ==========");
        System.out.println("1. Add Student Marks");
        System.out.println("2. View Student Details");
        System.out.println("3. Calculate Grade");
        System.out.println("4. Check Result");
        System.out.println("5. Update Marks");
        System.out.println("6. Delete Student");
        System.out.println("7. Exit");
        System.out.println("==========================================");
    }

    void addStudent()
    {
        if (studentAdded)
        {
            System.out.println("Student already exists.");
            return;
        }

        System.out.println("\nEnter Student ID:");
        studentId = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Student Name:");
        studentName = sc.nextLine();

        System.out.println("Enter Java Marks:");
        javaMarks = sc.nextInt();

        System.out.println("Enter DBMS Marks:");
        dbmsMarks = sc.nextInt();

        System.out.println("Enter DSA Marks:");
        dsaMarks = sc.nextInt();

        System.out.println("Enter Maths Marks:");
        mathsMarks = sc.nextInt();

        System.out.println("Enter Python Marks:");
        pythonMarks = sc.nextInt();

        studentAdded = true;

        System.out.println("Student Details Added Successfully.");
    }

    void viewStudent()
    {
        if (!studentAdded)
        {
            System.out.println("No Student Record Available.");
            return;
        }

        System.out.println("\n========== Student Details ==========");
        System.out.println("Student ID   : " + studentId);
        System.out.println("Student Name : " + studentName);
        System.out.println("--------------------------------------");
        System.out.println("Java         : " + javaMarks);
        System.out.println("DBMS         : " + dbmsMarks);
        System.out.println("DSA          : " + dsaMarks);
        System.out.println("Maths        : " + mathsMarks);
        System.out.println("Python       : " + pythonMarks);
    }

    void calculateGrade()
    {
        if (!studentAdded)
        {
            System.out.println("No Student Record Available.");
            return;
        }

        totalMarks = javaMarks + dbmsMarks + dsaMarks + mathsMarks + pythonMarks;
        percentage = totalMarks / 5.0;

        if (percentage >= 90)
        {
            grade = "A+";
        }
        else if (percentage >= 80)
        {
            grade = "A";
        }
        else if (percentage >= 70)
        {
            grade = "B";
        }
        else if (percentage >= 60)
        {
            grade = "C";
        }
        else if (percentage >= 50)
        {
            grade = "D";
        }
        else
        {
            grade = "F";
        }

        System.out.println("\n========== Grade Result ==========");
        System.out.println("Student Name : " + studentName);
        System.out.println("Total Marks  : " + totalMarks + "/500");
        System.out.println("Percentage   : " + percentage + "%");
        System.out.println("Grade        : " + grade);
    }

    void checkResult()
    {
        if (!studentAdded)
        {
            System.out.println("No Student Record Available.");
            return;
        }

        if (javaMarks >= 33 && dbmsMarks >= 33 &&
            dsaMarks >= 33 && mathsMarks >= 33 &&
            pythonMarks >= 33)
        {
            System.out.println("\nResult: PASS");
        }
        else
        {
            System.out.println("\nResult: FAIL");
        }
    }

    void updateMarks()
    {
        if (!studentAdded)
        {
            System.out.println("No Student Record Available.");
            return;
        }

        System.out.println("\nEnter New Java Marks:");
        javaMarks = sc.nextInt();

        System.out.println("Enter New DBMS Marks:");
        dbmsMarks = sc.nextInt();

        System.out.println("Enter New DSA Marks:");
        dsaMarks = sc.nextInt();

        System.out.println("Enter New Maths Marks:");
        mathsMarks = sc.nextInt();

        System.out.println("Enter New Python Marks:");
        pythonMarks = sc.nextInt();

        System.out.println("Marks Updated Successfully.");
    }

    void deleteStudent()
    {
        if (!studentAdded)
        {
            System.out.println("No Student Record Available.");
            return;
        }

        studentId = 0;
        studentName = "";
        javaMarks = 0;
        dbmsMarks = 0;
        dsaMarks = 0;
        mathsMarks = 0;
        pythonMarks = 0;
        totalMarks = 0;
        percentage = 0;
        grade = "";
        studentAdded = false;

        System.out.println("Student Record Deleted Successfully.");
    }

    public static void main(String[] args)
    {
        StudentGradeSystem obj = new StudentGradeSystem();
        int choice;

        do
        {
            obj.menu();

            System.out.println("Enter Choice:");
            choice = obj.sc.nextInt();

            switch (choice)
            {
                case 1:
                    obj.addStudent();
                    break;

                case 2:
                    obj.viewStudent();
                    break;

                case 3:
                    obj.calculateGrade();
                    break;

                case 4:
                    obj.checkResult();
                    break;

                case 5:
                    obj.updateMarks();
                    break;

                case 6:
                    obj.deleteStudent();
                    break;

                case 7:
                    System.out.println("Thank you for using Student Grade System.");
                    break;

                default:
                    System.out.println("Invalid Choice. Please try again.");
            }

        }
        while (choice != 7);

        obj.sc.close();
    }
}
