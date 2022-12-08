package controller.home;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import model.Account;
import model.Name;

public class SearchResultController {
    @FXML
    public Button subscribe;
    @FXML
    public Button unsubscribe;
    @FXML
    public Text accountName;
    @FXML
    public Text accountUserName;
    private Account account;

    @FXML
    public void onSubscribe() {
        Home.getContext().getSubscribers().add(account);
        showUnsubscribe();
    }

    @FXML
    public void onUnsubscribe() {
        Home.getContext().getSubscribers().remove(account);
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
