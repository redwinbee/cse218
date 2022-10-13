package p1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import p1.obj.MainLinkedList;

import java.io.File;
import java.util.LinkedList;

public class Main extends Application {
    private static final File TEXT_FILE = new File("data/blowingInTheWind.txt");
    private static final File OUT_FILE = new File("data/output.txt");
    private VBox container;
    private TextArea generatedParagraph;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        buildStage();

        primaryStage.setScene(new Scene(container, 500, 350));
        primaryStage.setTitle("Homework05");
        primaryStage.show();
    }

    private void buildStage() {
        container = new VBox();
        container.setAlignment(Pos.CENTER);
        container.setSpacing(10);
        container.setPadding(new Insets(10, 10, 10, 10));

        HBox inputs = new HBox();
        inputs.setAlignment(Pos.CENTER);
        inputs.setSpacing(10);
        TextField wordField = new TextField();
        wordField.setPromptText("Word");
        TextField numWordsInPara = new TextField();
        numWordsInPara.setPromptText("# Of Words");
        Button process = new Button("Construct");
        process.setOnAction(event -> constructParagraph(wordField.getText(), Integer.parseInt(numWordsInPara.getText())));
        inputs.getChildren().addAll(wordField, numWordsInPara, process);

        generatedParagraph = new TextArea();
        container.getChildren().addAll(inputs, generatedParagraph);
    }

    private void constructParagraph(String word, int numWords) {
        Parser parser = new Parser(TEXT_FILE);
        MainLinkedList list = parser.construct();

        StringBuilder sb = new StringBuilder();
        String next = list.search(word).getValue();
        sb.append(next).append(" ");
        for (int i = 0; i < numWords - 1; i++) {
            LinkedList<String> children = list.search(next).getChildren();
            String randChild = children.get((int) (Math.random() * children.size()));
            sb.append(randChild);
            sb.append(" ");
            next = randChild;
        }

        generatedParagraph.setText(sb.toString());
    }
}
