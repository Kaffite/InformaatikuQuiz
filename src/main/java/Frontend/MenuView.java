package Frontend;

import App.Main;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MenuView {

    /**
     * Function: Builds a scene for main menu
     * @param stage main stage
     * @return New scene used for menu view
     */
    public static Scene getScene(Stage stage) {
        BorderPane BPane = new BorderPane();
        Scene scene = Main.baseScene(BPane);

        // Title text
        Text filler = new Text(); // Filler text to set title to right position
        Text title = new Text("Milline informaatik oled sina?");
        title.getStyleClass().add("title-text");
        //title.setId("title-text");
        VBox titleBox = new VBox(50);
        titleBox.getChildren().addAll(filler, title);
        BPane.setTop(titleBox);
        titleBox.setAlignment(Pos.TOP_CENTER);

        // Vbox for Buttons
        VBox vBtnBox = btnBox(stage);
        BPane.setCenter(vBtnBox);
        vBtnBox.setAlignment(Pos.CENTER);

        return scene;
    }

    /**
     * Funtion: Helper method for building the Menu scene
     * @param stage main stage
     * @return Vertical Box, that contains 3 buttons:
     * 1) Start the quiz
     * 2) Go to the settings
     * 3) Exit the application
     */
    private static VBox btnBox(Stage stage) {
        VBox verticalBox = new VBox();
        verticalBox.setPrefWidth(150);
        verticalBox.setSpacing(20);
        double btnWidth = verticalBox.getPrefWidth();

        // Button: Start the quiz
        Button startBtn = menuBtn("Alusta Mängu", btnWidth);
        startBtn.getStyleClass().addAll("btn", "start-btn");
        startBtn.setOnMouseClicked(mouseEvent -> {
            Main.showView(stage, GameView.getScene(stage), "Mäng" );
        });
        // Button: Go to settings
        Button settingsBtn = menuBtn("Seaded", btnWidth);
        settingsBtn.getStyleClass().addAll("btn");
        settingsBtn.setOnMouseClicked(MouseEvent -> {
            Main.showView(stage, SettingsView.getScene(stage), "Seaded??");
        });
        // Button: Close the application
        Button exitBtn = menuBtn("Välju", btnWidth);
        exitBtn.getStyleClass().addAll("btn", "exit-btn");
        exitBtn.setOnMouseClicked(MouseEvent -> {
            System.exit(0);
        });

        verticalBox.getChildren().addAll(startBtn, settingsBtn, exitBtn);
        return verticalBox;
    }

    /**
     * Function: Helper method for creating buttons (in btnBox)
     * @param text text that Button contains
     * @param btnWidth The width of a button
     * @return Modified Button that meets the project standard
     */
    public static Button menuBtn(String text, double btnWidth){
        Button btn = new Button(text);
        btn.setMinWidth(btnWidth);
        btn.setFont(new Font(18));
        return btn;
    }

}
