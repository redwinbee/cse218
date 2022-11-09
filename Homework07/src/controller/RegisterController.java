package controller;

import app.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Account;
import model.Name;
import persistence.AccountsManager;

public class RegisterController {
    private final AccountsManager accountsManager = App.getStorageManager();
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField email;
    @FXML
    private TextField userName;
    @FXML
    private TextField password;
    @FXML
    private Button create;
    @FXML
    private Button back;
    @FXML
    private Label createStatus;

    public void onCreate() {
        Name name = new Name(firstName.getText(), lastName.getText());
        Account account = new Account(email.getText(), name, userName.getText(), password.getText());
        if (!accountsManager.exists(account)) {
            accountsManager.add(account);
            createStatus.setStyle("-fx-text-fill: #10b90c");
            createStatus.setText("Account created!");
            createStatus.setVisible(true);
            clearFields();
        } else {
            createStatus.setStyle("-fx-text-fill: #c00808");
            createStatus.setText("Email/username already in use");
            createStatus.setVisible(true);
        }
    }

    public void onBack() {
        App.changeView("../view/login.fxml");
    }

    private void clearFields() {
        firstName.clear();
        lastName.clear();
        email.clear();
        userName.clear();
        password.clear();
    }
}
