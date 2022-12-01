package util;

import app.App;

import java.net.URL;
import java.util.HashMap;

public class ViewFinder {
    private static final HashMap<String, String> views = new HashMap<>();

    static {
        views.put("login", "../fxml/login.fxml");
        views.put("register", "../fxml/register.fxml");
        views.put("home", "../fxml/home/home.fxml");
        views.put("post", "../fxml/home/post.fxml");
        views.put("search", "../fxml/home/search.fxml");
        views.put("search_result", "../fxml/home/search_result.fxml");
    }

    private ViewFinder() {
    }

    public static URL get(String key) {
        return App.class.getResource(views.get(key));
    }
}
