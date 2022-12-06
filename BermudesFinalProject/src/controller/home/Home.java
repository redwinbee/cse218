package controller.home;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import model.Account;
import model.Post;
import util.ViewFinder;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

public class Home implements Initializable {
    private static Account context;
    @FXML
    public BorderPane borderPane;
    @FXML
    public MenuItem homeMenu;
    @FXML
    public MenuItem searchMenu;
    @FXML
    private TextArea postTextArea;
    @FXML
    private Button postButton;
    @FXML
    private Button attachButton;
    @FXML
    private Button removeAttachButton;
    @FXML
    private VBox postsBox;

    private File selectedFile;
    private Node prevCenter;

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
        Post post = (this.selectedFile != null) ? createPostWithAttach(body, selectedFile) : createPost(body);
        context.getPosts().add(post);
        try {
            FXMLLoader loader = new FXMLLoader(ViewFinder.get("post"));
            AnchorPane postPane = loader.load();
            PostController controller = loader.getController();
            controller.updateFullName(context.getName().toString());
            controller.updateUserName(context.getUserName());
            controller.updateBody(postTextArea.getText());
            controller.updatePostTime(post.getTimePosted());
            if (selectedFile != null) {
                controller.updateFile(selectedFile);
                this.selectedFile = null;
                removeAttachButton.setDisable(true);
            }
            postsBox.getChildren().add(0, postPane);
            postTextArea.clear();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    public void onHomeMenu() {
        // this is probably incredibly inefficient
        initializePosts();
        if (prevCenter != null) {
            borderPane.setCenter(prevCenter);
        }
    }

    @FXML
    public void onSearchMenu() {
        try {
            this.prevCenter = borderPane.getCenter();
            borderPane.setCenter(new FXMLLoader(ViewFinder.get("search")).load());
            SearchController.setContext(context);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    private void onAttach(ActionEvent event) {
        FileChooser chooser = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("*.images", "jpg", "png", "gif");
        chooser.setSelectedExtensionFilter(filter);
        File result = chooser.showOpenDialog(null);
        if (result != null) {
            this.selectedFile = result;
            removeAttachButton.setDisable(false);
        }
    }

    @FXML
    private void onRemoveAttachment(ActionEvent event) {
        this.selectedFile = null;
        removeAttachButton.setDisable(true);
    }

    private void initializePosts() {
        context.getSubscribers().forEach(acc -> {
            for (Post post : acc.getPosts()) {
                try {
                    FXMLLoader loader = new FXMLLoader(ViewFinder.get("post"));
                    AnchorPane postPane = loader.load();
                    PostController controller = loader.getController();
                    controller.updateFullName(post.getAuthor().getName().toString());
                    controller.updateUserName(post.getAuthor().getUserName());
                    controller.updateBody(post.getBody());
                    controller.updatePostTime(post.getTimePosted());
                    if (post.getAttachment() != null) {
                        controller.updateFile(post.getAttachment());
                    }
                    postsBox.getChildren().add(0, postPane);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    private Post createPost(String postBody) {
        return new Post(context, LocalDateTime.now(), postBody);
    }

    private Post createPostWithAttach(String postBody, File attach) {
        return new Post(context, LocalDateTime.now(), postBody, attach);
    }
}
