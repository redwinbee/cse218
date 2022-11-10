package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import persistence.AccountsManager;
import persistence.Storage;

import java.util.Objects;
import java.util.TreeSet;

public class App extends Application {
    private static AccountsManager accountsManager;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        accountsManager = Storage.ACCOUNTS_FILE.exists() ? Storage.restore() : new AccountsManager(new TreeSet<>());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../fxml/login.fxml")));
        primaryStage.setOnCloseRequest(event -> Storage.backup(accountsManager));
        primaryStage.setTitle("BermudesFinalProject");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static AccountsManager getAccountsManager() {
        return accountsManager;
    }
}