package p1_queue;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        QueueX queue = new QueueX(4);
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        System.out.println(queue.isFull());

        long ten = queue.remove();
        System.out.println("removed: " + ten);

        long twenty = queue.remove();
        System.out.println("removed: " + twenty);

        queue.add(50);
        System.out.println("added: 50");

        long thirty = queue.remove();
        System.out.println("removed: " + thirty);

        long forty = queue.remove();
        System.out.println("removed: " + forty);

        long fifty = queue.remove();
        System.out.println("removed: " + fifty);

        // queue is now empty
    }
}
