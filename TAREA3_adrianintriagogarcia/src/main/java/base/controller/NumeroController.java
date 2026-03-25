package base.controller;

import org.springframework.stereotype.Component;
import base.model.*;
import base.service.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.List;

@Component
public class NumeroController {

    private final NumeroService numeroService;
    private final ArtistaService artistaService;
    private final EspectaculoService espectaculoService;

    public NumeroController(NumeroService numeros, ArtistaService artistas, EspectaculoService espectaculos) {
        this.numeroService = numeros;
        this.artistaService = artistas;
        this.espectaculoService = espectaculos;
    }

    @FXML private TextField txtNombre, txtDuracion;
    @FXML private ComboBox<Espectaculo> cbEspectaculo;
    @FXML private ListView<Artista> listaArtistas;
    @FXML private ListView<Numero> listaNumeros;

    @FXML
    public void initialize() {
        cbEspectaculo.getItems().setAll(espectaculoService.findAll());
        listaArtistas.getItems().setAll(artistaService.findAll());
        cargar();
    }

    @FXML
    private void guardar() {
        String nombre = txtNombre.getText();
        String duracion = txtDuracion.getText();
        Espectaculo espectaculo = cbEspectaculo.getValue();
        Artista artista = listaArtistas.getSelectionModel().getSelectedItem();

        if (nombre.isBlank() || duracion.isBlank() || espectaculo == null || artista == null) return;

        Numero numero = new Numero();
        numero.setNombre(nombre);
        numero.setDuracion(duracion); 
        numero.setEspectaculo(espectaculo);
        numero.setArtistas(List.of(artista)); 

        numeroService.save(numero);
        cargar();
    }

    private void cargar() {
        listaNumeros.getItems().setAll(numeroService.findAll());
    }
}
