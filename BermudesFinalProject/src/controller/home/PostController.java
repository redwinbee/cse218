package controller.home;

import app.App;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import util.ViewFinder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PostController {
    @FXML
    private Label fullName;
    @FXML
    private Label userName;
    @FXML
    private Text body;
    @FXML
    private Label postTime;
    @FXML
    private ImageView imageView;

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

    public void openPost() {
        App.changeView(ViewFinder.get("post_comment"));
    }
}
