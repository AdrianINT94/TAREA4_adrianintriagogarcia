package base;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import base.config.StageManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class JavaFxApp extends Application {

    private static ConfigurableApplicationContext context;

    @Override
    public void init() {
        context = new SpringApplicationBuilder(Base.class).run();
    }

    @Override
    public void start(Stage stage) {
        StageManager stageManager = context.getBean(StageManager.class);
        stageManager.setPrimaryStage(stage);
        stageManager.switchScene("login.fxml", "Circo");
    }

    @Override
    public void stop() {
        context.close();
    }
}