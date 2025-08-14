package Frontend;

import App.Main;
import Backend.Descriptions;
import Backend.Points;
import Backend.QuestionBank;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class GameView {

    public static Scene getScene(Stage stage) throws IOException {
        BorderPane BPane = new BorderPane();
        Scene scene = Main.baseScene(BPane);

        Descriptions descriptions = new Descriptions("src/main/resources/Descriptions.txt");
        QuestionBank bank = bank = new QuestionBank("src/main/resources/Questions.txt");
        Points points = new Points(bank.getPointMap());

        CheckBox chkBox = new CheckBox("Vastus 1");
        VBox answerBox = new VBox(chkBox);
        BPane.setCenter(answerBox);
        answerBox.setAlignment(Pos.BASELINE_CENTER);



        return scene;
    }


}
