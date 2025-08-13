package Frontend;


import App.Main;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class SettingsView {

    public static Scene getScene(Stage stage) {
        BorderPane BPane = new BorderPane();
        Scene scene = Main.baseScene(BPane);

        VBox verticalBox = new VBox();
        verticalBox.setAlignment(Pos.TOP_CENTER);
        String [] messages = {
                "Miks sa siin oled?",
                "Mis seaded sellel quiz-il olema peaks?",
                "Ära tegele lollustega!"};
        for (int i = 0; i < messages.length; i++){
            Text text = new Text(messages[i].toString());
            text.setId("title-text");
            verticalBox.getChildren().add(text);
        }

        verticalBox.setSpacing(10);
        BPane.setCenter(verticalBox);

        return scene;
    }

}