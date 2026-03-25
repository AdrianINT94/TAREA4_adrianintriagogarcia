package base.config;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SpringFXMLLoader {

    private final ApplicationContext context;

    @Autowired
    public SpringFXMLLoader(ApplicationContext context) {
        this.context = context;
    }

    public Parent load(String fxmlPath) {

        try {
            FXMLLoader loader = new FXMLLoader(
                getClass().getClassLoader().getResource(fxmlPath)
            );

            loader.setControllerFactory(context::getBean);

            return loader.load();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}