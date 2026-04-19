package base.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;
import java.util.List;

import javafx.scene.control.cell.PropertyValueFactory;
import base.model.LogOperacion;
import base.service.LogService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


@Component
public class HistorialController {
	
	private final LogService logService;

	public HistorialController(LogService logService) {
		
		this.logService = logService;
	}
	
	@FXML private TableView<LogOperacion> tablaLogs;
	@FXML private TableColumn<LogOperacion, LocalDateTime> colFecha;
	@FXML private TableColumn<LogOperacion,String> colUsuario;
	@FXML private TableColumn<LogOperacion,String> colOperacion;
	@FXML private TableColumn<LogOperacion, String> colResumen;
	
	@FXML private TextField txtFiltroUsuario;
	@FXML private ComboBox<String> cbTipo;
	@FXML private DatePicker dpInicio;
	@FXML private DatePicker dpFin;
	
	
	
	@FXML 
	public void initialize() {
		colFecha.setCellValueFactory(new PropertyValueFactory<>("fechaHora"));
		colUsuario.setCellValueFactory(new PropertyValueFactory<> ("usuario"));
		colOperacion.setCellValueFactory(new PropertyValueFactory<>("tipoOperacion"));
		colResumen.setCellValueFactory(new PropertyValueFactory<>("resumen"));
		
		
		cbTipo.getItems().setAll("TODOS","NUEVO","ACTUALIZACION","BORRADO");
		cbTipo.setValue("TODOS");
		cargarTodo();
	}
	
	@FXML
	private void cargarTodo() {
		txtFiltroUsuario.clear();
		cbTipo.setValue("TODOS");
		dpInicio.setValue(null);	
		dpFin.setValue(null);
		
		tablaLogs.setItems(FXCollections.observableArrayList(logService.obtenerTodosLosLogs()));
		
	}
	
	@FXML
	private void filtrarAvanzado() {
		
		String usuario = txtFiltroUsuario.getText();
		String tipo = cbTipo.getValue();
		LocalDate inicio = dpInicio.getValue();
		LocalDate fin = dpFin.getValue();
		
		List<LogOperacion> filtrados = logService.buscarLogsAvanzado(usuario, tipo, inicio, fin);
		tablaLogs.setItems(FXCollections.observableArrayList(filtrados));
	}

}
