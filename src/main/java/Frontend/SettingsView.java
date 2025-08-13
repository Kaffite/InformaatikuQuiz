package Frontend;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SettingsView {

    public static Scene getScene(Stage stage, BorderPane BPane, Scene scene) {

        VBox verticalBox = new VBox();
        verticalBox.setAlignment(Pos.CENTER);
        Text text1 = new Text("Mida sa siit otsid?");
        Text text2 = new Text("Kas sa arvasid, et sellel quiz-il on graafika seaded vms?");
        Text text3 = new Text("Ära tegele lollustega ja mine tee see quiz ära!");

        verticalBox.getChildren().addAll(text1, text2, text3);
        BPane.setCenter(verticalBox);

        return scene;
    }

}