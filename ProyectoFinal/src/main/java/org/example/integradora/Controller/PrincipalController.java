package org.example.integradora.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.example.integradora.Model.Libro;
import org.example.integradora.Service.LibroRepository;

public class PrincipalController {

    // Tabla y columnas
    @FXML private TableView<Libro> tblLibros;
    @FXML private TableColumn<Libro, String>  colIsbn;
    @FXML private TableColumn<Libro, String>  colTitulo;
    @FXML private TableColumn<Libro, String>  colAutor;
    @FXML private TableColumn<Libro, Integer> colAnio;
    @FXML private TableColumn<Libro, String>  colGenero;
    @FXML private TableColumn<Libro, Boolean> colDisponible;

    // El repositorio maneja los datos y el archivo
    private LibroRepository repositorio = new LibroRepository();

    @FXML
    public void initialize() {
        // 1. Conectamos cada columna con el nombre exacto del atributo en la clase Libro
        colIsbn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        colTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        colAutor.setCellValueFactory(new PropertyValueFactory<>("autor"));
        colAnio.setCellValueFactory(new PropertyValueFactory<>("anio"));
        colGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        colDisponible.setCellValueFactory(new PropertyValueFactory<>("disponible"));

        // 2. Le pasamos la lista de libros a la tabla
        tblLibros.setItems(repositorio.getLista());
    }



    @FXML
    void onNuevo(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/integradora/formulario.fxml"));
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Nuevo Libro");
            stage.setScene(new Scene(loader.load()));

            // Le pasamos el repositorio y null porque es libro nuevo
            FormularioController controller = loader.getController();
            controller.inicializar(null, repositorio);

            stage.showAndWait();
            tblLibros.refresh();
        } catch (Exception e) {
            System.out.println("Error al abrir formulario: " + e.getMessage());
        }
    }

    @FXML
    void onEditar(ActionEvent event) {
        Libro seleccionado = tblLibros.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAlerta("Selecciona un libro para editar.");
            return;
        }

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/integradora/formulario.fxml"));
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Editar Libro");
            stage.setScene(new Scene(loader.load()));

            // Le pasamos el repositorio y el libro a editar
            FormularioController controller = loader.getController();
            controller.inicializar(seleccionado, repositorio);

            stage.showAndWait();
            tblLibros.refresh();
        } catch (Exception e) {
            System.out.println("Error al abrir formulario: " + e.getMessage());
        }
    }

    @FXML
    void onEliminar(ActionEvent event) {
        Libro seleccionado = tblLibros.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAlerta("Selecciona un libro para eliminar.");
            return;
        }

        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setTitle("Confirmar");
        confirmacion.setContentText("¿Eliminar el libro: " + seleccionado.getTitulo() + "?");
        confirmacion.showAndWait().ifPresent(respuesta -> {
            if (respuesta == ButtonType.OK) {
                repositorio.eliminar(seleccionado);
            }
        });
    }

    @FXML
    void onVerDetalle(ActionEvent event) {
        Libro seleccionado = tblLibros.getSelectionModel().getSelectedItem();
        if (seleccionado == null) {
            mostrarAlerta("Selecciona un libro para ver el detalle.");
            return;
        }
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/org/example/integradora/detalle.fxml"));
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Detalle del Libro");
            stage.setScene(new Scene(loader.load()));

            DetalleController controller = loader.getController();
            controller.inicializar(seleccionado);

            stage.showAndWait();
        } catch (Exception e) {
            System.out.println("Error al abrir detalle: " + e.getMessage());
        }
    }

    @FXML
    void onExportar(ActionEvent event) {
        repositorio.exportarReporte();
        Alert info = new Alert(Alert.AlertType.INFORMATION);
        info.setTitle("Listo");
        info.setContentText("Reporte exportado como reporte.csv");
        info.showAndWait();
    }

    private void mostrarAlerta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Aviso");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}