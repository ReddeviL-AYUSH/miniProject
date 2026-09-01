import java.util.*;

class AccountManagement
{
    void disp()
    {
        Scanner sc = new Scanner(System.in);

        String name;
        double amount, deposit, withdraw;

        System.out.println("----- Account Management System -----");

        System.out.print("Enter your name: ");
        name = sc.nextLine();

        System.out.print("Enter your initial amount: ");
        amount = sc.nextDouble();

        System.out.print("Enter deposit amount: ");
        deposit = sc.nextDouble();

        amount = amount + deposit;

        System.out.print("Enter withdraw amount: ");
        withdraw = sc.nextDouble();

        if (withdraw <= amount)
        {
            amount = amount - withdraw;

            System.out.println("\n----- Account Details -----");
            System.out.println("Account Holder: " + name);
            System.out.println("Deposited Amount: " + deposit);
            System.out.println("Withdrawn Amount: " + withdraw);
            System.out.println("Remaining Balance: " + amount);
        }
        else
        {
            System.out.println("Insufficient balance!");
        }

        sc.close();
    }

    public static void main(String args[])
    {
        AccountManagement obj = new AccountManagement();
        obj.disp();
    }
}
