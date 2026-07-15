import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount(10000);

        int choice;

        do {
            System.out.println("\n ==== Welcome to the ATM Interface ====");
            System.out.println("1. Check Balance:");
            System.out.println("2. Deposit Money:");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1 :
                    account.checkBalance();
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: $");
                    account.deposit(sc.nextDouble());
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: $");
                    account.withdraw(sc.nextDouble());
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}