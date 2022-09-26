package p4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PrioritizedStudentEnrollment extends Application {
    private final PriorityQueue<Student> students = new PriorityQueue<>(Comparator.comparingDouble(Student::getGpa));

    private BorderPane root;
    private TextField name;
    private TextField phone;
    private TextField gpa;
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

    @SuppressWarnings("Duplicates")
    private VBox registrationView() {
        VBox box = new VBox(10);
        box.setAlignment(Pos.CENTER);

        // fields
        HBox inputs = new HBox(10);
        name = new TextField();
        phone = new TextField();
        gpa = new TextField();
        inputs.getChildren().addAll(new Label("Name:"), name);
        inputs.getChildren().addAll(new Label("Phone:"), phone);
        inputs.getChildren().addAll(new Label("GPA:"), gpa);

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

    @SuppressWarnings("Duplicates")
    private VBox processView() {
        VBox box = new VBox(10);
        box.setAlignment(Pos.CENTER);

        HBox admittedBox = new HBox(10);
        admittedArea = new TextArea();
        admittedBox.getChildren().addAll(new Label("Admitted:"), admittedArea);

        HBox waitingBox = new HBox(10);
        waitingArea = new TextArea();
        waitingBox.getChildren().addAll(new Label("Waiting:"), waitingArea);

        box.getChildren().addAll(admittedBox, waitingBox);
        return box;
    }

    private void addStudent() {
        Student student = new Student(name.getText(), phone.getText(), Double.parseDouble(gpa.getText()));
        if (students.offer(student)) {
            name.clear();
            phone.clear();
            gpa.clear();
        }
    }

    @SuppressWarnings("Duplicates")
    private void processStudents() {
        root.setCenter(processView());

        for (int i = 0; i < 2; i++) {
            Student polled = students.poll();
            if (polled != null) {
                waitingArea.appendText(polled + "\n");
            }
        }

        for (int i = 0; i <= students.size(); i++) {
            Student next = students.poll();
            admittedArea.appendText(next + "\n");
        }
    }
}
