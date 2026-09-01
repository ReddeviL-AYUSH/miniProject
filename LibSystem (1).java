import java.util.*;

class LibSystem
{
    Scanner sc = new Scanner(System.in);

    // Book variables
    int bookId;
    String bookName;
    String authorName;
    String category;
    int totalCopies;
    int availableCopies;

    // Student variables
    int studentId;
    String studentName;

    // Status variables
    boolean bookAdded = false;
    boolean bookIssued = false;

    void menu()
    {
        System.out.println("\n========== Library Management System ==========");
        System.out.println("1. Add Book");
        System.out.println("2. View Book");
        System.out.println("3. Search Book");
        System.out.println("4. Issue Book");
        System.out.println("5. Return Book");
        System.out.println("6. Delete Book");
        System.out.println("7. Library Report");
        System.out.println("8. Exit");
        System.out.println("==============================================");
    }

    void addBook()
    {
        if (bookAdded)
        {
            System.out.println("Book already exists.");
            return;
        }

        System.out.println("\nEnter Book ID:");
        bookId = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Book Name:");
        bookName = sc.nextLine();

        System.out.println("Enter Author Name:");
        authorName = sc.nextLine();

        System.out.println("Enter Category:");
        category = sc.nextLine();

        System.out.println("Enter Total Copies:");
        totalCopies = sc.nextInt();

        availableCopies = totalCopies;
        bookAdded = true;

        System.out.println("Book Added Successfully.");
    }

    void viewBook()
    {
        if (!bookAdded)
        {
            System.out.println("No Book Available.");
            return;
        }

        System.out.println("\n========== Book Details ==========");
        System.out.println("Book ID         : " + bookId);
        System.out.println("Book Name       : " + bookName);
        System.out.println("Author Name     : " + authorName);
        System.out.println("Category        : " + category);
        System.out.println("Total Copies    : " + totalCopies);
        System.out.println("Available Copies: " + availableCopies);
    }

    void searchBook()
    {
        if (!bookAdded)
        {
            System.out.println("No Book Available.");
            return;
        }

        System.out.println("\nSearch Book By:");
        System.out.println("1. Book ID");
        System.out.println("2. Book Name");
        System.out.println("Enter Choice:");
        int searchChoice = sc.nextInt();
        sc.nextLine();

        boolean found = false;

        if (searchChoice == 1)
        {
            System.out.println("Enter Book ID:");
            int searchId = sc.nextInt();

            if (searchId == bookId)
            {
                found = true;
            }
        }
        else if (searchChoice == 2)
        {
            System.out.println("Enter Book Name:");
            String searchName = sc.nextLine();

            if (searchName.equalsIgnoreCase(bookName))
            {
                found = true;
            }
        }
        else
        {
            System.out.println("Invalid Choice.");
            return;
        }

        if (found)
        {
            System.out.println("\nBook Found!");
            viewBook();
        }
        else
        {
            System.out.println("Book Not Found.");
        }
    }

    void issueBook()
    {
        if (!bookAdded)
        {
            System.out.println("No Book Available.");
            return;
        }

        if (availableCopies <= 0)
        {
            System.out.println("Book Not Available.");
            return;
        }

        if (bookIssued)
        {
            System.out.println("Book is already issued.");
            return;
        }

        System.out.println("Enter Student ID:");
        studentId = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Student Name:");
        studentName = sc.nextLine();

        availableCopies--;
        bookIssued = true;

        System.out.println("Book Issued Successfully.");
        System.out.println("Student ID   : " + studentId);
        System.out.println("Student Name : " + studentName);
    }

    void returnBook()
    {
        if (!bookAdded)
        {
            System.out.println("No Book Available.");
            return;
        }

        if (!bookIssued)
        {
            System.out.println("No Book Has Been Issued.");
            return;
        }

        System.out.println("Enter Student ID:");
        int returnStudentId = sc.nextInt();

        if (returnStudentId == studentId)
        {
            availableCopies++;
            bookIssued = false;

            System.out.println("Book Returned Successfully.");
        }
        else
        {
            System.out.println("Invalid Student ID.");
        }
    }

    void deleteBook()
    {
        if (!bookAdded)
        {
            System.out.println("No Book Available.");
            return;
        }

        bookId = 0;
        bookName = "";
        authorName = "";
        category = "";
        totalCopies = 0;
        availableCopies = 0;

        studentId = 0;
        studentName = "";

        bookAdded = false;
        bookIssued = false;

        System.out.println("Book Deleted Successfully.");
    }

    void libraryReport()
    {
        if (!bookAdded)
        {
            System.out.println("No Book Available.");
            return;
        }

        int issuedCopies = totalCopies - availableCopies;

        System.out.println("\n========== Library Report ==========");
        System.out.println("Book ID         : " + bookId);
        System.out.println("Book Name       : " + bookName);
        System.out.println("Total Copies    : " + totalCopies);
        System.out.println("Available Copies: " + availableCopies);
        System.out.println("Issued Copies   : " + issuedCopies);
    }

    public static void main(String[] args)
    {
        LibSystem obj = new LibSystem();
        int choice;

        do
        {
            obj.menu();

            System.out.println("Enter Choice:");
            choice = obj.sc.nextInt();

            switch (choice)
            {
                case 1:
                    obj.addBook();
                    break;

                case 2:
                    obj.viewBook();
                    break;

                case 3:
                    obj.searchBook();
                    break;

                case 4:
                    obj.issueBook();
                    break;

                case 5:
                    obj.returnBook();
                    break;

                case 6:
                    obj.deleteBook();
                    break;

                case 7:
                    obj.libraryReport();
                    break;

                case 8:
                    System.out.println("Thanks for using Library Management System.");
                    break;

                default:
                    System.out.println("Invalid Choice. Please try again.");
                    continue;
            }

        }
        while (choice != 8);

        obj.sc.close();
    }
}
