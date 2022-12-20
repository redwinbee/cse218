package app;

import atlantafx.base.theme.NordLight;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import persistence.AccountsManager;
import persistence.Storage;
import util.ViewFinder;
import util.ViewFinder.ViewKey;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.TreeMap;

public class App extends Application {
    /**
     * The number of accounts that should be created when reconstructing a random AccountsManager
     **/
    public static final int MAX_ACCOUNTS = 1_000;
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

    public static void setAccountsManager(AccountsManager accountsManager) {
        App.accountsManager = accountsManager;
        Storage.backup(accountsManager);
    }

    public static Node getPrimaryStage() {
        return primaryStage.getScene().getRoot();
    }

    @Override
    public void init() {
        accountsManager = Storage.ACCOUNTS_FILE.exists() ? Storage.restore() : new AccountsManager(new TreeMap<>());
        Objects.requireNonNull(accountsManager).display();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Application.setUserAgentStylesheet(new NordLight().getUserAgentStylesheet());
        Parent root = FXMLLoader.load(ViewFinder.get(ViewKey.LOGIN));
        stage.setOnCloseRequest(event -> Storage.backup(accountsManager));
        stage.setTitle("BermudesFinalProject");
        stage.setScene(new Scene(root));
        stage.show();

        primaryStage = stage;
    }
}