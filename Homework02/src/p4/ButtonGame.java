package p4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Stack;

public class ButtonGame extends Application {
    private final Stack<Button> buttonStack = new Stack<>();

    private VBox container;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        buildStage();

        primaryStage.setScene(new Scene(container));
        primaryStage.setTitle("Button Game");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void buildStage() {
        container = new VBox();
        container.setAlignment(Pos.CENTER);
        container.setSpacing(10);
        container.setPadding(new Insets(10, 10, 10, 10));

        Button undo = new Button("Undo");
        undo.setOnAction(event -> onUndo());
        GridPane board = new GridPane();
        board.setHgap(5);
        board.setVgap(5);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                Button button = new Button();
                button.setMinSize(100, 100);
                button.setOnAction(event -> onClick((Button) event.getSource()));
                button.setStyle("-fx-background-color: #000000; ");
                board.add(button, j, i);
            }
        }

        container.getChildren().addAll(undo, board);
    }

    private void onClick(Button button) {
        button.setStyle("-fx-background-color: #ff0000; ");
        button.setDisable(true);
        buttonStack.push(button);
    }

    private void onUndo() {
        if (buttonStack.isEmpty()) {
            TextField noMoreButtons = new TextField("No more buttons to revert to black.");
            noMoreButtons.setAlignment(Pos.CENTER);
            noMoreButtons.setPrefSize(210, 50);
            noMoreButtons.setEditable(false);

            Stage nothingToDoStage = new Stage(StageStyle.UTILITY);
            nothingToDoStage.setScene(new Scene(noMoreButtons));
            nothingToDoStage.setTitle("Cannot undo");
            nothingToDoStage.setResizable(false);
            nothingToDoStage.show();
            return;
        }
        Button undone = buttonStack.pop();
        undone.setStyle("-fx-background-color: #000000; ");
        undone.setDisable(false);
    }
}
