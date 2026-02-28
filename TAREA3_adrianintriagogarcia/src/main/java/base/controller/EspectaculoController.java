package base.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;

import base.model.Coordinador;
import base.model.Espectaculo;
import base.service.CoordinadorService;
import base.service.EspectaculoService;
import javafx.fxml.FXML;
import javafx.scene.control.*;

@Controller
public class EspectaculoController {

    private final EspectaculoService espectaculoService;
    private final CoordinadorService coordinadorService;

    public EspectaculoController(EspectaculoService espectaculoService,
                                 CoordinadorService coordinadorService) {
        this.espectaculoService = espectaculoService;
        this.coordinadorService = coordinadorService;
    }

    @FXML
    private TextField txtNombre;

    @FXML
    private DatePicker dpInicio;

    @FXML
    private DatePicker dpFin;

    @FXML
    private ComboBox<Coordinador> cbCoordinador;

    @FXML
    private ListView<Espectaculo> listaEspectaculos;

    @FXML
    public void initialize() {
        cargarCoordinadores();
        cargarLista();
    }

    private void cargarCoordinadores() {
        cbCoordinador.getItems().clear();
        cbCoordinador.getItems().addAll(coordinadorService.findAll());
    }

    @FXML
    private void guardar() {

        String nombre = txtNombre.getText();
        LocalDate inicio = dpInicio.getValue();
        LocalDate fin = dpFin.getValue();
        Coordinador coordinador = cbCoordinador.getValue();

        if (nombre == null || nombre.isBlank() ||
            inicio == null || fin == null || coordinador == null) {

            mostrarError("Todos los campos son obligatorios");
            return;
        }

        Espectaculo espectaculo = new Espectaculo();
        espectaculo.setNombre(nombre);
        espectaculo.setFechaInicio(inicio);
        espectaculo.setFechaFin(fin);
        espectaculo.setCoordinador(coordinador);

        espectaculoService.save(espectaculo);

        limpiarCampos();
        cargarLista();
    }

    private void cargarLista() {
        listaEspectaculos.getItems().clear();
        listaEspectaculos.getItems().addAll(espectaculoService.findAll());
    }

    private void limpiarCampos() {
        txtNombre.clear();
        dpInicio.setValue(null);
        dpFin.setValue(null);
        cbCoordinador.setValue(null);
    }

    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
