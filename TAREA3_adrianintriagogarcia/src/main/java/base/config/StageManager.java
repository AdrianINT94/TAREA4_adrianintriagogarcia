package base.config;

import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StageManager {

    private Stage primaryStage;
    private final SpringFXMLLoader springFXMLLoader;

    public StageManager(SpringFXMLLoader springFXMLLoader) {
        this.springFXMLLoader = springFXMLLoader;
    }

    public void setPrimaryStage(Stage stage) {
        this.primaryStage = stage;
    }

    public void switchScene(String fxmlPath, String title) {
        Parent rootNode = loadView(fxmlPath);
        if (rootNode == null) {
            return;
        }

        Scene scene = new Scene(rootNode);
        primaryStage.setTitle(title);
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    private Parent loadView(String fxmlPath) {
        try {
            return springFXMLLoader.load(fxmlPath);
        } catch (Exception e) {
            e.printStackTrace();
            Platform.exit();
            return null;
        }
    }
}