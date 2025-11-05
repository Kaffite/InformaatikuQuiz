package FrontEnd;


import App.Main;
import BackEnd.Settings;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;

// View for quiz settings
public class SettingsView {

    public static Scene getScene(Stage stage) throws IOException{
        BorderPane BPane = new BorderPane();
        Scene scene = View.baseScene(BPane, "colors-bg");

        // VBox for text and Button
        VBox verticalBox = new VBox(300);
        verticalBox.setAlignment(Pos.TOP_CENTER);
        BPane.setCenter(verticalBox);

        // Messages that are displayed in the settings screen (minor easter egg)
        Settings settings = new Settings("/textFiles/SettingsEST.txt");
        ArrayList<String> messages = settings.getSettingMessages();
        Text text = new Text(messages.removeFirst());
        text.getStyleClass().add("h1");
        verticalBox.getChildren().add(text);
        VBox.setMargin(text, new Insets(120, 0, 0, 0));

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