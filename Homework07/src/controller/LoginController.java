package controller;

import app.App;
import controller.home.HomeController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Account;

import java.io.IOException;
import java.util.Optional;

public class LoginController {
    @FXML
    private Label loginStatus;
    @FXML
    private TextField email;
    @FXML
    private TextField password;

    @FXML
    private void onLogin() {
        Optional<Account> account = App.getStorageManager().all().stream()
                .filter(acc -> acc.getUsername().equals(email.getText()) && acc.getPassword().equals(password.getText()))
                .findFirst();

        if (account.isPresent()) {
            try {
                FXMLLoader loader = new FXMLLoader(App.class.getResource("../view/home/home.fxml"));
                loader.load();
                HomeController controller = loader.getController();
                controller.initData(account.get());
                App.changeView("../view/home/home.fxml");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void onRegister() {
        App.changeView("../view/register.fxml");
    }
}
