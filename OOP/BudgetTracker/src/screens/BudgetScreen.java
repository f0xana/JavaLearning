package screens;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class BudgetScreen extends VBox {

    TextField sumTextField = new TextField();
    final ComboBox<String> transactionTypeComboBox = new ComboBox<String>();

    ComboBox<String> categoryComboBox = new ComboBox<String>();

    Button addTransactionButton = new Button("Add transaction");

    Label totalAccountStatement = new Label();
    Label transactionList = new Label();


    public BudgetScreen() {
        totalAccountStatement.setStyle("-fx-text-fill: white;");
        transactionTypeComboBox.getItems().addAll(
                "REFILL",
                "EXPENSE"
        );

        categoryComboBox.getItems().addAll(
                "Transport",
                "Food",
                "Appartment",
                "Loisir"
        );

        //Add the box to display total account statement
        setAlignment(Pos.CENTER);
        VBox budgetBoxBorder = new VBox();
        budgetBoxBorder.setStyle("-fx-background-color: white; -fx-padding: 20px; -fx-alignment: center;");
        budgetBoxBorder.setSpacing(10);
        budgetBoxBorder.setPrefHeight(150);
        budgetBoxBorder.setMaxWidth(850);
        budgetBoxBorder.setAlignment(Pos.CENTER);

        VBox budgetBox = new VBox();
        budgetBox.setStyle("-fx-background-color: black; -fx-padding: 20px; -fx-alignment: center;");
        budgetBox.setSpacing(10);
        budgetBox.setPrefHeight(130);
        budgetBox.setMaxWidth(830);
        budgetBox.setAlignment(Pos.CENTER);

        budgetBox.getChildren().add(totalAccountStatement);
        budgetBoxBorder.getChildren().add(budgetBox);

        //Add the box to display the transaction statement and transaction form
        HBox transactionBox = new HBox();
        transactionBox.setSpacing(10);
        transactionBox.setPrefHeight(350);
        transactionBox.setMaxWidth(850);
        transactionBox.setAlignment(Pos.CENTER);

        // Add transaction list region
        VBox transactionListBoxBorder = new VBox();
        transactionListBoxBorder.setStyle("-fx-background-color: white; -fx-padding: 20px; -fx-alignment: center;");
        transactionListBoxBorder.setSpacing(10);
        transactionListBoxBorder.setPrefHeight(300);
        transactionListBoxBorder.setPrefWidth(580);
        transactionListBoxBorder.setAlignment(Pos.BASELINE_LEFT);

        VBox transactionListBox = new VBox();
        transactionListBox.setStyle("-fx-background-color: black; -fx-padding: 20px; -fx-alignment: center;");
        transactionListBox.setSpacing(10);
        transactionListBox.setPrefHeight(300);
        transactionListBox.setPrefWidth(550);
        transactionListBox.setAlignment(Pos.CENTER);

        transactionListBox.getChildren().add(transactionList);
        transactionListBoxBorder.getChildren().add(transactionListBox);

        for (Node node : transactionListBox.getChildren()) {
            if (node instanceof Label) {
                ((Label) node).setStyle("-fx-font-size: 14px; -fx-text-fill: white; -fx-font-weight: bold;");
            }
        }

        // Add transaction list form
        VBox transactionFormBox = new VBox();
        transactionFormBox.setStyle("-fx-background-color: white; -fx-padding: 20px; -fx-alignment: center;");
        transactionFormBox.setSpacing(10);
        transactionFormBox.setPrefHeight(300);
        transactionFormBox.setPrefWidth(280);
        transactionFormBox.setAlignment(Pos.BASELINE_RIGHT);

        VBox transactionForm = new VBox();
        transactionForm.setStyle("-fx-background-color: black; -fx-padding: 20px; -fx-alignment: center;");
        transactionForm.setSpacing(10);
        transactionForm.setPrefHeight(300);
        transactionForm.setPrefWidth(250);
        transactionForm.setAlignment(Pos.CENTER);

        GridPane transactionFormGrid = new GridPane();

        transactionFormGrid.setVgap(10);  // Adds vertical space between rows
        transactionFormGrid.setHgap(10);

        transactionFormGrid.add(new Label("Sum"), 0, 0);
        transactionFormGrid.add(sumTextField, 1, 0);
        transactionFormGrid.add(new Label("Type"), 0, 1);
        transactionFormGrid.add(transactionTypeComboBox, 1, 1);
        transactionFormGrid.add(new Label("Category"), 0, 2);
        transactionFormGrid.add(categoryComboBox, 1, 2);
        transactionFormGrid.add(addTransactionButton, 1, 5);

        for (Node node : transactionFormGrid.getChildren()) {
            if (node instanceof Label) {
                ((Label) node).setStyle("-fx-font-size: 14px; -fx-text-fill: white; -fx-font-weight: bold;");
            }
        }

        //Add the spacer between the two main regions
        Region spacerH = new Region();
        spacerH.setPrefWidth(20);

        transactionForm.getChildren().add(transactionFormGrid);
        transactionFormBox.getChildren().add(transactionForm);
        transactionBox.getChildren().addAll(transactionListBoxBorder, spacerH, transactionFormBox);

        //Add the spacer between the two main regions
        Region spacerV = new Region();
        spacerV.setPrefHeight(20);

        getChildren().addAll(budgetBoxBorder, spacerV, transactionBox);
    }

        public TextField getSumField(){
            return sumTextField;
        }

        public ComboBox getTransactionTypeComboBox(){
            return transactionTypeComboBox;
        }

        public ComboBox getCategoryComboBox(){
            return categoryComboBox;
        }

        public Button getAddTransactionButton(){
            return addTransactionButton;
        }

        public Label getTotalAccountStatement(){
            return totalAccountStatement;
        }

        public Label getTransactionList(){
            return transactionList;
        }

}