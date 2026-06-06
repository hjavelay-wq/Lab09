package com.ucv.labt09;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.beans.property.SimpleStringProperty;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML private TextField txtNombres;
    @FXML private ComboBox<String> cmbSemestre;
    @FXML private RadioButton rbPreGrado;
    @FXML private RadioButton rbPostGrado;
    @FXML private ToggleGroup tipoEstudiante;

    @FXML private TableView<String[]> tablaEstudiantes;
    @FXML private TableColumn<String[], String> colCodigo;
    @FXML private TableColumn<String[], String> colNombre;

    private final ObservableList<String[]> lista = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        cmbSemestre.setItems(FXCollections.observableArrayList(
                "2010-I", "2011-I", "2011-II"));
        cmbSemestre.getSelectionModel().selectFirst();

        rbPreGrado.setSelected(true);

        colCodigo.setCellValueFactory(d -> new SimpleStringProperty(d.getValue()[0]));
        colNombre.setCellValueFactory(d -> new SimpleStringProperty(d.getValue()[1]));
        tablaEstudiantes.setItems(lista);
    }

    @FXML
    private void onRegistrar() {
        String nombres = txtNombres.getText().trim();

        if (nombres.isEmpty()) {
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setContentText("Ingrese un nombre.");
            a.showAndWait();
            return;
        }

        EstudiantePreGrado ep = new EstudiantePreGrado(
                "", nombres, cmbSemestre.getValue(), "A", 14, "Estatal");

        lista.add(new String[]{ ep.getCodigo(), ep.getNombres() });
        txtNombres.clear();
    }

    @FXML
    private void onPostGrado() {
        // proximamente
    }
}