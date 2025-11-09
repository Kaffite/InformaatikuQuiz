package App;

import FrontEnd.MenuView;
import javafx.application.Application;
import javafx.scene.Scene;
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

    public static void showView(Stage stage, Scene scene, String title){
        stage.setScene(scene);
        stage.setTitle(title);
        stage.show();
    }





}