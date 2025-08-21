package Frontend;

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
import java.util.ArrayList;
import java.util.HashMap;

// View that asks user questions and displays the results
public class GameView {

    public static Scene getScene(Stage stage) throws IOException {
        BorderPane BPane = new BorderPane();
        Scene scene = View.baseScene(BPane);

        Descriptions descriptions = new Descriptions("src/main/resources/Descriptions.txt");
        QuestionBank bank = bank = new QuestionBank("src/main/resources/Questions.txt");
        Points points = new Points(bank.getPointMap());
        askQuestion(bank, points, BPane, descriptions);

        return scene;
    }

    /**
     * Function: Asks a question and displays possible answers (buttons).
     * When an answer is chosen, asks another question and displays its possible answers.
     * After there are no more answers displays results (calls method displayResults)
     * @param bank instance - used to ask questions
     * @param points instance - used to hold and add points
     * @param BPane scene root
     * @param desc instance - used to hold all the type descriptions
     */
    private static void askQuestion(QuestionBank bank, Points points, BorderPane BPane, Descriptions desc){
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
                    displayResults(points, BPane, desc);
                } else {
                    askQuestion(bank, points, BPane, desc);
                }
            });
            answerBox.getChildren().add(button);
        }
        BPane.setCenter(answerBox);
    }

    /**
     * Function: Displays the results (points + type descriptions for the types with most points)
     * @param points
     * @param BPane
     * @param desc
     */
    private static void displayResults(Points points, BorderPane BPane, Descriptions desc) {
        VBox titleBox = View.titleBox("Tulemused:", BPane);

        // Displays descriptions
        VBox resultBox = new VBox(3);
        ArrayList<Character> resultTypes = points.MostPointsTypes();
        HashMap descMap = desc.getDescriptions();
        for (Character resultType : resultTypes) {
            String[] typeAndDesc = ((String) descMap.get(resultType)).split("\\.");
            for (int i = 0; i < typeAndDesc.length; i++){
                String line = typeAndDesc[i];
                Text descText = new Text(line);
                descText.getStyleClass().add("results-text");
                resultBox.getChildren().add(descText);
            }
        }
        resultBox.setAlignment(Pos.TOP_CENTER);
        BPane.setCenter(resultBox);


        // How many points for what type
        HashMap results = points.getPoints();
        HashMap symbolToType = desc.getTypes();
        VBox typePointsBox = new VBox(10, new Text());
        for (Object symbol: results.keySet()){
            String type = (String) symbolToType.get(symbol);
            Double symbolPoints = (Double) results.get(symbol);
            Text typePoints = new Text(type + " - " + symbolPoints);
            typePoints.getStyleClass().add("results-text");
            typePointsBox.getChildren().add(typePoints);
            System.out.println(type + " " + symbolPoints);
        }
        typePointsBox.setAlignment(Pos.TOP_CENTER);
        BPane.setBottom(typePointsBox);

    }

}
