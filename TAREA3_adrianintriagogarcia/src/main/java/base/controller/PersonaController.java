package base.controller;

import java.util.List;

import org.springframework.stereotype.Component;

import base.model.Persona;
import base.service.PersonaService;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

@Component
public class PersonaController {

    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @FXML
    private ListView<Persona> listaPersonas;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtEmail;
    
    @FXML
    private TextField txtNacionalidad;
    
    
    
    @FXML
    public void initialize() {
        cargarPersonas();
    }

    private void cargarPersonas() {
        listaPersonas.getItems().clear();
        listaPersonas.getItems().addAll(personaService.findAll());
    }

    @FXML
    private void guardar() {

        String nombre = txtNombre.getText();
        String email = txtEmail.getText();
        String nacionalidad = txtNacionalidad.getText();
        
        
        if (nombre == null || nombre.isBlank()) {
            mostrarError("El nombre no puede estar vacío");
            return;
        }
        if (email == null || email.isBlank()) {
            mostrarError("El email no puede estar vacío");
            return;
            
        }

        Persona persona = new Persona(nombre, email, nacionalidad);
        personaService.save(persona);

        txtNombre.clear();
        txtEmail.clear();
        txtNacionalidad.clear();
        cargarPersonas();
    }

    @FXML
    private void borrar() {

        Persona personaSeleccionada =
                listaPersonas.getSelectionModel().getSelectedItem();

        if (personaSeleccionada == null) {
            mostrarError("Seleccione una persona para borrar");
            return;
        }

        personaService.deleteById(personaSeleccionada.getId());
        cargarPersonas();
    }

    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
