package controller.home;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import model.Account;
import model.Name;

public class SearchResultController {
    private static Account context;
    @FXML
    public Button subscribe;
    @FXML
    public Button unsubscribe;
    @FXML
    public Text accountName;
    @FXML
    public Text accountUserName;
    private Account account;

    public static void setContext(Account context) {
        SearchResultController.context = context;
    }

    @FXML
    public void onSubscribe(ActionEvent actionEvent) {
        context.getSubscribers().add(account);
        showUnsubscribe();
    }

    @FXML
    public void onUnsubscribe(ActionEvent actionEvent) {
        context.getSubscribers().remove(account);
        showSubscribe();
    }

    public void updateAccount(Account account) {
        this.account = account;
    }

    public void updateAccountName(Name name) {
        this.accountName.setText(name.toString());
    }

    public void updateAccountUserName(String userName) {
        this.accountUserName.setText(userName);
    }

    public void showSubscribe() {
        subscribe.setVisible(true);
        unsubscribe.setVisible(false);
    }

    public void showUnsubscribe() {
        subscribe.setVisible(false);
        unsubscribe.setVisible(true);
    }
}
