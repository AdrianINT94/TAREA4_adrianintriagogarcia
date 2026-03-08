package base.controller;

import java.time.LocalDate;
import org.springframework.stereotype.Controller;
import base.model.*;
import base.service.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

@Controller
public class EspectaculoController {

    private final EspectaculoService espectaculoService;
    private final CoordinadorService coordinadorService;

    public EspectaculoController(EspectaculoService espectaculoService, CoordinadorService coordinadorService) {
        this.espectaculoService = espectaculoService;
        this.coordinadorService = coordinadorService;
    }

    @FXML private TextField txtNombre;
    @FXML private DatePicker dpInicio, dpFin;
    @FXML private ComboBox<Coordinador> cbCoordinador;
    @FXML private ListView<Espectaculo> listaEspectaculos;

    @FXML
    public void initialize() {
        cbCoordinador.getItems().setAll(coordinadorService.findAll());
        listaEspectaculos.getItems().setAll(espectaculoService.findAll());
    }

    @FXML
    private void guardar() {
        String nombre = txtNombre.getText();
        LocalDate fechaInicio = dpInicio.getValue(), fechaFin = dpFin.getValue();
        Coordinador coordinador = cbCoordinador.getValue();

        if (nombre == null || nombre.isBlank() || fechaInicio == null || fechaFin == null || coordinador == null) return;

        
        if (nombre.length() > 25 || fechaFin.isBefore(fechaInicio) || fechaFin.isAfter(fechaInicio.plusYears(1))) return;

        espectaculoService.save(new Espectaculo(nombre, fechaInicio, fechaFin, coordinador));
        listaEspectaculos.getItems().setAll(espectaculoService.findAll());
    }
}
