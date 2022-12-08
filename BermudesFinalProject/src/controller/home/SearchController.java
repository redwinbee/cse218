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
import java.util.regex.Pattern;

public class SearchController implements Initializable {
    @FXML
    private VBox resultsBox;
    @FXML
    private TextField searchField;
    @FXML
    private Button findButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void onFind() {
        clearResultsBox();

        // Use a regular expression with a wildcard pattern to partially match against the name and username of each account
        String searchText = searchField.getText().toLowerCase();
        Pattern searchPattern = Pattern.compile(".*" + searchText + ".*");

        for (Account acc : App.getAccountsManager().all().values()) {
            if (searchPattern.matcher(acc.getName().toString().toLowerCase()).matches()
                    || searchPattern.matcher(acc.getUserName().toLowerCase()).matches()) {
                loadAccountResult(acc).ifPresent(node -> resultsBox.getChildren().add(node));
            }
        }
    }

    private Optional<Node> loadAccountResult(Account account) {
        try {
            FXMLLoader loader = new FXMLLoader(ViewFinder.get("search_result"));
            AnchorPane pane = loader.load();
            SearchResultController controller = loader.getController();
            controller.updateAccount(account);

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
