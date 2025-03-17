package model;

import java.time.LocalDate;

public class Transaction {

    private final LocalDate date;
    private float sum;
    private String transactionStatus;
    BudgetHandler.TransactionType transactionType;
    private String category;

    public Transaction(float sum, BudgetHandler.TransactionType transactionType, String category){
        this.sum = sum;
        this.transactionStatus = "Accepted";
        this.transactionType = transactionType;
        if (transactionType.equals("REFILL")) {
            this.category = "No category";
        }
        else {
            this.category = category;
        }
        this.date = LocalDate.now();
    }

    // Getters & Setters
    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }

    public BudgetHandler.TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(BudgetHandler.TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public String getCategory(){
        return this.category;
    }

    public LocalDate getDate() {
        return this.date;
    }
    public String getTransactionStatus(){
        return this.transactionStatus;
    }

    public void setTransactionStatus(String transactionStatus) {
        this.transactionStatus = transactionStatus;
    }
}
