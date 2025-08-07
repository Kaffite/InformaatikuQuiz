package Frontend;

import javafx.scene.Group;
import javafx.scene.Scene;

public class QuizView {

    public static Scene getScene() {
        Group group = new Group();

        return new Scene(group, 480, 600);
    }
}
