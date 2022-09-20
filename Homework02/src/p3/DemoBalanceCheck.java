package p3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Stack;

public class DemoBalanceCheck extends Application {
    private VBox root;
    private Label checkedLabel;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        buildStage();
        primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.setTitle("BalanceChecker");
        primaryStage.show();
    }

    private void buildStage() {
        root = new VBox(10);
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setAlignment(Pos.CENTER);
        TextArea codeTextArea = new TextArea();
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);
        Button checkButton = new Button("Check");
        checkButton.setOnAction(event -> checkBalance(codeTextArea.getText().strip().toCharArray()));
        checkedLabel = new Label("None");
        hBox.getChildren().addAll(checkButton, checkedLabel);
        root.getChildren().addAll(codeTextArea, hBox);
    }

    private void checkBalance(char[] sample) {
        Stack<Character> stack = new Stack<>();
        for (char c : sample) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            if (c == ')' || c == ']' || c == '}') {
                stack.pop();
            }
        }

        checkedLabel.setText((stack.isEmpty() ? "TRUE" : "FALSE"));
    }
}
