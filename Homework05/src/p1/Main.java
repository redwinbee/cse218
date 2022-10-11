package p1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

public class Main extends Application {
    private static final File TEXT_FILE = new File("data/blowingInTheWind.txt");
    private VBox container;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        buildStage();

        primaryStage.setScene(new Scene(container));
        primaryStage.setTitle("Homework05");
        primaryStage.show();
    }

    private void buildStage() {
        container = new VBox();
        container.setAlignment(Pos.CENTER);
        container.setSpacing(10);
        container.setPadding(new Insets(10, 10, 10, 10));
    }
}
