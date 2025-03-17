import controller.BudgetHandlerController;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import model.BudgetHandler;
import screens.BudgetScreen;
import screens.ExpensesScreen;
import screens.SettingsScreen;

import java.net.URL;

public class Main extends Application {

    /*
    #0d0d0d - black
    #D92323; - red
    #732424 - dark red
    #8c6723 - golden
    #f2e852 - yellow
    */

    @Override
    public void start(Stage primaryStage) {
        // Side menu area
        VBox sideMenu = new VBox();
        Font customFont = Font.loadFont(getClass().getResourceAsStream("resources/fonts/Expose-Regular.otf"), 20);

        String permanentStyle = "-fx-font-size: 15pt; " +
                "-fx-font-family: '" + customFont.getName() + "'; " +
                "-fx-text-fill: white; " +
                "-fx-background-color: transparent;";

        sideMenu.setStyle("-fx-background-color: #000000; -fx-padding: 10px;");
        sideMenu.setPrefWidth(200);

        //Creating Avatar
        Image avatar = new Image(getClass().getResourceAsStream("resources/images/avatar.jpg"));
        ImageView avatarView = new ImageView(avatar);
        avatarView.setFitWidth(100);
        avatarView.setFitHeight(100);
        avatarView.setPreserveRatio(true);

        // Create circular clip
        Circle clip = new Circle(30);
        clip.setCenterX(50);
        clip.setCenterY(50);
        avatarView.setClip(clip);

        Label nameLabel = new Label("@Joker");

        VBox userBox = new VBox();
        userBox.getChildren().addAll(avatarView, nameLabel);
        userBox.setAlignment(Pos.BASELINE_CENTER);

        Button myBudgetButton = createStyledButton("My Budget", customFont, permanentStyle);
        Button myExpensesButton = createStyledButton("My Expenses", customFont, permanentStyle);
        Button mySettingsButton = createStyledButton("Settings", customFont, permanentStyle);

        sideMenu.getChildren().addAll(userBox, myBudgetButton, myExpensesButton, mySettingsButton);
        sideMenu.setAlignment(Pos.BASELINE_CENTER);

        StackPane dynamicContent = new StackPane();
        dynamicContent.setStyle("-fx-background-color: #D92323;");

        myBudgetButton.setOnAction(e -> switchContent(dynamicContent, "My Budget"));
        myExpensesButton.setOnAction(e -> switchContent(dynamicContent, "My Expenses"));
        mySettingsButton.setOnAction(e -> switchContent(dynamicContent, "Settings"));

        // Layout setup using BorderPane
        BorderPane layout = new BorderPane();
        layout.setLeft(sideMenu); // Attach side menu to the left
        layout.setCenter(dynamicContent); // Attach dynamic content to the center

        // Scene setup
        Scene scene = new Scene(layout, 1100, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("My Budget");
        primaryStage.show();
    }

    private Button createStyledButton(String text, Font font, String style){
        Button button = new Button(text);
        button.setFont(font);
        button.setStyle(style);
        button.setPrefSize(150, 50);

        // Hover effects
        button.setOnMouseEntered(e -> button.setStyle(style + "-fx-text-fill: #D92323;"));
        button.setOnAction(e -> button.setStyle(style + "-fx-text-fill: #D92323;"));
        button.setOnMouseExited(e -> button.setStyle(style));
        return button;
        }

    private void switchContent(StackPane dynamicContent, String screenName) {
        dynamicContent.getChildren().clear();  // Clear previous content

        switch (screenName) {
            case "My Budget":
                dynamicContent.getChildren().add(createBudgetScreen());
                break;
            case "My Expenses":
                dynamicContent.getChildren().add(createExpensesScreen());
                break;
            case "Settings":
                dynamicContent.getChildren().add(createSettingsScreen());
                break;
            default:
                System.out.println("Invalid screen name: " + screenName);
        }
    }

    private StackPane createBudgetScreen() {
        // Budget Screen Setup
        BudgetHandler model = new BudgetHandler();
        BudgetScreen view = new BudgetScreen();
        new BudgetHandlerController(view, model);

        StackPane budgetScreen = new StackPane();
        budgetScreen.getChildren().add(view);
        return budgetScreen;
    }

    private StackPane createExpensesScreen() {
        // Expenses Screen Setup (for now, a placeholder screen)
        ExpensesScreen expensesScreen = new ExpensesScreen();
        StackPane expensesPane = new StackPane();
        expensesPane.getChildren().add(expensesScreen);
        return expensesPane;
    }

    private StackPane createSettingsScreen() {
        // Settings Screen Setup (for now, a placeholder screen)
        SettingsScreen settingsScreen = new SettingsScreen();
        StackPane settingsPane = new StackPane();
        settingsPane.getChildren().add(settingsScreen);
        return settingsPane;
    }

    public static void main(String[] args) {
        launch(args);
    }
}