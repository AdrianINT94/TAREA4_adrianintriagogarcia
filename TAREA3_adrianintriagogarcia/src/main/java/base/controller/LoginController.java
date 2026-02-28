package base.controller;

import org.springframework.stereotype.Component;

import base.config.StageManager;
import base.model.Credencial;
import base.model.Rol;
import base.service.CredencialService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


@Component
public class LoginController{
	
	private final CredencialService credencialService;
	private final StageManager stageManager;
	
	
	public LoginController(CredencialService credencialService, StageManager stageManager) {
		super();
		this.credencialService = credencialService;
		this.stageManager = stageManager;
	}
	
	
	@FXML
	private TextField txtUsuario;
	
	@FXML 
	private PasswordField txtPassword;
	
	@FXML
	private void login() {
		
		String user = txtUsuario.getText();
		String pass = txtPassword.getText();
		
		
		if(user ==null || user.isBlank() || pass==null || pass.isBlank()) {
			mostrarError("Debe introducir usuario y contraseña");
			return;
		}
		
		Credencial c = credencialService.getByUsername(user);
		
		if(c != null && c.getPassword().equals(pass)) {
			
			switch (c.getRol()) {
			
			case ADMIN:
				stageManager.switchScene("persona.fxml","Personas");
				break;
				
			case COORDINADOR:
				stageManager.switchScene("espectaculo.fxml", "Espectaculos");
				break;
				
			case ARTISTA:
				stageManager.switchScene("artista.fxml","Artista");
				break;
				
		}
		 } else {
	            mostrarError("Usuario o contraseña incorrectos");
	        }
	}

	    private void mostrarError(String mensaje) {
	        Alert alert = new Alert(Alert.AlertType.ERROR);
	        alert.setContentText(mensaje);
	        alert.showAndWait();
	          
	    }
}