package controller;

import app.App;
import javafx.event.ActionEvent;
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

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class Register implements Initializable {
    private Validator validator = new Validator();
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
                .dependsOn("username", userNameField.textProperty())
                .dependsOn("email", emailField.textProperty())
                .withMethod(c -> {
                    if (App.getAccountsManager().exists(userNameField.getText(), emailField.getText())) {
                        c.error("Username/email already in use");
                    }
                })
                .decorates(userNameField)
                .decorates(emailField)
                .immediate();
    }

    @FXML
    public void handleRegister(ActionEvent actionEvent) {
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
    public void handleBack(ActionEvent actionEvent) {
        App.changeView("../fxml/login.fxml");
    }
}
