package model;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TransactionTable {

    private TableView<Transaction> tableView;

    public TransactionTable() {
        this.tableView = new TableView<>();


    }

    public void setTableView(){
        TableColumn<Transaction, String> transactionStatusColumn = new TableColumn<>("Transaction Status");
        TableColumn<Transaction, String> sumColumn = new TableColumn<>("Money");
        TableColumn<Transaction, String> transactionTypeColumn = new TableColumn<>("Transaction Type");
        TableColumn<Transaction, String> transactionCategoryColumn = new TableColumn<>("Category");
        TableColumn<Transaction, String> dateColumn = new TableColumn<>("Date");

        this.tableView.getColumns().addAll(transactionStatusColumn, sumColumn, transactionTypeColumn, transactionCategoryColumn, dateColumn);
    }

    public TableView getTransactionTable(){
        return tableView;
    }
}
