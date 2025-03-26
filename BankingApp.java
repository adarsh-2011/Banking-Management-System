import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private String password;

    public BankAccount(String accountNumber, String accountHolder, double initialBalance, String password) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.password = password;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public boolean checkPassword(String inputPassword) {
        return password.equals(inputPassword);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: Rs" + amount);
        } else {
            System.out.println("Invalid amount for deposit.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: Rs" + amount);
        } else {
            System.out.println("Invalid amount for withdrawal.");
        }
    }

    public void checkBalance() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: Rs" + balance);
    }
}

public class BankingApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, BankAccount> accounts = new HashMap<>();

        int choice;
        do {
            System.out.println("\n<----Welcome to NITP Bank---->");
            System.out.println("Menu:");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.next();
                    if (accounts.containsKey(accountNumber)) {
                        System.out.println("Account already exists.");
                        break;
                    }
                    System.out.print("Enter account holder name: ");
                    String accountHolder = scanner.next();
                    System.out.print("Enter initial balance: Rs");
                    double initialBalance = scanner.nextDouble();
                    System.out.print("Set a password: ");
                    String password = scanner.next();
                    BankAccount newAccount = new BankAccount(accountNumber, accountHolder, initialBalance, password);
                    accounts.put(accountNumber, newAccount);
                    System.out.println("Account created successfully.");
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    String depositAccountNumber = scanner.next();
                    if (accounts.containsKey(depositAccountNumber)) {
                        System.out.print("Enter password: ");
                        String inputPassword = scanner.next();
                        if (accounts.get(depositAccountNumber).checkPassword(inputPassword)) {
                            System.out.print("Enter deposit amount: Rs");
                            double depositAmount = scanner.nextDouble();
                            accounts.get(depositAccountNumber).deposit(depositAmount);
                        } else {
                            System.out.println("Invalid password.");
                        }
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    String withdrawAccountNumber = scanner.next();
                    if (accounts.containsKey(withdrawAccountNumber)) {
                        System.out.print("Enter password: ");
                        String inputPassword = scanner.next();
                        if (accounts.get(withdrawAccountNumber).checkPassword(inputPassword)) {
                            System.out.print("Enter withdrawal amount: Rs");
                            double withdrawalAmount = scanner.nextDouble();
                            accounts.get(withdrawAccountNumber).withdraw(withdrawalAmount);
                        } else {
                            System.out.println("Invalid password.");
                        }
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter account number: ");
                    String checkAccountNumber = scanner.next();
                    if (accounts.containsKey(checkAccountNumber)) {
                        System.out.print("Enter password: ");
                        String inputPassword = scanner.next();
                        if (accounts.get(checkAccountNumber).checkPassword(inputPassword)) {
                            accounts.get(checkAccountNumber).checkBalance();
                        } else {
                            System.out.println("Invalid password.");
                        }
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 5:
                    System.out.println("<---Visit Again---> \n <---Thank You--->");
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
