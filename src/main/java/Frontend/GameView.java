package Frontend;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameView {

    public static Scene getScene(Stage stage) {
        Group group = new Group();

        return new Scene(group, 480, 600);
    }
}
