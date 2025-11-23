import java.util.ArrayList;
import java.util.List;

public class Account {

    // we make these fields private so that other class dont access them
    private int balance;
    private List<String> transactionHistory;

    public Account() {
        this.balance = 0;
        this.transactionHistory = new ArrayList<>();
    }

    // to deposit money into amount
    public void deposit(int amount) {

        // to check if our amount is correct or not
        if (Validation.isPositive(amount)) {
            // we add our amount to our bank balance
            balance = balance + amount;

            // message to user
            System.out.println("Amount successfully deposited.\nCurrent balance: " + balance + "rs");

            // to maintain history
            addTransaction("Deposited: " + amount + "rs.\n Current amount: " + balance + "rs");
        }
    }

    // to withdraw money from account
    public void withdraw(int amount) {

        // to check if our amount is correct or not
        if (Validation.isPositive(amount)) {

            // 1st we check if our amount has sufficient balance or not
            if (amount <= balance) {
                balance = balance - amount;

                // message to user
                System.out.println("Amount successfully withdrawn.\nCurrent balance: " + balance);

                // to maintain history
                addTransaction("Withdrawn: " + amount + "rs.\n Current amount: " + balance + "rs");
            } else {

                // transaction failed
                System.out.println("Not sufficient balance!!!");
            }
        }
    }

    // to add transaction for reviewing
    public void addTransaction(String transactionMsg) {

        // we add transaction into the list with a message
        transactionHistory.add(transactionMsg);
    }

    // to get balance
    public int getBalance() {
        return balance;
    }

    // to get whole transactional history
    public List<String> getTransactionHistory() {
        return transactionHistory;
    }
}
