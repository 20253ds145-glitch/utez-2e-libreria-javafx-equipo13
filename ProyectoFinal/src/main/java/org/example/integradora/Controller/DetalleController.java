package org.example.integradora.Controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.example.integradora.Model.Libro;

public class DetalleController {

    @FXML private Label lblIsbn;
    @FXML private Label lblTitulo;
    @FXML private Label lblAutor;
    @FXML private Label lblAnio;
    @FXML private Label lblGenero;
    @FXML private Label lblDisponible;

    public void inicializar(Libro libro) {
        lblIsbn.setText(libro.getIsbn());
        lblTitulo.setText(libro.getTitulo());
        lblAutor.setText(libro.getAutor());
        lblAnio.setText(String.valueOf(libro.getAnio()));
        lblGenero.setText(libro.getGenero());
        lblDisponible.setText(libro.isDisponible() ? "Sí" : "No");
    }

    @FXML
    void onRegresar(ActionEvent event) {
        Stage stage = (Stage) lblIsbn.getScene().getWindow();
        stage.close();
    }
}