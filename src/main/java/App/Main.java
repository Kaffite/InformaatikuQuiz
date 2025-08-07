package App;

//import io.github.kaffite.informaatikuquiz.Frontend.MenuView;
import Frontend.MenuView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        showView(stage, MenuView.getScene(stage), "Menu");
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