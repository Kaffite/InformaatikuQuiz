package App;

import Frontend.MenuView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Scene menuScene = MenuView.getScene(stage);
        showView(stage, menuScene, "Milline informaatik sa oled?" );
    }

    public static void main(String[] args) {
        launch();
    }

    public static void showView(Stage stage, Scene scene, String title) {
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }

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




}