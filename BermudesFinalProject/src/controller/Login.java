package controller;

import app.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import util.ViewFinder;

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
    private Label statusLabel;

    @FXML
    public void handleLogin(ActionEvent actionEvent) {
        App.getAccountsManager()
                .verifyCredentials(userNameField.getText(), passwordField.getText())
                .ifPresentOrElse(acc -> App.changeView(ViewFinder.get("home")), () -> {
                    statusLabel.setTextFill(Color.RED);
                    statusLabel.setText("Invalid username/password!");
                });
    }

    @FXML
    public void handleRegister(ActionEvent actionEvent) {
        App.changeView(ViewFinder.get("register"));
    }
}
