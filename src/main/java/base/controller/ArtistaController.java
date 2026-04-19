package base.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;

import base.model.Artista;
import base.model.LogOperacion;
import base.repository.LogRepository;
import base.service.ArtistaService;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;


@Controller
public class ArtistaController {
	
	private final ArtistaService artistaService;
	private final LogRepository logRepository; 
	
	public ArtistaController(ArtistaService artistaService, LogRepository logRepository) {
		this.artistaService = artistaService;
		this.logRepository = logRepository;
	}
	
	@FXML
	private ListView<Artista> listaArtistas;
	
	@FXML
	public void initialize() {
		
		listaArtistas.getItems().setAll(artistaService.findAll());
		
		LogOperacion logInicio = new LogOperacion();
		logInicio.setFechaHora(LocalDateTime.now());
		logInicio.setUsuario("Sistema");
		logInicio.setTipoOperacion("CONSULTA");
		logInicio.setResumen("El usuario ha visualizado la lista de artistas");
		
		logRepository.registrarAccion(logInicio);
	}
}
