package cs112.anikalamud3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WarriorOfLightApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WarriorOfLightApplication.class.getResource("openingWindow-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 600);
        setUserAgentStylesheet(STYLESHEET_MODENA);
        stage.setTitle("Final Fantasy XIV");
        stage.setScene(scene);
        stage.show();

//        FXMLLoader fxmlLoaderTest = new FXMLLoader(WarriorOfLightApplication.class.getResource("ffxivInfo-view.fxml"));
//        Scene testScene = new Scene(fxmlLoaderTest.load(), 650, 600);
//        stage.setTitle("Test Stage");
//        stage.setScene(testScene);
//        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}