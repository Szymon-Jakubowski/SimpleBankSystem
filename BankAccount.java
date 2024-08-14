class BankAccount {
    private final String accountNumber;
    private double balance;

    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + " USD. New balance: " + balance + " USD.");
        } else {
            System.out.println("Deposit amount must be greater than zero.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrew: " + amount + " USD. New balance: " + balance + " USD.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public void transfer(BankAccount targetAccount, double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            targetAccount.deposit(amount);
            System.out.println("Transferred: " + amount + " USD from account " + accountNumber + " to account " + targetAccount.getAccountNumber());
        } else {
            System.out.println("Transfer failed. Check balance and transfer amount.");
        }
    }
}