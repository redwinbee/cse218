package controller.home;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.Account;

import java.net.URL;
import java.util.ResourceBundle;

public class PostController implements Initializable {
    @FXML
    private AnchorPane post;
    @FXML
    private Label name;
    @FXML
    private Label userName;
    @FXML
    private Label body;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void initData(Account account, TextArea postArea) {
        this.name.setText(account.getName().toString());
        this.userName.setText(account.getUsername());
        this.body.setText(postArea.getText());
    }

    public void onClickPost(MouseEvent mouseEvent) {
    }
}
