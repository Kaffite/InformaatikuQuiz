package Frontend;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class SettingsView {

    public static Scene getScene() {
        VBox verticalBox = new VBox();
        verticalBox.setAlignment(Pos.CENTER);
        Text text1 = new Text("Mida sa siit otsid?");
        Text text2 = new Text("Mis seadeid sa loota leidsid, graafikat?");
        Text text3 = new Text("Ära tegele lollustega ja mine tee see quiz ära!");

        verticalBox.getChildren().addAll(text1, text2, text3);
        BorderPane BPane = new BorderPane();
        BPane.setCenter(verticalBox);
        BPane.setStyle("-fx-background-color: rgba(255,207,214,0.67);");

        return new Scene(BPane, 480, 600);
    }

}