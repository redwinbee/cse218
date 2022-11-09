package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import persistence.AccountsManager;
import persistence.Storage;

import java.io.IOException;
import java.util.Objects;
import java.util.TreeSet;

public class App extends Application {
    private static Stage primaryStage;
    private static AccountsManager accountsManager;

    public static void changeView(String resource) {
        try {
            Parent parent = FXMLLoader.load(Objects.requireNonNull(App.class.getResource(resource)));
            primaryStage.setScene(new Scene(parent));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static AccountsManager getStorageManager() {
        return accountsManager;
    }

    @Override
    public void init() throws Exception {
        accountsManager = Storage.ACCOUNTS_FILE.exists() ? Storage.restore() : new AccountsManager(new TreeSet<>());
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../view/login.fxml")));
        stage.setOnCloseRequest(event -> Storage.backup(accountsManager));
        stage.setScene(new Scene(parent));
        stage.setTitle("Homework07");
        stage.show();

        primaryStage = stage;
    }
}
