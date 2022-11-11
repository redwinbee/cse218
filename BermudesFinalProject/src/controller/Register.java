package controller;

import app.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import model.Account;
import model.Name;

public class Register {
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


    @FXML
    public void handleRegister(ActionEvent actionEvent) {
        // TODO move all this into the AccountsManager after verifying it works, with more checks too...
        Name name = new Name(firstNameField.getText(), lastNameField.getText());
        String userName = userNameField.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        Account created = new Account(name, userName, email, password);
        if (!App.getAccountsManager().exists(userName, email)) {
            App.getAccountsManager().add(created);
            statusLabel.setTextFill(Color.GREEN);
            statusLabel.setText("Account created!");
        } else {
            statusLabel.setTextFill(Color.RED);
            statusLabel.setText("Username/email already in use!");
        }
    }

    @FXML
    public void handleBack(ActionEvent actionEvent) {
        App.changeView("../fxml/login.fxml");
    }
}
