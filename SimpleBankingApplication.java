import java.util.*;

public class SimpleBankingApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount bank1 = new BankAccount("XYZ", "01");
        bank1.showmenu();
    }

}

class BankAccount {
    int balance;
    int previousTransaction;
    String customername;
    String customerID;

    BankAccount(String cname, String cid) {
        customername = cname;
        customerID = cid;
    }

    void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void withdrawl(int amount) {
        if (amount != 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    void getpreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrwal: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction is occured!");
        }
    }

    void showmenu() {
        char option = '\0';
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome " + customername);
        System.out.println("Your ID is: " + customerID);
        System.out.println();
        System.out.println("A. Check Balanece");
        System.out.println("B. Deposit");
        System.out.println("C. Withdraw");
        System.out.println("D. Previous Transaction");
        System.out.println("E. Exit");

        do {
            System.out.println("-----------------------");
            System.out.println("Enter the option");
            System.out.println("--------------------------");
            option = sc.next().charAt(0);
            Character.toUpperCase(option);
            switch (option) {
                case 'A':
                    System.out.println("----------------------");
                    System.out.println("Balance is: " + balance);
                    System.out.println("---------------------");
                    System.out.println();
                    break;

                case 'B':
                    System.out.println("----------------------");
                    System.out.println("Enter the amount to deposit");
                    System.out.println("---------------------");
                    int amount = sc.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;

                case 'C':
                    System.out.println("----------------------");
                    System.out.println("Enter the amount to withdraw");
                    System.out.println("---------------------");
                    int amount2 = sc.nextInt();
                    deposit(amount2);
                    System.out.println();
                    break;

                case 'D':
                    System.out.println("-------------------");
                    getpreviousTransaction();
                    System.out.println("------------------------");
                    System.out.println();
                    break;

                case 'E':
                    System.out.println("---------------------");
                    break;

                default:
                    System.out.println("Invalid option! Please try again");
                    break;
            }
        } while (option != 'E');

    }
}
