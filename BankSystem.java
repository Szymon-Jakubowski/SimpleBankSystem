import java.util.Scanner;

public class BankSystem {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);
        BankAccount account;
        String accountNumber;

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Create account");
            System.out.println("2. Deposit funds");
            System.out.println("3. Withdraw funds");
            System.out.println("4. Check balance");
            System.out.println("5. Transfer funds");
            System.out.println("6. Admin - Show funds of all accounts");
            System.out.println("7. Exit");

            int option = scanner.nextInt();
            scanner.nextLine();  // Clear the buffer

            switch (option) {
                case 1:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    bank.createAccount(accountNumber);
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    account = bank.findAccount(accountNumber);
                    if (account != null) {
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    account = bank.findAccount(accountNumber);
                    if (account != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawalAmount = scanner.nextDouble();
                        account.withdraw(withdrawalAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    account = bank.findAccount(accountNumber);
                    if (account != null) {
                        System.out.println("Account balance " + accountNumber + ": " + account.getBalance() + " USD.");
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter source account number: ");
                    String sourceAccountNumber = scanner.nextLine();
                    BankAccount sourceAccount = bank.findAccount(sourceAccountNumber);

                    if (sourceAccount != null) {
                        System.out.print("Enter target account number: ");
                        String targetAccountNumber = scanner.nextLine();
                        BankAccount targetAccount = bank.findAccount(targetAccountNumber);

                        if (targetAccount != null) {
                            System.out.print("Enter transfer amount: ");
                            double transferAmount = scanner.nextDouble();
                            sourceAccount.transfer(targetAccount, transferAmount);
                        } else {
                            System.out.println("Target account not found.");
                        }
                    } else {
                        System.out.println("Source account not found.");
                    }
                    break;
                case 6:
                    System.out.print("List of funds of all accounts: ");
                    bank.listAccounts();
                    break;
                case 7:
                    System.out.println("Program terminated.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }
}
