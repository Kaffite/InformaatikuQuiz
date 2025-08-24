package FrontEnd;

import App.Main;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

// Main menu view
public class MenuView {

    /**
     * Function: Builds a scene for main menu
     * @param stage main stage
     * @return New scene used for menu view
     */
    public static Scene getScene(Stage stage) throws IOException {
        BorderPane BPane = new BorderPane();
        Scene scene = View.baseScene(BPane, "colors-bg");

        VBox titleBox = View.titleBox("Milline informaatik oled sina?", BPane);
        titleBox.getStyleClass().add("h1-dark");

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
        verticalBox.setPrefWidth(200);
        verticalBox.setSpacing(20);
        double btnWidth = verticalBox.getPrefWidth();

        // Button: Start the quiz
        Button startBtn = new Button("Alusta Mängu");
        startBtn.getStyleClass().addAll("btn", "start-btn");
        startBtn.setOnMouseClicked(mouseEvent -> {
            try {
                Main.showView(stage, GameView.getScene(stage), "Mäng" );
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        // Button: Go to settings
        Button settingsBtn = new Button("Seaded");
        settingsBtn.getStyleClass().add("btn");
        settingsBtn.setOnMouseClicked(MouseEvent -> {
            Main.showView(stage, SettingsView.getScene(stage), "Seaded??");
        });
        // Button: Close the application
        Button exitBtn = new Button("Välju");
        exitBtn.getStyleClass().addAll("btn", "exit-btn");
        exitBtn.setOnMouseClicked(MouseEvent -> {
            System.exit(0);
        });

        verticalBox.getChildren().addAll(startBtn, settingsBtn, exitBtn);
        return verticalBox;
    }

}
