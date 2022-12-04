package controller;

import app.App;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import model.Account;
import model.Name;
import net.synedra.validatorfx.Validator;
import util.ViewFinder;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class Register implements Initializable {
    private final Validator validator = new Validator();
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField userNameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button registerButton;
    @FXML
    private Button backButton;
    @FXML
    private Label statusLabel;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        validator.createCheck()
                .dependsOn("firstName", firstNameField.textProperty())
                .dependsOn("lastName", lastNameField.textProperty())
                .dependsOn("username", userNameField.textProperty())
                .dependsOn("email", emailField.textProperty())
                .dependsOn("password", passwordField.textProperty())
                .withMethod(c -> {
                    if (App.getAccountsManager().exists(userNameField.getText(), emailField.getText())) {
                        c.error("Username/email already in use");
                        registerButton.setDisable(true);
                    } else {
                        registerButton.setDisable(false);
                    }
                })
                .withMethod(c -> {
                    if (fieldsEmpty()) {
                        c.error("Please fill in this field");
                        registerButton.setDisable(true);
                    } else {
                        registerButton.setDisable(false);
                    }
                })
                .decorates(firstNameField)
                .decorates(lastNameField)
                .decorates(userNameField)
                .decorates(emailField)
                .decorates(passwordField);
    }

    @FXML
    public void handleRegister() {
        if (!validator.validate()) {
            registerButton.setDisable(false);
            return;
        }
        Name name = new Name(firstNameField.getText(), lastNameField.getText());
        String userName = userNameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        Optional<Account> created = App.getAccountsManager().create(name, userName, email, password);
        if (created.isPresent()) {
            statusLabel.setTextFill(Color.GREEN);
            statusLabel.setText("Account created!");
        } else {
            statusLabel.setTextFill(Color.RED);
            statusLabel.setText("Username/email already in use!");
        }
    }

    @FXML
    public void handleBack() {
        App.changeView(ViewFinder.get("login"));
    }

    private boolean fieldsEmpty() {
        return firstNameField.getText().isEmpty()
                || lastNameField.getText().isEmpty()
                || emailField.getText().isEmpty()
                || userNameField.getText().isEmpty()
                || passwordField.getText().isEmpty();
    }
}
