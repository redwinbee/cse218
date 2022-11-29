package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import persistence.AccountsManager;
import persistence.Storage;
import util.ViewFinder;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.TreeSet;

public class App extends Application {
    private static Stage primaryStage;
    private static AccountsManager accountsManager;

    public static void main(String[] args) {
        launch(args);
    }

    public static void changeView(URL resource) {
        try {
            Parent parent = FXMLLoader.load(resource);
            primaryStage.setScene(new Scene(parent));
        } catch (IOException ex) {
            // this is fatal
            ex.printStackTrace();
        }
    }

    public static AccountsManager getAccountsManager() {
        return accountsManager;
    }

    @Override
    public void init() throws Exception {
        accountsManager = Storage.ACCOUNTS_FILE.exists() ? Storage.restore() : new AccountsManager(new TreeSet<>());
        Objects.requireNonNull(accountsManager).display();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(ViewFinder.get("login"));
        stage.setOnCloseRequest(event -> Storage.backup(accountsManager));
        stage.setTitle("BermudesFinalProject");
        stage.setScene(new Scene(root));
        stage.show();

        primaryStage = stage;
    }
}