package App;

import Frontend.MenuView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        BorderPane BPane = new BorderPane();
        Scene baseScene = baseScene(BPane);
        Scene menuScene = MenuView.getScene(stage, BPane, baseScene);
        showView(stage, menuScene, "Milline informaatik sa oled?" );
    }

    public static void main(String[] args) {
        launch();
    }

    public static void showView(Stage stage, Scene scene, String title){
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }

    /**
     * Helper method: Builds a basic scene to prevent code repetition in View classes
     * @param Bpane new BorderPane that every view will use (instead of creating own Bpane)
     * @return Basic scene that has 'style.css' as a stylesheet and a background
     */
    private static Scene baseScene(BorderPane Bpane){
        Scene scene =  new Scene(Bpane, 480, 500);
        scene.getStylesheets().add("style.css");
        Bpane.setId("normal-background");
        return scene;
    }




}