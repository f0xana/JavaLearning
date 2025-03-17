package model;

import java.util.ArrayList;
import java.util.List;

public class BudgetHandler {
    private float budgetSum;
    private List<Transaction> transactions; // Store transactions

    public enum TransactionType {
        REFILL, EXPENSE
    }

    // Constructor
    public BudgetHandler() {
        this.budgetSum = 0;
        this.transactions = new ArrayList<>(); // Initialize list
    }

    public float getBudget() {
        return budgetSum;
    }

    public void addTransaction(Transaction transaction) {
        float transactionAmount = 0;
        if(transaction.getTransactionType() == TransactionType.EXPENSE && this.budgetSum < transaction.getSum()){
            System.out.println("Transaction is impossible! The expense exceeds your budget!");
            transaction.setTransactionStatus("Declined");
            transaction.setSum(0);
        } else if (transaction.getTransactionType() == TransactionType.EXPENSE) {
            transactionAmount = -transaction.getSum();
        } else {
            transactionAmount = transaction.getSum();
        }
        this.budgetSum += transactionAmount;

        this.transactions.add(transaction);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
