public class BankAccount {

        private double balance;

        public BankAccount(double balance) {
            this.balance = balance;
        }

        public void deposit(double amount) {
            balance += amount;
            System.out.println("$" + amount + " deposited successfully.");
        }

        public void withdraw(double amount) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("$" + amount + " withdrawn successfully."); 
            } else {
                System.out.println("Insufficient balance. Withdrawal failed.");
            }
        }

        public void checkBalance() {
            System.out.println("Current balance: $" + balance);
        }
    }