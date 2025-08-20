package Frontend;

import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class View {

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
