import javafx.application.Application;
import javafx.stage.Stage;
import model.Account;
import persistence.Storage;

import java.util.HashSet;

public class App extends Application {
    private HashSet<Account> accounts = new HashSet<>();

    @Override
    public void init() throws Exception {
        if (Storage.ACCOUNTS_FILE.exists()) {
            accounts = (HashSet<Account>) Storage.restore();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setOnCloseRequest(event -> Storage.backup(accounts));
        primaryStage.setTitle("BermudesFinalProject");
        primaryStage.show();
    }
}
