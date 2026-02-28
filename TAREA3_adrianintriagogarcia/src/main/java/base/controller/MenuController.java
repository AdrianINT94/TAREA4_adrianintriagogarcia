package base.controller;

import org.springframework.stereotype.Component;

import base.config.StageManager;
import javafx.fxml.FXML;

@Component
public class MenuController {

    private final StageManager stageManager;

    public MenuController(StageManager stageManager) {
        this.stageManager = stageManager;
    }

    @FXML
    private void irPersonas() {
        stageManager.switchScene("/persona.fxml", "Personas");
    }

    @FXML
    private void irArtistas() {
        stageManager.switchScene("/artista.fxml", "Artistas");
    }

    @FXML
    private void irEspectaculos() {
        stageManager.switchScene("/espectaculo.fxml", "Espectáculos");
    }

    @FXML
    private void salir() {
        System.exit(0);
    }
}