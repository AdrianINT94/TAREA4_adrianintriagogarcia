package base.controller;

import org.springframework.stereotype.Component;
import base.config.StageManager;
import base.config.UserSession;
import javafx.fxml.FXML;

@Component
public class MenuController {

    private final StageManager stageManager;
    private final UserSession userSession;

    public MenuController(StageManager stageManager, UserSession userSession) {
        this.stageManager = stageManager;
        this.userSession = userSession;
    }

    @FXML 
    private void irPersonas() { 
        stageManager.switchScene("persona.fxml", "Gestión Personas"); 
    }

    @FXML 
    private void irArtistas() { 
        stageManager.switchScene("artista.fxml", "Gestión Artistas"); 
    }

    @FXML 
    private void irEspectaculos() { 
        stageManager.switchScene("espectaculo.fxml", "Gestión Espectáculos"); 
    }
    
    @FXML
    private void irHistorial() {
    	stageManager.switchScene("historial.fxml","Historial");
    }

    @FXML
    private void salir() {
        userSession.logout(); 
        stageManager.switchScene("login.fxml", "Login");
    }
}