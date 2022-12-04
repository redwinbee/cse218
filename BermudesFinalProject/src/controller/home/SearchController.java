package controller.home;

import app.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import model.Account;
import util.ViewFinder;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class SearchController implements Initializable {
    private static Account context;
    @FXML
    private VBox resultsBox;
    @FXML
    private TextField searchField;
    @FXML
    private Button findButton;

    public static void setContext(Account context) {
        SearchController.context = context;
        SearchResultController.setContext(context);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void onFind() {
        clearResultsBox();
        App.getAccountsManager().all().stream()
                .filter(acc -> acc.getName().toString().toLowerCase().contains(searchField.getText().toLowerCase())
                        || acc.getUserName().toLowerCase().contains(searchField.getText().toLowerCase()))
                .forEach(acc -> loadAccountResult(acc).ifPresent(node -> resultsBox.getChildren().add(node)));
    }

    private Optional<Node> loadAccountResult(Account account) {
        try {
            FXMLLoader loader = new FXMLLoader(ViewFinder.get("search_result"));
            AnchorPane pane = loader.load();
            SearchResultController controller = loader.getController();
            if (context.getSubscribers().contains(account)) {
                controller.showUnsubscribe();
            }
            controller.updateAccount(account);
            controller.updateAccountName(account.getName());
            controller.updateAccountUserName('@' + account.getUserName());
            return Optional.of(pane);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return Optional.empty();
    }

    private void clearResultsBox() {
        // scuffed... but it works
        Node keep = resultsBox.getChildren().get(0);
        resultsBox.getChildren().clear();
        resultsBox.getChildren().add(keep);
    }
}
