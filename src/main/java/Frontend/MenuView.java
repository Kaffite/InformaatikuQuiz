package Frontend;

import App.Main;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
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
        BorderPane Bpane = new BorderPane();
        Scene scene =  new Scene(Bpane, 480, 500);
        // String css = (scene.getClass().getResource("style.css").toExternalForm());
        // scene.getStylesheets().add("css");
       // Bpane.setStyle();


        Text title = new Text("Informaatiku Quiz");
        Bpane.setTop(title);
        //title.setAlignment(Pos.TOP_CENTER);

        VBox vBtnBox = btnBox(stage);
        Bpane.setCenter(vBtnBox);
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

        // Start the quiz
        Button startBtn = menuBtn("Alusta Mängu", btnWidth);
        startBtn.setOnMouseClicked(mouseEvent -> {
            Main.showView(stage, QuizView.getScene(), "InformaatikuQuiz");
        });
        // Go to settings
        Button settingsBtn = menuBtn("Seaded", btnWidth);
        settingsBtn.setOnMouseClicked(MouseEvent -> {
            Main.showView(stage, SettingsView.getScene(), "Settings");
        });
        // Close the application
        Button exitBtn = menuBtn("Välju", btnWidth);
        exitBtn.setOnMouseClicked(MouseEvent -> {
            System.exit(0);
        });

        verticalBox.getChildren().addAll(startBtn, settingsBtn, exitBtn);
        return verticalBox;
    }

    /**
     * Function: Helper method for creating Buttons
     * @param text text that Button contains
     * @param btnWidth The width of a button
     * @return Modified Button that meets the project standard
     */
    private static Button menuBtn(String text, double btnWidth){
        Button btn = new Button(text);
        btn.setMinWidth(btnWidth);
        btn.setFont(new Font(18));
        return btn;
    }

}
