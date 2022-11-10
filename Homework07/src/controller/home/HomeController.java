package controller.home;

import app.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import model.Account;

import java.io.IOException;

public class HomeController {
    private static Account account;
    @FXML
    private ScrollPane postsPane;
    @FXML
    private VBox posts;
    @FXML
    private TextArea postArea;
    @FXML
    private Button post;

    public void initData(Account account) {
        HomeController.account = account;
    }

    @FXML
    private void onPost() {
        try {
            FXMLLoader loader = new FXMLLoader(App.class.getResource("../view/home/post.fxml"));
            AnchorPane pane = loader.load();
            PostController controller = loader.getController();
            controller.initData(account, postArea);
            posts.getChildren().add(pane);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
