package org.example.integradora.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.example.integradora.Model.Libro;
import org.example.integradora.Service.LibroRepository;

public class FormularioController {

    @FXML private TextField txtIsbn;
    @FXML private TextField txtTitulo;
    @FXML private TextField txtAutor;
    @FXML private TextField txtAnio;
    @FXML private TextField txtGenero;
    @FXML private CheckBox  chkDisponible;

    private LibroRepository repositorio;
    private Libro libroEditar;

    public void inicializar(Libro libro, LibroRepository repositorio) {
        this.repositorio =repositorio;
        this.libroEditar = libro;

        // Si nos pasan un libro, es edicion,llenamos los campos
        if (libro != null) {
            txtIsbn.setText(libro.getIsbn());
            txtTitulo.setText(libro.getTitulo());
            txtAutor.setText(libro.getAutor());
            txtAnio.setText(String.valueOf(libro.getAnio()));
            txtGenero.setText(libro.getGenero());
            chkDisponible.setSelected(libro.isDisponible());
        }
    }

    @FXML
    void onGuardar(ActionEvent event) {

        // Validar campos vacios
        if (txtIsbn.getText().isBlank() || txtTitulo.getText().isBlank() ||
                txtAutor.getText().isBlank() || txtAnio.getText().isBlank() ||
                txtGenero.getText().isBlank()) {
            mostrarAlerta("Todos los campos son obligatorios.");
            return;
        }

        // Validar minimo 3 caracteres
        if (txtTitulo.getText().length() < 3) {
            mostrarAlerta("El título debe tener al menos 3 caracteres.");
            return;
        }
        if (txtAutor.getText().length() < 3) {
            mostrarAlerta("El autor debe tener al menos 3 caracteres.");
            return;
        }

        // Validar que el año sea número
        int anio;
        try {
            anio = Integer.parseInt(txtAnio.getText());
        } catch (NumberFormatException e) {
            mostrarAlerta("debe ser un numero.");
            return;
        }

        // Validar rango del año
        if (anio < 1500 || anio > 2026) {
            mostrarAlerta("El año debe estar entre 1500 y 2025.");
            return;
        }

        if (libroEditar == null) {
            // Es un libro nuevo
            // Validar ISBN duplicado
            for (Libro l : repositorio.getLista()) {
                if (l.getIsbn().equals(txtIsbn.getText())) {
                    mostrarAlerta("Ya existe un libro con ese ID.");
                    return;
                }
            }

            Libro nuevo = new Libro(
                    txtIsbn.getText(),
                    txtTitulo.getText(),
                    txtAutor.getText(),
                    anio,
                    txtGenero.getText(),
                    chkDisponible.isSelected()
            );
            repositorio.agregar(nuevo);

        } else {
            libroEditar.setIsbn(txtIsbn.getText());
            libroEditar.setTitulo(txtTitulo.getText());
            libroEditar.setAutor(txtAutor.getText());
            libroEditar.setAnio(anio);
            libroEditar.setGenero(txtGenero.getText());
            libroEditar.setDisponible(chkDisponible.isSelected());
            repositorio.actualizar();
        }

        // Cerrar la ventana
        Stage stage = (Stage) txtIsbn.getScene().getWindow();
        stage.close();
    }

    @FXML
    void onCancelar(ActionEvent event) {
        Stage stage = (Stage) txtIsbn.getScene().getWindow();
        stage.close();
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Aviso");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}

