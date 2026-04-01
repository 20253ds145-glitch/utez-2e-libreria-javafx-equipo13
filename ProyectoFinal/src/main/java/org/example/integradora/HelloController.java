package org.example.integradora;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloController {

    @FXML
    private TableView<Libro> tblLibros;
    @FXML
    private TableColumn<Libro, String> colIsbn;
    @FXML
    private TableColumn<Libro, String> colTitulo;
    @FXML
    private TextField txtIsbn;
    @FXML
    private TextField txtTitulo;

    private ObservableList<Libro> listaLibros = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Conectamos las columnas con los atributos de la clase Libro
        colIsbn.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        colTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));

        // Vinculamos la lista a la tabla
        tblLibros.setItems(listaLibros);
    }

    @FXML
    void onNuevoClick(ActionEvent event) {
        // Leemos lo que se escribe en los cuadritos
        String isbn = txtIsbn.getText();
        String titulo = txtTitulo.getText();

        // Validamos que no esten vacios
        if (!isbn.isEmpty() && !titulo.isEmpty()) {
            Libro nuevo = new Libro(isbn, titulo);
            listaLibros.add(nuevo);

            // Limpiamos los campos para el siguiente libro
            txtIsbn.clear();
            txtTitulo.clear();
        }
    }
}