package controller;

import app.App;
import controller.home.Home;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import persistence.Generator;
import util.ViewFinder;

public class Login {
    public Button reconstruct;
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

    public void onReconstruct() {
        System.out.println("[info]: reconstructing accounts manager with random values...");
        App.setAccountsManager(Generator.generate(App.NUM_RANDOM_ACCOUNTS));
        statusLabel.setTextFill(Color.RED);
        statusLabel.setText("Reconstructed with " + App.NUM_RANDOM_ACCOUNTS + " accounts");
        reconstruct.setDisable(true);
    }

    @FXML
    public void handleLogin() {
        App.getAccountsManager()
                .verifyCredentials(userNameField.getText(), passwordField.getText())
                .ifPresentOrElse(acc -> {
                    Home.setContext(acc);
                    App.changeView(ViewFinder.get("home"));
                }, () -> {
                    statusLabel.setTextFill(Color.RED);
                    statusLabel.setText("Invalid username/password!");
                });
    }

    @FXML
    public void handleRegister() {
        App.changeView(ViewFinder.get("register"));
    }
}
