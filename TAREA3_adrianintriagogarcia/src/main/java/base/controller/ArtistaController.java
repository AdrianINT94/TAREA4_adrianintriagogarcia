package base.controller;

import org.springframework.stereotype.Controller;

import base.model.Artista;
import base.service.ArtistaService;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;


@Controller
public class ArtistaController {
	
	private final ArtistaService artistaService;
	
	public ArtistaController(ArtistaService artistaService) {
		this.artistaService = artistaService;
	}
	
	@FXML
	private ListView<Artista> listaArtistas;
	
	@FXML
	public void initialize() {
		listaArtistas.getItems().setAll(artistaService.findAll());
		
	}
}
