package Frontend;

import App.Main;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class GameView {

    public static Scene getScene(Stage stage) {
        BorderPane BPane = new BorderPane();
        Scene scene = Main.baseScene(BPane);


        return scene;
    }
}
