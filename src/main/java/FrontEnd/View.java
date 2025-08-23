package FrontEnd;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

// Class that contains base builds (basic scene, title) that other frontend views use
public class View {

    /**
     * Helper method: Builds a basic scene to prevent code repetition in View classes
     * @param Bpane new BorderPane that every view will use (instead of creating own Bpane)
     * @return Basic scene that has 'style.css' as a stylesheet and a background
     */
    public static Scene baseScene(BorderPane Bpane){
        Scene scene =  new Scene(Bpane, 800, 600);
        scene.getStylesheets().add("style.css");
        Bpane.setId("normal-background");
        return scene;
    }

    /**
     * Method for creating VBox that contains title.
     * This method exists to prevent code duplication.
     * @param titleString the text for the title
     * @param BPane BorderPane where the title will be set
     * @return vertical Box that contains the text at the right position
     */
    public static VBox titleBox (String titleString, BorderPane BPane){
        // Title text
        Text title = new Text(titleString);
        title.getStyleClass().add("title-text");
        VBox titleBox = new VBox(50, new Text(), title);
        BPane.setTop(titleBox);
        titleBox.setAlignment(Pos.TOP_CENTER);
        return titleBox;
    }
}
