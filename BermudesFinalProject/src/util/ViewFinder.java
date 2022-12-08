package util;

import app.App;

import java.net.URL;

public class ViewFinder {
    private static final String BASE_PATH = "../fxml/";

    private ViewFinder() {
    }

    public static URL get(ViewKey key) {
        return App.class.getResource(key.getPath());
    }

    public enum ViewKey {
        LOGIN(viewPath("login.fxml")),
        REGISTER(viewPath("register.fxml")),
        HOME(viewPath("home/home.fxml")),
        POST(viewPath("home/post.fxml")),
        POST_COMMENT(viewPath("home/post_comment.fxml")),
        SEARCH(viewPath("home/search.fxml")),
        SEARCH_RESULT(viewPath("home/search_result.fxml"));

        private final String path;

        ViewKey(String path) {
            this.path = path;
        }

        private static String viewPath(String path) {
            return BASE_PATH + path;
        }

        public String getPath() {
            return path;
        }
    }
}
