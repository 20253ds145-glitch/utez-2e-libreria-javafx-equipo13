module org.example.integradora {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;

    // Esto permite que JavaFX acceda a tus carpetas nuevas
    opens org.example.integradora to javafx.fxml;
    opens org.example.integradora.Controller to javafx.fxml;
    opens org.example.integradora.Model to javafx.fxml;

    exports org.example.integradora;
}