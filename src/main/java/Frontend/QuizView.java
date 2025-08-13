package Frontend;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class QuizView {

    public static Scene getScene(Stage stage, BorderPane Bpane, Scene scene) {
        Group group = new Group();

        return new Scene(group, 480, 600);
    }
}
