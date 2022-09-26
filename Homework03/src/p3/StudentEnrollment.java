package p3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.concurrent.ArrayBlockingQueue;

public class StudentEnrollment extends Application {
    private final ArrayBlockingQueue<Student> students = new ArrayBlockingQueue<>(10);

    private BorderPane root;
    private TextField name;
    private TextField phone;
    private DatePicker regDate;
    private TextArea admittedArea;
    private TextArea waitingArea;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        root = new BorderPane();
        root.setPadding(new Insets(10, 10, 10, 10));
        root.setCenter(registrationView());

        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Student Enrollment");
        primaryStage.show();
    }

    private VBox registrationView() {
        VBox box = new VBox(10);
        box.setAlignment(Pos.CENTER);

        // fields
        HBox inputs = new HBox(10);
        name = new TextField();
        phone = new TextField();
        regDate = new DatePicker();
        inputs.getChildren().addAll(new Label("Name:"), name);
        inputs.getChildren().addAll(new Label("Phone:"), phone);
        inputs.getChildren().addAll(new Label("Reg. Date:"), regDate);

        // buttons
        HBox buttons = new HBox(10);
        buttons.setAlignment(Pos.CENTER);
        Button addButton = new Button("Add");
        addButton.setOnAction(event -> addStudent());
        Button processButton = new Button("Process");
        processButton.setOnAction(event -> processStudents());
        buttons.getChildren().addAll(addButton, processButton);

        box.getChildren().addAll(inputs, buttons);
        return box;
    }

    private VBox processView() {
        VBox box = new VBox(10);
        box.setAlignment(Pos.CENTER);

        HBox textAreas = new HBox(10);
        admittedArea = new TextArea();
        waitingArea = new TextArea();
        textAreas.getChildren().addAll(admittedArea, waitingArea);

        box.getChildren().addAll(textAreas);
        return box;
    }

    private void addStudent() {
        Student student = new Student(name.getText(), phone.getText(), regDate.getValue());
        if (students.offer(student)) {
            name.clear();
            phone.clear();
            regDate.setValue(null);
        }
    }

    private void processStudents() {
        root.setCenter(processView());

        for (int i = 0; i < 2; i++) {
            Student polled = students.poll();
            if (polled != null) {
                admittedArea.appendText(polled + "\n");
            }
        }

        for (int i = 0; i <= students.size(); i++) {
            Student next = students.poll();
            waitingArea.appendText(next + "\n");
        }
    }
}
