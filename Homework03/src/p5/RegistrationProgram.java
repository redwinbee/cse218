package p5;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import p5.model.Account;
import p5.persistence.Storage;

import java.util.ArrayList;

public class RegistrationProgram extends Application {
    private ArrayList<Account> accounts = new ArrayList<>();
    private BorderPane root;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        if (Storage.ACCOUNTS_FILE.exists()) {
            accounts = Storage.restore();
        }
    }

    @Override
    public void start(Stage primaryStage) {
        root = new BorderPane();
        root.setCenter(signInView());
        root.setPadding(new Insets(10, 10, 10, 10));

        primaryStage.setOnCloseRequest(event -> Storage.backup(accounts));
        primaryStage.setScene(new Scene(root, 300, 350));
        primaryStage.setTitle("Registration Program");
        primaryStage.show();
    }

    @SuppressWarnings("Duplicates")
    private VBox signInView() {
        VBox box = new VBox(15);
        box.setAlignment(Pos.CENTER);

        HBox userNameBox = new HBox(15);
        TextField userNameField = new TextField();
        userNameBox.getChildren().addAll(new Label("Username:"), userNameField);
        HBox passwordBox = new HBox(15);
        PasswordField passwordField = new PasswordField();
        passwordBox.getChildren().addAll(new Label("Password:"), passwordField);

        HBox buttonBox = new HBox(15);
        buttonBox.setAlignment(Pos.CENTER);
        Button signInBtn = new Button("Sign In");
        signInBtn.setDefaultButton(true);
        Label successLabel = new Label();
        signInBtn.setOnAction(event -> {
            boolean successful = onSignIn(userNameField.getText(), passwordField.getText());
            if (successful) {
                successLabel.setText("SUCCESS");
            } else {
                successLabel.setText("FAILED");
            }
        });
        Button signUpButton = new Button("Sign Up");
        signUpButton.setOnAction(event -> onSignUp());
        buttonBox.getChildren().addAll(signInBtn, signUpButton);

        box.getChildren().addAll(userNameBox, passwordBox, buttonBox, successLabel);
        return box;
    }

    @SuppressWarnings("Duplicates")
    private VBox signUpView() {
        VBox box = new VBox(15);
        box.setAlignment(Pos.CENTER);

        HBox emailBox = new HBox(15);
        TextField emailField = new TextField();
        emailBox.getChildren().addAll(new Label("Email:"), emailField);
        HBox userNameBox = new HBox(15);
        TextField userNameField = new TextField();
        userNameBox.getChildren().addAll(new Label("Username:"), userNameField);
        HBox passwordBox = new HBox(15);
        PasswordField passwordField = new PasswordField();
        passwordBox.getChildren().addAll(new Label("Password:"), passwordField);

        HBox buttonBox = new HBox(15);
        buttonBox.setAlignment(Pos.CENTER);
        Button createButton = new Button("Create");
        createButton.setDefaultButton(true);
        Label successLabel = new Label();
        createButton.setOnAction(event -> {
            boolean successful = onClickCreate(emailField.getText(), userNameField.getText(), passwordField.getText());
            if (successful) {
                successLabel.setText("Created!");
            } else {
                successLabel.setText("FAILED: Email/Username already taken.");
            }
        });
        Button backButton = new Button("Back");
        backButton.setOnAction(event -> root.setCenter(signInView()));
        buttonBox.getChildren().addAll(createButton, backButton);

        box.getChildren().addAll(emailBox, userNameBox, passwordBox, buttonBox, successLabel);
        return box;
    }


    private boolean onSignIn(String username, String password) {
        return accounts.stream().anyMatch(account -> account.getUsername().equals(username) && account.getPassword().equals(password));
    }

    private void onSignUp() {
        root.setCenter(signUpView());

    }

    private boolean onClickCreate(String email, String username, String password) {
        if (accounts.stream().noneMatch(account -> account.getEmail().equals(email) && account.getUsername().equals(username))) {
            Account account = new Account(email, username, password);
            accounts.add(account);
            return true;
        }

        return false;
    }
}
