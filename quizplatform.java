
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class BankingApplicationWithTransfer {

    private static Map<String, Double> accounts = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Banking Application with Transfer!");

        // Create some sample accounts for testing
        accounts.put("Account1", 1000.0);
        accounts.put("Account2", 1500.0);
        boolean continueOperation = true;
        int choice;
        do {
            System.out.println("\n1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Transfer Funds");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    deposit(scanner);
                    break;
                case 2:
                    withdraw(scanner);
                    break;
                case 3:
                    checkBalance(scanner);
                    break;
                case 4:
                    transferFunds(scanner);
                    break;
                case 5:
                    System.out.println("Exiting the program. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
            if (choice != 5) {
                System.out.print("Do you want to continue another operation?");
                String continueChoice = scanner.next().toLowerCase();
                continueOperation = continueChoice.equals("yes") || continueChoice.equals("y");
            }

        } while (continueOperation);
        scanner.close();
    }

    private static void deposit(Scanner scanner) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.next();

        System.out.print("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();

        if (amount > 0) {
            accounts.put(accountNumber, accounts.getOrDefault(accountNumber, 0.0) + amount);
            System.out.println("Deposit successful. Current balance:-   " + accounts.get(accountNumber));
        } else {
            System.out.println("Invalid amount. Please enter a positive value.");
        }
    }

    private static void withdraw(Scanner scanner) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.next();

        System.out.print("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();

        if (amount > 0 && amount <= accounts.getOrDefault(accountNumber, 0.0)) {
            accounts.put(accountNumber, accounts.get(accountNumber) - amount);
            System.out.println("Withdrawal successful. Current balance: LK" + accounts.get(accountNumber));
        } else if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
        } else {
            System.out.println("Insufficient funds. Withdrawal not allowed.");
        }
    }

    private static void checkBalance(Scanner scanner) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.next();

        System.out.println(
                "Current balance for account " + accountNumber  + accounts.getOrDefault(accountNumber, 0.0));
    }

    private static void transferFunds(Scanner scanner) {
        System.out.print("Enter source account number: ");
        String sourceAccount = scanner.next();

        System.out.print("Enter destination account number: ");
        String destinationAccount = scanner.next();

        System.out.print("Enter the amount to transfer: ");
        double amount = scanner.nextDouble();

        if (amount > 0 && amount <= accounts.getOrDefault(sourceAccount, 0.0)) {
            accounts.put(sourceAccount, accounts.get(sourceAccount) - amount);
            accounts.put(destinationAccount, accounts.getOrDefault(destinationAccount, 0.0) + amount);
            System.out.println("Transfer successful.");
            System.out.println("Current balance for: " + sourceAccount  + accounts.get(sourceAccount));
            System.out.println("Current balance for:  " + destinationAccount + accounts.get(destinationAccount));
        } else if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
        } else {
            System.out.println("Insufficient funds for transfer. Transfer not allowed.");
        }
    }
}

