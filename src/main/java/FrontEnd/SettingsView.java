package FrontEnd;


import App.Main;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

// View for quiz settings
public class SettingsView {

    public static Scene getScene(Stage stage) {
        BorderPane BPane = new BorderPane();
        Scene scene = View.baseScene(BPane);

        VBox verticalBox = new VBox(120, new Text()); // VBox for text and Button
        verticalBox.setAlignment(Pos.TOP_CENTER);
        BPane.setCenter(verticalBox);

        // Text
        String[] arrayMessages = {
                "Miks sa siin oled?",
                "Mis seaded sellel quiz-il olema peaks?",
                "Ära tegele lollustega, mine tee parem see quiz ära."};
        // Arraylist of messages that are displayed after going to SettingsView:
        ArrayList<String> messages = new ArrayList<>(Arrays.asList(arrayMessages));
        Text text = new Text(messages.removeFirst());
        text.getStyleClass().add("h1");
        verticalBox.getChildren().add(text);

        // Button
        Button returnBtn = new Button("Edasi");
        returnBtn.getStyleClass().addAll("btn");
        returnBtn.setOnMouseClicked(mouseEvent -> {
            // If there are no more messages to display, return to menu
            if (messages.isEmpty() ){
                try {
                    Main.showView(stage, MenuView.getScene(stage), "Milline informaatik sa oled?");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else { // Display messages from Arraylist 'messages'
                if (messages.size() == 1) returnBtn.setText("Tagasi menüüsse");
                text.setText(messages.removeFirst());
            }
        });
        verticalBox.getChildren().add(returnBtn);

        return scene;
    }

}