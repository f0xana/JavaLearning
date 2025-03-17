package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.BudgetHandler;
import model.Transaction;
import screens.BudgetScreen;

import java.util.List;

public class BudgetHandlerController {
    private BudgetScreen view;
    private BudgetHandler model;

    public BudgetHandlerController(BudgetScreen view, BudgetHandler model) {
        this.view = view;
        this.model = model;

        view.getAddTransactionButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                handleCreateTransactionClick();
            }
        });

        view.getTransactionTypeComboBox().setOnAction(e -> {
            String dropdownValue = (String) view.getTransactionTypeComboBox().getValue();
            if (dropdownValue.equalsIgnoreCase("Refill")){
                view.getCategoryComboBox().setDisable(true);
            }
            else {
                view.getCategoryComboBox().setDisable(false);
            }
        });
    }

    private void handleCreateTransactionClick() {
        System.out.println("Create transaction button is clicked!");
        try {
            float sumToAdd = Float.parseFloat(view.getSumField().getText());
            String transactionType = (String) view.getTransactionTypeComboBox().getValue();
            String categoryType = (String) view.getCategoryComboBox().getValue();

            // Manual mapping to Enum
            BudgetHandler.TransactionType type = transactionType.equalsIgnoreCase("Refill") ?
                    BudgetHandler.TransactionType.REFILL : BudgetHandler.TransactionType.EXPENSE;

            Transaction newTransaction = new Transaction(sumToAdd, type, categoryType);
            System.out.println("New Transaction: " + newTransaction);

            model.addTransaction(newTransaction);
            view.getTotalAccountStatement().setText("You have " + model.getBudget() + " euros on your account");


            List<Transaction> transactions = model.getTransactions();
            System.out.println("Stored Transactions: " + transactions.size());
            for (Transaction t : transactions) {
                System.out.println("Transaction: " + t);
            }

            StringBuilder transactionText = new StringBuilder();
            for (Transaction transaction : transactions) {
                transactionText.append(transaction.getTransactionStatus() + " "
                        + transaction.getSum() + " "
                        + transaction.getTransactionType() + " "
                        + transaction.getCategory() + " "
                        + transaction.getDate().toString()).append("\n");
            }

            view.getTransactionList().setText(transactionText.toString());
            System.out.println("Updated transaction label: " + view.getTransactionList().getText());


        } catch (NumberFormatException e) {
            System.out.println("Not a good value, try again with numbers.");
        }
    }
}
