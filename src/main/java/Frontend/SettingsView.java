package Frontend;


import App.Main;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class SettingsView {

    public static Scene getScene(Stage stage) {
        BorderPane BPane = new BorderPane();
        Scene scene = Main.baseScene(BPane);

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
        Button returnBtn = MenuView.menuBtn("Tagasi menüüsse", 150);
        returnBtn.getStyleClass().addAll("btn");
        returnBtn.setOnMouseClicked(mouseEvent -> {
                Main.showView(stage, MenuView.getScene(stage), "Milline informaatik sa oled?");
        });
        VBox btnBox = new VBox(returnBtn);
        btnBox.setAlignment(Pos.CENTER); // ??????????????????????????????????????????????????????
        //verticalBox.getChildren().add(returnBtn);
        BPane.setCenter(btnBox);

        verticalBox.setSpacing(15);
        BPane.setTop(verticalBox);

        return scene;
    }

}