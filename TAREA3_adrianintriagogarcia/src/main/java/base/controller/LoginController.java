package base.controller;

import org.springframework.stereotype.Component;
import base.config.StageManager;
import base.config.UserSession;
import base.model.Credencial;
import base.service.CredencialService;
import javafx.fxml.FXML;
import javafx.scene.control.*;

@Component
public class LoginController {

    private final CredencialService credencialService;
    private final StageManager stageManager;
    private final UserSession userSession;

    public LoginController(CredencialService credencialService, StageManager stageManager, UserSession userSession) {
        this.credencialService = credencialService;
        this.stageManager = stageManager;
        this.userSession = userSession;
    }

    @FXML private TextField txtUsuario;
    @FXML private PasswordField txtPassword;

    @FXML
    private void login() {
        String usuarioTexto = txtUsuario.getText();
        String passwordTexto = txtPassword.getText();
        
        Credencial cuenta = credencialService.getByUsername(usuarioTexto);

        
        if (cuenta != null && cuenta.getPassword().equals(passwordTexto)) {
            userSession.login(cuenta); 
            
            
            String fxml = switch (cuenta.getRol()) {
                case ADMIN -> "menu.fxml";
                case COORDINADOR -> "espectaculo.fxml";
                case ARTISTA -> "artista.fxml";
                default -> "login.fxml";
            };
            
            stageManager.switchScene(fxml, "Circo - " + cuenta.getRol());
        }
    }
}