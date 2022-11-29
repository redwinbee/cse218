package controller.home;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import model.Account;
import model.Post;
import util.ViewFinder;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class Home implements Initializable {
    private static Account context;
    @FXML
    private TextArea postTextArea;
    @FXML
    private Button postButton;
    @FXML
    private VBox postsBox;

    public static void setContext(Account context) {
        Home.context = context;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializePosts();
    }

    @FXML
    private void onPost(ActionEvent event) {
        String body = postTextArea.getText();
        Post post = createPost(body);
        context.getPosts().add(post);
        try {
            FXMLLoader loader = new FXMLLoader(ViewFinder.get("post"));
            AnchorPane postPane = loader.load();
            PostController controller = loader.getController();
            controller.updateFullName(context.getName().toString());
            controller.updateUserName(context.getUserName());
            controller.updateBody(postTextArea.getText());
            controller.updatePostTime(post.getTimePosted());
            postsBox.getChildren().add(0, postPane);
            postTextArea.clear();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void initializePosts() {
        context.getPosts().forEach(post -> {
            try {
                FXMLLoader loader = new FXMLLoader(ViewFinder.get("post"));
                AnchorPane postPane = loader.load();
                PostController controller = loader.getController();
                controller.updateFullName(post.getAuthor().getName().toString());
                controller.updateUserName(post.getAuthor().getUserName());
                controller.updateBody(post.getBody());
                controller.updatePostTime(post.getTimePosted());
                postsBox.getChildren().add(0, postPane);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }

    private Post createPost(String postBody) {
        return new Post(context, LocalDateTime.now(), postBody);
    }
}
