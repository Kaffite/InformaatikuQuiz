package Frontend;


import App.Main;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

// View for quiz settings
public class SettingsView {

    public static Scene getScene(Stage stage) {
        BorderPane BPane = new BorderPane();
        Scene scene = View.baseScene(BPane);

        // Text
        VBox verticalBox = new VBox();
        verticalBox.setAlignment(Pos.CENTER);
        String [] messages = {
                "", "",
                "Miks sa siin oled?",
                "Mis seaded sellel quiz-il olema peaks?",
                "Ära tegele lollustega, mine tee parem see quiz ära."};
        for (int i = 0; i < messages.length; i++){
            Text text = new Text(messages[i].toString());
            text.getStyleClass().add("title-text");
            verticalBox.getChildren().add(text);
        }

        // Return button
        Button returnBtn = new Button("Tagasi menüüsse");
        returnBtn.getStyleClass().addAll("btn");
        returnBtn.setOnMouseClicked(mouseEvent -> {
            try {
                Main.showView(stage, MenuView.getScene(stage), "Milline informaatik sa oled?");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        VBox btnBox = new VBox(returnBtn);
        btnBox.setAlignment(Pos.CENTER);
        BPane.setCenter(btnBox);

        verticalBox.setSpacing(15);
        BPane.setTop(verticalBox);

        return scene;
    }

}