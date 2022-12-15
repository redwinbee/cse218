package controller.home;

import app.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import model.Account;
import model.Post;
import util.ViewFinder;
import util.ViewFinder.ViewKey;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PostCommentController {
    @FXML
    public TextField commentField;
    @FXML
    public Button comment;
    @FXML
    public VBox postComments;
    @FXML
    public Button backButton;
    @FXML
    public ImageView imageView;
    private Post post;
    @FXML
    private Label fullName;
    @FXML
    private Label userName;
    @FXML
    private Text body;
    @FXML
    private Label postTime;

    public void initData() {
        post.getComments().forEach(comment -> createComment(comment.author(), comment.body(), false));
    }

    @FXML
    public void onBack() {
        App.changeView(ViewFinder.get(ViewKey.HOME));
    }

    public void setPost(Post post) {
        this.post = post;
        updateFullName(post.getAuthor().getName().toString());
        updateUserName(post.getAuthor().getUserName());
        updateBody(post.getBody());
        if (post.getAttachment() != null) {
            updateFile(post.getAttachment());
        }
        updatePostTime(post.getTimePosted());
        initData();
    }

    public void updateFile(File file) {
        try {
            FileInputStream stream = new FileInputStream(file.getPath());
            this.imageView.setImage(new Image(stream));
            this.imageView.setFitHeight(299); // arbitrary values, just need it to fit the screen
            this.imageView.setFitWidth(133);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

    }

    public void updateFullName(String name) {
        this.fullName.setText(name);
    }

    public void updateUserName(String userName) {
        this.userName.setText('@' + userName);
    }

    public void updateBody(String body) {
        this.body.setText(body);
    }

    public void updatePostTime(LocalDateTime time) {
        this.postTime.setText(time.format(DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm")));
    }

    public void onComment() {
        createComment(Home.getContext(), commentField.getText(), true);
    }

    private void createComment(Account context, String body, boolean addToBox) {
        VBox container = new VBox();
        container.setSpacing(10);

        HBox commenterBox = new HBox();
        commenterBox.setSpacing(10);
        Label fullName = new Label(context.getName().toString());
        fullName.setFont(Font.font("Rockwell", 12.0));
        Label userName = new Label('@' + context.getUserName());
        userName.setFont(Font.font("Rockwell", 12.0));
        Text text = new Text(body);
        text.setFont(Font.font("Rockwell", 12.0));
        commenterBox.getChildren().addAll(fullName, userName);

        container.getChildren().addAll(commenterBox, text);
        postComments.getChildren().add(container);

        if (addToBox) {
            post.addComment(context, commentField.getText());
        }
    }
}