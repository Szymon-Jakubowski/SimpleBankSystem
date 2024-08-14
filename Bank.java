import java.util.HashMap;
import java.util.Map;

class Bank {
    private final Map<String, BankAccount> accounts;

    public Bank() {
        accounts = new HashMap<>();
    }

    public void createAccount(String accountNumber) {
        if (!accounts.containsKey(accountNumber)) {
            accounts.put(accountNumber, new BankAccount(accountNumber));
            System.out.println("Account created: " + accountNumber);
        } else {
            System.out.println("Account with number " + accountNumber + " already exists.");
        }
    }

    public BankAccount findAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }
}