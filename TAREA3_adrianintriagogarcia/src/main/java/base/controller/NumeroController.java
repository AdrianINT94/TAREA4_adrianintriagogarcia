package base.controller;

import org.springframework.stereotype.Component;

import base.model.Artista;
import base.model.Espectaculo;
import base.model.Numero;
import base.service.ArtistaService;
import base.service.EspectaculoService;
import base.service.NumeroService;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

@Component
public class NumeroController {

		private final NumeroService numeroService;
		private final EspectaculoService espectaculoService;
		private final ArtistaService artistaService;
		
		
		
		public NumeroController(NumeroService numeroService, EspectaculoService espectaculoService,
				ArtistaService artistaService) {
			super();
			this.numeroService = numeroService;
			this.espectaculoService = espectaculoService;
			this.artistaService = artistaService;
		}
		
		@FXML
		private TextField txtNombre;
		
		@FXML 
		private TextField txtDuracion;
		
		@FXML 
		private ComboBox <Espectaculo> cbespectaculo;
		
		
		@FXML
		private ListView<Artista> listaArtistas;
		
		@FXML
		private ListView<String> listaNumeros;
		
		@FXML
		public void initialize() {
			cbespectaculo.getItems().setAll(espectaculoService.findAll());
			listaArtistas.getItems().setAll(artistaService.findAll());
			cargar();
		}
		
		@FXML
		private void guardar() {
			
			String nombre = txtNombre.getText();
			String duracionTexto= txtDuracion.getText();
			Espectaculo espectaculo = cbespectaculo.getValue();
			
			
			if(nombre ==null || nombre.isBlank() || espectaculo ==null) return;
			
			Numero numero = new Numero();
			numero.setNombre(nombre);
			numero.setDuracion(Double.parseDouble(duracionTexto));
			numero.setEspectaculo(espectaculo);
			numero.setArtistas(listaArtistas.getSelectionModel().getSelectedItems());
			
			numeroService.save(numero);
			
			txtNombre.clear();
			txtDuracion.clear();
			
			cargar();
		}
		
		private void cargar() {
			listaNumeros.getItems().clear();
			
			for(Numero n: numeroService.findAll()) {
			listaNumeros.getItems().add(n.getId() + " - " + n.getNombre());
		}
		
		
}
		
}
