package controller.home;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.Post;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PostCommentController {
    @FXML
    public TextField commentField;
    @FXML
    public Button comment;
    @FXML
    public VBox postComments;
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
        post.getComments().forEach(comment -> {
            VBox container = new VBox();
            HBox commenterBox = new HBox();
            Label fullName = new Label(comment.author().getName().toString());
            Label userName = new Label('@' + comment.author().getUserName());
            Text body = new Text(comment.body());
            commenterBox.getChildren().addAll(fullName, userName);

            container.getChildren().addAll(commenterBox, body);
            postComments.getChildren().add(container);
        });
    }

    public void setPost(Post post) {
        this.post = post;
        updateFullName(post.getAuthor().getName().toString());
        updateUserName(post.getAuthor().getUserName());
        updateBody(post.getBody());
        updatePostTime(post.getTimePosted());
        initData();
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

    public void onComment(ActionEvent actionEvent) {
        VBox container = new VBox();

        HBox commenterBox = new HBox();
        Label fullName = new Label(Home.getContext().getName().toString());
        Label userName = new Label('@' + Home.getContext().getUserName());
        Text body = new Text(commentField.getText());
        commenterBox.getChildren().addAll(fullName, userName);

        container.getChildren().addAll(commenterBox, body);
        postComments.getChildren().add(container);

        post.addComment(Home.getContext(), commentField.getText());
    }
}
