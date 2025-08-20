package Frontend;

import App.Main;
import Backend.Descriptions;
import Backend.Points;
import Backend.Question;
import Backend.QuestionBank;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class GameView {

    public static Scene getScene(Stage stage) throws IOException {
        BorderPane BPane = new BorderPane();
        Scene scene = Main.baseScene(BPane);

        Descriptions descriptions = new Descriptions("src/main/resources/Descriptions.txt");
        QuestionBank bank = bank = new QuestionBank("src/main/resources/Questions.txt");
        Points points = new Points(bank.getPointMap());
        askQuestion(bank, points, BPane);

        return scene;
    }

    private static void askQuestion(QuestionBank bank, Points points, BorderPane BPane){
        VBox answerBox = new VBox(15, new Text());
        answerBox.setAlignment(Pos.BASELINE_CENTER);

        // Displays the question text:
        Question question = bank.randomQuestion();
        String questionText = question.getQuestionText();
        VBox titleBox = View.titleBox(questionText, BPane);

        // Displays the possible answers as buttons:
        /*
        method 'question.getAnswerValues()' returns HashMap:
            key is text of the answer (String type)
            value is HashMap for adding points
         */
        HashMap answers = question.getAnswerValues();
        for (Object answerText : answers.keySet()) {
            Button button = new Button(answerText.toString());
            button.getStyleClass().addAll("btn", "btn-wide");
            button.setOnMouseClicked(MouseEvent -> {
                // Adds points (how many and to what type is defined in the HashMap)
                HashMap pointsToAdd = (HashMap) answers.get(answerText);
                points.addPoints(pointsToAdd);

                // Asks next question
                BPane.getChildren().remove(answerBox);
                // if there are no more questions -> display results
                if (bank.getQuestionList().isEmpty()) { //
                    BPane.getChildren().remove(titleBox);
                    displayResults(points, BPane);
                } else {
                    askQuestion(bank, points, BPane);
                }
            });
            answerBox.getChildren().add(button);
        }
        BPane.setCenter(answerBox);
    }

    private static void displayResults(Points points, BorderPane BPane) {
        VBox titleBox = View.titleBox("Tulemused", BPane);
        HashMap results = points.getPoints();
        for (Object symbol: results.keySet()){
            Double symbolPoints = (Double) results.get(symbol);
            System.out.println(symbol + " " + symbolPoints);
        }
    }

}
