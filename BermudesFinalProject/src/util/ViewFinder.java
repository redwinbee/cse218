package util;

import app.App;

import java.net.URL;

public class ViewFinder {
    private ViewFinder() {
    }

    public static URL get(ViewKey key) {
        return App.class.getResource(key.getPath());
    }

    public enum ViewKey {
        LOGIN("../fxml/login.fxml"),
        REGISTER("../fxml/register.fxml"),
        HOME("../fxml/home/home.fxml"),
        POST("../fxml/home/post.fxml"),
        POST_COMMENT("../fxml/home/post_comment.fxml"),
        SEARCH("../fxml/home/search.fxml"),
        SEARCH_RESULT("../fxml/home/search_result.fxml");

        private final String path;

        ViewKey(String path) {
            this.path = path;
        }

        public String getPath() {
            return path;
        }
    }
}
