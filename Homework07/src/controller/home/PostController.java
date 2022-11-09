package controller.home;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

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

    public void onClickPost(MouseEvent mouseEvent) {
        //TODO vbox inside a scrollpane, replace anchorpane
    }
}
