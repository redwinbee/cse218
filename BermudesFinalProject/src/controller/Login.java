package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Login {
    @FXML
    private TextField userNameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button loginButton;
    @FXML
    private Button registerButton;

    @FXML
    public void handleLogin(ActionEvent actionEvent) {
        clearFields();
    }

    @FXML
    public void handleRegister(ActionEvent actionEvent) {
        clearFields();
    }

    private void clearFields() {
        userNameField.clear();
        passwordField.clear();
    }
}
