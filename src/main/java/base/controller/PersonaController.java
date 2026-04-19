package base.controller;



import org.springframework.stereotype.Component;
import base.model.Artista;
import base.model.Coordinador;
import base.model.Persona;
import base.service.LogService;
import base.service.ArtistaService;
import base.service.CoordinadorService;
import base.service.PersonaService;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

@Component
public class PersonaController {

    private final PersonaService personaService;
    private final ArtistaService artistaService;      
    private final CoordinadorService coordinadorService; 
    
    private final LogService logService;
    
    public PersonaController(PersonaService personaService, ArtistaService artistaService, CoordinadorService coordinadorService, LogService logService) {
        this.personaService = personaService;
        this.artistaService = artistaService;
        this.coordinadorService = coordinadorService;
        this.logService = logService;
    }

    @FXML private ListView<Persona> listaPersonas;
    @FXML private TextField txtNombre, txtEmail, txtNacionalidad;
    @FXML private ComboBox<String> cbTipoPersona;

    @FXML
    public void initialize() {
        
        cbTipoPersona.getItems().setAll("Artista", "Coordinador");
        cargar();
    }

    @FXML
    private void guardar() {
        String nombre = txtNombre.getText();
        String email = txtEmail.getText();
        String nacion = txtNacionalidad.getText();
        String tipo = cbTipoPersona.getValue(); 

        if (nombre.isBlank() || email.isBlank() || tipo == null) return;

        if (tipo.equals("Coordinador")) {
            
            Coordinador coordinador = new Coordinador();
            coordinador.setNombre(nombre);
            coordinador.setEmail(email);
            coordinador.setNacionalidad(nacion);
            coordinador.setSenior(true); 
            
            
            coordinadorService.save(coordinador); 
            
            logService.Operacion("Admin", "NUEVO", "Se ha insertado un nuevo Coordinador" + nombre);
        } else {
            
            Artista artista = new Artista();
            artista.setNombre(nombre);
            artista.setEmail(email);
            artista.setNacionalidad(nacion);
            artistaService.save(artista);
            
            
            logService.Operacion("Admin","NUEVO"," nuevo Artista " +nombre);
        }

        
        txtNombre.clear(); 
        txtEmail.clear(); 
        txtNacionalidad.clear();
        cbTipoPersona.setValue(null);
        cargar();
    }

    @FXML
    private void borrar() {
        Persona seleccionada = listaPersonas.getSelectionModel().getSelectedItem();
        if (seleccionada == null) return;
        
        
        
        logService.Operacion("Admin","BORRADO","Se ha borrado a " + seleccionada.getNombre() + "ID: " + seleccionada.getId());
        personaService.deleteById(seleccionada.getId());
        cargar();
    }

    private void cargar() {
        listaPersonas.getItems().setAll(personaService.findAll());
    }
}